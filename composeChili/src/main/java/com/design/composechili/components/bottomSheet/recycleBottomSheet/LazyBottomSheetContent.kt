package com.design.composechili.components.bottomSheet.recycleBottomSheet

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
import com.design.composechili.components.cell.radioButtonCell.RadioButtonCell
import com.design.composechili.theme.ChiliTheme
import kotlin.random.Random

/**
 * RecycleBottomSheet is a reusable component that displays a bottom sheet with a customizable list.
 * You can provide a list of items, a custom layout for each item, and a header with a title and subtitle.
 *
 * @param modifier Modifier for applying layout changes to the LazyColumn in the bottom sheet.
 * @param title The title text to be displayed at the top of the bottom sheet.
 * @param subtitle The subtitle text to be displayed below the title.
 * @param listOfItems The list of items to be displayed inside the bottom sheet.
 * @param onItemClick A callback invoked when an item in the list is clicked.
 * @param lazyBottomSheetContentParams Optional parameter for styling and configuration options for the bottom sheet.
 * @param composableItem A composable function for rendering each item in the list.
 *
 * @sample RecycleBottomSheet_Preview
 */

@Composable
fun <T> LazyBottomSheetContent(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    listOfItems: List<T>,
    onItemClick: (T) -> Unit = {},
    isVisibleDivider: Boolean = true,
    params: LazyBottomSheetContentParams = LazyBottomSheetContentParams.Default,
    composableItem: @Composable (LazyItemScope.(T, (T) -> Unit) -> Unit),
) {
    LazyColumn(modifier = modifier) {
        item {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
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
            if (index != listOfItems.size - 1 && isVisibleDivider) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = ChiliTheme.Colors.ChiliDividerColor,
                    thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun RecycleBottomSheet_Preview() {
    val listOfItems = listOf(
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("ELCART ЭЛКАП", "···· 1234"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("ELCART ЭЛКАП", "···· 1234"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
    )
    ChiliTheme {
        LazyBottomSheetContent(
            title = "Это боттомщит со списком",
            subtitle = "Тут можно задать стиль тексту",
            listOfItems = listOfItems,
            onItemClick = {},
            composableItem = { item: SampleRadioItem, onClick: (SampleRadioItem) -> Unit ->
                RadioButtonCell(
                    title = item.title,
                    subtitle = item.subtitle,
                    onItemClick = { onClick(item) }
                )
            }
        )
    }
}

data class SampleRadioItem(
    val title: String,
    val subtitle: String,
    val id: Int = Random.nextInt(1000)
)