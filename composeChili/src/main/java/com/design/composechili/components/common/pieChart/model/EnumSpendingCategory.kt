package com.design.composechili.components.common.pieChart.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

enum class EnumSpendingCategory {
    SUBSCRIPTION_FEE,
    OMONEY,
    SERVICES,
    INTERNET,
    INTERNET_PACKAGE,
    ROAMING,
    OUT_VOICE,
    SMS,
    INNER_VOICE,
    NONE,
}

@Composable
fun EnumSpendingCategory.getColor(): Color {
    return when (this) {
        EnumSpendingCategory.SUBSCRIPTION_FEE -> colorResource(R.color.orange_1)
        EnumSpendingCategory.OMONEY -> colorResource(R.color.magenta_1)
        EnumSpendingCategory.SERVICES -> colorResource(R.color.green_5)
        EnumSpendingCategory.INTERNET -> colorResource(R.color.cyan_1)
        EnumSpendingCategory.INTERNET_PACKAGE -> colorResource(R.color.red_1)
        EnumSpendingCategory.ROAMING -> colorResource(R.color.blue_2)
        EnumSpendingCategory.OUT_VOICE -> colorResource(R.color.green_1)
        EnumSpendingCategory.SMS -> colorResource(R.color.purple_1)
        EnumSpendingCategory.INNER_VOICE -> colorResource(R.color.magenta_2)
        EnumSpendingCategory.NONE -> colorResource(R.color.gray_6)
    }
}