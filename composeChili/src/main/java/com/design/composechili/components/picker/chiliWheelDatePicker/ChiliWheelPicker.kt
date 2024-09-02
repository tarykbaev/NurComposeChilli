package com.design.composechili.components.picker.chiliWheelDatePicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.SnapperLayoutInfo
import dev.chrisbanes.snapper.rememberLazyListSnapperLayoutInfo
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlin.math.absoluteValue

@OptIn(ExperimentalSnapperApi::class)
@Composable
internal fun ChiliWheelPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    count: Int,
    rowCount: Int,
    wheeSize: DpSize = DpSize(128.dp, 128.dp),
    chiliWheelPickerSelectorProperties: ChiliWheelPickerSelectorProperties = ChiliWheelPickerSelectorProperties.Default,
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
    content: @Composable LazyItemScope.(index: Int) -> Unit,
) {
    val lazyListState = rememberLazyListState(startIndex)
    val snapperLayoutInfo = rememberLazyListSnapperLayoutInfo(lazyListState = lazyListState)
    val isScrollInProgress = lazyListState.isScrollInProgress

    LaunchedEffect(isScrollInProgress, count) {
        if (!isScrollInProgress) {
            onScrollFinished(calculateSnappedItemIndex(snapperLayoutInfo) ?: startIndex)?.let {
                lazyListState.scrollToItem(it)
            }
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .height(wheeSize.height)
                .width(wheeSize.width),
            state = lazyListState,
            contentPadding = PaddingValues(vertical = wheeSize.height / rowCount * ((rowCount - 1) / 2)),
            flingBehavior = rememberSnapperFlingBehavior(
                lazyListState = lazyListState
            )
        ) {
            items(count) { index ->
                val rotationX = calculateAnimatedRotationX(
                    lazyListState = lazyListState,
                    snapperLayoutInfo = snapperLayoutInfo,
                    index = index,
                    rowCount = rowCount
                )
                Box(
                    modifier = Modifier
                        .height(wheeSize.height / rowCount)
                        .width(wheeSize.width)
                        .alpha(
                            calculateAnimatedAlpha(
                                lazyListState = lazyListState,
                                snapperLayoutInfo = snapperLayoutInfo,
                                index = index,
                                rowCount = rowCount
                            )
                        )
                        .graphicsLayer {
                            this.rotationX = rotationX
                        },
                    contentAlignment = Alignment.Center
                ) {
                    content(index)
                }
            }
        }
    }
}

@OptIn(ExperimentalSnapperApi::class)
private fun calculateSnappedItemIndex(snapperLayoutInfo: SnapperLayoutInfo): Int? {
    var currentItemIndex = snapperLayoutInfo.currentItem?.index

    if (snapperLayoutInfo.currentItem?.offset != 0) {
        if (currentItemIndex != null) {
            currentItemIndex++
        }
    }
    return currentItemIndex
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
private fun calculateAnimatedAlpha(
    lazyListState: LazyListState,
    snapperLayoutInfo: SnapperLayoutInfo,
    index: Int,
    rowCount: Int
): Float {

    val distanceToIndexSnap = snapperLayoutInfo.distanceToIndexSnap(index).absoluteValue
    val layoutInfo = remember { derivedStateOf { lazyListState.layoutInfo } }.value
    val viewPortHeight = layoutInfo.viewportSize.height.toFloat()
    val singleViewPortHeight = viewPortHeight / rowCount

    return if (distanceToIndexSnap in 0..singleViewPortHeight.toInt()) {
        1.2f - (distanceToIndexSnap / singleViewPortHeight)
    } else {
        0.2f
    }
}

@OptIn(ExperimentalSnapperApi::class)
@Composable
private fun calculateAnimatedRotationX(
    lazyListState: LazyListState,
    snapperLayoutInfo: SnapperLayoutInfo,
    index: Int,
    rowCount: Int
): Float {

    val distanceToIndexSnap = snapperLayoutInfo.distanceToIndexSnap(index)
    val layoutInfo = remember { derivedStateOf { lazyListState.layoutInfo } }.value
    val viewPortHeight = layoutInfo.viewportSize.height.toFloat()
    val singleViewPortHeight = viewPortHeight / rowCount
    val animatedRotationX = -20f * (distanceToIndexSnap / singleViewPortHeight)

    return if (animatedRotationX.isNaN()) {
        0f
    } else {
        animatedRotationX
    }
}