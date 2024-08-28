package com.design.composechili.components.tooltip

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

@Composable
fun BubbleLayout(
    modifier: Modifier = Modifier,
    pathColor: Color,
    alignment: TooltipAlignment = TooltipAlignment.BottomCenter,
    arrowHeight: Dp,
    arrowPositionX: Float,
    content: @Composable () -> Unit,
) {

    val arrowHeightPx = with(LocalDensity.current) {
        arrowHeight.toPx()
    }

    Box(
        modifier = modifier
            .drawBehind {
                if (arrowPositionX <= 0f) return@drawBehind

                val isTopCenter = alignment == TooltipAlignment.BottomCenter

                val path = Path()

                if (isTopCenter) {
                    val position = Offset(arrowPositionX, 0f)
                    path.apply {
                        moveTo(x = position.x, y = position.y)
                        lineTo(x = position.x - arrowHeightPx, y = position.y)
                        lineTo(x = position.x, y = position.y - arrowHeightPx)
                        lineTo(x = position.x + arrowHeightPx, y = position.y)
                        lineTo(x = position.x, y = position.y)
                    }
                } else {
                    val arrowY = drawContext.size.height
                    val position = Offset(arrowPositionX, arrowY)
                    path.apply {
                        moveTo(x = position.x, y = position.y)
                        lineTo(x = position.x + arrowHeightPx, y = position.y)
                        lineTo(x = position.x, y = position.y + arrowHeightPx)
                        lineTo(x = position.x - arrowHeightPx, y = position.y)
                        lineTo(x = position.x, y = position.y)
                    }
                }

                drawPath(
                    path = path,
                    color = pathColor,
                )
                path.close()
            }
    ) {
        content()
    }
}