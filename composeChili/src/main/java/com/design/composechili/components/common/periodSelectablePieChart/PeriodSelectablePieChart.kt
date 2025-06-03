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
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.card.AccentCardPreview
import com.design.composechili.components.card.cardWithExpandableCategories.CardWithExpandableCategories
import com.design.composechili.components.card.cardWithExpandableCategories.CardWithExpandableCategoriesParams
import com.design.composechili.components.card.cardWithExpandableCategories.toEnumSpendingCategory
import com.design.composechili.components.card.cardWithExpandableCategories.toExpandableCategoryCellModel
import com.design.composechili.components.card.cardWithExpandableCategories.toExpandableCategoryCellType
import com.design.composechili.components.common.pieChart.PieChart
import com.design.composechili.components.common.pieChart.mapper.mapToPieChartInfo
import com.design.composechili.components.common.pieChart.mapper.toEnumSpendingCategory
import com.design.composechili.components.common.pieChart.mapper.toPieChartCategoryType
import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.EnumSpendingSubCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingCategory
import com.design.composechili.components.common.pieChart.model.OModels.SpendingSubCategory
import com.design.composechili.components.common.pieChart.model.PieChartCategoryType
import com.design.composechili.components.common.pieChart.model.PieChartInfo
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.expand
import com.design.composechili.utils.formatByRegex
import com.design.composechili.utils.getFirstDayOfMonth
import com.design.composechili.utils.getFirstDayOfWeek
import com.design.composechili.utils.getLastDayOfMonth
import com.design.composechili.utils.getLastDayOfMonthNotInFuture
import com.design.composechili.utils.getLastDayOfWeek
import com.design.composechili.utils.getLastDayOfWeekNotInFuture
import com.design.composechili.utils.hide
import com.design.composechili.utils.softLayerShadow
import com.design.composechili.utils.toLocalDate
import com.design.composechili.utils.toLocalDateTime
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
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
                            getPreviousPeriod(it.first, it.second, periodType)
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
                        enabled = checkIfPeriodAvailable(detalizationPeriod),
                        indication = ripple(),
                        interactionSource = remember { MutableInteractionSource() }
                    ) {
                        detalizationPeriod?.let {
                            getNextPeriod(it.first, detalizationPeriod.second, periodType)
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
                colorFilter = disableColorFilter(detalizationPeriod)
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
                text = getPeriodText(detalizationPeriod, periodTitleSingle, periodTitleStartToEnd),
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

private fun disableColorFilter(detalizationPeriod: Pair<String, String>?) =
    if (checkIfPeriodAvailable(detalizationPeriod))
        ColorFilter.lighting(Color.Transparent, Color.Transparent)
    else ColorFilter.lighting(Color.Gray, Color.Gray)

private fun checkIfPeriodAvailable(detalizationPeriod: Pair<String, String>?) =
    detalizationPeriod?.let { it.second.toLocalDate() < LocalDate.now() } ?: false

private fun getPeriodText(
    detalizationPeriod: Pair<String, String>?,
    periodTitleSingle: String,
    periodTitleStartToEnd: Pair<String, String>
): String {
    return when {
        detalizationPeriod == null -> getInitDate(periodTitleSingle)
        detalizationPeriod.first == detalizationPeriod.second ->
            "${periodTitleSingle}${detalizationPeriod.first}"

        else ->
            "${periodTitleStartToEnd.first}${detalizationPeriod.first} ${periodTitleStartToEnd.second} ${detalizationPeriod.second}"
    }
}

private fun getInitDate(periodTitleSingle: String): String {
    return periodTitleSingle.plus(LocalDateTime.now().formatByRegex(DATE_PATTERN))
}

private fun getPreviousPeriod(
    startDate: String,
    endDate: String,
    periodType: PeriodType
): Pair<String, String> {
    return when (periodType) {
        PeriodType.DAY -> Pair(
            startDate.toLocalDateTime().minusDays(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDateTime().minusDays(1).formatByRegex(DATE_PATTERN)
        )

        PeriodType.WEEK -> Pair(
            startDate.toLocalDateTime().minusWeeks(1).formatByRegex(DATE_PATTERN),
            startDate.toLocalDate().minusWeeks(1).getLastDayOfWeek()
        )

        PeriodType.MONTH -> Pair(
            startDate.toLocalDateTime().minusMonths(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDateTime().minusMonths(1).getLastDayOfMonth()
        )
    }
}

private fun getNextPeriod(
    startDate: String,
    endDate: String,
    periodType: PeriodType
): Pair<String, String> {
    return when (periodType) {
        PeriodType.DAY -> Pair(
            startDate.toLocalDateTime().plusDays(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDateTime().plusDays(1).formatByRegex(DATE_PATTERN)
        )

        PeriodType.WEEK -> Pair(
            startDate.toLocalDateTime().plusWeeks(1).formatByRegex(DATE_PATTERN),
            startDate.toLocalDate().plusWeeks(1).getLastDayOfWeekNotInFuture()
        )

        PeriodType.MONTH -> Pair(
            startDate.toLocalDateTime().plusMonths(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDateTime().plusMonths(1).getLastDayOfMonthNotInFuture()
        )
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

//Below functions are examples of using PieChart with DatePicker can be tested in a preview

@Composable
private fun DatePickerDialog(uiState: MutableState<DetalizationUiState>) {
    ChiliDatePickerDialog(
        modifier = Modifier,
        onDismissRequest = { },
        datePickedParams = ChiliDatePickerParams(
            firstDate = DatePickerTimeParams(
                startDateTime = LocalDateTime.now(),
                minDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
                maxDateTime = LocalDateTime.now(),
            ),
            secondDate = DatePickerTimeParams(
                startDateTime = LocalDateTime.now(),
                minDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
                maxDateTime = LocalDateTime.now(),
            ),
        ),
        startDateTitle = "Начальная Дата",
        endDateTitle = "Конечная Дата",
        submitBtnTitle = "Готово",
        calendarLocale = "ru",
        onSubmitBtn = { startDate, endDate ->
            if (startDate != null && endDate != null) {
                uiState.value = uiState.value.copy(
                    dateRange = Pair(
                        startDate.formatByRegex(DATE_PATTERN),
                        endDate.formatByRegex(DATE_PATTERN),
                    ),
                    detalizationInfo = DetalizationInfo(
                        900.44,
                        uiState.value.detalizationInfo.category
                    ),
                    periodType = null
                )
                uiState.value = uiState.value.copy(showDatePicker = false)
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DatePickerBottomSheet(
    coScope: CoroutineScope,
    sheetState: BottomSheetScaffoldState,
    onStateChange: (DetalizationUiState) -> Unit
) {
    ActionBottomSheetContent(
        buttons = listOf(
            ActionBottomSheetParams(
                title = "Today",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    //todo will be implemented vm logic to get info from server
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 0.0,
                                category = emptyList()
                            ),
                            dateRange = Pair(
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                            ),
                            periodType = PeriodType.DAY
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "One week",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 450.44,
                                category = DetalizationUiState().detalizationInfo.category?.takeLast(5)
                            ),
                            dateRange = Pair(
                                LocalDate.now().getFirstDayOfWeek(),
                                LocalDate.now().getLastDayOfWeekNotInFuture()
                            ),
                            periodType = PeriodType.WEEK
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "One Month",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(
                        DetalizationUiState().copy(
                            detalizationInfo = DetalizationInfo(
                                totalAmount = 450.0,
                                category = DetalizationUiState().detalizationInfo.category?.take(5)
                            ),
                            dateRange = Pair(
                                LocalDateTime.now().getFirstDayOfMonth(),
                                LocalDateTime.now().getLastDayOfMonthNotInFuture(),
                            ),
                            periodType = PeriodType.MONTH
                        )
                    )
                }
            },
            ActionBottomSheetParams(
                title = "Choose period manually",
                buttonStyle = ChiliButtonStyle.Primary
            ) {
                coScope.launch {
                    sheetState.hide()
                    onStateChange(DetalizationUiState().copy(showDatePicker = true))
                }
            },
        )
    )
}

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
