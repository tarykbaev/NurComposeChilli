package com.design.composechili.components.containers.highlight

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

enum class HighlightState {
    WITH_CIRCLE_AND_ICON,
    WITH_LINE_ONLY,
    WITHOUT_HIGHLIGHT
}

/**
 * @param [borderWidth] Sets the width of the border around the container.
 * @param [cornerRadius] Sets the radius of the container's rounded corners.
 * @param [highlighterColorStart] The starting color of the gradient applied to the highlight.
 * @param [highlighterColorEnd] The ending color of the gradient applied to the highlight; if null,
 * [highlighterColorStart] will be used.
 * @param [highlighterIcon] Accepts a [Drawable] icon to be displayed within the circle highlight.
 * @param [highlightState] Defines the style of the highlight: [HighlightState.WITH_CIRCLE_AND_ICON],
 * [HighlightState.WITH_LINE_ONLY], or [HighlightState.WITHOUT_HIGHLIGHT].
 * @param [content] A composable content block displayed inside the HighlightContainer.
 */
@Composable
fun HighlightContainer(
    modifier: Modifier = Modifier,
    borderWidth: Dp = ChiliTheme.Attribute.ChiliHighLightContainerBorderWidth,
    cornerRadius: Dp = ChiliTheme.Attribute.ChiliHighLightContainerCornerRadius,
    highlighterColorStart: Color = Color.Transparent,
    highlighterColorEnd: Color? = null,
    highlighterIcon: Drawable? = null,
    highlightState: HighlightState = HighlightState.WITH_LINE_ONLY,
    content: @Composable () -> Unit
) {

    val iconSizePx = LocalDensity.current.run { dimensionResource(R.dimen.view_12dp).toPx() }
    val circleRadiusPx = LocalDensity.current.run { dimensionResource(R.dimen.radius_11dp).toPx() }
    val circleOffsetPx = LocalDensity.current.run { dimensionResource(R.dimen.padding_23dp).toPx() }
    val iconPaddingX = LocalDensity.current.run { dimensionResource(R.dimen.padding_2dp).toPx() }
    val iconPaddingY = LocalDensity.current.run { dimensionResource(R.dimen.padding_3dp).toPx() }

    val borderBrush = Brush.linearGradient(
        colors = listOf(highlighterColorStart, highlighterColorEnd ?: highlighterColorStart)
    )

    ChiliTheme {
        Box(modifier = modifier) {
            content()

            Canvas(
                modifier = Modifier
                    .matchParentSize()
                    .clip(RoundedCornerShape(cornerRadius))
            ) {
                when (highlightState) {
                    HighlightState.WITH_CIRCLE_AND_ICON -> {
                        drawLine(borderBrush, borderWidth, cornerRadius)
                        drawCircleWithIcon(
                            borderBrush,
                            highlighterIcon,
                            iconSizePx,
                            circleRadiusPx,
                            circleOffsetPx,
                            iconPaddingX,
                            iconPaddingY,
                            borderWidth,
                            cornerRadius
                        )
                    }

                    HighlightState.WITH_LINE_ONLY -> {
                        drawLine(borderBrush, borderWidth, cornerRadius)
                    }

                    HighlightState.WITHOUT_HIGHLIGHT -> {}
                }
            }
        }
    }
}

private fun DrawScope.drawLine(
    brush: Brush,
    borderWidth: Dp,
    cornerRadius: Dp
) {
    val inset = borderWidth.toPx() / 2f
    val cornerRadiusPx = cornerRadius.toPx()

    drawRoundRect(
        brush = brush,
        style = Stroke(width = borderWidth.toPx(), cap = StrokeCap.Round),
        cornerRadius = CornerRadius(cornerRadiusPx, cornerRadiusPx),
        topLeft = Offset(inset, inset),
        size = Size(
            width = size.width - borderWidth.toPx(),
            height = size.height - borderWidth.toPx()
        )
    )
}

private fun DrawScope.drawCircleWithIcon(
    brush: Brush,
    highlighterIcon: Drawable?,
    iconSizePx: Float,
    circleRadiusPx: Float,
    circleOffsetPx: Float,
    highlighterPaddingX: Float,
    highlighterPaddingY: Float,
    borderWidth: Dp,
    cornerRadius: Dp
) {
    val circlePosition = Offset(
        x = size.width - circleOffsetPx + cornerRadius.toPx(),
        y = circleOffsetPx - cornerRadius.toPx()
    )
    drawCircle(brush = brush, radius = circleRadiusPx, center = circlePosition)

    highlighterIcon?.let { icon ->
        drawIntoCanvas { canvas ->
            val left = (size.width - iconSizePx - borderWidth.toPx() - highlighterPaddingX).toInt()
            val top = (borderWidth.toPx() + highlighterPaddingY).toInt()
            icon.setBounds(
                left,
                top,
                left + iconSizePx.toInt(),
                top + iconSizePx.toInt()
            )
            icon.draw(canvas.nativeCanvas)
        }
    }
}