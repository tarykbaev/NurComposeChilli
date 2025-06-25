package com.design.composeNur.components.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

@Stable
data class CategoryCardParams(
    val style: TextStyle,
    val alignment: Alignment.Horizontal,
    val iconPaddings: PaddingValues
) {
    companion object {
        val LeftAligned
            @Composable get() = CategoryCardParams(
                style = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.NurBoldTextFont
                ),
                alignment = Alignment.Start,
                iconPaddings = PaddingValues(top = 12.dp)
            )
        val Centered
            @Composable get() = CategoryCardParams(
                style = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.NurBoldTextFont
                ),
                alignment = Alignment.CenterHorizontally,
                iconPaddings = PaddingValues(top = 12.dp)
            )
        val LeftAligned8Dp
            @Composable get() = CategoryCardParams(
                style = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.NurRegularTextFont
                ),
                alignment = Alignment.Start,
                iconPaddings = PaddingValues(top = 8.dp)
            )
    }
}
