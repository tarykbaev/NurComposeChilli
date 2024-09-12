package com.design.composechili.components.bottomSheet.recycleBottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> RecycleBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    peekHeight: Dp = 0.dp,
    title: String,
    subtitle: String,
    listOfItems: List<T>,
    onItemClick: () -> Unit = {},
    composableItem: @Composable (LazyItemScope.(T, () -> Unit) -> Unit),
    screenContent: @Composable () -> Unit,
) {
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            bottomSheetContent = {
                LazyColumn(modifier = modifier) {
                    item {
                        Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                            Text(
                                modifier = Modifier.padding(bottom = 16.dp), text = title,
                                style = ChiliTextStyle.get(
                                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                                )
                            )
                            Text(
                                text = subtitle,
                                style = ChiliTextStyle.get(
                                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                                    color = ChiliTheme.Colors.ChiliCardErrorTextColor,
                                )
                            )
                        }
                    }
                    itemsIndexed(listOfItems) { index, itemData ->
                        composableItem(itemData, onItemClick)
                        if (index != listOfItems.size - 1) {
                            HorizontalDivider(
                                modifier = Modifier.fillMaxWidth(),
                                color = ChiliTheme.Colors.ChiliDividerColor,
                                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                            )
                        }
                    }
                }
            }) {
            screenContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RecycleBottomSheet_Preview() {
    val sheetState = getBottomSheetState()
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
    RecycleBottomSheet(
        sheetState = sheetState,
        peekHeight = 800.dp,
        title = "Это боттомщит где вы можете засетить свой адаптер к ресайклу",
        subtitle = "Тут можно задать стиль тексту",
        listOfItems = listOfItems,
        onItemClick = {},
        composableItem = { item: SampleRadioItem, onClick: () -> Unit ->
            RadioButtonCell(
                title = item.title,
                subtitle = item.subtitle,
                onItemClick = onClick
            )
        }
    ) {}
}

@Composable
fun RadioButtonCell(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onItemClick: () -> Unit
) {
    var selected by remember { mutableStateOf(false) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(
                text = title,
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                )
            )
            Text(
                text = subtitle,
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                )
            )
        }
        Spacer(modifier = modifier.weight(1f))
        RadioButton(selected = selected, onClick = {
            selected = !selected
            onItemClick()
        })
    }
}

data class SampleRadioItem(
    val title: String,
    val subtitle: String,
    val id: Int = Random.nextInt(1000)
)