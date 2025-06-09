package com.design.composechili.components.bottomSheet.searchSelector

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H8

data class NurSearchSelectorBottomSheetParams(
    val searchInputBackgroundColor: Color,
    val groupHeaderTextStyle: TextStyle,
    val searchIcon: Painter? = null,
    val headerBackgroundColor: Color
) {
    companion object {

        val Default
            @Composable get() = NurSearchSelectorBottomSheetParams(
                searchInputBackgroundColor = ChiliTheme.Colors.ChiliInputViewBackgroundColor,
                groupHeaderTextStyle = H8.Primary.Default,
                searchIcon = painterResource(R.drawable.chili_ic_search),
                headerBackgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground
            )
    }
}