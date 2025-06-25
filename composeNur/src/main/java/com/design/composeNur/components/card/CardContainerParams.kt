package com.design.composeNur.components.card

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

data class CardContainerParams(
    val shape: Shape,
    val colors: CardColors,
    val titleStyle: TextStyle
) {
    companion object {
        val Transparent
            @Composable get() = CardContainerParams(
                shape = RoundedCornerShape(corner = CornerSize(0)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = Color.Transparent,
                ),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.Nur700TextFont
                )
            )
        val Filled
            @Composable get() = CardContainerParams(
                shape = RoundedCornerShape(corner = CornerSize(0)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = NurTheme.Colors.NurSurfaceBackground,
                ),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.Nur700TextFont
                )
            )
    }
}