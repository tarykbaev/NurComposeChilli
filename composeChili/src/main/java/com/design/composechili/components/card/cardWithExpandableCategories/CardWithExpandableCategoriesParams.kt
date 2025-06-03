package com.design.composechili.components.card.cardWithExpandableCategories

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composechili.R

data class CardWithExpandableCategoriesParams(
    val verticalPadding: Dp,
    val cornerRadius: Dp,
    val animatedTopPadding: Dp,
    val currency: String,
    val expandableCategoryCellParams: ExpandableCategoryCellParams,
    val expandableSubCategoryDetailsParams: ExpandableSubCategoryDetailsParams,
) {
    companion object {
        val Default @Composable get() = CardWithExpandableCategoriesParams(
            verticalPadding = dimensionResource(R.dimen.padding_16dp),
            cornerRadius = dimensionResource(id = R.dimen.radius_12dp),
            animatedTopPadding = dimensionResource(R.dimen.padding_12dp),
            currency = String(),
            expandableCategoryCellParams = ExpandableCategoryCellParams.Default,
            expandableSubCategoryDetailsParams = ExpandableSubCategoryDetailsParams.Default
        )
    }
}
