package com.design.composeNur.components.input.baseInput

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H6
import com.design.composenur.R

@Immutable
data class BaseInputParams(
    val textStyle: TextStyle,
    val errorTextColor: Color,
    val cursorColor: Color,
    val fieldBackground: Color,
    val selectionBackgroundColor: Color,
    val hintColor: Color,
    val fieldIconSize: Dp,
    val keyboardType: KeyboardType = KeyboardType.Text,
    val autoCorrectionEnable: Boolean = true,
    val imeAction: ImeAction = ImeAction.None,
    val textFieldPadding: PaddingValues,
    val maxLines: Int = 1,
    val errorFieldColor: Color
) {

    @Composable
    fun getTextFieldColorParameter(): TextFieldColors {
        return TextFieldDefaults.colors().copy(
            focusedContainerColor = fieldBackground,
            unfocusedContainerColor = fieldBackground,
            disabledContainerColor = fieldBackground,
            errorTextColor = errorTextColor,
            errorIndicatorColor = Color.Transparent,
            errorContainerColor = errorFieldColor,
            errorCursorColor = errorTextColor,
            textSelectionColors = TextSelectionColors(
                cursorColor,
                selectionBackgroundColor
            ),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    }

    companion object {
        val Default
            @Composable
            get() = BaseInputParams(
                textStyle = H6.Primary.Regular,
                errorTextColor = NurTheme.Colors.NurInputViewErrorMessageTextColor,
                cursorColor = NurTheme.Colors.NurInputViewCursorColor,
                fieldBackground = NurTheme.Colors.NurInputViewBackgroundColor,
                selectionBackgroundColor = colorResource(id = R.color.magenta_3),
                hintColor = colorResource(id = R.color.gray_1),
                keyboardType = KeyboardType.Text,
                autoCorrectionEnable = true,
                imeAction = ImeAction.None,
                textFieldPadding = PaddingValues(dimensionResource(id = R.dimen.padding_12dp)),
                fieldIconSize = dimensionResource(id = R.dimen.view_24dp),
                errorFieldColor = NurTheme.Colors.NurInputViewBackgroundErrorColor
            )
    }

}