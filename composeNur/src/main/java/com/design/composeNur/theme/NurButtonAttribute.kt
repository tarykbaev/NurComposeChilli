package com.design.composeNur.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.design.composenur.R

@Immutable
data class NurButtonAttribute(
    // Button
    val NurButtonPaddingTop: Dp,
    val NurButtonPaddingBottom: Dp,
    val NurButtonPaddingStart: Dp,
    val NurButtonPaddingEnd: Dp,

    // Primary Button
    val NurPrimaryButtonCornerRadius: Dp,
    val NurPrimaryButtonTextSize: TextUnit,
    val NurPrimaryButtonTextFont: Font,
    val NurPrimaryButtonTextAllCaps: Boolean,

    // Secondary Button
    val NurSecondaryButtonCornerRadius: Dp,
    val NurSecondaryButtonTextSize: TextUnit,
    val NurSecondaryButtonTextFont: Font,
    val NurSecondaryButtonTextAllCaps: Boolean,

    // Additional
    val NurAdditionalButtonCornerRadius: Dp,
    val NurAdditionalButtonTextSize: TextUnit,
    val NurAdditionalButtonTextFont: Font,
    val NurAdditionalButtonTextAllCaps: Boolean,

    // Component
    val NurComponentButtonCornerRadius: Dp,
    val NurComponentButtonTextSize: TextUnit,
    val NurComponentButtonTextFont: Font,
    val NurComponentButtonHorizontalPadding: Dp,
    val NurComponentButtonVerticalPadding: Dp
) {
    companion object {
        @Composable
        fun getDefault() = NurButtonAttribute(
            NurButtonPaddingTop = 14.dp,
            NurButtonPaddingBottom = 14.dp,
            NurButtonPaddingStart = 24.dp,
            NurButtonPaddingEnd = 24.dp,
            NurPrimaryButtonCornerRadius = 12.dp,
            NurPrimaryButtonTextSize = 16.sp,
            NurPrimaryButtonTextFont = Font(R.font.roboto_medium),
            NurPrimaryButtonTextAllCaps = false,
            NurSecondaryButtonCornerRadius = 12.dp,
            NurSecondaryButtonTextSize = 16.sp,
            NurSecondaryButtonTextFont = Font(R.font.roboto_medium),
            NurSecondaryButtonTextAllCaps = false,
            NurAdditionalButtonCornerRadius = 12.dp,
            NurAdditionalButtonTextSize = 16.sp,
            NurAdditionalButtonTextFont = Font(R.font.roboto_medium),
            NurAdditionalButtonTextAllCaps = false,
            NurComponentButtonCornerRadius = 4.dp,
            NurComponentButtonTextSize = 16.sp,
            NurComponentButtonTextFont = Font(R.font.roboto_regular),
            NurComponentButtonHorizontalPadding = 4.dp,
            NurComponentButtonVerticalPadding = 0.dp

        )
    }
}