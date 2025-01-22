package com.design.composechili.components.input.inputFieldWithDescAndAction

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

@Immutable
data class NurChiliAutoCompleteInputParams(
    val height: Dp,
    val dropDownShape: Shape,
    val dropDownBackgroundColor: Color,
) {
    companion object {
        val Default
            @Composable
            get() = NurChiliAutoCompleteInputParams(
                height = 200.dp,
                dropDownShape = RoundedCornerShape(16.dp),
                dropDownBackgroundColor = ChiliTheme.Background.color
            )
    }
}

interface NurChiliAutoCompleteItem {
    fun getDisplayValue(): String
}