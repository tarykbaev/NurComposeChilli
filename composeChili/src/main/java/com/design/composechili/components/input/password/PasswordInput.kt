package com.design.composechili.components.input.password

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    hint: String = String(),
    value: String = "Password",
    message: String? = "null",
    isEnabled: Boolean = true,
    isError: Boolean = true,
    transformationMask: Char = '\u2022',
    onValueChange: (String) -> Unit = {},
    @DrawableRes stateVisibleEndIcon: Int = R.drawable.chili_ic_visible,
    @DrawableRes stateInvisibleEndIcon: Int = R.drawable.chili_ic_invisible,
    startIcon: @Composable (() -> Unit)? = null,
    params: PasswordInputParams = PasswordInputParams.Default,
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            textStyle = params.textStyle,
            enabled = isEnabled,
            isError = isError,
            maxLines = 1,
            visualTransformation = if (isPasswordVisible) PasswordVisualTransformation(
                transformationMask
            ) else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType),
            shape = CircleShape.copy(CornerSize(8.dp)),
            leadingIcon = startIcon,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        painter = painterResource(
                            id = if (isPasswordVisible) stateVisibleEndIcon else stateInvisibleEndIcon
                        ),
                        contentDescription = "Clear"
                    )
                }
            },
            colors = TextFieldDefaults.colors().copy(
                focusedContainerColor = params.fieldBackground,
                unfocusedContainerColor = params.fieldBackground,
                disabledContainerColor = params.fieldBackground,
                errorTextColor = params.errorTextColor,
                errorIndicatorColor = Color.Transparent,
                errorCursorColor = params.errorTextColor,
                textSelectionColors = TextSelectionColors(
                    params.cursorColor,
                    params.selectionBackgroundColor
                ),
                errorTrailingIconColor = TextFieldDefaults.colors().focusedTrailingIconColor,
                cursorColor = params.cursorColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = params.textStyle,
                    color = params.hintColor,
                    modifier = modifier.animateContentSize()
                )
            }
        )
        if (message != null) {
            Text(
                modifier = Modifier.padding(params.messagePadding.toPaddingValues()),
                text = message,
                style = if (isError) params.errorMessageTextStyle else params.messageTextStyle,
            )
        }
    }
}

@Composable
@Preview
fun PasswordInputPreview() {
    ChiliTheme {
        PasswordInput()
    }
}