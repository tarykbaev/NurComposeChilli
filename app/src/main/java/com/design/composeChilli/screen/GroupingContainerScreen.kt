package com.design.composeChilli.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.utils.dragContainer
import com.design.composeChilli.utils.draggableItems
import com.design.composeChilli.utils.rememberDragDropState
import com.design.composechili.components.cell.baseCell.NurChiliBaseCell
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.ChiliShadowParams
import com.design.composechili.utils.softLayerShadow

@Composable
fun GroupingContainerScreen() {
    val list1 by remember {
        mutableStateOf(
            listOf(
                listOf("1", "2", "3", "4", "5", "6", "7"),
                listOf("8", "9", "10", "11", "12", "13", "14"),
                listOf("15", "16", "17", "18", "19", "20", "21"),
                listOf("22", "23", "24", "25", "26", "27", "28")
            )
        )
    }
    val stateList = rememberLazyListState()
    var isDraggingEnabled by remember { mutableStateOf(true) }

    val dragDropState =
        rememberDragDropState(
            lazyListState = if (isDraggingEnabled) stateList else rememberLazyListState(),
            items = list1,
            onMove = { fromIndex, toIndex, sublistIndex -> })

    Box {
        LazyColumn(
            modifier = Modifier
                .softLayerShadow(params = ChiliShadowParams.Default.copy(spread = 2.dp))
                .dragContainer(dragDropState)
                .fillMaxWidth(),
            state = if (isDraggingEnabled) stateList else rememberLazyListState(),
            contentPadding = PaddingValues(16.dp),
        ) {
            draggableItems(list1, dragDropState) { modifier, subListIndex, index, value ->
                val isSingleItem = list1[subListIndex].size == 1
                val isFirstItem = index == 0
                val isLastItem = index == list1[subListIndex].lastIndex
                NurChiliBaseCell(
                    modifier = modifier,
                    title = value,
                    isChevronVisible = true,
                    isDividerVisible = !isSingleItem && !isLastItem,
                    cellCornerMode = when {
                        isSingleItem -> CellCornerMode.Single
                        isFirstItem -> CellCornerMode.Top
                        isLastItem -> CellCornerMode.Bottom
                        else -> CellCornerMode.Middle
                    }
                )
                if (isLastItem) {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }

}

@Composable
@Preview
fun GroupingContainerScreenPreview() {
    ChiliTheme {
        GroupingContainerScreen()
    }
}