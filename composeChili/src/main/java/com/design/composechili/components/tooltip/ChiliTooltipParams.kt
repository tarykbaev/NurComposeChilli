package com.design.composechili.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ChiliTooltipParams(
    val titleTextStyle: TextStyle,
    val subtitleTextStyle: TextStyle,
    val tooltipBackground: Color,
    val tooltipCornerSize: Dp,
    val arrowHeight: Dp
) {

    companion object {
        val Default
            @Composable
            get() = ChiliTooltipParams(
                titleTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                    ChiliTheme.Colors.ChiliMarkedTextColor,
                    ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                subtitleTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                    ChiliTheme.Colors.ChiliMarkedTextColor,
                ),
                tooltipBackground = ChiliTheme.Colors.ChiliTooltipBackground,
                tooltipCornerSize = ChiliTheme.Attribute.ChiliToolipCornerRadius,
                arrowHeight = 8.dp
            )
    }

}