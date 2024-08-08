package com.design.composechili.components.buttons

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    title: String,
    titleStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1,
        ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
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
            Text(
                modifier = Modifier,
                text = title,
                textAlign = TextAlign.Center,
                style = titleStyle
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

data class ChiliButtonStyle(
    val backgroundActiveColor: Color,
    val backgroundDisabledColor: Color,
    val textActiveColor: Color,
    val textDisabledColor: Color,
    val cornerSize: Dp,
    val buttonTextSize: TextUnit,
    val borderColor: Color,
    val borderWidth: Dp,
    val textFont: Font
) {
    companion object {
        val Primary
            @Composable
            get() = ChiliButtonStyle(
                backgroundActiveColor = ChiliTheme.Colors.ChiliPrimaryButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.Colors.ChiliPrimaryButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.Colors.ChiliPrimaryButtonTextColorActive,
                textDisabledColor = ChiliTheme.Colors.ChiliPrimaryButtonTextColorDisabled,
                cornerSize = ChiliTheme.ChiliButtonAttribute.ChiliPrimaryButtonCornerRadius,
                buttonTextSize = ChiliTheme.ChiliButtonAttribute.ChiliPrimaryButtonTextSize,
                borderColor = ChiliTheme.Colors.ChiliPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.ChiliButtonAttribute.ChiliPrimaryButtonTextFont
            )

        val Secondary
            @Composable
            get() = ChiliButtonStyle(
                backgroundActiveColor = ChiliTheme.Colors.ChiliSecondaryButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.Colors.ChiliSecondaryButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.Colors.ChiliSecondaryButtonTextColorActive,
                textDisabledColor = ChiliTheme.Colors.ChiliSecondaryButtonTextColorDisabled,
                cornerSize = ChiliTheme.ChiliButtonAttribute.ChiliSecondaryButtonCornerRadius,
                buttonTextSize = ChiliTheme.ChiliButtonAttribute.ChiliSecondaryButtonTextSize,
                borderColor = ChiliTheme.Colors.ChiliPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.ChiliButtonAttribute.ChiliSecondaryButtonTextFont
            )

        val Additional
            @Composable
            get() = ChiliButtonStyle(
                backgroundActiveColor = ChiliTheme.Colors.ChiliAdditionalButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.Colors.ChiliAdditionalButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.Colors.ChiliAdditionalButtonTextColorActive,
                textDisabledColor = ChiliTheme.Colors.ChiliAdditionalButtonTextColorDisabled,
                cornerSize = ChiliTheme.ChiliButtonAttribute.ChiliAdditionalButtonCornerRadius,
                buttonTextSize = ChiliTheme.ChiliButtonAttribute.ChiliAdditionalButtonTextSize,
                borderColor = ChiliTheme.Colors.ChiliAdditionalButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.ChiliButtonAttribute.ChiliAdditionalButtonTextFont
            )
    }

}
