package com.design.composechili.components.common.periodSelectablePieChart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.card.AccentCardPreview
import com.design.composechili.components.card.cardWithExpandableCategories.CardWithExpandableCategories
import com.design.composechili.components.card.cardWithExpandableCategories.CardWithExpandableCategoriesParams
import com.design.composechili.components.card.cardWithExpandableCategories.toEnumSpendingCategory
import com.design.composechili.components.card.cardWithExpandableCategories.toExpandableCategoryCellModel
import com.design.composechili.components.card.cardWithExpandableCategories.toExpandableCategoryCellType
import com.design.composechili.components.common.periodSelectablePieChart.mock.DatePickerBottomSheet
import com.design.composechili.components.common.periodSelectablePieChart.mock.DatePickerDialog
import com.design.composechili.components.common.periodSelectablePieChart.model.DetalizationUiState
import com.design.composechili.components.common.pieChart.PieChart
import com.design.composechili.components.common.pieChart.mapper.mapToPieChartInfo
import com.design.composechili.components.common.pieChart.mapper.toEnumSpendingCategory
import com.design.composechili.components.common.pieChart.mapper.toPieChartCategoryType
import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.PieChartCategoryType
import com.design.composechili.components.common.pieChart.model.PieChartInfo
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.expand
import com.design.composechili.utils.softLayerShadow
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun PeriodSelectablePieChart(
    modifier: Modifier,
    periodTitleSingle: String,
    periodTitleStartToEnd: Pair<String, String>,
    periodSelectablePieChartParams: PeriodSelectablePieChartParams = PeriodSelectablePieChartParams.Default,
    detalizationPeriod: Pair<String, String>?,
    pieChartInfo: PieChartInfo,
    onPeriodClick: () -> Unit,
    periodType: PeriodType?,
    dateRangeListener: (startDate: String, endDate: String) -> Unit,
    onSelectedCategory: (PieChartCategoryType?) -> Unit,
    selectedCategory: PieChartCategoryType?,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(periodSelectablePieChartParams.cardCornerRadius))
            .background(periodSelectablePieChartParams.cardBackgroundColor)
    ) {
        if (periodType != null) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable(
                        enabled = true,
                        indication = ripple(),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        detalizationPeriod?.let {
                            PieChartUtils.getPreviousPeriod(it.first, it.second, periodType)
                        }?.let { dateRangeListener(it.first, it.second) }
                        onSelectedCategory(null)
                    }
                    .background(Color.Transparent)
                    .padding(vertical = periodSelectablePieChartParams.chevronClickableAreaHeight)
                    .padding(horizontal = periodSelectablePieChartParams.chevronClickableAreaWidth)
                    .size(periodSelectablePieChartParams.chevronSize),
                painter = periodSelectablePieChartParams.chevronPainter,
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable(
                        enabled = PieChartUtils.checkIfPeriodAvailable(detalizationPeriod),
                        indication = ripple(),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        detalizationPeriod?.let {
                            PieChartUtils.getNextPeriod(it.first, detalizationPeriod.second, periodType)
                        }?.let { dateRangeListener(it.first, it.second) }
                        onSelectedCategory(null)
                    }
                    .background(Color.Transparent)
                    .padding(horizontal = periodSelectablePieChartParams.chevronClickableAreaWidth)
                    .padding(vertical = periodSelectablePieChartParams.chevronClickableAreaHeight)
                    .size(periodSelectablePieChartParams.chevronSize)
                    .rotate(periodSelectablePieChartParams.rightChevronRotateDegree),
                painter = periodSelectablePieChartParams.chevronPainter,
                contentDescription = null,
                colorFilter = PieChartUtils.disableColorFilter(detalizationPeriod)
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = periodSelectablePieChartParams.pieChartWithTextHorizontalPadding)
                .padding(vertical = periodSelectablePieChartParams.pieChartWithTextVerticalPadding)
                .clickable(interactionSource = null, indication = null) { onSelectedCategory(null) },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = periodSelectablePieChartParams.periodTextVerticalPadding)
                    .clickable { onPeriodClick() },
                text = PieChartUtils.getPeriodText(
                    detalizationPeriod,
                    periodTitleSingle,
                    periodTitleStartToEnd
                ),
                style = periodSelectablePieChartParams.periodTextStyle,
                textAlign = TextAlign.Center
            )
            PieChart(
                detalizationInfo = pieChartInfo,
                params = PieChartParams.Default,
                onSliceClick = { onSelectedCategory(it) },
                selectedCategory = selectedCategory
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PeriodSelectablePieChart_Preview() {
    val uiState = remember { mutableStateOf(DetalizationUiState()) }

    val coScope = rememberCoroutineScope()
    val sheetState = getBottomSheetState().apply { coScope.launch { bottomSheetState.hide() } }

    ChiliTheme {
        BaseBottomSheet(peekHeight = 0.dp, sheetState = sheetState, bottomSheetContent = {
            DatePickerBottomSheet(coScope, sheetState) { uiState.value = it }
        }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .softLayerShadow()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_8dp))
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_16dp)))
                    PeriodSelectablePieChart(
                        modifier = Modifier.fillMaxWidth(),
                        periodTitleSingle = "Детализация на ",
                        periodTitleStartToEnd = Pair("Детализация с ", "по"),
                        detalizationPeriod = uiState.value.dateRange,
                        pieChartInfo = uiState.value.detalizationInfo.mapToPieChartInfo(),
                        onPeriodClick = { coScope.launch { sheetState.expand() } },
                        dateRangeListener = { start, end ->
                            uiState.value = uiState.value.copy(dateRange = Pair(start, end))
                            val randomCountOfCategories = Random.nextInt(0..8)
                            uiState.value = uiState.value.copy(
                                detalizationInfo = DetalizationInfo(
                                    totalAmount = DetalizationUiState()
                                        .detalizationInfo.category
                                        ?.take(randomCountOfCategories)
                                        ?.sumOf { it.totalCharge?.toDouble() ?: 0.0 }
                                        ?: 0.0,
                                    category = DetalizationUiState()
                                        .detalizationInfo.category
                                        ?.take(randomCountOfCategories)
                                )
                            )
                        },
                        periodType = uiState.value.periodType,
                        onSelectedCategory = {
                            uiState.value =
                                uiState.value.copy(selectedCategory = it?.toEnumSpendingCategory())
                        },
                        selectedCategory = uiState.value.selectedCategory?.toPieChartCategoryType(),
                    )
                    CardWithExpandableCategories(
                        params = CardWithExpandableCategoriesParams.Default.copy(currency = "c"),
                        listOfCategories = uiState.value.detalizationInfo.category?.map { it.toExpandableCategoryCellModel() },
                        onCategoryClick = {
                            uiState.value =
                                uiState.value.copy(
                                    selectedCategory =
                                        if (uiState.value.selectedCategory == it?.toEnumSpendingCategory()) null
                                        else it?.toEnumSpendingCategory()
                                )
                        },
                        selectedCategory = uiState.value.selectedCategory?.toExpandableCategoryCellType()
                    )
                    //todo just for check if last items shown
                    AccentCardPreview()
                    if (uiState.value.showDatePicker) {
                        DatePickerDialog(uiState)
                    }
                }
            }
        }
    }
}

