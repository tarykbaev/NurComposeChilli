package com.design.composechili.components.input.maskedTextField

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class MaskedTextFieldParams(
    val titleTextStyle: TextStyle,
    val hintTextColor: Color,
    val representation: Char,
    val maskSymbols: List<Char>,
    val allowedInputSymbols: String,
    val fieldContainerColor: Color,
) {
    companion object {
        val Default
            @Composable
            get() = MaskedTextFieldParams(
                titleTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                    ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                hintTextColor = colorResource(id = R.color.gray_2),
                representation = 'X',
                maskSymbols = listOf('-', ' ', '/'),
                allowedInputSymbols = "*",
                fieldContainerColor = colorResource(id = R.color.gray_5)
            )
    }
}