package com.design.composeNur.extensions

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import kotlin.math.PI
import kotlin.math.pow

fun Modifier.gradientBackground(colors: List<Color>, angle: Float, cornerRadius: Dp) = this.then(
    Modifier.drawBehind {
        val angleRad = angle / 180f * PI
        val x = kotlin.math.cos(angleRad).toFloat()
        val y = kotlin.math.sin(angleRad).toFloat()

        val radius: Float = kotlin.math.sqrt(
            ((size.width.pow(2) + size.height.pow(2))) / 2f
        )
        val offset = center + Offset(x * radius, y * radius)

        val exactOffset = Offset(
            x = kotlin.math.min(offset.x.coerceAtLeast(0f), size.width),
            y = size.height - kotlin.math.min(offset.y.coerceAtLeast(0f), size.height)
        )

        val cornerRadiusPx = cornerRadius.toPx()

        drawRoundRect(
            brush = Brush.linearGradient(
                colors = colors,
                start = Offset(size.width, size.height) - exactOffset,
                end = exactOffset
            ),
            size = size,
            cornerRadius = CornerRadius(cornerRadiusPx)
        )
    }
)