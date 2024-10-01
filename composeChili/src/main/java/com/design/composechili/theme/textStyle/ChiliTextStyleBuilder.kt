package com.design.composechili.theme.textStyle

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import kotlin.random.Random

class ChiliTextStyleBuilder {

    companion object {
        val H1
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1)

        val H2
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH2)

        val H3
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH3)

        val H4
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4)

        val H5
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5)

        val H6
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6)

        val H7
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7)

        val H8
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8)

        val H9
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9)

        val H10
            @Composable
            get() = TextStyleColors(ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH10)

        val Default
        @Composable
        get() = ChiliTextStyle.get()
    }
}

class TextStyleColors(private val textUnit: TextUnit) {

    val Primary
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliPrimaryTextColor)

    val Secondary
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliSecondaryTextColor)

    val Marked
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliMarkedTextColor)

    val Error
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliErrorTextColor)

    val Value
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliValueTextColor)

    val Link
        @Composable
        get() = TextStyleFont(textUnit, ChiliTheme.Colors.ChiliLinkTextColor)

    val Default
        @Composable
        get() = ChiliTextStyle.get(textUnit)

}

class TextStyleFont(private val textUnit: TextUnit, private val chiliPrimaryTextColor: Color) {

    val Bold
        get() = getTextStyle(Font(R.font.roboto_700))

    val Regular
        get() = getTextStyle(Font(R.font.roboto_regular))

    val Medium
        get() = getTextStyle(Font(R.font.roboto_medium))

    val Italic
        get() = getTextStyle(Font(R.font.roboto_italic))

    val Default
        @Composable
        get() = ChiliTextStyle.get(textUnit, chiliPrimaryTextColor)

    private fun getTextStyle(font: Font) = ChiliTextStyle.get(textUnit, chiliPrimaryTextColor, font)
}