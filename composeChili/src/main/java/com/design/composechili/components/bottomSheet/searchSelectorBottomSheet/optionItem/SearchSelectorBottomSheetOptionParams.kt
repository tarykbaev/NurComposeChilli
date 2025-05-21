package com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H7
import com.design.composechili.values.ChiliPadding

data class SearchSelectorBottomSheetOptionParams(
    val contentPadding: ChiliPadding,
    val valueTextStyle: TextStyle,
    val backgroundColor: Color,
    val icon: Painter
) {
    companion object {

        val Default
            @Composable get() = SearchSelectorBottomSheetOptionParams(
                contentPadding = ChiliPadding(
                    top = dimensionResource(id = R.dimen.padding_16dp),
                    bottom = dimensionResource(id = R.dimen.padding_16dp),
                    start = dimensionResource(id = R.dimen.padding_16dp),
                    end = dimensionResource(id = R.dimen.padding_8dp)
                ),
                valueTextStyle = H7.Primary.Default,
                backgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                icon = painterResource(R.drawable.chili_ic_checkmark)
            )
    }
}