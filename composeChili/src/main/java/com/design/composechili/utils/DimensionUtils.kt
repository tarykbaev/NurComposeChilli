package com.design.composechili.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

fun Dp.asSp() = this.value.sp

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }