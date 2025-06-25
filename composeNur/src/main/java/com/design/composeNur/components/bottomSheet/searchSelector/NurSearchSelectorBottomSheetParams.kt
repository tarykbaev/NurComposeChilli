package com.design.composeNur.components.bottomSheet.searchSelector

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H8
import com.design.composenur.R

data class NurSearchSelectorBottomSheetParams(
    val searchInputBackgroundColor: Color,
    val groupHeaderTextStyle: TextStyle,
    val searchIcon: Painter? = null,
    val headerBackgroundColor: Color
) {
    companion object {

        val Default
            @Composable get() = NurSearchSelectorBottomSheetParams(
                searchInputBackgroundColor = NurTheme.Colors.NurInputViewBackgroundColor,
                groupHeaderTextStyle = H8.Primary.Default,
                searchIcon = painterResource(R.drawable.nur_ic_search),
                headerBackgroundColor = NurTheme.Colors.NurSurfaceBackground
            )
    }
}