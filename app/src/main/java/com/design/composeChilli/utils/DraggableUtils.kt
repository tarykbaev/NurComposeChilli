package com.design.composeChilli.utils

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.zIndex
import kotlinx.coroutines.channels.Channel
import java.util.Collections


inline fun <T : Any> LazyListScope.draggableItems(
    items: List<List<T>>,
    dragDropState: DragDropState<T>,
    crossinline content: @Composable (Modifier, Int, Int, T) -> Unit,
) {
    items.forEachIndexed { subListIndex, subList ->
        itemsIndexed(
            items = subList,
            contentType = { index, _ -> DraggableItem(sublistIndex = subListIndex, index = index) })
        { index, item ->
            val modifier =
                if (dragDropState.draggingSublistIndex == subListIndex && dragDropState.draggingItemIndex == index) {
                    Modifier
                        .zIndex(1f)
                        .graphicsLayer {
                            translationY = dragDropState.delta
                        }
                } else {
                    Modifier
                }
            content(modifier, subListIndex, index, item)
        }
    }
}

fun <T : Any> Modifier.dragContainer(dragDropState: DragDropState<T>): Modifier {
    return this.then(pointerInput(dragDropState) {
        detectDragGesturesAfterLongPress(
            onDrag = { change, offset ->
                change.consume()
                dragDropState.onDrag(offset = offset)
            },
            onDragStart = { offset -> dragDropState.onDragStart(offset) },
            onDragEnd = { dragDropState.onDragInterrupted() },
            onDragCancel = { dragDropState.onDragInterrupted() }
        )
    })
}

@Composable
fun <T : Any> rememberDragDropState(
    lazyListState: LazyListState,
    items: List<List<T>>,
    onMove: (Int?, Int?, Int?) -> Unit
): DragDropState<T> {

    val state =
        remember(lazyListState) {
            DragDropState(
                stateList = lazyListState,
                items = items,
                onMove = onMove,
            )
        }
    LaunchedEffect(state) {
        while (true) {
            val diff = state.scrollChannel.receive()
            lazyListState.scrollBy(diff)
        }
    }
    return state
}

class DragDropState<T : Any>(
    private val stateList: LazyListState,
    private var items: List<List<T>>,
    private val onMove: (Int?, Int?, Int?) -> Unit,
) {

    var draggingItemIndex: Int? by mutableStateOf(null)
    var draggingSublistIndex: Int? by mutableStateOf(null)

    var delta by mutableFloatStateOf(0f)

    val scrollChannel = Channel<Float>()

    private var draggingItem: LazyListItemInfo? = null

    internal fun onDragStart(offset: Offset) {
        stateList.layoutInfo.visibleItemsInfo
            .firstOrNull { item -> offset.y.toInt() in item.offset..(item.offset + item.size) }
            ?.also {
                (it.contentType as? DraggableItem)?.let { draggableItem ->
                    draggingItem = it
                    draggingItemIndex = draggableItem.index
                    draggingSublistIndex = draggableItem.sublistIndex
                }
            }
    }

    internal fun onDragInterrupted() {
        draggingItem = null
        draggingSublistIndex = null
        draggingItemIndex = null
        delta = 0f
    }

    internal fun onDrag(offset: Offset) {
        delta += offset.y

        val currentDraggingItemIndex = draggingItemIndex ?: return
        val currentDraggingSublistIndex = draggingSublistIndex ?: return
        val currentDraggingItem = draggingItem ?: return

        val startOffset = currentDraggingItem.offset + delta
        val endOffset =
            currentDraggingItem.offset + currentDraggingItem.size + delta
        val middleOffset = startOffset + (endOffset - startOffset) / 2

        val targetItem =
            stateList.layoutInfo.visibleItemsInfo.find { item ->
                middleOffset.toInt() in item.offset..item.offset + item.size &&
                        currentDraggingItem.index != item.index &&
                        getItemSublistIndex(item.index) == currentDraggingSublistIndex &&
                        item.contentType is DraggableItem
            }

        if (targetItem != null) {
            val targetIndex = (targetItem.contentType as DraggableItem).index
            val subList = items.getOrNull(currentDraggingSublistIndex)
            subList?.let {
                Collections.swap(subList, currentDraggingItemIndex, targetIndex)
            }
            onMove(currentDraggingItemIndex, targetIndex, currentDraggingSublistIndex)
            draggingItemIndex = targetIndex
            delta += currentDraggingItem.offset - targetItem.offset
            draggingItem = targetItem
        } else {
            val startOffsetToTop = startOffset - stateList.layoutInfo.viewportStartOffset
            val endOffsetToBottom = endOffset - stateList.layoutInfo.viewportEndOffset
            val scroll =
                when {
                    startOffsetToTop < 0 -> startOffsetToTop.coerceAtMost(0f)
                    endOffsetToBottom > 0 -> endOffsetToBottom.coerceAtLeast(0f)
                    else -> 0f
                }

            if (scroll != 0f && currentDraggingItemIndex != 0 && currentDraggingItemIndex != stateList.layoutInfo.totalItemsCount - 1) {
                scrollChannel.trySend(scroll)
            }
        }
    }

    private fun getItemSublistIndex(index: Int?): Int? {
        if (index == null) return null
        var currentIndex = 0
        items.forEachIndexed { sublistIndex, sublist ->
            val sublistStart = currentIndex
            if (index in sublistStart..<currentIndex + sublist.size) {
                return sublistIndex
            }
            currentIndex += sublist.size
        }
        return null
    }
}

data class DraggableItem(val sublistIndex: Int, val index: Int)