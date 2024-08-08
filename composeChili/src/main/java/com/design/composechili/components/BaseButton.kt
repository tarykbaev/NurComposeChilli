package com.design.composechili.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonTitle: String,
    titleStyle: TextStyle,
    buttonStyle: ChiliButtonStyle = ChiliButtonStyle.Primary,
    isEnabled: Boolean = true,
    paddingTop: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingTop,
    paddingBottom: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingBottom,
    paddingStart: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingStart,
    paddingEnd: Dp = ChiliTheme.Attribute.ChiliPrimaryButtonAttribute.PaddingEnd
) {
    ChiliTheme {
        Button(
            modifier = modifier
                .wrapContentSize()
                .fillMaxWidth()
                .padding(),
            onClick = onClick,
            shape = CircleShape.copy(CornerSize(buttonStyle.cornerSize)),
            border = BorderStroke(buttonStyle.borderWidth, buttonStyle.borderColor),
            enabled = isEnabled,
            contentPadding = PaddingValues(
                start = paddingStart,
                top = paddingTop,
                end = paddingEnd,
                bottom = paddingBottom
            ),
            colors = ButtonColors(
                contentColor = buttonStyle.textActiveColor,
                containerColor = buttonStyle.backgroundActiveColor,
                disabledContentColor = buttonStyle.textDisabledColor,
                disabledContainerColor = buttonStyle.backgroundDisabledColor
            )
        ) {
            Text(text = buttonTitle)

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
    val borderWidth: Dp
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
                borderWidth = dimensionResource(id = R.dimen.view_1dp)
            )
//
//        internal val Secondary
//        @Composable
//        get () = ChiliButtonStyle()
    }

}
