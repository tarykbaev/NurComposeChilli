package com.design.composechili.components.input.password

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

/**
 *
 * [TextField] composable for entering password or secret word.
 * It applies transformation to entered chars
 *
 * @param [modifier] [Modifier] to be applied to the entire PasswordInput composable.
 * This can be used to set padding, width, etc.
 * @param [value] The current text value of the [PasswordInput]. This should be a [String]
 * @param [hint] A hint or placeholder text to display when the text field is empty. Default is empty [String]
 * Typically used for error or helper messages.
 * @param [isEnabled] A flag to enable or disable the [PasswordInput] field.
 * @param [isError] Indicates whether the input field should be displayed in an error state.
 * Default value is false
 * @param [transformationMask] A character used to mask the password input (e.g., • or *).
 * Default value is bullet char (\u2022)
 * @param [onValueChange] Callback function that gets triggered when the value of the input field changes.
 * @param [onImeAction] Callback function that gets triggered when the imeAction button is clicked.
 * @param [passwordVisibleEndIcon] A drawable resource representing the icon to show when the password is visible.
 * @param [passwordInvisibleEndIcon] A drawable resource representing the icon to show when the password is hidden.
 * @param [startIcon] An optional drawable resource representing the icon to display at the start of the input field.
 * @param [params] A set of customizable parameters (e.g., text style, colors, padding) for the [PasswordInput]
 * Default is [PasswordInputParams.Default]
 *
 */

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    value: String,
    hint: String = String(),
    isEnabled: Boolean = true,
    isError: Boolean = true,
    transformationMask: Char = '\u2022',
    onValueChange: (String) -> Unit = {},
    onImeAction: () -> Unit = {},
    passwordVisibleEndIcon: Painter = painterResource(id = R.drawable.chili_ic_visible),
    passwordInvisibleEndIcon: Painter = painterResource(id = R.drawable.chili_ic_invisible),
    params: PasswordInputParams = PasswordInputParams.Default,
) {

    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = params.textStyle,
        enabled = isEnabled,
        isError = isError,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None
        else PasswordVisualTransformation(transformationMask),
        keyboardOptions = KeyboardOptions(
            keyboardType = params.keyboardType,
            imeAction = params.imeAction
        ),
        keyboardActions = KeyboardActions { onImeAction() },
        shape = CircleShape.copy(CornerSize(8.dp)),
        trailingIcon = {
            IconButton(
                onClick = {
                    isPasswordVisible = isPasswordVisible.not()
                }) {
                Icon(
                    painter = if (isPasswordVisible) passwordInvisibleEndIcon else passwordVisibleEndIcon,
                    contentDescription = "Clear icon"
                )
            }
        },
        colors = TextFieldDefaults.colors().copy(
            focusedContainerColor = params.fieldBackground,
            unfocusedContainerColor = params.fieldBackground,
            disabledContainerColor = params.fieldBackground,
            errorContainerColor = params.fieldErrorBackground,
            errorTextColor = params.errorTextColor,
            errorIndicatorColor = Color.Transparent,
            errorCursorColor = params.errorTextColor,
            textSelectionColors = TextSelectionColors(
                params.cursorColor,
                params.selectionBackgroundColor
            ),
            unfocusedTrailingIconColor = params.endIconColor,
            focusedTrailingIconColor = params.endIconColor,
            errorTrailingIconColor = params.endIconColor,
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
}

@Composable
@Preview
fun PasswordInputPreview() {
    ChiliTheme {
        PasswordInput(value = "Password")
    }
}

@Composable
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PasswordInputPreviewDark() {
    ChiliTheme {
        PasswordInput(value = "Password")
    }
}