package com.design.composechili.components.bottomSheet.lazy

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.base.NurModalBottomSheet
import com.design.composechili.components.cell.radioButtonCell.RadioButtonCell
import com.design.composechili.theme.ChiliTheme
import kotlin.random.Random

/**
 * RecycleBottomSheet is a reusable component that displays a bottom sheet with a customizable list.
 * You can provide a list of items, a custom layout for each item, and a header with a title and subtitle.
 *
 * @param modifier Modifier for applying layout changes to the LazyColumn in the bottom sheet.
 * @param isVisible Controls the visibility of the bottom sheet.
 * @param swipeToDismissEnabled Enables swipe-to-dismiss gesture for the bottom sheet.
 * @param title The title text to be displayed at the top of the bottom sheet.
 * @param subtitle The subtitle text to be displayed below the title.
 * @param listOfItems The list of items to be displayed inside the bottom sheet.
 * @param onItemClick A callback invoked when an item in the list is clicked.
 * @param isVisibleDivider If true, a divider will be shown between list items (except the last).
 * @param params Optional parameter for styling and configuration options for the bottom sheet.
 * @param composableItem A composable function for rendering each item in the list. Provides the item and click handler.
 * @param onDismissRequest Callback triggered when the bottom sheet is requested to be dismissed.
 *
 * @see [NurModalBottomSheet]
 * @see [NurLazyBottomSheetContentParams]
 * @see [HorizontalDivider]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> NurLazyBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    swipeToDismissEnabled: Boolean = false,
    title: String,
    subtitle: String,
    listOfItems: List<T>,
    onItemClick: (T) -> Unit = {},
    isVisibleDivider: Boolean = true,
    params: NurLazyBottomSheetContentParams = NurLazyBottomSheetContentParams.Default,
    composableItem: @Composable LazyItemScope.(T, (T) -> Unit) -> Unit,
    onDismissRequest: () -> Unit,
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        swipeToDismissEnabled = swipeToDismissEnabled,
        hasCloseIcon = false,
        dragHandle = {},
        onDismissRequest = onDismissRequest
    ) {
        NurLazyBottomSheetContent(
            title = title,
            subtitle = subtitle,
            listOfItems = listOfItems,
            onItemClick = onItemClick,
            isVisibleDivider = isVisibleDivider,
            params = params,
            composableItem = composableItem
        )
    }
}

@Composable
private fun <T> NurLazyBottomSheetContent(
    title: String,
    subtitle: String,
    listOfItems: List<T>,
    onItemClick: (T) -> Unit,
    isVisibleDivider: Boolean,
    params: NurLazyBottomSheetContentParams,
    composableItem: @Composable LazyItemScope.(T, (T) -> Unit) -> Unit
) {
    LazyColumn {
        item {
            Column(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = title,
                    style = params.titleStyle
                )
                Text(
                    text = subtitle,
                    style = params.subtitleStyle
                )
            }
        }
        itemsIndexed(listOfItems) { index, itemData ->
            composableItem(itemData, onItemClick)
            if (index != listOfItems.lastIndex && isVisibleDivider) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = ChiliTheme.Colors.ChiliDividerColor,
                    thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun NurLazyBottomSheetContentPreview() {
    ChiliTheme {
        NurLazyBottomSheetContent(
            title = "Choose option",
            subtitle = "Select one from list",
            listOfItems = listOf("One", "Two", "Three"),
            onItemClick = {},
            isVisibleDivider = true,
            params = NurLazyBottomSheetContentParams.Default,
            composableItem = { item, onClick ->
                RadioButtonCell(
                    title = item,
                    subtitle = "Subtitle",
                    onItemClick = { onClick(item) }
                )
            }
        )
    }
}