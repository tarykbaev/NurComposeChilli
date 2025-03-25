package com.design.composechili.components.common.pieChart.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

@Stable
data class PieChartParams(
    val size: Dp,
    val description: String,
    val emptyDescription: String,
    val currency: String,
    val pieStartAngle: Float,
    val pieChartMaxAngle: Float,
    val strokeWidthDivider: Int,
    val descriptionTextStyle: SpanStyle,
    val amountTextStyle: SpanStyle,
    val currencyTextStyle: SpanStyle,
) {
    companion object {
        val Default
            @Composable get() = PieChartParams(
                size = 200.dp,
                description = "Все расходы",
                emptyDescription = "Нет расходов",
                currency = "с",
                pieStartAngle = 90f,
                pieChartMaxAngle = 360f,
                strokeWidthDivider = 7,
                descriptionTextStyle = SpanStyle(
                    fontSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                amountTextStyle = SpanStyle(
                    fontSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    fontWeight = FontWeight.Bold
                ),
                currencyTextStyle = SpanStyle(
                    fontSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    textDecoration = TextDecoration.Underline,
                    fontWeight = FontWeight.Bold
                )
            )
    }
}