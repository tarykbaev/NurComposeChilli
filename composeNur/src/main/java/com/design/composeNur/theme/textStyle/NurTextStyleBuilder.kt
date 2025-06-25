package com.design.composeNur.theme.textStyle

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.TextUnit
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

class NurTextStyleBuilder {

    companion object {
        val H1
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH1)

        val H2
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH2)

        val H3
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH3)

        val H4
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH4)

        val H5
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH5)

        val H6
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH6)

        val H7
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH7)

        val H8
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH8)

        val H9
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH9)

        val H10
            @Composable
            get() = TextStyleColors(NurTheme.Attribute.NurTextDimensions.TextSizeH10)

        val Default
            @Composable
            get() = NurTextStyle.get()
    }
}

class TextStyleColors(private val textUnit: TextUnit) {

    val Primary
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurPrimaryTextColor)

    val Secondary
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurSecondaryTextColor)

    val Marked
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurMarkedTextColor)

    val Error
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurErrorTextColor)

    val Value
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurValueTextColor)

    val Link
        @Composable
        get() = TextStyleFont(textUnit, NurTheme.Colors.NurLinkTextColor)

    val Default
        @Composable
        get() = NurTextStyle.get(textUnit)

}

class TextStyleFont(private val textUnit: TextUnit, private val NurPrimaryTextColor: Color) {

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
        get() = NurTextStyle.get(textUnit, NurPrimaryTextColor)

    private fun getTextStyle(font: Font) = NurTextStyle.get(textUnit, NurPrimaryTextColor, font)
}