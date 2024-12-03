package com.design.composechili.components.input.code

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A Composable function for a code input field that allows users to enter a code
 * of a specified length. It provides visual feedback for errors and supports actions
 * on text completion and action text click.
 *
 * @param modifier An optional [Modifier] to customize the layout and appearance of the code input.
 * @param initialValue The initial value of the code input, default is an empty string.
 * @param codeLength Specifies the length of the code to be entered. Defaults to [CodeLength.SIX].
 * @param errorMessage An optional message to display when the input is invalid. Default is null.
 * @param actionText An optional text that triggers an action when clicked. Default is null.
 * @param isError A Boolean flag indicating whether the input is in an error state. Defaults to false.
 * @param onCodeComplete A callback function that is invoked when the code input is completed.
 * It provides the filled code as a parameter.
 * @param onCodeChange A callback function that is invoked when the code input changes.
 * It provides the current value of the input as a parameter. Defaults to an empty lambda.
 * @param onActionTextClick A callback function that is invoked when the action text is clicked.
 * Defaults to an empty lambda.
 *
 * Usage Example:
 * ```kotlin
 * CodeInput(
 *     modifier = Modifier.padding(16.dp),
 *     initialValue = "123456",
 *     codeLength = CodeLength.SIX,
 *     errorMessage = "Invalid code",
 *     isError = true,
 *     onCodeComplete = { code ->
 *         // Handle code completion
 *     },
 *     onCodeChange = { value ->
 *         // Handle code change
 *     },
 *     onActionTextClick = {
 *         // Handle action text click
 *     }
 * )
 * ```
 */

@Composable
fun CodeInput(
    modifier: Modifier = Modifier,
    initialValue: String = String(),
    codeLength: CodeLength = CodeLength.SIX,
    errorMessage: String? = null,
    actionText: String? = null,
    isError: Boolean = false,
    onCodeComplete: (filledCode: String) -> Unit,
    onCodeChange: (value: String) -> Unit = {},
    onActionTextClick: () -> Unit = {}
) {

    val focusRequester = remember { FocusRequester() }
    val itemWidth = when (codeLength) {
        CodeLength.FOUR -> dimensionResource(id = R.dimen.view_64dp)
        CodeLength.SIX -> dimensionResource(id = R.dimen.view_44dp)
        CodeLength.EIGHT -> dimensionResource(id = R.dimen.view_40dp)
    }

    var codeInputValue by rememberSaveable {
        mutableStateOf(initialValue
            .filter { it.isDigit() }
            .take(codeLength.length)
        )
    }

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
                value = TextFieldValue(codeInputValue, TextRange(codeInputValue.length)),
                onValueChange = { newText ->
                    if (newText.text.length <= codeLength.length) {
                        val digitText = newText.text.filter { it.isDigit() }

                        codeInputValue = digitText
                        onCodeChange(digitText)

                        if (newText.text.length == codeLength.length) {
                            onCodeComplete.invoke(digitText)
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
                            isError && index == codeInputValue.lastIndex -> CodeInputItemState.ACTIVE_ERROR
                            isError -> CodeInputItemState.ERROR
                            codeInputValue.isEmpty() && index == 0 -> CodeInputItemState.ACTIVE
                            codeInputValue.isEmpty() -> CodeInputItemState.INACTIVE
                            codeInputValue.length == codeLength.length && index == codeInputValue.lastIndex -> CodeInputItemState.ACTIVE
                            codeInputValue.length == index -> CodeInputItemState.ACTIVE
                            else -> CodeInputItemState.INACTIVE
                        },
                        text = codeInputValue.getOrNull(index)?.toString().orEmpty(),
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.padding_8dp))
                .animateContentSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (errorMessage != null && isError) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    style = ChiliTextStyle.get(
                        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                        color = ChiliTheme.Colors.ChiliCodeInputViewMessageColor
                    ),
                    text = errorMessage
                )
            }
            if (actionText != null && isError) {
                BaseButton(
                    modifier = Modifier.wrapContentSize(),
                    buttonPadding = PaddingValues(0.dp),
                    onClick = { onActionTextClick.invoke() },
                    title = actionText,
                    buttonStyle = ChiliButtonStyle.ComponentButton.copy(
                        contentPaddingValues = PaddingValues(
                            0.dp
                        ), minHeight = 0.dp
                    )
                )
            }
        }
    }

}

enum class CodeLength(val length: Int) {
    FOUR(4), SIX(6), EIGHT(8)
}

@Preview(showBackground = true)
@Composable
fun CodeInputViewPreview() {
    ChiliTheme {

        CodeInput(
            modifier = Modifier.padding(top = 32.dp),
            codeLength = CodeLength.SIX,
            actionText = "Action",
            errorMessage = "Message",
            onCodeComplete = {

            }
        )
    }
}
