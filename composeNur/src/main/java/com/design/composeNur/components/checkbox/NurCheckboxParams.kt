package com.design.composeNur.components.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composenur.R

data class NurCheckboxParams(
    val checkedColor: Color,
    val uncheckedColor: Color,
    val disabledColor: Color,
) {

    companion object {
        val Default
            @Composable get() = NurCheckboxParams(
                checkedColor = colorResource(R.color.magenta_1),
                uncheckedColor = colorResource(R.color.gray_3),
                disabledColor = colorResource(R.color.gray_1_alpha_50),
            )
    }
}