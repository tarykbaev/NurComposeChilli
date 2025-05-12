package com.design.composechili.components.common.pieChart

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.common.pieChart.model.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.PieChartData
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.components.common.pieChart.model.SpendingCategory
import com.design.composechili.components.common.pieChart.model.getColor
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.pxToDp
import kotlin.math.atan2
import kotlin.math.roundToInt


@Composable
fun PieChart(
    detalizationInfo: DetalizationInfo?,
    modifier: Modifier = Modifier,
    params: PieChartParams,
    onSliceClick: (EnumSpendingCategory) -> Unit = {},
    selectedCategory: EnumSpendingCategory? = null,
) {
    val emptyCanvasItem = listOf(
        PieChartData(
            color = EnumSpendingCategory.NONE.getColor(),
            amount = detalizationInfo?.totalAmount?.takeIf { it != 0.0 }?.toFloat() ?: 100.0f,
            type = EnumSpendingCategory.NONE
        )
    )

    val pieChartData = detalizationInfo?.category?.map {
        PieChartData(
            color = it.type?.getColor() ?: colorResource(R.color.gray_6),
            amount = it.totalCharge ?: 0f,
            type = it.type ?: EnumSpendingCategory.NONE
        )
    }.orEmpty()

    val canvasItems = when {
        pieChartData.isEmpty() -> emptyCanvasItem
        pieChartData.all { it.amount == 0f } -> emptyCanvasItem
        detalizationInfo?.totalAmount == null || detalizationInfo.totalAmount == 0.0 -> emptyCanvasItem
        else -> pieChartData
    }

    val totalAmount = detalizationInfo?.totalAmount?.takeIf { it != 0.0 } ?: 100.0

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(params.size))
            .padding(params.strokeWidthDivider.pxToDp())
    ) {
        PieChartCanvas(modifier, params, canvasItems, totalAmount, onSliceClick, selectedCategory)
        PieChartText(detalizationInfo?.totalAmount, params)
    }
}

@Composable
private fun PieChartCanvas(
    modifier: Modifier,
    params: PieChartParams,
    canvasItems: List<PieChartData>,
    totalAmount: Double,
    onSliceClick: (EnumSpendingCategory) -> Unit,
    selectedCategory: EnumSpendingCategory?,
) {
    var selectedCategoryType by remember { mutableStateOf(selectedCategory) }
    val localDensity = LocalDensity.current
    var startAngle = params.pieStartAngle

    LaunchedEffect(selectedCategory) {
        selectedCategoryType = selectedCategory
    }
    canvasItems.forEach { item ->
        val animatedStrokeWidth by animateFloatAsState(
            targetValue = if (item.type != selectedCategoryType)
                with(localDensity) { (params.size.toPx() / params.strokeWidthDivider.toFloat()) }
            else
                with(localDensity) { (params.size.toPx() / params.strokeWidthDivider.toFloat()) }.toFloat() * 1.3f,
            animationSpec = tween(1000)
        )

        Canvas(
            modifier = modifier
                .size(params.size)
                .pointerInput(canvasItems) {
                    detectTapGestures(onTap = { offset ->
                        val center = Offset((params.size.toPx() / 2), (params.size.toPx() / 2))
                        val angle = calculateAngle(center, offset)
                        val foundCategory = findCategoryByAngle(
                            totalAmount = totalAmount,
                            params = params,
                            items = canvasItems,
                            angle = angle
                        )
                        selectedCategoryType = foundCategory?.type
                        onSliceClick(foundCategory?.type ?: EnumSpendingCategory.NONE)
                    })
                }
        ) {
            val sweepAngle = ((item.amount * params.pieChartMaxAngle) / totalAmount).toFloat()
            val radius = (params.size.toPx() - (params.size.toPx() / params.strokeWidthDivider.toFloat()))
            val topLeftOffset = Offset((params.size.toPx() - radius) / 2, (params.size.toPx() - radius) / 2)

            drawArc(
                color = item.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(width = animatedStrokeWidth),
                size = Size(radius, radius),
                topLeft = topLeftOffset,
            )
            startAngle += sweepAngle
        }
    }
}

@Composable
private fun PieChartText(
    totalAmount: Double?,
    params: PieChartParams
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = totalAmount?.let { amount ->
                buildAnnotatedString {
                    val description = if (amount != 0.0) params.description else params.emptyDescription
                    withStyle(style = params.descriptionTextStyle) {
                        append("$description\n")
                    }

                    withStyle(style = params.amountTextStyle) {
                        append(
                            if (hasNonZeroFraction(amount)) formatAmount(amount)
                            else "${amount.roundToInt()} "
                        )
                    }

                    withStyle(style = params.currencyTextStyle) {
                        append(params.currency)
                    }
                }
            } ?: buildAnnotatedString {
                withStyle(style = params.noValueTextStyle.toSpanStyle()) {
                    append(params.emptyDescription)
                }
            },
            textAlign = TextAlign.Center,
            style = if (totalAmount == null) params.noValueTextStyle else LocalTextStyle.current // Fallback style
        )
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
        val sweepAngle = totalAmount?.let { (item.amount * params.pieChartMaxAngle) / totalAmount }?.toFloat()
            ?: params.pieChartMaxAngle

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

private fun formatAmount(totalAmount: Double?) = ("$totalAmount ").replace(".", ",")

private fun hasNonZeroFraction(totalAmount: Double) = totalAmount % 1 != 0.0

@Preview(showBackground = true)
@Composable
private fun PieChart_Preview() {
    val listOfItems = listOf(
        SpendingCategory("", type = EnumSpendingCategory.SUBSCRIPTION_FEE, totalCharge = 10f),
        SpendingCategory("", type = EnumSpendingCategory.OMONEY, totalCharge = 190f),
        SpendingCategory("", type = EnumSpendingCategory.SERVICES, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET_PACKAGE, totalCharge = 50f),
        SpendingCategory("", type = EnumSpendingCategory.ROAMING, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 50f),
        SpendingCategory("", type = EnumSpendingCategory.SMS, totalCharge = 250f),
        SpendingCategory("", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 50.44f),
        SpendingCategory("", type = EnumSpendingCategory.NONE, totalCharge = 0f),
    )
    val listOfCategories = remember {
        mutableStateOf(
            DetalizationInfo(
                totalAmount = 900.44,
                category = listOfItems
            )
        )
    }

    ChiliTheme {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PieChart(
                detalizationInfo = DetalizationInfo(listOfCategories.value.totalAmount, listOfItems),
                params = PieChartParams.Default,
                onSliceClick = { println("clicked $it") },
                selectedCategory = EnumSpendingCategory.SMS
            )
        }
    }
}