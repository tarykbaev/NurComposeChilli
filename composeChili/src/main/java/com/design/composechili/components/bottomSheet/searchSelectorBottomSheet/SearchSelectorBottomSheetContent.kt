package com.design.composechili.components.bottomSheet.searchSelectorBottomSheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem.SearchSelectorBottomSheetOption
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem.SearchSelectorOptionItem
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.components.input.baseInput.NurChiliBaseInput
import com.design.composechili.theme.ChiliTheme

/**
 * A Bottom Sheet containing search Input field and options filtered by search value.
 * Supports multiple and single option selection
 *
 * @param [modifier] Will be applied to bottomSheetContent root composable content.
 * In this is case root is [LazyColumn]
 * @param [list] A list of options for the selector. Each item is represented by the [com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem.SearchSelectorOptionItem] class.
 * @param [searchHint] The [String] displayed on a search input field hint, Default is empty
 * Default is a search icon drawable [R.drawable.chili_ic_search]
 * @param [isHeaderVisible] Controls whether group headers are visible for the options. Default is true
 * @param [isGroupingEnabled] Determines whether the list of options is grouped by the first letter of the item. Default is true.
 * @param [isSingleSelection] Controls whether only one item can be selected (single selection mode). Default is true
 * @param [onOptionClick] A callback function that is triggered when an option is clicked.
 * The selected [com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem.SearchSelectorOptionItem] is passed as an argument. Default is an empty lambda
 * @param [params] A custom parameter class for configuring the background color, text styles and e.t.c.
 * The default value uses [SearchSelectorBottomSheetParams.Default]
 *
 */

@Composable
fun SearchSelectorBottomSheetContent(
    modifier: Modifier = Modifier,
    list: List<SearchSelectorOptionItem>,
    searchHint: String = String(),
    isHeaderVisible: Boolean = true,
    isGroupingEnabled: Boolean = true,
    isSingleSelection: Boolean = true,
    params: SearchSelectorBottomSheetParams = SearchSelectorBottomSheetParams.Default,
    inputParams: BaseInputParams = BaseInputParams.Default,
    onOptionClick: (option: SearchSelectorOptionItem) -> Unit = {},
) {

    fun filterList(filter: String = String()): List<Pair<Type, Any>> {
        val newList = list
            .filter { it.value.contains(filter, ignoreCase = true) }
            .groupBy {
                if (isGroupingEnabled) it.value.firstOrNull()?.uppercase().orEmpty() else String()
            }

        return newList.flatMap { (header, items) ->
            val section = mutableListOf<Pair<Type, Any>>()
            if (isHeaderVisible) section.add(Type.HEADER to header)
            section.addAll(items.map { Type.ITEM to it.copy() })
            section
        }
    }

    var options by remember { mutableStateOf(filterList()) }
    var textValue by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
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
                if (params.searchIcon != null) {
                    Image(
                        modifier = Modifier
                            .padding(horizontal = dimensionResource(id = R.dimen.padding_8dp)),
                        painter = params.searchIcon,
                        contentDescription = "Search"
                    )
                }
                NurChiliBaseInput(
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
                    },
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

                Type.ITEM -> SearchSelectorBottomSheetOption(
                    option = option.second as SearchSelectorOptionItem,
                    isDividerVisible = index != options.size - 1,
                    onOptionClick = { opt ->
                        list.forEach {
                            it.isSelected = if (isSingleSelection) {
                                it.id == opt.id
                            } else {
                                if (it.id == opt.id) !it.isSelected else it.isSelected
                            }
                        }
                        options = filterList(textValue)
                        onOptionClick.invoke(opt)
                    }
                )
            }
        }
    }
}

private enum class Type { HEADER, ITEM }

@Preview
@Composable
fun SearchSelectorBottomSheetPreview() {
    ChiliTheme {
        SearchSelectorBottomSheetContent(
            list = listOf(
                SearchSelectorOptionItem("1", "Option 1", true)
            )
        )
    }
}
