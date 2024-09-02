package com.design.composechili.components.picker.chiliWheelDatePicker

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Immutable
data class ChiliWheelPickerSelectorProperties(
    val shape: Shape,
    val color:Color,
    val border:BorderStroke
){
    companion object{
        val Default
        @Composable
        get() = ChiliWheelPickerSelectorProperties(
            shape = RoundedCornerShape(16.dp),
            color = Color.Transparent,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        )
    }

}