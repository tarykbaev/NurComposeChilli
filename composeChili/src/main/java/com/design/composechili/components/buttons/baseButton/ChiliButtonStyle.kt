package com.design.composechili.components.buttons.baseButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

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