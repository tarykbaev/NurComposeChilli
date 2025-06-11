package com.design.composechili.components.common.leftOver

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme


data class AnimatedLeftOverParams(
    val size: Dp,
    val arcBackgroundColor: Color,
    val arcProgressColor: Color,
    val limit: Long,
    val left: Long,
    val typeName: String,
    @DrawableRes val centeredImage: Int = R.drawable.ic_internet_32_dp,
    @DrawableRes val chevron: Int = R.drawable.chili_ic_chevron,
    val iconRippleShape: RoundedCornerShape = RoundedCornerShape(32.dp),
) {
    companion object {

        const val ABSOLUTE_PROGRESS_ANGLE = 300f
        const val START_PROGRESS_ANGLE = 120f
        const val ARC_ANIMATION_DURATION = 500L
        const val TETHERING_ANIMATION_DURATION = 1000L
        const val BACKGROUND_ARC_WIDTH_DIVIDER = 4.5f
        const val PROGRESS_ARC_WIDTH_DIVIDER = 3.5f
        const val INTERNET_TYPE = "Internet"
        const val CALL_TYPE = "Call"

        val Internet
            @Composable get() = AnimatedLeftOverParams(
                size = 60.dp,
                arcBackgroundColor = ChiliTheme.Colors.ChiliLeftOverBackgroundColor,
                arcProgressColor = colorResource(R.color.cyan_1),
                centeredImage = R.drawable.ic_internet_32_dp,
                limit = 50000L,
                left = 10000L,
                typeName = INTERNET_TYPE
            )
        val Call
            @Composable get() = AnimatedLeftOverParams(
                size = 60.dp,
                arcBackgroundColor = ChiliTheme.Colors.ChiliLeftOverBackgroundColor,
                arcProgressColor = colorResource(R.color.green_1),
                centeredImage = R.drawable.ic_calls_outer_32_dp,
                limit = 50000L,
                left = 10000L,
                typeName = CALL_TYPE
            )
    }
}