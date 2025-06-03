package com.design.composechili.components.card.cardWithExpandableCategories.model

import com.design.composechili.components.common.pieChart.model.OModels.SpendingSubCategory

data class ExpandableSubCategoryModel(
    val title: String?,
    val rightSubtitle: String?,
    val bottomSubtitle: String?
)

fun SpendingSubCategory.toExpandableSubcategoryModel(): ExpandableSubCategoryModel {
    return ExpandableSubCategoryModel(title = name, rightSubtitle = getCharge(), bottomSubtitle = getPaymentDate())
}