package com.design.composechili.components.card.cardWithExpandableCategories

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.components.card.cardWithExpandableCategories.model.ExpandableCategoryCellModel
import com.design.composechili.components.card.cardWithExpandableCategories.model.ExpandableSubCategoryModel
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingSubCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingSubCategory
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import com.design.composechili.utils.addCurrency

@Composable
fun ExpandableCategoryCell(
    modifier: Modifier = Modifier,
    category: ExpandableCategoryCellModel?,
    title: String?,
    subTitle: AnnotatedString?,
    selectedSpendingCategory: ExpandableCategoryCellType?,
    onClick: (ExpandableCategoryCellType?) -> Unit,
    checkIfLastItem: (ExpandableCategoryCellModel) -> Boolean,
    params: ExpandableCategoryCellParams = ExpandableCategoryCellParams.Default,
    subCategoryParams: ExpandableSubCategoryDetailsParams = ExpandableSubCategoryDetailsParams.Default
) {
    val expandedState = remember { mutableStateOf(false) }
    expandedState.value = category?.type == selectedSpendingCategory

    val expandedContentHeight = remember { mutableStateOf(params.markerInitialHeight) }
    val animatedCanvasHeight by animateDpAsState(
        targetValue = if (expandedState.value) expandedContentHeight.value else params.markerInitialHeight,
        animationSpec = tween(300)
    )
    val canvasColor = category?.type?.getColor() ?: colorResource(R.color.gray_6)

    Row(
        modifier = modifier
            .clickable { onClick(category?.type) }
            .padding(params.cellPaddings.toPaddingValues())
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(params.canvasContainer.toPaddingValues())) {
            Canvas(
                modifier = Modifier
                    .padding(params.canvasPaddings.toPaddingValues())
                    .width(params.canvasWidth)
                    .height(animatedCanvasHeight)
                    .animateContentSize()
            ) {
                if (expandedState.value)
                    drawRoundRect(
                        color = canvasColor,
                        cornerRadius = CornerRadius(params.canvasTransformedRadius.toPx())
                    ) else drawCircle(canvasColor)
            }
        }
        Column {
            Row(
                modifier = Modifier.padding(params.titlePaddings.toPaddingValues())
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title ?: "",
                    style = params.titleStyle
                )
                Text(
                    modifier = Modifier.padding(params.rightTitlePaddings.toPaddingValues()),
                    text = subTitle ?: buildAnnotatedString { append("") },
                    style = params.rightTitleStyle,
                )
            }
            if (category != null && checkIfLastItem(category))
                HorizontalDivider(color = ChiliTheme.Colors.ChiliDividerColor)

            AnimatedVisibility(
                visible = expandedState.value,
                enter = fadeIn() + expandVertically(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessVeryLow
                    )
                )
            ) {
                ExpandableSubCategoryDetails(
                    expandedState = expandedState.value,
                    onExpandedContentHeightChange = { expandedContentHeight.value = it },
                    subCategories = category?.subCategories,
                    params = subCategoryParams
                )
            }
        }
    }
}


@Composable
private fun ExpandableSubCategoryDetails(
    modifier: Modifier = Modifier,
    expandedState: Boolean,
    onExpandedContentHeightChange: (Dp) -> Unit,
    subCategories: List<ExpandableSubCategoryModel>?,
    params: ExpandableSubCategoryDetailsParams = ExpandableSubCategoryDetailsParams.Default
) {
    val localDensity = LocalDensity.current
    val padding = dimensionResource(R.dimen.padding_8dp)

    Column(modifier = modifier.onSizeChanged { size ->
        if (expandedState) {
            onExpandedContentHeightChange(with(localDensity) { size.height.toDp() + padding })
        }
    }) {
        subCategories?.let {
            it.forEach { subCategory ->
                key(it.hashCode()) {
                    Column(
                        modifier = Modifier
                            .padding(top = dimensionResource(R.dimen.padding_8dp))
                            .fillMaxWidth(),
                    ) {
                        Row {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = subCategory.title ?: "",
                                style = params.titleStyle
                            )
                            Text(
                                modifier = Modifier.padding(end = dimensionResource(R.dimen.padding_8dp)),
                                text = subCategory.rightSubtitle?.addCurrency("с")
                                    ?: buildAnnotatedString { append("") },
                                color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                                style = params.rightSubtitleStyle
                            )
                        }
                        Row {
                            Text(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(top = dimensionResource(R.dimen.padding_8dp)),
                                text = subCategory.bottomSubtitle ?: "",
                                style = params.bottomSubtitleStyle
                            )
                        }
                    }
                }
                HorizontalDivider(
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_4dp)),
                    color = ChiliTheme.Colors.ChiliDividerColor
                )
            }
        }
    }
}

data class ExpandableSubCategoryDetailsParams(
    val titleStyle: TextStyle,
    val rightSubtitleStyle: TextStyle,
    val bottomSubtitleStyle: TextStyle,
) {
    companion object {
        val Default
            @Composable() get() = ExpandableSubCategoryDetailsParams(
                titleStyle = ChiliTextStyleBuilder.H7.Default,
                rightSubtitleStyle = ChiliTextStyleBuilder.H7.Default,
                bottomSubtitleStyle = ChiliTextStyleBuilder.H8.Default.copy(color = ChiliTheme.Colors.ChiliValueTextColor)
            )
    }
}

@Preview(showBackground = true)
@Composable
fun ExpandableCategoryCell_Preview() {
    val selectedSpendingCategory = remember { mutableStateOf(EnumSpendingCategory.SUBSCRIPTION_FEE) }
    val categoryDetail = SpendingCategory(
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
    ).toExpandableCategoryCellModel()

    ChiliTheme {
        Column(Modifier.fillMaxSize()) {
            ExpandableCategoryCell(
                title = categoryDetail.title ?: "",
                subTitle = categoryDetail.rightSubtitle.addCurrency("с"),
                category = categoryDetail,
                selectedSpendingCategory = selectedSpendingCategory.value.toExpandableCategoryCellType(),
                checkIfLastItem = { true },
                onClick = { selectedSpendingCategory.value = it!!.toEnumSpendingCategory() }
            )
        }
    }
}