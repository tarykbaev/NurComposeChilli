package com.design.composechili.components.common.periodSelectablePieChart

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.card.AccentCardPreview
import com.design.composechili.components.common.pieChart.PieChart
import com.design.composechili.components.common.pieChart.model.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.EnumSpendingSubCategory
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.components.common.pieChart.model.SpendingCategory
import com.design.composechili.components.common.pieChart.model.SpendingSubCategory
import com.design.composechili.components.common.pieChart.model.getColor
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.addCurrency
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

@Composable
fun PeriodSelectablePieChart(
    modifier: Modifier,
    detalizationPeriod: Pair<String, String>?,
    detalizationInfo: DetalizationInfo,
    onPeriodClick: () -> Unit,
    periodType: PeriodType?,
    dateRangeListener: (startDate: String, endDate: String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp)))
            .background(Color.White)
    ) {
        if (periodType != null) {
            Image(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = dimensionResource(R.dimen.padding_8dp))
                    .clickable {
                        detalizationPeriod?.let {
                            getPreviousPeriod(it.first, it.second, periodType)
                        }?.let { dateRangeListener(it.first, it.second) }
                    },
                painter = painterResource(R.drawable.chili_ic_chevron_left),
                contentDescription = null
            )
            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = dimensionResource(R.dimen.padding_8dp))
                    .rotate(180f)
                    .clickable(enabled = checkIfPeriodAvailable(detalizationPeriod)) {
                        detalizationPeriod?.let {
                            getNextPeriod(it.first, detalizationPeriod.second, periodType)
                        }?.let { dateRangeListener(it.first, it.second) }
                    },
                painter = painterResource(R.drawable.chili_ic_chevron_left),
                contentDescription = null,
                colorFilter = disableColorFilter(detalizationPeriod)
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = dimensionResource(R.dimen.padding_8dp))
                    .clickable { onPeriodClick() },
                text = getPeriodText(detalizationPeriod),
                textAlign = TextAlign.Center
            )
            PieChart(
                detalizationInfo = detalizationInfo,
                params = PieChartParams.Default
            ) {}
        }
    }
}

private fun disableColorFilter(detalizationPeriod: Pair<String, String>?) =
    if (checkIfPeriodAvailable(detalizationPeriod))
        ColorFilter.lighting(Color.Transparent, Color.Transparent)
    else ColorFilter.lighting(Color.Gray, Color.Gray)

private fun checkIfPeriodAvailable(detalizationPeriod: Pair<String, String>?) =
    detalizationPeriod?.let { it.second.toLocalDate() < LocalDate.now() } ?: false

private fun getPeriodText(detalizationPeriod: Pair<String, String>?): String {
    return when {
        detalizationPeriod == null -> getInitDate()
        detalizationPeriod.first == detalizationPeriod.second ->
            "Детализация на ${detalizationPeriod.first}"

        else ->
            "Детализация с ${detalizationPeriod.first} по ${detalizationPeriod.second}"
    }
}

private fun getInitDate(): String {
    return "Детализация на ".plus(LocalDateTime.now().formatByRegex(DATE_PATTERN))
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
    val localDensity = LocalDensity.current

    ChiliTheme {
        BaseBottomSheet(peekHeight = 0.dp, sheetState = sheetState, bottomSheetContent = {
            DatePickerBottomSheet(coScope, sheetState, uiState.value) { uiState.value = it }
        }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .softLayerShadow()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    PeriodSelectablePieChart(
                        modifier = Modifier.fillMaxWidth(),
                        detalizationPeriod = uiState.value.dateRange,
                        detalizationInfo = uiState.value.detalizationInfo,
                        onPeriodClick = { coScope.launch { sheetState.expand() } },
                        dateRangeListener = { start, end ->
                            uiState.value = uiState.value.copy(dateRange = Pair(start, end))
                        },
                        periodType = uiState.value.periodType
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = dimensionResource(R.dimen.padding_12dp))
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp)))
                            .background(Color.White),
                    ) {

                        uiState.value.detalizationInfo.category?.let { category ->
                            category.forEach { item ->
                                key(item.hashCode()) {
                                    val expandedState = remember { mutableStateOf(false) }
                                    val expandedContentHeight = remember { mutableStateOf(0.dp) }
                                    val animatedCanvasHeight by animateDpAsState(
                                        targetValue = if (expandedState.value) expandedContentHeight.value else 12.dp,
                                        animationSpec = tween(300)
                                    )
                                    val canvasColor = item.type?.getColor() ?: colorResource(R.color.gray_6)
                                    Row(
                                        modifier = Modifier
                                            .clickable {
                                                expandedState.value =
                                                    if (item.subCategories.isNullOrEmpty()) expandedState.value else !expandedState.value
                                            }
                                            .padding(dimensionResource(R.dimen.padding_12dp))
                                            .fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Column {
                                            Canvas(
                                                modifier = Modifier
                                                    .padding(horizontal = dimensionResource(R.dimen.padding_12dp))
                                                    .width(dimensionResource(R.dimen.view_12dp))
                                                    .height(animatedCanvasHeight)
                                                    .animateContentSize()
                                            ) {
                                                if (expandedState.value)
                                                    drawRoundRect(
                                                        color = canvasColor,
                                                        cornerRadius = CornerRadius(6.dp.toPx())
                                                    ) else drawCircle(canvasColor)
                                            }
                                        }
                                        Column {
                                            Row {
                                                Text(modifier = Modifier.weight(1f), text = item.name ?: "")
                                                Text(
                                                    text = item.totalCharge?.addCurrency()
                                                        ?: buildAnnotatedString { append("") },
                                                    color = ChiliTheme.Colors.ChiliValueTextColor
                                                )
                                            }
                                            AnimatedVisibility(expandedState.value) {
                                                Column(modifier = Modifier.onSizeChanged { size ->
                                                    if (expandedState.value) {
                                                        expandedContentHeight.value =
                                                            with(localDensity) { size.height.toDp() }
                                                    }
                                                }) {
                                                    item.subCategories?.let {
                                                        it.forEach { subCategory ->
                                                            Column(
                                                                modifier = Modifier
                                                                    .padding(
                                                                        top = dimensionResource(R.dimen.padding_12dp),
                                                                    )
                                                                    .fillMaxWidth(),
                                                            ) {
                                                                Row {
                                                                    Text(
                                                                        modifier = Modifier.weight(1f),
                                                                        text = subCategory.name ?: ""
                                                                    )
                                                                    Text(
                                                                        text = subCategory.charge?.addCurrency()
                                                                            ?: buildAnnotatedString { append("") },
                                                                        color = ChiliTheme.Colors.ChiliValueTextColor
                                                                    )
                                                                }
                                                                Row {
                                                                    Text(
                                                                        modifier = Modifier
                                                                            .weight(1f)
                                                                            .padding(top = dimensionResource(R.dimen.padding_8dp)),
                                                                        text = subCategory.getPaymentDate()
                                                                    )
                                                                }
                                                            }
                                                            HorizontalDivider(
                                                                modifier = Modifier.padding(
                                                                    top = dimensionResource(
                                                                        R.dimen.padding_4dp
                                                                    )
                                                                ),
                                                                color = ChiliTheme.Colors.ChiliDividerColor
                                                            )
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (uiState.value.detalizationInfo.category?.last() != item)
                                        HorizontalDivider(
                                            modifier = Modifier.padding(start = dimensionResource(R.dimen.padding_48dp)),
                                            color = ChiliTheme.Colors.ChiliDividerColor
                                        )
                                }
                            }
                        }
                    }
                    AccentCardPreview()
                    if (uiState.value.showDatePicker) {
                        DatePickerDialog(uiState)
                    }
                }
            }
        }
    }
}

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
    uiState: DetalizationUiState,
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
                                totalAmount = 350.44,
                                category = uiState.detalizationInfo.category?.takeLast(5)
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
                                category = uiState.detalizationInfo.category?.take(5)
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
                totalCharge = 10f
            ),
            SpendingCategory("Banking", type = EnumSpendingCategory.OMONEY, totalCharge = 190f),
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
            SpendingCategory("Internet", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
            SpendingCategory(
                "Internet Package",
                type = EnumSpendingCategory.INTERNET_PACKAGE,
                totalCharge = 50f
            ),
            SpendingCategory("Roaming", type = EnumSpendingCategory.ROAMING, totalCharge = 100f),
            SpendingCategory("Out Voice", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 50f),
            SpendingCategory("SMS", type = EnumSpendingCategory.SMS, totalCharge = 250f),
            SpendingCategory("InnerVoice", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 50.44f),
            SpendingCategory("Other", type = EnumSpendingCategory.NONE, totalCharge = 0f),
        )
    ),
    val dateRange: Pair<String, String> = Pair(
        LocalDateTime.now().formatByRegex(DATE_PATTERN),
        LocalDateTime.now().formatByRegex(DATE_PATTERN)
    ),
    val showDatePicker: Boolean = false,
    val periodType: PeriodType? = PeriodType.DAY,
)