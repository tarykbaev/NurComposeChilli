package com.design.composechili.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.spacerVerticalDefaultPadding(topPadding: Dp = 0.dp, bottomPadding: Dp = 0.dp): Modifier {
    return this
        .fillMaxWidth()
        .padding(top = topPadding, bottom = bottomPadding)
}