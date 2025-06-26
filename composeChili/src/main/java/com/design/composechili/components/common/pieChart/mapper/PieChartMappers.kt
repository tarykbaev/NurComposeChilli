package com.design.composechili.components.common.pieChart.mapper

import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.PieChartCategory
import com.design.composechili.components.common.pieChart.model.PieChartCategoryType
import com.design.composechili.components.common.pieChart.model.PieChartInfo
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory
/**
 * Maps a [DetalizationInfo] model to a [PieChartInfo] UI model.
 *
 * Used to convert domain-layer data into a format suitable for pie chart visualization.
 * Typically called within the presentation or UI layer.
 *
 * @return [PieChartInfo] containing total amount and a list of mapped [PieChartCategory] items.
 */
fun DetalizationInfo.mapToPieChartInfo(): PieChartInfo {
    return PieChartInfo(totalAmount = totalAmount, category = category?.map { it.toPieChartCategory() })
}
/**
 * Maps a single [SpendingCategory] into a [PieChartCategory] used in the UI.
 *
 * This function extracts the name, type (converted), and total charge to be displayed on the pie chart.
 *
 * @return [PieChartCategory] UI model.
 */
fun SpendingCategory.toPieChartCategory(): PieChartCategory {
    return PieChartCategory(name = name, type = type?.toPieChartCategoryType(), totalCharge = totalCharge)
}
/**
 * Converts a domain-level enum [EnumSpendingCategory] into a UI-friendly [PieChartCategoryType],
 * which defines the visual color or category appearance for the chart.
 *
 * @return [PieChartCategoryType] corresponding to the enum value.
 */
fun EnumSpendingCategory.toPieChartCategoryType(): PieChartCategoryType {
    return when(this){
        EnumSpendingCategory.SUBSCRIPTION_FEE -> PieChartCategoryType.Orange
        EnumSpendingCategory.OMONEY -> PieChartCategoryType.Magenta
        EnumSpendingCategory.SERVICES -> PieChartCategoryType.Green
        EnumSpendingCategory.INTERNET -> PieChartCategoryType.Cyan
        EnumSpendingCategory.INTERNET_PACKAGE -> PieChartCategoryType.Red
        EnumSpendingCategory.ROAMING -> PieChartCategoryType.Blue
        EnumSpendingCategory.OUT_VOICE -> PieChartCategoryType.LightGreen
        EnumSpendingCategory.SMS -> PieChartCategoryType.Purple
        EnumSpendingCategory.INNER_VOICE -> PieChartCategoryType.DarkMagenta
        EnumSpendingCategory.NONE -> PieChartCategoryType.None
    }
}

/**
 * Converts a [PieChartCategoryType] (used in UI) back to a domain-level [EnumSpendingCategory].
 *
 * This can be used for reverse mapping when sending user selection or analytics data back to the domain layer.
 *
 * @return Corresponding [EnumSpendingCategory] for the given UI category type.
 */
fun PieChartCategoryType.toEnumSpendingCategory(): EnumSpendingCategory {
    return when (this) {
        PieChartCategoryType.Orange -> EnumSpendingCategory.SUBSCRIPTION_FEE
        PieChartCategoryType.Magenta -> EnumSpendingCategory.OMONEY
        PieChartCategoryType.Green -> EnumSpendingCategory.SERVICES
        PieChartCategoryType.Cyan -> EnumSpendingCategory.INTERNET
        PieChartCategoryType.Red -> EnumSpendingCategory.INTERNET_PACKAGE
        PieChartCategoryType.Blue -> EnumSpendingCategory.ROAMING
        PieChartCategoryType.LightGreen -> EnumSpendingCategory.OUT_VOICE
        PieChartCategoryType.Purple -> EnumSpendingCategory.SMS
        PieChartCategoryType.DarkMagenta -> EnumSpendingCategory.INNER_VOICE
        PieChartCategoryType.None -> EnumSpendingCategory.NONE
    }
}