package com.design.composeNur.components.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class PromoBannerCardParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle,
    val backgroundColors: List<Color>,
) {
    companion object {
        val Regular
            @Composable get() = PromoBannerCardParams(
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurBoldTextFont,
                ),
                subtitleStyle = NurTextStyle.get(textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH9),
                backgroundColors = listOf(
                    colorResource(id = R.color.gray_8),
                    colorResource(id = R.color.white_1)
                ),
            )
        val Small
            @Composable get() = PromoBannerCardParams(
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.Nur700TextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                subtitleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH9,
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