package com.design.composechili.components.navBar.simpleNavBar.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

data class ChiliNavBarParams(
    val backgroundColor: Color,
    val backgroundShape: Shape,
    val selectedColor: Color,
    val unselectedColor: Color,
    val navItemParams: ChiliNavSimpleItemParams
) {
    companion object {
        val Default
            @Composable get() = ChiliNavBarParams(
                backgroundColor = ChiliTheme.Colors.chiliScreenBackground,
                backgroundShape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius24Dp),
                selectedColor = ChiliTheme.Colors.ChiliNavBarSelectedItemColor,
                unselectedColor = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                navItemParams = ChiliNavSimpleItemParams.Default
            )
    }
}