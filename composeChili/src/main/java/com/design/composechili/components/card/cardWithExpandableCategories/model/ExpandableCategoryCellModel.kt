package com.design.composechili.components.card.cardWithExpandableCategories.model

import com.design.composechili.components.card.cardWithExpandableCategories.ExpandableCategoryCellType

data class ExpandableCategoryCellModel(
    val title: String?,
    val rightSubtitle:String,
    val type: ExpandableCategoryCellType,
    val subCategories: List<ExpandableSubCategoryModel>?,
)