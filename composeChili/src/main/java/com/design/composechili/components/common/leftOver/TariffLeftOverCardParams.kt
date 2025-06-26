package com.design.composechili.components.common.leftOver

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class TariffLeftOverCardParams(
    val cardBottomPadding: Dp = 24.dp,
    val rowHorizontalPadding: Dp = 16.dp,
    val rowVerticalPadding: Dp = 12.dp,
    val titleBottomPadding: Dp = 8.dp,
    val leftOverRowHorizontalPadding: Dp = 12.dp,
) {
    companion object {
        val Default @Composable get() = TariffLeftOverCardParams()
    }
}