package com.design.composechili.components.buttons.baseButton

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

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
 * @sample ChiliButtonStyle.Primary
 */

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    titleStyle: TextStyle? = null,
    buttonStyle: ChiliButtonStyle = ChiliButtonStyle.Primary,
    isEnabled: Boolean = true,
    buttonPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    contentPaddingTop: Dp = ChiliTheme.ChiliButtonAttribute.ChiliButtonPaddingTop,
    contentPaddingBottom: Dp = ChiliTheme.ChiliButtonAttribute.ChiliButtonPaddingBottom,
    contentPaddingStart: Dp = ChiliTheme.ChiliButtonAttribute.ChiliButtonPaddingStart,
    contentPaddingEnd: Dp = ChiliTheme.ChiliButtonAttribute.ChiliButtonPaddingEnd,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
) {
    ChiliTheme {
        Button(
            modifier = modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(buttonPadding),
            onClick = onClick,
            shape = CircleShape.copy(CornerSize(buttonStyle.cornerSize)),
            border = BorderStroke(buttonStyle.borderWidth, buttonStyle.borderColor),
            enabled = isEnabled,
            contentPadding = PaddingValues(
                start = contentPaddingStart,
                top = contentPaddingTop,
                end = contentPaddingEnd,
                bottom = contentPaddingBottom
            ),
            colors = ButtonColors(
                contentColor = buttonStyle.textActiveColor,
                containerColor = buttonStyle.backgroundActiveColor,
                disabledContentColor = buttonStyle.textDisabledColor,
                disabledContainerColor = buttonStyle.backgroundDisabledColor
            )
        ) {
            if (startIcon != null) {
                Image(
                    modifier = modifier.wrapContentSize(),
                    painter = painterResource(id = startIcon),
                    contentDescription = "Button start icon"
                )
            }
            val buttonTextStyle = titleStyle ?: ChiliTextStyle.get(
                    buttonStyle.buttonTextSize,
                    buttonStyle.textActiveColor,
                    buttonStyle.textFont
                )
            Text(
                modifier = Modifier,
                text = title,
                textAlign = TextAlign.Center,
                style =buttonTextStyle
            )
            if (endIcon != null) {
                Image(
                    modifier = modifier.wrapContentSize(),
                    painter = painterResource(endIcon),
                    contentDescription = "Button end icon"
                )
            }
        }
    }
}

