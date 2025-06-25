package com.design.composeNur.components.input.maskedTextField

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

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
                titleTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH5,
                    NurTheme.Colors.NurPrimaryTextColor,
                    NurTheme.Attribute.NurBoldTextFont
                ),
                hintTextColor = colorResource(id = R.color.gray_2),
                representation = 'X',
                maskSymbols = listOf('-', ' ', '/'),
                allowedInputSymbols = "*",
                fieldContainerColor = colorResource(id = R.color.gray_5)
            )
    }
}