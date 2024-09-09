package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.compose.animation.core.Spring
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

data class ChiliNavItemParams(
    val labelTextStyle: TextStyle,
    val iconBackgroundColor: Color,
    val iconBackgroundShape: Shape,
    val animationScaleSize: Float,
    val animationStiffness: Float,
    val verticalOffset: Dp
) {
    companion object {
        val Default
            @Composable get() = ChiliNavItemParams(
                labelTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                    color = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ), iconBackgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                iconBackgroundShape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius12Dp),
                animationScaleSize = 1.2f,
                animationStiffness = Spring.StiffnessMedium,
                verticalOffset = dimensionResource(id = R.dimen.padding_14dp)
            )
    }
}