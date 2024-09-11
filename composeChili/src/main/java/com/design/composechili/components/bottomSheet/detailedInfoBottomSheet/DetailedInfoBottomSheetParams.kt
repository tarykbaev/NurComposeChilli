package com.design.composechili.components.bottomSheet.detailedInfoBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class DetailedInfoBottomSheetParams(
    val textStyle: TextStyle,
){
    companion object{
        val Default @Composable get() = DetailedInfoBottomSheetParams(
            textStyle = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                textAlign = TextAlign.Center
            )
        )
    }
}