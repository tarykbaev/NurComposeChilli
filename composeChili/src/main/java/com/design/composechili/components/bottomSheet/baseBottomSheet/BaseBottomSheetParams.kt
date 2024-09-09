package com.design.composechili.components.bottomSheet.baseBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Stable
data class BaseBottomSheetParams(
    val bottomSheetContentBackgroundColor: Color,
    val topCornerRadius: Dp,
    val bottomCornerRadius: Dp,
    val bottomSheetBottomPadding: Dp,
    val backgroundDimmingColor: Color,
    val bottomSheetShadowElevation: Dp
) {

    companion object {

        val Default
            @Composable
            get() = BaseBottomSheetParams(
                bottomSheetContentBackgroundColor = ChiliTheme.Colors.ChiliBottomSheetBackgroundColor,
                topCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetTopCornerRadius,
                bottomCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetBottomCornerRadius,
                backgroundDimmingColor = Color.Black,
                bottomSheetBottomPadding = ChiliTheme.Attribute.ChiliBottomSheetContainerBottomMargin,
                bottomSheetShadowElevation = dimensionResource(id = R.dimen.elevation_8dp)
            )
    }

}