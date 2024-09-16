package com.design.composechili.components.bottomSheet.searchSelectorBottomSheet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheetParams
import com.design.composechili.components.input.baseInput.BaseInput
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A Bottom Sheet containing search Input field and options filtered by search value.
 * Supports multiple and single option selection
 *
 * @param [modifier] Will be applied to bottomSheetContent root composable content.
 * In this is case root is [LazyColumn]
 * @param [sheetState] Bottom sheet state, hosting state like expanded or not
 * @see [BottomSheetScaffoldState]
 * @param [list] A list of options for the selector. Each item is represented by the [SearchSelectorOptionItem] class.
 * @param [peekHeight] The default peek height used by BottomSheetScaffold.
 * @param [hasCloseIcon] The icon which will show up on the top right corner of the sheet
 * @param [searchHint] The [String] displayed on a search input field hint, Default is empty
 * @param [searchIcon] A drawable resource ID for the search icon. If null, no search icon is displayed.
 * Default is a search icon drawable [R.drawable.chili_ic_search]
 * @param [isHeaderVisible] Controls whether group headers are visible for the options. Default is true
 * @param [isGroupingEnabled] Determines whether the list of options is grouped by the first letter of the item. Default is true.
 * @param [isSingleSelection] Controls whether only one item can be selected (single selection mode). Default is true
 * @param [onOptionClick] A callback function that is triggered when an option is clicked.
 * The selected [SearchSelectorOptionItem] is passed as an argument. Default is an empty lambda
 * @param [params] A custom parameter class for configuring the background color, text styles and e.t.c.
 * The default value uses [SearchSelectorBottomSheetParams.Default]
 * @param [content] Screen content, which should be covered by the [SearchSelectorBottomSheet].
 * Bottom Sheet will show over this content
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSelectorBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    list: List<SearchSelectorOptionItem>,
    peekHeight: Dp = 0.dp,
    hasCloseIcon: Boolean = true,
    searchHint: String = String(),
    @DrawableRes searchIcon: Int? = R.drawable.chili_ic_search,
    isHeaderVisible: Boolean = true,
    isGroupingEnabled: Boolean = true,
    isSingleSelection: Boolean = true,
    onOptionClick: (option: SearchSelectorOptionItem) -> Unit = {},
    params: SearchSelectorBottomSheetParams = SearchSelectorBottomSheetParams.Default,
    content: @Composable () -> Unit
) {

    fun filterList(filter: String = ""): List<Pair<Type, Any>> {
        val filteredList = list.filter { it.value.contains(filter, true) }
        val sortedList = if (isGroupingEnabled) filteredList.groupBy {
            it.value.firstOrNull()?.uppercase().orEmpty()
        } else mapOf("" to filteredList)
        val newList = mutableListOf<Pair<Type, Any>>()
        sortedList.forEach {
            if (isHeaderVisible) newList.add(Type.HEADER to it.key)
            it.value.forEach { item ->
                newList.add(Type.ITEM to item.copy())
            }
        }
        return newList
    }

    var options by remember { mutableStateOf(filterList()) }
    var textValue by remember { mutableStateOf("") }

    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            hasCloseIcon = hasCloseIcon,
            baseBottomSheetParams = BaseBottomSheetParams.Default.copy(
                bottomSheetContentBackgroundColor = ChiliTheme.Colors.ChiliBottomSheetGrayBackgroundColor
            ),
            bottomSheetContent = {
                LazyColumn(
                    modifier = modifier.fillMaxWidth()
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
                            if (searchIcon != null) {
                                Image(
                                    modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_8dp)),
                                    painter = painterResource(id = searchIcon),
                                    contentDescription = "Search"
                                )
                            }
                            BaseInput(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textFieldValue = textValue,
                                hint = searchHint,
                                params = BaseInputParams.Default.copy(
                                    textFieldPadding = PaddingValues(dimensionResource(id = R.dimen.padding_0dp)),
                                    fieldBackground = Color.Transparent
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
                            Type.ITEM -> SearchSelectorBottomSheetOption(
                                option = option.second as SearchSelectorOptionItem,
                                isDividerVisible = when {
                                    index == options.size - 1 -> false
                                    options[index + 1].first == Type.HEADER -> false
                                    else -> true
                                },
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
                            Type.HEADER -> Text(
                                modifier = Modifier.padding(
                                    horizontal = dimensionResource(id = R.dimen.padding_16dp),
                                    vertical = dimensionResource(id = R.dimen.padding_8dp)
                                ),
                                text = option.second as String,
                                style = params.groupHeaderTextStyle
                            )
                        }
                    }
                }
            },
            screenContent = { content() }
        )
    }
}

data class SearchSelectorBottomSheetParams(
    val searchInputBackgroundColor: Color,
    val groupHeaderTextStyle: TextStyle
) {
    companion object {
        val Default
            @Composable get() = SearchSelectorBottomSheetParams(
                searchInputBackgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                groupHeaderTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                )
            )
    }
}

private enum class Type { HEADER, ITEM }

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchSelectorBottomSheetPreview() {
    ChiliTheme {
        val sheetState = getBottomSheetState()

        SearchSelectorBottomSheet(
            sheetState = sheetState,
            peekHeight = 272.dp,
            list = listOf(SearchSelectorOptionItem("1", "Option 1", true))
        ) {

        }
    }
}
