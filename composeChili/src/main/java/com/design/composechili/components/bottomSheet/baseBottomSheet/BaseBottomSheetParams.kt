package com.design.composechili.components.bottomSheet.baseBottomSheet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Stable
data class BaseBottomSheetParams(
    val bottomSheetContentBackgroundColor: Color,
    val topCornerRadius: Dp,
    val bottomCornerRadius: Dp,
    val bottomSheetBottomPadding: Dp,
    val closeIconPadding: PaddingValues,
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
                closeIconPadding = PaddingValues(top = 8.dp, end = 12.dp),
                bottomSheetShadowElevation = dimensionResource(id = R.dimen.elevation_8dp)
            )
    }

}