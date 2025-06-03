package com.design.composechili.components.common.pieChart.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

data class PieChartInfo(
    val totalAmount: Double?,
    val category: List<PieChartCategory>?
)

data class PieChartCategory(
    var name: String? = null,
    var type: PieChartCategoryType? = null,
    var totalCharge: Float? = null,
)

sealed class PieChartCategoryType {
    data object Orange : PieChartCategoryType()
    data object Magenta : PieChartCategoryType()
    data object Green : PieChartCategoryType()
    data object Cyan : PieChartCategoryType()
    data object Red : PieChartCategoryType()
    data object Blue : PieChartCategoryType()
    data object LightGreen : PieChartCategoryType()
    data object Purple : PieChartCategoryType()
    data object DarkMagenta : PieChartCategoryType()
    data object None : PieChartCategoryType()
}

@Composable
fun PieChartCategoryType.getColor(): Color {
    return when (this) {
        PieChartCategoryType.Orange -> colorResource(R.color.orange_1)
        PieChartCategoryType.Magenta -> colorResource(R.color.magenta_1)
        PieChartCategoryType.Green -> colorResource(R.color.green_5)
        PieChartCategoryType.Cyan -> colorResource(R.color.cyan_1)
        PieChartCategoryType.Red -> colorResource(R.color.red_1)
        PieChartCategoryType.Blue -> colorResource(R.color.blue_2)
        PieChartCategoryType.LightGreen -> colorResource(R.color.green_1)
        PieChartCategoryType.Purple -> colorResource(R.color.purple_1)
        PieChartCategoryType.DarkMagenta -> colorResource(R.color.magenta_2)
        PieChartCategoryType.None -> colorResource(R.color.gray_6)
    }
}