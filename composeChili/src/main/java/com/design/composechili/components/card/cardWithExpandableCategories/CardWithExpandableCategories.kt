package com.design.composechili.components.card.cardWithExpandableCategories

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.components.card.cardWithExpandableCategories.model.ExpandableCategoryCellModel
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingSubCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingSubCategory
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.addCurrency

@Composable
fun CardWithExpandableCategories(
    modifier: Modifier = Modifier,
    listOfCategories: List<ExpandableCategoryCellModel>?,
    selectedCategory: ExpandableCategoryCellType?,
    onCategoryClick: (ExpandableCategoryCellType?) -> Unit,
    params: CardWithExpandableCategoriesParams = CardWithExpandableCategoriesParams.Default
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = params.verticalPadding)
            .clip(RoundedCornerShape(params.cornerRadius))
            .background(Color.White),
    ) {
        AnimatedVisibility(!listOfCategories?.find { it.type == selectedCategory }?.subCategories.isNullOrEmpty()) {
            Spacer(modifier = Modifier.padding(top = params.animatedTopPadding))
        }
        listOfCategories?.let { category ->
            category.forEach { categoryDetails ->
                key(categoryDetails.hashCode()) {
                    ExpandableCategoryCell(
                        title = categoryDetails.title ?: "",
                        subTitle = categoryDetails.rightSubtitle.addCurrency(params.currency),
                        category = categoryDetails,
                        selectedSpendingCategory = selectedCategory,
                        onClick = { it?.let { onCategoryClick(it) } },
                        checkIfLastItem = {
                            listOfCategories.last() != categoryDetails
                        },
                        params = params.expandableCategoryCellParams,
                        subCategoryParams = params.expandableSubCategoryDetailsParams
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CardWithExpandableCategories_Preview() {
    val listOfItems = listOf(
        SpendingCategory(
            "Subscriptions",
            type = EnumSpendingCategory.SUBSCRIPTION_FEE,
            totalCharge = 10f,
            subCategories = emptyList()
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
    val selectedCategory = remember { mutableStateOf<ExpandableCategoryCellType?>(null) }
    ChiliTheme {
        CardWithExpandableCategories(
            params = CardWithExpandableCategoriesParams.Default.copy(currency = "c"),
            listOfCategories = listOfItems.map { it.toExpandableCategoryCellModel() },
            selectedCategory = selectedCategory.value,
            onCategoryClick = { selectedCategory.value = if (selectedCategory.value == it) null else it }
        )
    }
}