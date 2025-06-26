package com.design.composechili.components.card.cardWithExpandableCategories

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R
import com.design.composechili.components.card.cardWithExpandableCategories.model.ExpandableCategoryCellModel
import com.design.composechili.components.card.cardWithExpandableCategories.model.toExpandableSubcategoryModel
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory


fun SpendingCategory.toExpandableCategoryCellModel(): ExpandableCategoryCellModel {
    return ExpandableCategoryCellModel(
        title = name,
        rightSubtitle = getTotalCharge(),
        type = type?.toExpandableCategoryCellType() ?: ExpandableCategoryCellType.Gray,
        subCategories = subCategories?.map { it.toExpandableSubcategoryModel() }
    )
}

fun EnumSpendingCategory.toExpandableCategoryCellType(): ExpandableCategoryCellType {
    return when (this) {
        EnumSpendingCategory.SUBSCRIPTION_FEE -> ExpandableCategoryCellType.Orange
        EnumSpendingCategory.OMONEY -> ExpandableCategoryCellType.Magenta
        EnumSpendingCategory.SERVICES -> ExpandableCategoryCellType.Green
        EnumSpendingCategory.INTERNET -> ExpandableCategoryCellType.Cyan
        EnumSpendingCategory.INTERNET_PACKAGE -> ExpandableCategoryCellType.Red
        EnumSpendingCategory.ROAMING -> ExpandableCategoryCellType.Blue
        EnumSpendingCategory.OUT_VOICE -> ExpandableCategoryCellType.LightGreen
        EnumSpendingCategory.SMS -> ExpandableCategoryCellType.Purple
        EnumSpendingCategory.INNER_VOICE -> ExpandableCategoryCellType.DarkMagenta
        EnumSpendingCategory.NONE -> ExpandableCategoryCellType.Gray
    }
}

fun ExpandableCategoryCellType.toEnumSpendingCategory(): EnumSpendingCategory {
    return when (this) {
        ExpandableCategoryCellType.Orange -> EnumSpendingCategory.SUBSCRIPTION_FEE
        ExpandableCategoryCellType.Magenta -> EnumSpendingCategory.OMONEY
        ExpandableCategoryCellType.Green -> EnumSpendingCategory.SERVICES
        ExpandableCategoryCellType.Cyan -> EnumSpendingCategory.INTERNET
        ExpandableCategoryCellType.Red -> EnumSpendingCategory.INTERNET_PACKAGE
        ExpandableCategoryCellType.Blue -> EnumSpendingCategory.ROAMING
        ExpandableCategoryCellType.LightGreen -> EnumSpendingCategory.OUT_VOICE
        ExpandableCategoryCellType.Purple -> EnumSpendingCategory.SMS
        ExpandableCategoryCellType.DarkMagenta -> EnumSpendingCategory.INNER_VOICE
        ExpandableCategoryCellType.Gray -> EnumSpendingCategory.NONE
    }
}

sealed class ExpandableCategoryCellType {
    data object Orange : ExpandableCategoryCellType()
    data object Magenta : ExpandableCategoryCellType()
    data object Green : ExpandableCategoryCellType()
    data object Cyan : ExpandableCategoryCellType()
    data object Red : ExpandableCategoryCellType()
    data object Blue : ExpandableCategoryCellType()
    data object LightGreen : ExpandableCategoryCellType()
    data object Purple : ExpandableCategoryCellType()
    data object DarkMagenta : ExpandableCategoryCellType()
    data object Gray : ExpandableCategoryCellType()
}

@Composable
fun ExpandableCategoryCellType.getColor(): Color {
    return when (this) {
        ExpandableCategoryCellType.Orange -> colorResource(R.color.orange_1)
        ExpandableCategoryCellType.Magenta -> colorResource(R.color.magenta_1)
        ExpandableCategoryCellType.Green -> colorResource(R.color.green_5)
        ExpandableCategoryCellType.Cyan -> colorResource(R.color.cyan_1)
        ExpandableCategoryCellType.Red -> colorResource(R.color.red_1)
        ExpandableCategoryCellType.Blue -> colorResource(R.color.blue_2)
        ExpandableCategoryCellType.LightGreen -> colorResource(R.color.green_1)
        ExpandableCategoryCellType.Purple -> colorResource(R.color.purple_1)
        ExpandableCategoryCellType.DarkMagenta -> colorResource(R.color.magenta_2)
        ExpandableCategoryCellType.Gray -> colorResource(R.color.gray_6)
    }
}