package com.design.composeNur.components.buttons.baseButton

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

/**
 * @param [onClick] callback will invoke when user will click button
 * @param [title] button main title value
 * @param [titleStyle] button main title style
 * @param [buttonStyle] button visual style
 * @param [isEnabled] is button enabled state
 * @param [buttonPadding] root button container padding
 * @param [contentPaddingTop] title content padding top
 * @param [contentPaddingBottom] title content padding bottom
 * @param [contentPaddingEnd] title content padding end
 * @param [contentPaddingStart] title content padding start
 * @param [startIcon] accept [DrawableRes] value. And setting on the start of button content
 * @param [endIcon] accept [DrawableRes] value. And setting on the end of button content
 * @sample NurButtonStyle.Primary
 */

@Composable
fun NurButton(
    modifier: Modifier = Modifier
        .wrapContentSize()
        .fillMaxWidth(),
    title: String,
    titleStyle: TextStyle? = null,
    buttonStyle: NurButtonStyle = NurButtonStyle.Primary,
    isEnabled: Boolean = true,
    buttonPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    startIcon: Painter? = null,
    endIcon: Painter? = null,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .padding(buttonPadding)
            .heightIn(min = buttonStyle.minHeight),
        onClick = onClick,
        shape = CircleShape.copy(CornerSize(buttonStyle.cornerSize)),
        border = BorderStroke(buttonStyle.borderWidth, buttonStyle.borderColor),
        enabled = isEnabled,
        contentPadding = buttonStyle.contentPaddingValues,
        colors = ButtonColors(
            contentColor = buttonStyle.textActiveColor,
            containerColor = buttonStyle.backgroundActiveColor,
            disabledContentColor = buttonStyle.textDisabledColor,
            disabledContainerColor = buttonStyle.backgroundDisabledColor
        )
    ) {
        val buttonTextStyle = titleStyle ?: NurTextStyle.get(
            buttonStyle.buttonTextSize,
            buttonStyle.textActiveColor,
            buttonStyle.textFont
        )
        if (startIcon != null) {
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .padding(end = 4.dp),
                painter = startIcon,
                contentDescription = "Button start icon"
            )
        }
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = title,
            textAlign = TextAlign.Center,
            style = buttonTextStyle.copy(color = if (isEnabled) buttonStyle.textActiveColor else buttonStyle.textDisabledColor)
        )
        if (endIcon != null) {
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .padding(start = 4.dp),
                painter = endIcon,
                contentDescription = "Button end icon"
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun BaseButtonPreview() {
    NurTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(NurTheme.Colors.NurSurfaceBackground)
        ) {
            Spacer(modifier = Modifier.size(24.dp))
            NurButton(
                onClick = { /*TODO*/ },
                title = "NurButtonStyle.Primary",
                buttonStyle = NurButtonStyle.Primary
            )
            Spacer(modifier = Modifier.size(24.dp))
            NurButton(
                onClick = { /*TODO*/ },
                title = "NurButtonStyle.Secondary",
                buttonStyle = NurButtonStyle.Secondary
            )
            Spacer(modifier = Modifier.size(24.dp))
            NurButton(
                onClick = { /*TODO*/ },
                title = "NurButtonStyle.Additional",
                buttonStyle = NurButtonStyle.Additional
            )
        }
    }


}

