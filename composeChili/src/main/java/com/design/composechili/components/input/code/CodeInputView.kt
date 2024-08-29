package com.design.composechili.components.input.code

import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

@Composable
fun CodeInputView(
    modifier: Modifier = Modifier,
    codeLength: Int = 6,
    message: String? = null,
    actionText: String? = null,
    code: String,
    isActionTextEnabled: Boolean = true,
    state: CodeInputItemState = CodeInputItemState.INACTIVE,
    onActionTextClicked: () -> Unit = {},
    codeCompleteListener: OnCodeChangeListener
) {

    val focusRequester = remember { FocusRequester() }
    val actionTextColor =
        if (isActionTextEnabled) ChiliTheme.Colors.ChiliCodeInputViewActionTextActiveColor
        else ChiliTheme.Colors.ChiliCodeInputViewActionTextInActiveColor

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
                    if (newText.text.length <= codeLength && newText.text.all { it.isDigit() }) {
                        codeCompleteListener.onCodeChange(newText.text)
                        if (newText.text.length == codeLength) {
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
                repeat(codeLength) { index ->
                    CodeInputItemView(
                        state = when {
                            state == CodeInputItemState.ERROR && index == 0 -> CodeInputItemState.ACTIVE_ERROR
                            state == CodeInputItemState.ERROR -> CodeInputItemState.ERROR
                            code.isEmpty() && index == 0 -> CodeInputItemState.ACTIVE
                            code.isEmpty() -> CodeInputItemState.INACTIVE
                            code.length == codeLength && index == code.lastIndex -> CodeInputItemState.ACTIVE
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
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.padding_16dp)),
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
                        .padding(
                            end = dimensionResource(id = R.dimen.padding_12dp),
                            start = dimensionResource(id = R.dimen.padding_2dp)
                        )
                        .clickable(enabled = isActionTextEnabled, onClick = onActionTextClicked),
                    text = actionText,
                    textAlign = TextAlign.End,
                    style = ChiliTextStyle.get(
                        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                        color = actionTextColor
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

@Preview
@Composable
fun CodeInputViewPreview() {
    ChiliTheme {
        CodeInputView(
            code = "",
            state = CodeInputItemState.ERROR,
            codeCompleteListener = object : OnCodeChangeListener {
                override fun onCodeChange(text: String?) {

                }
                override fun onCodeComplete(otp: String) {

                }
            }
        )
    }
}
