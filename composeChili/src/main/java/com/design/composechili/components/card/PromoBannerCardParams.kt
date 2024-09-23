package com.design.composechili.components.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class PromoBannerCardParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle,
    val backgroundColors: List<Color>,
) {
    companion object {
        val Regular
            @Composable get() = PromoBannerCardParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont,
                ),
                subtitleStyle = ChiliTextStyle.get(textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9),
                backgroundColors = listOf(
                    colorResource(id = R.color.gray_8),
                    colorResource(id = R.color.white_1)
                ),
            )
        val Small
            @Composable get() = PromoBannerCardParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.Chili700TextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                subtitleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                    color = colorResource(id = R.color.white_1)
                ),
                backgroundColors = listOf(
                    Color(0xFF321B28),
                    colorResource(id = R.color.black_3),
                    colorResource(id = R.color.black_3)
                ),
            )
    }
}