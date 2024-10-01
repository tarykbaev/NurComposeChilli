package com.design.composechili.components.input.baseInput

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.text.BasicTextField
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
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseInput(
    modifier: Modifier = Modifier,
    textFieldValue: String,
    onValueChange: (String) -> Unit,
    hint: String = String(),
    isEnabled: Boolean = true,
    isError: Boolean = false,
    params: BaseInputParams = BaseInputParams.Default,
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
                    minWidth = TextFieldDefaults.MinWidth, minHeight = TextFieldDefaults.MinHeight
                )
                .animateContentSize(),
            value = textFieldValue,
            onValueChange = onValueChange,
            enabled = isEnabled,
            textStyle = mergedTextStyle,
            keyboardOptions = KeyboardOptions(keyboardType = params.keyboardType),
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
}

@Preview
@Composable
fun BaseInput_Preview() {
    ChiliTheme {
        Column {
            BaseInput(
                textFieldValue = "",
                onValueChange = {},
                fieldEndIcon = painterResource(id = R.drawable.chili_ic_card_oil),
                hint = "HINT",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyle.get(
                        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                        ChiliTheme.Colors.ChiliPrimaryTextColor,
                        ChiliTheme.Attribute.ChiliBoldTextFont
                    ).copy(textAlign = TextAlign.Center)
                )
            )
        }
    }
}