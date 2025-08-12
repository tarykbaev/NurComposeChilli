package com.design.composeNur.components.common.carousel

import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composenur.R

@Stable
data class NurImageCarouselParams(
    val autoSlideDelay: Long,
    val animationDurationMillis: Int,
    val animationEasing: Easing,
    val pageSpacing: Dp,
    val cornerRadius: Dp,
    val backgroundColor: Color,
    val dotIndicatorBottomPadding: Dp,
    val pagerDotIndicatorParams: NurPagerDotIndicatorParams
) {
    companion object {
        val Default @Composable get() = NurImageCarouselParams(
            autoSlideDelay = 5000L,
            animationDurationMillis = 500,
            animationEasing = FastOutLinearInEasing,
            pageSpacing = 4.dp,
            cornerRadius = 4.dp,
            backgroundColor = Color.LightGray,
            dotIndicatorBottomPadding = 12.dp,
            pagerDotIndicatorParams = NurPagerDotIndicatorParams.Default
        )
    }
}

@Stable
data class NurPagerDotIndicatorParams(
    val selectedColor: Color,
    val unselectedColor: Color,
    val selectedSize: Dp,
    val unselectedSize: Dp,
    val spacing: Dp,
    val shape: Shape
) {
    companion object {
        val Default @Composable get() = NurPagerDotIndicatorParams(
            selectedColor = colorResource(R.color.magenta_1),
            unselectedColor = colorResource(R.color.gray_2),
            selectedSize = 6.dp,
            unselectedSize = 4.dp,
            spacing = 2.dp,
            shape = CircleShape
        )
    }
}