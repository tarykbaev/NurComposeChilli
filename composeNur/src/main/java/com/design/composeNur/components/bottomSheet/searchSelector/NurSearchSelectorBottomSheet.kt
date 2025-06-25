package com.design.composeNur.components.bottomSheet.searchSelector

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.components.bottomSheet.base.NurModalBottomSheet
import com.design.composeNur.components.bottomSheet.searchSelector.optionItem.NurSearchSelectorBottomSheetOption
import com.design.composeNur.components.bottomSheet.searchSelector.optionItem.SearchSelectorOptionItem
import com.design.composeNur.components.input.baseInput.BaseInputParams
import com.design.composeNur.components.input.baseInput.NurBaseInput
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A Bottom Sheet containing search Input field and options filtered by search value.
 * Supports multiple and single option selection
 *
 * @param [modifier] Will be applied to bottomSheetContent root composable content.
 * In this is case root is [LazyColumn]
 * @param [list] A list of options for the selector. Each item is represented by the [com.design.composeNur.components.bottomSheet.searchSelector.optionItem.SearchSelectorOptionItem] class.
 * @param [searchHint] The [String] displayed on a search input field hint, Default is empty
 * Default is a search icon drawable [R.drawable.Nur_ic_search]
 * @param [isHeaderVisible] Controls whether group headers are visible for the options. Default is true
 * @param [isGroupingEnabled] Determines whether the list of options is grouped by the first letter of the item. Default is true.
 * @param [isSingleSelection] Controls whether only one item can be selected (single selection mode). Default is true
 * @param [onOptionClick] A callback function that is triggered when an option is clicked.
 * The selected [com.design.composeNur.components.bottomSheet.searchSelector.optionItem.SearchSelectorOptionItem] is passed as an argument. Default is an empty lambda
 * @param [params] A custom parameter class for configuring the background color, text styles and e.t.c.
 * The default value uses [NurSearchSelectorBottomSheetParams.Default]
 *
 * @see NurModalBottomSheet
 * @see NurSearchSelectorBottomSheetOption
 * @see SearchSelectorOptionItem
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurSearchSelectorBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    dragHandle: @Composable () -> Unit = { BottomSheetDefaults.DragHandle() },
    list: List<SearchSelectorOptionItem>,
    searchHint: String = "",
    isHeaderVisible: Boolean = true,
    isGroupingEnabled: Boolean = true,
    isSingleSelection: Boolean = true,
    params: NurSearchSelectorBottomSheetParams = NurSearchSelectorBottomSheetParams.Default,
    inputParams: BaseInputParams = BaseInputParams.Default,
    onOptionClick: (SearchSelectorOptionItem) -> Unit = {},
    onDismissRequest: () -> Unit,
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        dragHandle = dragHandle,
        onDismissRequest = onDismissRequest
    ) {
        NurSearchSelectorBottomSheetContent(
            list = list,
            searchHint = searchHint,
            isHeaderVisible = isHeaderVisible,
            isGroupingEnabled = isGroupingEnabled,
            isSingleSelection = isSingleSelection,
            params = params,
            inputParams = inputParams,
            onOptionClick = onOptionClick
        )
    }
}

@Composable
private fun NurSearchSelectorBottomSheetContent(
    list: List<SearchSelectorOptionItem>,
    searchHint: String,
    isHeaderVisible: Boolean,
    isGroupingEnabled: Boolean,
    isSingleSelection: Boolean,
    params: NurSearchSelectorBottomSheetParams,
    inputParams: BaseInputParams,
    onOptionClick: (SearchSelectorOptionItem) -> Unit
) {
    fun filterList(filter: String): List<Pair<Type, Any>> {
        val grouped = list
            .filter { it.value.contains(filter, ignoreCase = true) }
            .groupBy {
                if (isGroupingEnabled) it.value.firstOrNull()?.uppercase().orEmpty() else ""
            }

        return grouped.flatMap { (header, items) ->
            val section = mutableListOf<Pair<Type, Any>>()
            if (isHeaderVisible) section.add(Type.HEADER to header)
            section.addAll(items.map { Type.ITEM to it.copy() })
            section
        }
    }

    var options by remember { mutableStateOf(filterList("")) }
    var textValue by remember { mutableStateOf("") }

    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_16dp))
                    .background(
                        color = params.searchInputBackgroundColor,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp))
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                params.searchIcon?.let {
                    Image(
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_8dp)),
                        painter = it,
                        contentDescription = "Search"
                    )
                }
                NurBaseInput(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textFieldValue = textValue,
                    hint = searchHint,
                    params = inputParams.copy(
                        textFieldPadding = PaddingValues(dimensionResource(id = R.dimen.padding_0dp)),
                        fieldBackground = params.searchInputBackgroundColor
                    ),
                    onValueChange = {
                        textValue = it
                        options = filterList(it)
                    }
                )
            }
        }

        itemsIndexed(options) { index, option ->
            when (option.first) {
                Type.HEADER -> Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = params.headerBackgroundColor)
                        .padding(
                            horizontal = dimensionResource(id = R.dimen.padding_16dp),
                            vertical = dimensionResource(id = R.dimen.padding_8dp)
                        ),
                    text = option.second as String,
                    style = params.groupHeaderTextStyle
                )

                Type.ITEM -> NurSearchSelectorBottomSheetOption(
                    option = option.second as SearchSelectorOptionItem,
                    isDividerVisible = index != options.lastIndex,
                    onOptionClick = { selected ->
                        list.forEach {
                            it.isSelected = if (isSingleSelection) {
                                it.id == selected.id
                            } else {
                                if (it.id == selected.id) !it.isSelected else it.isSelected
                            }
                        }
                        options = filterList(textValue)
                        onOptionClick.invoke(selected)
                    }
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun NurSearchSelectorBottomSheetContentPreview() {
    val list = listOf(
        SearchSelectorOptionItem("1", "Option 1", false),
        SearchSelectorOptionItem("2", "Example 2", false),
        SearchSelectorOptionItem("3", "Test 3", true),
        SearchSelectorOptionItem("4", "Random 4", false),
    )
    NurTheme {
        NurSearchSelectorBottomSheetContent(
            list = list,
            searchHint = "Search...",
            isHeaderVisible = true,
            isGroupingEnabled = true,
            isSingleSelection = true,
            params = NurSearchSelectorBottomSheetParams.Default,
            inputParams = BaseInputParams.Default,
            onOptionClick = {}
        )
    }
}

private enum class Type { HEADER, ITEM }