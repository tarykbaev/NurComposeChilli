package com.design.composechili.components.common.pieChart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.common.pieChart.model.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.PieChartData
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.components.common.pieChart.model.SpendingCategory
import com.design.composechili.components.common.pieChart.model.getColor
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle

@Composable
fun PieChart(
    totalAmount: Double?,
    categoriesList: List<SpendingCategory>,
    modifier: Modifier = Modifier,
    params: PieChartParams,
) {

    val canvasItems = categoriesList.map {
        PieChartData(it.type?.getColor() ?: colorResource(R.color.gray_6), it.totalCharge ?: 0f)
    }

    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Canvas(modifier = modifier.size(params.size)) {
            var startAngle = 90f
            canvasItems.forEach { item ->
                val sweepAngle = totalAmount?.let { (item.amount * 360) / totalAmount } ?: 360
                drawArc(
                    color = item.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle.toFloat(),
                    useCenter = false,
                    style = Stroke(width = (params.size / 7).toPx())
                )
                startAngle += sweepAngle.toFloat()
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (totalAmount != null) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = params.descriptionTextStyle
                        ) {
                            append(params.description)
                            append("\n")
                        }
                        withStyle(
                            style = params.amountTextStyle
                        ) {
                            append(totalAmount.toInt().toString())
                            append(" ")
                        }
                        withStyle(
                            style = params.currencyTextStyle
                        ) {
                            append(params.currency)
                        }
                    }, textAlign = TextAlign.Center
                )
            } else {
                Text(
                    text = params.emptyDescription,
                    style = ChiliTextStyle.get(
                        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                        color = ChiliTheme.Colors.ChiliValueTextColor
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PieChart_Preview() {
    val listOfCategories = listOf(
        SpendingCategory("", type = EnumSpendingCategory.SUBSCRIPTION_FEE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.OMONEY, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.SERVICES, totalCharge = 250f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET_PACKAGE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.ROAMING, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.SMS, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.NONE, totalCharge = 183f),
    )
    ChiliTheme {
        Column(
            Modifier
                .size(300.dp)
                .padding(32.dp), verticalArrangement = Arrangement.Center
        ) {
            PieChart(
                totalAmount = 1233.44,
                categoriesList = listOfCategories,
                params = PieChartParams.Default
            )
        }
    }
}