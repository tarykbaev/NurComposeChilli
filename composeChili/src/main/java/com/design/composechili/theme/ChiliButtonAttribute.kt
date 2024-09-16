package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.design.composechili.R
import com.design.composechili.utils.asSp

@Immutable
data class ChiliButtonAttribute(
    // Button
    val ChiliButtonPaddingTop: Dp,
    val ChiliButtonPaddingBottom: Dp,
    val ChiliButtonPaddingStart: Dp,
    val ChiliButtonPaddingEnd: Dp,

    // Primary Button
    val ChiliPrimaryButtonCornerRadius: Dp,
    val ChiliPrimaryButtonTextSize: TextUnit,
    val ChiliPrimaryButtonTextFont: Font,
    val ChiliPrimaryButtonTextAllCaps: Boolean,

    // Secondary Button
    val ChiliSecondaryButtonCornerRadius: Dp,
    val ChiliSecondaryButtonTextSize: TextUnit,
    val ChiliSecondaryButtonTextFont: Font,
    val ChiliSecondaryButtonTextAllCaps: Boolean,

    // Additional
    val ChiliAdditionalButtonCornerRadius: Dp,
    val ChiliAdditionalButtonTextSize: TextUnit,
    val ChiliAdditionalButtonTextFont: Font,
    val ChiliAdditionalButtonTextAllCaps: Boolean,

    // Component
    val ChiliComponentButtonCornerRadius:Dp,
    val ChiliComponentButtonTextSize:TextUnit,
    val ChiliComponentButtonTextFont:Font,
    val ChiliComponentButtonHorizontalPadding:Dp,
    val ChiliComponentButtonVerticalPadding:Dp
) {
    companion object {
        @Composable
        fun getDefault() = ChiliButtonAttribute(
            ChiliButtonPaddingTop = 14.dp,
            ChiliButtonPaddingBottom = 14.dp,
            ChiliButtonPaddingStart = 24.dp,
            ChiliButtonPaddingEnd = 24.dp,
            ChiliPrimaryButtonCornerRadius = 12.dp,
            ChiliPrimaryButtonTextSize = 14.sp,
            ChiliPrimaryButtonTextFont = Font(R.font.roboto_medium),
            ChiliPrimaryButtonTextAllCaps = false,
            ChiliSecondaryButtonCornerRadius = 12.dp,
            ChiliSecondaryButtonTextSize = 14.sp,
            ChiliSecondaryButtonTextFont = Font(R.font.roboto_medium),
            ChiliSecondaryButtonTextAllCaps = false,
            ChiliAdditionalButtonCornerRadius = 12.dp,
            ChiliAdditionalButtonTextSize = 14.sp,
            ChiliAdditionalButtonTextFont = Font(R.font.roboto_medium),
            ChiliAdditionalButtonTextAllCaps = false,
            ChiliComponentButtonCornerRadius = 4.dp,
            ChiliComponentButtonTextSize = 14.sp,
            ChiliComponentButtonTextFont = Font(R.font.roboto_regular),
            ChiliComponentButtonHorizontalPadding = 4.dp,
            ChiliComponentButtonVerticalPadding = 0.dp

        )
    }
}