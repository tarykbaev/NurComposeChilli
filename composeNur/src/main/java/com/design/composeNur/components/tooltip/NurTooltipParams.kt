package com.design.composeNur.components.tooltip

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

data class NurTooltipParams(
    val titleTextStyle: TextStyle,
    val subtitleTextStyle: TextStyle,
    val tooltipBackground: Color,
    val tooltipCornerSize: Dp,
    val arrowHeight: Dp
) {

    companion object {
        val Default
            @Composable
            get() = NurTooltipParams(
                titleTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH9,
                    NurTheme.Colors.NurMarkedTextColor,
                    NurTheme.Attribute.NurBoldTextFont
                ),
                subtitleTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH9,
                    NurTheme.Colors.NurMarkedTextColor,
                ),
                tooltipBackground = NurTheme.Colors.NurTooltipBackground,
                tooltipCornerSize = NurTheme.Attribute.NurToolipCornerRadius,
                arrowHeight = 8.dp
            )
    }

}