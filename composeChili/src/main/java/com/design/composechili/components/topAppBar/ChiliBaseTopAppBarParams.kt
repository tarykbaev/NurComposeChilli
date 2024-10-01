package com.design.composechili.components.topAppBar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ChiliBaseTopAppBarParams(
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
            get() = ChiliBaseTopAppBarParams(
                titleTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                    ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                additionalTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    ChiliTheme.Colors.ChiliSecondaryTextColor
                ),
                navigationIconSize = dimensionResource(R.dimen.view_24dp),
                endIconSize = dimensionResource(R.dimen.view_24dp),
                containerColor = ChiliTheme.Colors.ChiliTopAppBarBackground,
                dividerColor = ChiliTheme.Colors.ChiliTopAppBarDividerColor,
                dividerThickness = ChiliTheme.Attribute.ChiliTopAppBarThicknessSize,
                endIconColorFilter = null,
                startIconFilter = ColorFilter.tint(
                    ChiliTheme.Colors.ChiliPrimaryTextColor
                )
            )
    }
}
