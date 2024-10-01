package com.design.composechili.components.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class CategoryCardParams(
    val style: TextStyle,
    val alignment: Alignment.Horizontal,
    val iconPaddings: PaddingValues
) {
    companion object {
        val LeftAligned
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                alignment = Alignment.Start,
                iconPaddings = PaddingValues(top = 12.dp)
            )
        val Centered
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                alignment = Alignment.CenterHorizontally,
                iconPaddings = PaddingValues(top = 12.dp)
            )
        val LeftAligned8Dp
            @Composable get() = CategoryCardParams(
                style = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                ),
                alignment = Alignment.Start,
                iconPaddings = PaddingValues(top = 8.dp)
            )
    }
}
