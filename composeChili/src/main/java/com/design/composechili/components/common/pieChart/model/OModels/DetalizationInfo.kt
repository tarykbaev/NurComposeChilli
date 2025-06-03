package com.design.composechili.components.common.pieChart.model.OModels

// This model reflects the real O! app data structure.
// It's used as a source for mapping to the UI model.

data class DetalizationInfo(
    val totalAmount:Double?,
    val category: List<SpendingCategory>?
)