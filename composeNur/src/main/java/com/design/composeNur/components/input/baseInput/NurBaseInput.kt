package com.design.composeNur.components.input.baseInput

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H8
import com.design.composenur.R

/**
 * A custom Composable function representing a text input field with various configuration options.
 *
 * This Composable provides a wrapper around `TextField` with additional customizations, including hints,
 * icons, error states, and keyboard actions.
 *
 * @param modifier [Modifier] to be applied to the input field's container. By default, it is set to [Modifier].
 * @param textFieldValue The current text input value displayed in the field.
 * @param onValueChange A lambda function to handle the change in text input. It takes the new value as a parameter.
 * @param hint Optional hint text to be displayed when the input field is empty. Default is an empty string.
 * @param isEnabled Boolean flag to enable/disable the input field. The default is `true`, meaning the field is enabled.
 * @param isError Boolean flag indicating whether the input field is in an error state. The default is `false`.
 * @param params A [BaseInputParams] object that holds additional configurations for the input. The default is [BaseInputParams.Default].
 * @param keyboardActions A [KeyboardActions] object to define keyboard actions such as "Done" or "Next". Default is [KeyboardActions.Default].
 * @param containerStartIcon Optional [Painter] representing an icon that will be shown at the start of the container (before the input field).
 * @param fieldStartIcon Optional [Painter] representing an icon that will be shown at the start of the text field.
 * @param fieldEndIcon Optional [Painter] representing an icon that will be shown at the end of the text field.
 * @param endIconClicked Optional lambda function that will be invoked when the end icon is clicked. Default is `null`.
 *
 * @optIn [ExperimentalMaterial3Api] The composable uses experimental APIs from Material3, requiring opt-in.
 *
 * @note This composable is designed to be used with the latest Material 3 components and integrates custom error handling,
 * icons, and keyboard support.
 *
 * @see [TextField] for the standard text field implementation.
 * @see [BaseInputParams] for details on custom input configurations.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurBaseInput(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    hint: String = String(),
    isEnabled: Boolean = true,
    isError: Boolean = false,
    errorMessage: String = String(),
    params: BaseInputParams = BaseInputParams.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    containerStartIcon: Painter? = null,
    fieldStartIcon: Painter? = null,
    fieldEndIcon: Painter? = null,
    endIconClicked: (() -> Unit)? = null
) {

    val interactionSource = remember { MutableInteractionSource() }

    val textColor = params.textStyle.color.takeOrElse {
        val focused = interactionSource.collectIsFocusedAsState().value
        when {
            !isEnabled -> TextFieldDefaults.colors().disabledTextColor
            isError -> params.errorTextColor
            focused -> TextFieldDefaults.colors().focusedTextColor
            else -> TextFieldDefaults.colors().unfocusedTextColor
        }
    }
    val mergedTextStyle = params.textStyle.merge(TextStyle(color = textColor))

    Column(modifier.animateContentSize()) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (containerStartIcon != null) {
                Image(
                    painter = containerStartIcon,
                    contentDescription = "Input field start description icon",
                    modifier = Modifier.size(48.dp)
                )
            }
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.MinWidth,
                        minHeight = TextFieldDefaults.MinHeight
                    )
                    .animateContentSize(),
                value = textFieldValue,
                onValueChange = onValueChange,
                enabled = isEnabled,
                keyboardActions = keyboardActions,
                textStyle = mergedTextStyle,
                keyboardOptions = KeyboardOptions(
                    keyboardType = params.keyboardType,
                    imeAction = params.imeAction
                ),
                maxLines = params.maxLines,
                cursorBrush = SolidColor(params.cursorColor)
            ) { innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = textFieldValue,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    placeholder = {
                        Text(
                            text = hint,
                            style = params.textStyle,
                            color = params.hintColor,
                            modifier = Modifier
                                .fillMaxWidth()
                                .animateContentSize()
                        )
                    },
                    shape = CircleShape.copy(CornerSize(12.dp)),
                    singleLine = true,
                    enabled = isEnabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = params.getTextFieldColorParameter(),
                    trailingIcon = if (fieldEndIcon != null) {
                        {
                            IconButton(modifier = Modifier.size(params.fieldIconSize), onClick = {
                                endIconClicked?.invoke()
                            }) {
                                Image(
                                    painter = fieldEndIcon,
                                    contentDescription = "Input field end description icon"
                                )
                            }
                        }
                    } else null,
                    leadingIcon = if (fieldStartIcon != null) {
                        {
                            Image(
                                painter = fieldStartIcon,
                                contentDescription = "Input field end description icon",
                                modifier = Modifier.size(params.fieldIconSize)
                            )
                        }
                    } else null,
                    contentPadding = params.textFieldPadding,
                )
            }
        }

        if (errorMessage.isNotBlank()) {
            Text(
                modifier = Modifier.padding(horizontal = 6.dp),
                text = errorMessage,
                style = H8.Error.Regular
            )
        }
    }
}

@Preview
@Composable
fun BaseInput_Preview() {
    NurTheme {
        Column {
            NurBaseInput(
                textFieldValue = "",
                onValueChange = {},
                fieldEndIcon = painterResource(id = R.drawable.nur_ic_card_oil),
                hint = "HINT",
                errorMessage = "test",
                params = BaseInputParams.Default.copy(
                    textStyle = NurTextStyle.get(
                        NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                        NurTheme.Colors.NurPrimaryTextColor,
                        NurTheme.Attribute.NurBoldTextFont
                    ).copy(textAlign = TextAlign.Center)
                )
            )
        }
    }
}