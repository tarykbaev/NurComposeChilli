package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

data class NavBarWithFabParams(
    val selectedColor: Color,
    val unselectedColor: Color,
    val backgroundColor: Color,
    val backgroundShape: Shape,
) {
    companion object {
        val Default
            @Composable get() = NavBarWithFabParams(
                selectedColor = ChiliTheme.Colors.ChiliNavBarSelectedItemColor,
                unselectedColor = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                backgroundColor = ChiliTheme.Colors.chiliScreenBackground,
                backgroundShape = RoundedCornerShape(
                    ChiliRadiusDimensions.fromResources().radius24Dp,
                    ChiliRadiusDimensions.fromResources().radius24Dp,
                    ChiliRadiusDimensions.fromResources().radius0Dp,
                    ChiliRadiusDimensions.fromResources().radius0Dp,
                )
            )
    }
}