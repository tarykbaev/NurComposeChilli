package com.design.composeNur.components.buttons.baseButton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

data class NurButtonStyle(
    val backgroundActiveColor: Color,
    val backgroundDisabledColor: Color,
    val textActiveColor: Color,
    val textDisabledColor: Color,
    val cornerSize: Dp,
    val buttonTextSize: TextUnit,
    val borderColor: Color,
    val borderWidth: Dp,
    val textFont: Font,
    val contentPaddingValues: PaddingValues,
    val minHeight: Dp
) {

    companion object {
        val Primary
            @Composable
            get() = NurButtonStyle(
                backgroundActiveColor = NurTheme.Colors.NurPrimaryButtonBackgroundActive,
                backgroundDisabledColor = NurTheme.Colors.NurPrimaryButtonBackgroundDisabled,
                textActiveColor = NurTheme.Colors.NurPrimaryButtonTextColorActive,
                textDisabledColor = NurTheme.Colors.NurPrimaryButtonTextColorDisabled,
                cornerSize = NurTheme.NurButtonAttribute.NurPrimaryButtonCornerRadius,
                buttonTextSize = NurTheme.NurButtonAttribute.NurPrimaryButtonTextSize,
                borderColor = NurTheme.Colors.NurPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = NurTheme.NurButtonAttribute.NurPrimaryButtonTextFont,
                contentPaddingValues = PaddingValues(
                    top = NurTheme.NurButtonAttribute.NurButtonPaddingTop,
                    bottom = NurTheme.NurButtonAttribute.NurButtonPaddingBottom,
                    start = NurTheme.NurButtonAttribute.NurButtonPaddingStart,
                    end = NurTheme.NurButtonAttribute.NurButtonPaddingEnd
                ),
                minHeight = dimensionResource(id = R.dimen.view_48dp)
            )

        val ComponentButton
            @Composable
            get() = NurButtonStyle(
                backgroundActiveColor = NurTheme.Colors.NurComponentButtonBackgroundActive,
                backgroundDisabledColor = NurTheme.Colors.NurComponentButtonBackgroundDisabled,
                textActiveColor = NurTheme.Colors.NurComponentButtonTextColorActive,
                textDisabledColor = NurTheme.Colors.NurComponentButtonTextColorDisabled,
                cornerSize = NurTheme.NurButtonAttribute.NurComponentButtonCornerRadius,
                buttonTextSize = NurTheme.NurButtonAttribute.NurComponentButtonTextSize,
                borderColor = NurTheme.Colors.NurPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = NurTheme.NurButtonAttribute.NurComponentButtonTextFont,
                contentPaddingValues = PaddingValues(
                    top = NurTheme.NurButtonAttribute.NurButtonPaddingTop,
                    bottom = NurTheme.NurButtonAttribute.NurButtonPaddingBottom,
                    start = NurTheme.NurButtonAttribute.NurButtonPaddingStart,
                    end = NurTheme.NurButtonAttribute.NurButtonPaddingEnd
                ),
                minHeight = dimensionResource(id = R.dimen.view_48dp)
            )

        val Secondary
            @Composable
            get() = NurButtonStyle(
                backgroundActiveColor = NurTheme.Colors.NurSecondaryButtonBackgroundActive,
                backgroundDisabledColor = NurTheme.Colors.NurSecondaryButtonBackgroundDisabled,
                textActiveColor = NurTheme.Colors.NurSecondaryButtonTextColorActive,
                textDisabledColor = NurTheme.Colors.NurSecondaryButtonTextColorDisabled,
                cornerSize = NurTheme.NurButtonAttribute.NurSecondaryButtonCornerRadius,
                buttonTextSize = NurTheme.NurButtonAttribute.NurSecondaryButtonTextSize,
                borderColor = NurTheme.Colors.NurPrimaryButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = NurTheme.NurButtonAttribute.NurSecondaryButtonTextFont,
                contentPaddingValues = PaddingValues(
                    top = NurTheme.NurButtonAttribute.NurButtonPaddingTop,
                    bottom = NurTheme.NurButtonAttribute.NurButtonPaddingBottom,
                    start = NurTheme.NurButtonAttribute.NurButtonPaddingStart,
                    end = NurTheme.NurButtonAttribute.NurButtonPaddingEnd
                ),
                minHeight = dimensionResource(id = R.dimen.view_48dp)
            )

        val Additional
            @Composable
            get() = NurButtonStyle(
                backgroundActiveColor = NurTheme.Colors.NurAdditionalButtonBackgroundActive,
                backgroundDisabledColor = NurTheme.Colors.NurAdditionalButtonBackgroundDisabled,
                textActiveColor = NurTheme.Colors.NurAdditionalButtonTextColorActive,
                textDisabledColor = NurTheme.Colors.NurAdditionalButtonTextColorDisabled,
                cornerSize = NurTheme.NurButtonAttribute.NurAdditionalButtonCornerRadius,
                buttonTextSize = NurTheme.NurButtonAttribute.NurAdditionalButtonTextSize,
                borderColor = NurTheme.Colors.NurAdditionalButtonBorderColor,
                borderWidth = dimensionResource(id = R.dimen.view_1dp),
                textFont = NurTheme.NurButtonAttribute.NurAdditionalButtonTextFont,
                contentPaddingValues = PaddingValues(
                    NurTheme.NurButtonAttribute.NurComponentButtonHorizontalPadding,
                    NurTheme.NurButtonAttribute.NurComponentButtonVerticalPadding
                ),
                minHeight = dimensionResource(id = R.dimen.view_48dp)
            )
    }

}