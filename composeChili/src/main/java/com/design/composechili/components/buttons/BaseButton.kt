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
        ChiliTheme.colors.chiliPrimaryTextColor
    ),
    buttonStyle: ChiliButtonStyle = ChiliButtonStyle.Primary,
    isEnabled: Boolean = true,
    buttonPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    contentPaddingTop: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingTop,
    contentPaddingBottom: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingBottom,
    contentPaddingStart: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingStart,
    contentPaddingEnd: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingEnd,
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
                backgroundActiveColor = ChiliTheme.colors.ChiliPrimaryButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.colors.ChiliPrimaryButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.colors.ChiliPrimaryButtonTextColorActive,
                textDisabledColor = ChiliTheme.colors.ChiliPrimaryButtonTextColorDisabled,
                cornerSize = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.CornerRadius,
                buttonTextSize = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.TextSize,
                borderColor = ChiliTheme.colors.ChiliPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.TextFont
            )

        val Secondary
            @Composable
            get() = ChiliButtonStyle(
                backgroundActiveColor = ChiliTheme.colors.ChiliSecondaryButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.colors.ChiliSecondaryButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.colors.ChiliSecondaryButtonTextColorActive,
                textDisabledColor = ChiliTheme.colors.ChiliSecondaryButtonTextColorDisabled,
                cornerSize = ChiliTheme.Attribute.ChiliSecondaryButtonCornerRadius,
                buttonTextSize = ChiliTheme.Attribute.ChiliSecondaryButtonTextSize,
                borderColor = ChiliTheme.colors.ChiliPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.Attribute.ChiliSecondaryButtonTextFont
            )

        val Additional
            @Composable
            get() = ChiliButtonStyle(
                backgroundActiveColor = ChiliTheme.colors.ChiliAdditionalButtonBackgroundActive,
                backgroundDisabledColor = ChiliTheme.colors.ChiliAdditionalButtonBackgroundDisabled,
                textActiveColor = ChiliTheme.colors.ChiliAdditionalButtonTextColorActive,
                textDisabledColor = ChiliTheme.colors.ChiliAdditionalButtonTextColorDisabled,
                cornerSize = ChiliTheme.Attribute.ChiliAdditionalButtonCornerRadius,
                buttonTextSize = ChiliTheme.Attribute.ChiliAdditionalButtonTextSize,
                borderColor = ChiliTheme.colors.ChiliAdditionalButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = ChiliTheme.Attribute.ChiliAdditionalButtonTextFont
            )
    }

}
