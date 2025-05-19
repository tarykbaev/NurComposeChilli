package com.design.composechili.components.bottomSheet.baseBottomSheet

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Stable
data class NurChiliModalBottomSheetParams(
    val backgroundColor: Color,
    val topCornerRadius: Dp,
    val bottomCornerRadius: Dp,
    val bottomPadding: Dp,
    val closeIconPadding: PaddingValues,
    val backgroundDimmingColor: Color,
    val shadowElevation: Dp,
    val closeIcon: Painter,
    val topRoundedCornerShape: Shape
) {

    companion object {
        val Default
            @Composable
            get() = NurChiliModalBottomSheetParams(
                backgroundColor = ChiliTheme.Colors.ChiliBottomSheetBackgroundColor,
                topCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetTopCornerRadius,
                bottomCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetBottomCornerRadius,
                backgroundDimmingColor = Color.Black,
                bottomPadding = ChiliTheme.Attribute.ChiliBottomSheetContainerBottomMargin,
                closeIconPadding = PaddingValues(top = 8.dp, bottom = 8.dp, end = 12.dp),
                shadowElevation = dimensionResource(id = R.dimen.elevation_8dp),
                closeIcon = painterResource(id = R.drawable.chili_ic_clear_24),
                topRoundedCornerShape = RoundedCornerShape(
                    topStart = ChiliTheme.Attribute.ChiliBottomSheetTopCornerRadius,
                    topEnd = ChiliTheme.Attribute.ChiliBottomSheetTopCornerRadius
                )
            )
    }
}