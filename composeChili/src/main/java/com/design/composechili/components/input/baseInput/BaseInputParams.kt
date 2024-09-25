package com.design.composechili.components.input.baseInput

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Immutable
data class BaseInputParams(
    val textStyle: TextStyle,
    val errorTextColor: Color,
    val cursorColor: Color,
    val fieldBackground: Color,
    val selectionBackgroundColor: Color,
    val hintColor: Color,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val autoCorrectionEnable: Boolean = true,
    val imeAction: ImeAction = ImeAction.None,
    val textFieldPadding:PaddingValues,
    val maxLines: Int = 1,
) {

    companion object {
        val Default
            @Composable
            get() = BaseInputParams(
                textStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                    ChiliTheme.Attribute.ChiliBoldTextFont,
                ),
                errorTextColor = ChiliTheme.Colors.ChiliErrorTextColor,
                cursorColor = colorResource(id = R.color.magenta_1),
                fieldBackground = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor,
                selectionBackgroundColor = colorResource(id = R.color.magenta_3),
                hintColor = colorResource(id = R.color.gray_1),
                keyboardType = KeyboardType.Text,
                autoCorrectionEnable = true,
                imeAction = ImeAction.None,
                textFieldPadding = PaddingValues(dimensionResource(id = R.dimen.padding_12dp))
            )
    }

}