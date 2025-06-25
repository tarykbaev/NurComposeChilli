package com.design.composeNur.values

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class NurPadding(
    val top: Dp = 0.dp,
    val bottom: Dp = 0.dp,
    val start: Dp = 0.dp,
    val end: Dp = 0.dp
) {

    constructor(horizontal: Dp, vertical: Dp) : this(vertical, vertical, horizontal, horizontal)

    constructor(size: Dp) : this(size, size, size, size)

    fun toPaddingValues(): PaddingValues {
        return PaddingValues(start, top, end, bottom)
    }
}