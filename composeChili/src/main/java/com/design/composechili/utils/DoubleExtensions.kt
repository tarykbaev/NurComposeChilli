package com.design.composechili.utils

import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.abs

val Double.toThreeDigitsFormat: String
    get() {
        return when {
            (abs(this) < 10.0) -> this.round("0.00")
            (abs(this) in 10.0..100.0) -> this.round("#.0")
            else -> this.round("#")
        }.replace(".", ",")
    }

private fun Double.round(format: String = "#.##", roundingMode: RoundingMode? = null): String {
    val df = DecimalFormat(format)
    roundingMode?.let { df.roundingMode = roundingMode }
    return df.format(this).replace(".", ",")
}
