package com.design.composechili.components.bottomSheet.recycleBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class RecycleBottomSheetParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle
) {
    companion object {
        val Default
            @Composable get() = RecycleBottomSheetParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                subtitleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                    color = ChiliTheme.Colors.ChiliCardErrorTextColor,
                )
            )
    }
}