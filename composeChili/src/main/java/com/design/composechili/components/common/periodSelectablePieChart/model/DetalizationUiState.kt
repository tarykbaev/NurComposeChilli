package com.design.composechili.components.common.periodSelectablePieChart.model

import com.design.composechili.components.common.periodSelectablePieChart.PeriodType
import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingSubCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingSubCategory
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.formatByRegex
import java.time.LocalDateTime

data class DetalizationUiState(
    val detalizationInfo: DetalizationInfo = DetalizationInfo(
        totalAmount = 900.44, category = listOf(
            SpendingCategory(
                "Subscriptions",
                type = EnumSpendingCategory.SUBSCRIPTION_FEE,
                totalCharge = 10f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Banking", type = EnumSpendingCategory.OMONEY, totalCharge = 190f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Services", type = EnumSpendingCategory.SERVICES, totalCharge = 100f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Internet", type = EnumSpendingCategory.INTERNET, totalCharge = 100f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Internet Package",
                type = EnumSpendingCategory.INTERNET_PACKAGE,
                totalCharge = 50f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Roaming", type = EnumSpendingCategory.ROAMING, totalCharge = 100f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Out Voice", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 50f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "SMS", type = EnumSpendingCategory.SMS, totalCharge = 250f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "InnerVoice", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 50.44f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
            SpendingCategory(
                "Other", type = EnumSpendingCategory.NONE, totalCharge = 0f,
                subCategories = listOf(
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум",
                        charge = 7.32,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                    SpendingSubCategory(
                        name = "O!TV Премиум 2",
                        charge = 7.33,
                        date = 1745535333000,
                        subType = EnumSpendingSubCategory.INCOMING_CALL,
                        amount = 0.0
                    ),
                )
            ),
        )
    ),
    val dateRange: Pair<String, String> = Pair(
        LocalDateTime.now().formatByRegex(DATE_PATTERN),
        LocalDateTime.now().formatByRegex(DATE_PATTERN)
    ),
    val showDatePicker: Boolean = false,
    val periodType: PeriodType? = PeriodType.DAY,
    val selectedCategory: EnumSpendingCategory? = null
)