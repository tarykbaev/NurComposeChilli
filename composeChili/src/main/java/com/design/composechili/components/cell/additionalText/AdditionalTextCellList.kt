package com.design.composechili.components.cell.additionalText

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.components.cell.model.AdditionalTextCellViewItems
import com.design.composechili.theme.ChiliTheme

/**
 * Displays a list of `AdditionalTextCellView` items in a vertically scrollable column.
 * The list items are styled with appropriate rounded corners depending on their position
 * (top, middle, bottom) within the list.
 *
 * @param modifier A `Modifier` to apply to this layout. Defaults to `Modifier`.
 * @param itemsList A list of `AdditionalTextCellViewItems` representing the data to be displayed
 * in the list. Each item contains the text and description to be displayed in an `AdditionalTextCellView`.
 *
 * The first item in the list has rounded top corners, the last item has rounded bottom corners,
 * and all other items have no rounded corners. A divider is placed between each item, except after
 * the last item.
 *
 * Example usage:
 * ```
 * val items = listOf(
 *     AdditionalTextCellViewItems("Title 1", "Description 1"),
 *     AdditionalTextCellViewItems("Title 2", "Description 2"),
 *     AdditionalTextCellViewItems("Title 3", "Description 3")
 * )
 *
 * AdditionalTextCellViewList(
 *     itemsList = items
 * )
 * ```
 */

@Composable
fun AdditionalTextCellViewList(
    modifier: Modifier = Modifier,
    itemsList: List<AdditionalTextCellViewItems>,
) {
    LazyColumn(modifier = modifier.background(Color.Transparent)) {
        itemsIndexed(itemsList) { index, item ->
            val shape = when (index) {
                0 -> AdditionalTextCellParams.roundedShapeTop
                itemsList.size - 1 -> AdditionalTextCellParams.roundedShapeBottom
                else -> AdditionalTextCellParams.roundedShapeCenter
            }

            AdditionalTextCellView(
                title = item.text,
                description = item.description,
                shape = shape
            )

            if (index != itemsList.size - 1) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = ChiliTheme.Colors.ChiliDividerColor,
                    thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AdditionalTextCellViewList_Preview() {
    ChiliTheme {
        AdditionalTextCellViewList(
            itemsList = listOf(
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                ),
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                ),
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                ),
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                ),
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                )
            )
        )
    }
}

