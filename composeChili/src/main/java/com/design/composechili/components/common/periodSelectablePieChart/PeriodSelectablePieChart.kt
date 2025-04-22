package com.design.composechili.components.common.periodSelectablePieChart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.common.pieChart.PieChart
import com.design.composechili.components.common.pieChart.model.DetalizationInfo
import com.design.composechili.components.common.pieChart.model.EnumSpendingCategory
import com.design.composechili.components.common.pieChart.model.PieChartParams
import com.design.composechili.components.common.pieChart.model.SpendingCategory
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.expand
import com.design.composechili.utils.formatByRegex
import com.design.composechili.utils.hide
import com.design.composechili.utils.softLayerShadow
import com.design.composechili.utils.toLocalDate
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@Composable
fun PeriodSelectablePieChart(
    modifier: Modifier,
    detalizationPeriod: Pair<String, String>?,
    detalizationInfo: DetalizationInfo,
    onPeriodClick: () -> Unit,
    periodType: PeriodType? = PeriodType.DAY,
    nextPeriod: (startDate: String, endDate: String) -> Unit,
    previousPeriod: (startDate: String, endDate: String) -> Unit,
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
                            getPreviousPeriod(it.first, detalizationPeriod.second, periodType)
                        }?.let { previousPeriod(it.first, it.second) }
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
                            getPreviousPeriod(it.first, detalizationPeriod.second, periodType)
                        }?.let { previousPeriod(it.first, it.second) }
                    },
                painter = painterResource(R.drawable.chili_ic_chevron_left),
                contentDescription = null
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

private fun checkIfPeriodAvailable(detalizationPeriod: Pair<String, String>?) =
    detalizationPeriod?.let { it.second.toLocalDate() >= LocalDateTime.now() } ?: true

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
            startDate.toLocalDate().minusDays(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDate().minusDays(1).formatByRegex(DATE_PATTERN))
        PeriodType.WEEK -> Pair(
            startDate.toLocalDate().minusWeeks(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDate().minusDays(1).formatByRegex(DATE_PATTERN)
        )

        PeriodType.MONTH -> Pair(
            startDate.toLocalDate().minusMonths(1).formatByRegex(DATE_PATTERN),
            endDate.toLocalDate().minusMonths(1).formatByRegex(DATE_PATTERN))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PeriodSelectablePieChart_Preview() {
    val listOfItems = listOf(
        SpendingCategory("", type = EnumSpendingCategory.SUBSCRIPTION_FEE, totalCharge = 10f),
        SpendingCategory("", type = EnumSpendingCategory.OMONEY, totalCharge = 190f),
        SpendingCategory("", type = EnumSpendingCategory.SERVICES, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.INTERNET_PACKAGE, totalCharge = 50f),
        SpendingCategory("", type = EnumSpendingCategory.ROAMING, totalCharge = 100f),
        SpendingCategory("", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 50f),
        SpendingCategory("", type = EnumSpendingCategory.SMS, totalCharge = 250f),
        SpendingCategory("", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 50.44f),
        SpendingCategory("", type = EnumSpendingCategory.NONE, totalCharge = 0f),
    )
    val listOfCategories = remember {
        mutableStateOf(
            DetalizationInfo(
                totalAmount = 900.44,
                category = listOfItems
            )
        )
    }

    val dateState = remember { mutableStateOf<Pair<String, String>?>(null) }
    val showDatePickerDialog = remember { mutableStateOf(false) }

    val coScope = rememberCoroutineScope()
    val sheetState = getBottomSheetState().apply {
        coScope.launch { bottomSheetState.hide() }
    }
    ChiliTheme {
        BaseBottomSheet(peekHeight = 0.dp, sheetState = sheetState, bottomSheetContent = {
            ActionBottomSheetContent(
                buttons = listOf(
                    ActionBottomSheetParams(
                        title = "Today",
                        buttonStyle = ChiliButtonStyle.Primary
                    ) {
                        coScope.launch {
                            sheetState.hide()
                            //todo will be implemented vm logic to get info from server
                            listOfCategories.value = DetalizationInfo(0.0, emptyList())
                            dateState.value = Pair(
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                            )
                        }
                    },
                    ActionBottomSheetParams(
                        title = "One week",
                        buttonStyle = ChiliButtonStyle.Primary
                    ) {
                        coScope.launch {
                            sheetState.hide()
                            listOfCategories.value = DetalizationInfo(350.44, listOfItems.takeLast(5))
                            dateState.value = Pair(
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                                LocalDateTime.now().plusWeeks(1).formatByRegex(DATE_PATTERN),
                            )
                        }
                    },
                    ActionBottomSheetParams(
                        title = "One Month",
                        buttonStyle = ChiliButtonStyle.Primary
                    ) {
                        coScope.launch {
                            sheetState.hide();listOfCategories.value =
                            DetalizationInfo(450.0, listOfItems.take(5))
                            dateState.value = Pair(
                                LocalDateTime.now().formatByRegex(DATE_PATTERN),
                                LocalDateTime.now().plusMonths(1).formatByRegex(DATE_PATTERN),
                            )
                        }
                    },
                    ActionBottomSheetParams(
                        title = "Choose period manually",
                        buttonStyle = ChiliButtonStyle.Primary
                    ) {
                        coScope.launch {
                            sheetState.hide()
                            showDatePickerDialog.value = true
                        }
                    },
                )
            )
        }) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .softLayerShadow()
            ) {
                PeriodSelectablePieChart(
                    modifier = Modifier.fillMaxWidth(),
                    detalizationPeriod = dateState.value,
                    detalizationInfo = listOfCategories.value,
                    onPeriodClick = { coScope.launch { sheetState.expand() } },
                    previousPeriod = { start, end -> },
                    nextPeriod = { start, end -> }
                )
                if (showDatePickerDialog.value) {
                    ChiliDatePickerDialog(
                        modifier = Modifier,
                        onDismissRequest = { },
                        datePickedParams = ChiliDatePickerParams(
                            firstDate = DatePickerTimeParams(
                                startDateTime = LocalDateTime.now(),
                                minDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
                                maxDateTime = LocalDateTime.of(2100, 1, 1, 0, 0),
                            ),
                            secondDate = DatePickerTimeParams(
                                startDateTime = LocalDateTime.now(),
                                minDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
                                maxDateTime = LocalDateTime.of(2100, 1, 1, 0, 0),
                            ),
                        ),
                        startDateTitle = "Начальная Дата",
                        endDateTitle = "Конечная Дата",
                        submitBtnTitle = "Готово",
                        calendarLocale = "ru",
                        onSubmitBtn = { startDate, endDate ->
                            if (startDate != null && endDate != null) {
                                dateState.value = Pair(
                                    startDate.formatByRegex(DATE_PATTERN),
                                    endDate.formatByRegex(DATE_PATTERN),
                                )
                                listOfCategories.value = DetalizationInfo(900.44, listOfItems)
                                showDatePickerDialog.value = false
                            }
                        },
                    )
                }
            }
        }
    }
}