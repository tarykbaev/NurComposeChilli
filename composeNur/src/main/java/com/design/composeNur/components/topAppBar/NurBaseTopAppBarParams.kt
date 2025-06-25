package com.design.composeNur.components.topAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class NurBaseTopAppBarParams(
    val titleTextStyle: TextStyle,
    val additionalTextStyle: TextStyle,
    val navigationIconSize: Dp,
    val endIconSize: Dp,
    val containerColor: Color,
    val dividerColor: Color,
    val dividerThickness: Dp,
    val startIconFilter: ColorFilter,
    val endIconColorFilter: ColorFilter?
) {
    companion object {
        val Default
            @Composable
            get() = NurBaseTopAppBarParams(
                titleTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                    NurTheme.Colors.NurPrimaryTextColor,
                    NurTheme.Attribute.NurBoldTextFont
                ),
                additionalTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    NurTheme.Colors.NurSecondaryTextColor
                ),
                navigationIconSize = dimensionResource(R.dimen.view_24dp),
                endIconSize = dimensionResource(R.dimen.view_24dp),
                containerColor = NurTheme.Colors.NurTopAppBarBackground,
                dividerColor = NurTheme.Colors.NurTopAppBarDividerColor,
                dividerThickness = NurTheme.Attribute.NurTopAppBarThicknessSize,
                endIconColorFilter = null,
                startIconFilter = ColorFilter.tint(
                    NurTheme.Colors.NurPrimaryTextColor
                )
            )
    }
}
