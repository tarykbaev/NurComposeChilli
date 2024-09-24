package com.design.composechili.components.card

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class CategoryCardParams(
    val style: TextStyle,
    val alignment: Alignment.Horizontal,
) {
    companion object {
        val LeftAligned
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                alignment = Alignment.Start
            )
        val Centered
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                alignment = Alignment.CenterHorizontally
            )
        val LeftAligned8Dp
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                ),
                alignment = Alignment.Start
            )
    }
}
