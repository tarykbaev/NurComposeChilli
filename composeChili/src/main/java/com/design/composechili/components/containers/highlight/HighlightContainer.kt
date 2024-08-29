package com.design.composechili.components.containers.highlight

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HighlightContainer(
    modifier: Modifier = Modifier,
    borderWidth: Dp = 2.dp,
    cornerRadius: Dp = 16.dp,
    highlighterColor: Color = Color.Green,
    borderGradient: Brush,
    highlighterGradientStartColor: Color? = null,
    highlighterGradientEndColor: Color? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .drawBehind {
                val strokeWidth = borderWidth.toPx()
                val inset = strokeWidth / 2
                drawRoundRect(
                    brush = borderGradient,
                    style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                    cornerRadius = CornerRadius(cornerRadius.toPx(), cornerRadius.toPx()),
                    topLeft = Offset(inset, inset),
                    size = Size(
                        width = size.width - strokeWidth,
                        height = size.height - strokeWidth
                    )
                )
            }
            .padding(5.dp)
    ) {
        content()
    }
}