package com.design.composechili.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class ChiliTextDimensions(
    val textSizeH1: TextUnit = 64.sp,
    val textSizeH2: TextUnit = 32.sp,
    val textSizeH3: TextUnit = 28.sp,
    val textSizeH4: TextUnit = 24.sp,
    val textSizeH5: TextUnit = 20.sp,
    val textSizeH6: TextUnit = 18.sp,
    val textSizeH7: TextUnit = 16.sp,
    val textSizeH8: TextUnit = 14.sp,
    val textSizeH9: TextUnit = 12.sp,
    val textSizeH10: TextUnit = 10.sp
)

@Immutable
data class ChiliViewDimensions(
    val viewHeight: Dp = 1.dp,
    val viewWidth: Dp = 1.dp
)

@Immutable
data class ChiliPaddingDimensions(
    val paddingSmall: Dp = 4.dp,
    val paddingMedium: Dp = 8.dp,
    val paddingLarge: Dp = 16.dp
)

@Immutable
data class ChiliCornerDimensions(
    val cornerRadiusSmall: Dp = 4.dp,
    val cornerRadiusMedium: Dp = 8.dp,
    val cornerRadiusLarge: Dp = 12.dp
)

@Immutable
data class ChiliOtherDimensions(
    val snackbarElevation: Dp = 4.dp
)