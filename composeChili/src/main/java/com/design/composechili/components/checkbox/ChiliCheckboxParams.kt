package com.design.composechili.components.checkbox

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

data class ChiliCheckboxParams(
    val checkedColor: Color,
    val uncheckedColor: Color,
    val disabledColor: Color,
) {

    companion object {
        val Default
            @Composable get() = ChiliCheckboxParams(
                checkedColor = colorResource(R.color.magenta_1),
                uncheckedColor = colorResource(R.color.gray_3),
                disabledColor = colorResource(R.color.gray_1_alpha_50),
            )
    }
}