package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.compose.animation.core.Spring
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

data class ChiliNavFabItemParams(
    val iconBackgroundColor: Color,
    val iconBackgroundShape: Shape,
    val animationScaleSize: Float,
    val animationStiffness: Float,
    val iconSize: Dp,
    val verticalOffset: Dp
) {
    companion object {
        val Default
            @Composable get() = ChiliNavFabItemParams(
                iconBackgroundColor = Color.Transparent,
                iconBackgroundShape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius12Dp),
                animationScaleSize = 1.2f,
                animationStiffness = Spring.StiffnessMedium,
                iconSize = dimensionResource(id = R.dimen.view_48dp),
                verticalOffset = dimensionResource(id = R.dimen.padding_24dp)
            )
    }
}