package com.design.composeNur.components.tooltip

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp

/**
 * View that covers the space for tooltip [content] + arrow.
 * It also draws the arrow itself by the given [arrowPositionX] and [arrowHeight] and paints it in [pathColor]
 * P.S. our Nur tooltip's arrow points upward only
 */

@Composable
fun BubbleLayout(
    modifier: Modifier = Modifier,
    pathColor: Color,
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

                val path = Path()
                val position = Offset(arrowPositionX, 0f)
                path.apply {
                    moveTo(x = position.x, y = position.y)
                    lineTo(x = position.x - arrowHeightPx, y = position.y)
                    lineTo(x = position.x, y = position.y - arrowHeightPx)
                    lineTo(x = position.x + arrowHeightPx, y = position.y)
                    lineTo(x = position.x, y = position.y)
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