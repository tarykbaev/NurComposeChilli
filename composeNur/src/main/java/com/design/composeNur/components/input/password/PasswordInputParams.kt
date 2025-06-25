package com.design.composeNur.components.input.password

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder
import com.design.composenur.R

@Immutable
data class PasswordInputParams(
    val textStyle: TextStyle,
    val errorTextColor: Color,
    val cursorColor: Color,
    val fieldBackground: Color,
    val fieldErrorBackground: Color,
    val selectionBackgroundColor: Color,
    val hintColor: Color,
    val endIconColor: Color,
    val keyboardType: KeyboardType,
    val imeAction: ImeAction,
) {

    companion object {
        val Default
            @Composable
            get() = PasswordInputParams(
                textStyle = NurTextStyleBuilder.H6.Primary.Medium,
                errorTextColor = NurTheme.Colors.NurErrorTextColor,
                cursorColor = colorResource(id = R.color.magenta_1),
                fieldBackground = NurTheme.Colors.NurCodeInputItemBackgroundColor,
                fieldErrorBackground = NurTheme.Colors.NurCodeInputItemErrorBackgroundColor,
                selectionBackgroundColor = colorResource(id = R.color.magenta_3),
                hintColor = colorResource(id = R.color.gray_1),
                endIconColor = NurTheme.Colors.NurInputEndIconTint,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            )
    }

}