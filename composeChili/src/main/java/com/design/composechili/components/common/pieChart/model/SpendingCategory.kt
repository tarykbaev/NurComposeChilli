package com.design.composechili.components.common.pieChart.model

import com.design.composechili.utils.toThreeDigitsFormat

data class SpendingCategory(
    var name: String? = null,
    var type: EnumSpendingCategory? = null,
    var totalCharge: Float? = null,
    var subCategories: List<String>? = null
) {

    fun getTotalCharge(): String {
        return totalCharge?.toDouble()?.toThreeDigitsFormat ?: ""
    }

}