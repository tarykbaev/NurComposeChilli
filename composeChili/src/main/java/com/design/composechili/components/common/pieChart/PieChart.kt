package com.design.composechili.components.common.pieChart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
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
import kotlin.math.atan2
import kotlin.math.roundToInt


@Composable
fun PieChart(
    totalAmount: Double?,
    categoriesList: List<SpendingCategory>,
    modifier: Modifier = Modifier,
    params: PieChartParams,
    onSliceClick: (EnumSpendingCategory) -> Unit = {}
) {

    var selectedCategory by remember { mutableStateOf<PieChartData?>(null) }

    val canvasItems = categoriesList.map {
        PieChartData(
            it.type?.getColor() ?: colorResource(R.color.gray_6),
            it.totalCharge ?: 0f,
            it.type ?: EnumSpendingCategory.NONE
        )
    }

    Box(contentAlignment = Alignment.Center) {
        Canvas(
            modifier = modifier
                .size(params.size)
                .pointerInput(canvasItems) {
                    detectTapGestures(onTap = { offset ->
                        val centerPoint = (params.size.toPx() / 2)
                        val center = Offset(centerPoint, centerPoint)
                        val angle = calculateAngle(center, offset)
                        selectedCategory = findCategoryByAngle(
                            totalAmount = totalAmount,
                            params = params,
                            items = canvasItems,
                            angle = angle
                        )
                        onSliceClick(selectedCategory?.type ?: EnumSpendingCategory.NONE)
                    })
                }
        ) {
            var startAngle = params.pieStartAngle
            canvasItems.forEach { item ->
                val sweepAngle = calculateSweepAngle(totalAmount, item, params.pieChartMaxAngle)
                val isSelected = item == selectedCategory
                val strokeWidth =
                    if (isSelected) ((params.size.toPx() / params.strokeWidthDivider.toFloat()) * 1.3f)
                    else (params.size.toPx() / params.strokeWidthDivider.toFloat())

                drawArc(
                    color = item.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = strokeWidth),
                )
                startAngle += sweepAngle
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            totalAmount?.let {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = params.descriptionTextStyle) { append("${params.description}\n") }
                        withStyle(style = params.amountTextStyle) {
                            if (hasNonZeroFraction(totalAmount)) {
                                append(formatAmount(totalAmount))
                            } else {
                                append("${totalAmount.roundToInt()} ")
                            }
                        }
                        withStyle(style = params.currencyTextStyle) { append(params.currency) }
                    }, textAlign = TextAlign.Center
                )
            } ?: Text(
                text = params.emptyDescription,
                style = params.noValueTextStyle
            )
        }
    }
}

private fun calculateAngle(center: Offset, touchPoint: Offset): Float {
    val deltaX = touchPoint.x - center.x
    val deltaY = center.y - touchPoint.y
    var angle = Math.toDegrees(atan2(deltaY.toDouble(), deltaX.toDouble())).toFloat()

    angle = (angle + 360) % 360

    return 360 - angle
}

private fun findCategoryByAngle(
    items: List<PieChartData>,
    totalAmount: Double?,
    params: PieChartParams,
    angle: Float
): PieChartData? {
    var startAngle = params.pieStartAngle

    items.forEach { item ->
        val sweepAngle = calculateSweepAngle(totalAmount, item, params.pieChartMaxAngle)
        val endAngle = (startAngle + sweepAngle) % 360
        if (startAngle < endAngle) {
            if (angle in startAngle..endAngle) {
                return item
            }
        } else {
            if (angle in startAngle..360f || angle in 0f..endAngle) {
                return item
            }
        }
        startAngle = endAngle
    }
    return null
}

private fun calculateSweepAngle(
    totalAmount: Double?,
    item: PieChartData,
    pieChartMaxAngle: Float
): Float {
    return totalAmount?.let { (item.amount * pieChartMaxAngle) / totalAmount }?.toFloat() ?: pieChartMaxAngle
}

private fun formatAmount(totalAmount: Double?) = ("$totalAmount ").replace(".", ",")

private fun hasNonZeroFraction(totalAmount: Double) = totalAmount % 1 != 0.0

@Preview(showBackground = true)
@Composable
private fun PieChart_Preview() {
    val listOfCategories = listOf(
        SpendingCategory("", type = EnumSpendingCategory.SUBSCRIPTION_FEE, totalCharge = 10f),
        SpendingCategory("", type = EnumSpendingCategory.OMONEY, totalCharge = 190f),
        SpendingCategory("", type = EnumSpendingCategory.SERVICES, totalCharge = 150f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET_PACKAGE, totalCharge = 50f),
        SpendingCategory("", type = EnumSpendingCategory.ROAMING, totalCharge = 100.44f),
        SpendingCategory("", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.SMS, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.NONE, totalCharge = 0f),
    )
    ChiliTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PieChart(
                totalAmount = 900.44,
                categoriesList = listOfCategories,
                params = PieChartParams.Default,
                onSliceClick = { println("clicked $it") }
            )
        }
    }
}