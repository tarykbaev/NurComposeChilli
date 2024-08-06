package com.design.composechili.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit

internal object ChiliTextStyle {

    fun get(font: TextUnit = TextUnit.Unspecified, color: Color = Color.Unspecified): TextStyle {
        return TextStyle(fontSize = font, color = color)
    }


}