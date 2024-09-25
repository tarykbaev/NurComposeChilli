package com.design.composechili.components.input.code

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ripple
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * Input View component to enter code, OTP
 * @param [codeLength] sets the length of code, accepts enum [CodeLength]
 * @param [message] accepts [String] displays message and warnings below input view
 * @param [actionText] accepts [String] sets text to clickable [Text] at the end of component, below input view
 * @param [clearCode] clears code entered if value true
 * @param [isActionTextEnabled] sets actionText enabled/disabled
 * @param [state] sets component state, accepts [CodeInputItemState]
 * @param [onActionTextClick] called when actionText is clicked
 * @param [codeCompleteListener] interface called when code value changes, accepts [OnCodeChangeListener]
 */

@Composable
fun CodeInput(
    modifier: Modifier = Modifier,
    codeLength: CodeLength = CodeLength.SIX,
    message: String? = null,
    actionText: String? = null,
    clearCode: Boolean = false,
    isActionTextEnabled: Boolean = true,
    state: CodeInputItemState = CodeInputItemState.INACTIVE,
    onActionTextClick: () -> Unit = {},
    codeCompleteListener: OnCodeChangeListener
) {

    val focusRequester = remember { FocusRequester() }
    val actionTextColor =
        if (isActionTextEnabled) ChiliTheme.Colors.ChiliCodeInputViewActionTextActiveColor
        else ChiliTheme.Colors.ChiliCodeInputViewActionTextInActiveColor
    val itemWidth = when (codeLength) {
        CodeLength.FOUR -> dimensionResource(id = R.dimen.view_64dp)
        CodeLength.SIX -> dimensionResource(id = R.dimen.view_44dp)
        CodeLength.EIGHT -> dimensionResource(id = R.dimen.view_40dp)
    }
    var code by remember { mutableStateOf("") }
    if (clearCode) { code = "" }

    Column(
        modifier = modifier
    ) {
        Box(modifier = Modifier
            .onFocusChanged {
                if (it.isFocused) focusRequester.requestFocus()
            }) {
            TextField(
                modifier = Modifier
                    .alpha(0f)
                    .focusable()
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                value = TextFieldValue(code, TextRange(code.length)),
                onValueChange = { newText ->
                    if (newText.text.length <= codeLength.length && newText.text.all { it.isDigit() }) {
                        code = newText.text
                        codeCompleteListener.onCodeChange(newText.text)
                        if (newText.text.length == codeLength.length) {
                            codeCompleteListener.onCodeComplete(newText.text)
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = Color.Transparent,
                    errorCursorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(codeLength.length) { index ->
                    CodeInputItem(
                        modifier = Modifier.width(itemWidth),
                        state = when {
                            state == CodeInputItemState.ERROR && index == 0 -> CodeInputItemState.ACTIVE_ERROR
                            state == CodeInputItemState.ERROR -> CodeInputItemState.ERROR
                            code.isEmpty() && index == 0 -> CodeInputItemState.ACTIVE
                            code.isEmpty() -> CodeInputItemState.INACTIVE
                            code.length == codeLength.length && index == code.lastIndex -> CodeInputItemState.ACTIVE
                            code.length == index -> CodeInputItemState.ACTIVE
                            else -> CodeInputItemState.INACTIVE
                        },
                        text = code.getOrNull(index)?.toString().orEmpty(),
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_8dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (message != null) {
                Text(
                    modifier = Modifier
                        .weight(3f),
                    style = ChiliTextStyle.get(
                        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                        color = ChiliTheme.Colors.ChiliCodeInputViewMessageColor
                    ),
                    text = message
                )
            }
            if (actionText != null) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp)))
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_2dp)
                        )
                        .clickable(
                            indication = ripple(),
                            interactionSource = remember { MutableInteractionSource() },
                            enabled = isActionTextEnabled,
                            onClick = onActionTextClick
                        ),
                    text = actionText,
                    textAlign = TextAlign.End,
                    style = ChiliTextStyle.get(
                        color = actionTextColor,
                        font = ChiliTheme.Attribute.ChiliComponentButtonTextFont,
                    ),
                )
            }
        }
    }

}

interface OnCodeChangeListener {
    fun onCodeComplete(otp: String)
    fun onCodeChange(text: String?)
}

enum class CodeLength(val length: Int) {
    FOUR(4), SIX(6), EIGHT(8)
}

@Preview
@Composable
fun CodeInputViewPreview() {
    ChiliTheme {
        CodeInput(
            state = CodeInputItemState.ERROR,
            actionText = "Action",
            message = "Message",
            codeCompleteListener = object : OnCodeChangeListener {
                override fun onCodeChange(text: String?) {

                }

                override fun onCodeComplete(otp: String) {

                }
            }
        )
    }
}
