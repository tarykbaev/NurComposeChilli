package com.design.composechili.components.tooltip

import android.view.View
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import androidx.compose.ui.window.PopupProperties

/**
 * Tooltip Popup view. Opens a [Popup] with the tooltip [content] in the [BubbleLayout] (content + arrow)
 * @param [backgroundShape] defines the shape of the tooltip
 * @param [backgroundColor] defines the color of the tooltip and its arrow
 * @param [arrowHeight] defines the height of the arrow
 * @param [offset] is used to place the tooltip with arrow under the requesterView with added vertical padding
 * @param [horizontalPadding] defines the horizontal padding for tooltip
 * @param [verticalPadding] defines the vertical padding for tooltip and its arrow from the requesterView
 * @param [content] view which is displayed in the tooltip, i.e. its content
 */

@Composable
fun ChiliTooltipPopup(
    backgroundShape: Shape,
    backgroundColor: Color,
    arrowHeight: Dp,
    offset: IntOffset = IntOffset(0, 0),
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp,
    onDismissRequest: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val horizontalPaddingInPx = with(LocalDensity.current) {
        horizontalPadding.toPx()
    }
    val verticalPaddingInPx = with(LocalDensity.current) {
        verticalPadding.toPx() + arrowHeight.toPx()
    }

    var arrowPositionX by remember { mutableFloatStateOf(0f) }

    val popupPositionProvider = remember(offset) {
        TooltipAlignmentOffsetPositionProvider(
            offset = offset,
            horizontalPaddingInPx = horizontalPaddingInPx,
            verticalPaddingInPx = verticalPaddingInPx,
        ) { position ->
            arrowPositionX = position
        }
    }

    Popup(
        popupPositionProvider = popupPositionProvider,
        onDismissRequest = onDismissRequest,
        properties = PopupProperties(dismissOnBackPress = false),
    ) {
        BubbleLayout(
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .background(
                    color = backgroundColor,
                    shape = backgroundShape,
                ),
            arrowHeight = arrowHeight,
            arrowPositionX = arrowPositionX,
            pathColor = backgroundColor
        ) {
            content()
        }
    }
}

internal class TooltipAlignmentOffsetPositionProvider(
    private val offset: IntOffset,
    private val horizontalPaddingInPx: Float,
    private val verticalPaddingInPx: Float,
    private val onArrowPositionX: (Float) -> Unit,
) : PopupPositionProvider {

    override fun calculatePosition(
        anchorBounds: IntRect,
        windowSize: IntSize,
        layoutDirection: LayoutDirection,
        popupContentSize: IntSize
    ): IntOffset {
        val tooltipWidth = windowSize.width - (horizontalPaddingInPx * 2).toInt()
        val popupPositionX = horizontalPaddingInPx.toInt()
        val popupPositionY = anchorBounds.top + offset.y + verticalPaddingInPx.toInt()
        val arrowPosition = (tooltipWidth / 2).toFloat()
        onArrowPositionX.invoke(arrowPosition)
        return IntOffset(popupPositionX, popupPositionY)
    }
}

fun calculateTooltipPopupPosition(
    view: View,
    coordinates: LayoutCoordinates?,
): IntOffset {
    coordinates ?: return IntOffset(0, 0)

    val visibleWindowBounds = android.graphics.Rect()
    view.getWindowVisibleDisplayFrame(visibleWindowBounds)

    val boundsInWindow = coordinates.boundsInWindow()

    val centerPositionX = boundsInWindow.right - (boundsInWindow.right - boundsInWindow.left) / 2
    val offsetX = centerPositionX - visibleWindowBounds.centerX()
    val offset = IntOffset(
        y = coordinates.size.height,
        x = offsetX.toInt()
    )

    return offset
}