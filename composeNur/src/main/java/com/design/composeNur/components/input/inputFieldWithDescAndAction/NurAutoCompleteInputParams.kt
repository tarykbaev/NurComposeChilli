package com.design.composeNur.components.input.inputFieldWithDescAndAction

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H6

@Immutable
data class NurAutoCompleteInputParams(
    val height: Dp,
    val dropDownShape: Shape,
    val dropDownBackgroundColor: Color,
    val dropDownItemTextStyle: TextStyle
) {
    companion object {
        val Default
            @Composable
            get() = NurAutoCompleteInputParams(
                height = 200.dp,
                dropDownShape = RoundedCornerShape(16.dp),
                dropDownBackgroundColor = NurTheme.Background.color,
                dropDownItemTextStyle = H6.Primary.Regular
            )
    }
}