package com.design.composechili.components.card

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

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
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliTheme.Attribute.Chili700TextFont
                )
            )
        val Filled
            @Composable get() = CardContainerParams(
                shape = RoundedCornerShape(corner = CornerSize(0)),
                colors = CardDefaults.cardColors().copy(
                    containerColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliTheme.Attribute.Chili700TextFont
                )
            )
    }
}