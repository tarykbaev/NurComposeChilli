package com.design.composechili.components.bottomSheet.searchSelectorBottomSheet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

/**
 *
 * An Option component for SearchSelectorBottomSheet. It displays single option value
 *
 * @param [option] This represents a single option in the selector list.
 * It contains the [SearchSelectorOptionItem.id], [SearchSelectorOptionItem.value], and [SearchSelectorOptionItem.isSelected] state,
 * which indicates whether the option is currently selected.
 * @param [isDividerVisible] Determines if a divider is visible below the option in the list.
 * The divider is used to separate options visually. Default is true.
 * @param [selectedIcon] A drawable resource ID for the icon that is displayed when the option is selected.
 * By default, it uses a checkmark icon [R.drawable.chili_ic_checkmark].
 * @param [onOptionClick] A callback function that is triggered when the option is clicked.
 * It passes the SearchSelectorOptionItem to the calling function.
 * @param [params] A set of parameters that control the padding, text style, and background color of the option.
 * Default is [SearchSelectorBottomSheetOptionParams.Default]
 *
 */

@Composable
fun SearchSelectorBottomSheetOption(
    modifier: Modifier = Modifier,
    option: SearchSelectorOptionItem,
    isDividerVisible: Boolean = true,
    @DrawableRes selectedIcon: Int = R.drawable.chili_ic_checkmark,
    onOptionClick: (option: SearchSelectorOptionItem) -> Unit,
    params: SearchSelectorBottomSheetOptionParams = SearchSelectorBottomSheetOptionParams.Default
) {

    Box(
        modifier = modifier.background(color = params.backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .clickable { onOptionClick.invoke(option) }
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(
                        top = params.contentPadding.top,
                        bottom = params.contentPadding.bottom,
                        start = params.contentPadding.start
                    )
                    .align(Alignment.CenterVertically),
                text = option.value,
                style = params.valueTextStyle
            )
            if (option.isSelected) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = params.contentPadding.end),
                    painter = painterResource(id = selectedIcon),
                    contentDescription = "Selected icon"
                )
            }
        }
        if (isDividerVisible) {
            HorizontalDivider(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = dimensionResource(id = R.dimen.padding_8dp)),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
        }
    }
}

data class SearchSelectorOptionItem(
    val id: String,
    val value: String,
    var isSelected: Boolean
)

data class SearchSelectorBottomSheetOptionParams(
    val contentPadding: ChiliPadding,
    val valueTextStyle: TextStyle,
    val backgroundColor: Color
) {
    companion object {
        val Default
            @Composable get() = SearchSelectorBottomSheetOptionParams(
                contentPadding = ChiliPadding(
                    top = dimensionResource(id = R.dimen.padding_16dp),
                    bottom = dimensionResource(id = R.dimen.padding_16dp),
                    start = dimensionResource(id = R.dimen.padding_16dp),
                    end = dimensionResource(id = R.dimen.padding_8dp)
                ), valueTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ), backgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground
            )
    }
}

@Preview
@Composable
fun SearchSelectorBottomSheetOptionPreview() {
    ChiliTheme {
        SearchSelectorBottomSheetOption(
            option = SearchSelectorOptionItem("1", "Option 1", true),
            onOptionClick = {}
        )
    }
}