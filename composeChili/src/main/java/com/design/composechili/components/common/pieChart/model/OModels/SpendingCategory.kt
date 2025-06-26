package com.design.composechili.components.common.pieChart.model.OModels

import com.design.composechili.utils.formatByRegex
import com.design.composechili.utils.toThreeDigitsFormat
import java.util.Date

data class SpendingCategory(
    var name: String? = null,
    var type: EnumSpendingCategory? = null,
    var totalCharge: Float? = null,
    var subCategories: List<SpendingSubCategory>? = null
) {

    fun getTotalCharge(): String {
        return totalCharge?.toDouble()?.toThreeDigitsFormat ?: ""
    }

}

data class SpendingSubCategory(var name: String? = null,
                               var charge: Double? = null,
                               var amount: Double? = null,
                               var date: Long? = null,
                               var subType: EnumSpendingSubCategory? = null,
                               var count: Int? = null,
                               var desc: String? = null,
                               var number: String? = null,
                               var indDesc: String? = null){
    fun getPaymentDate(): String{
        date?.let { return Date(it).formatByRegex("dd.MM.yyyy - HH:mm:ss").lowercase() }
        return ""
    }

    fun getCharge(): String{
        return charge?.toThreeDigitsFormat ?: ""
    }
}


enum class EnumSpendingSubCategory{
    INTERNET,
    OUT_SMS,
    OUT_CALL,
    INCOMING_CALL,
    INCOMING_SMS,
    PREPAYMENT_BACK,
    INTERNATIONAL_OUT_CALL,
    SUBSCRIPTION_FEE,
    SERVICES,
    OMONEY,
    INTERNET_PACKAGE,
    ROAMING,
    OTHER;
}