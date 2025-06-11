package com.design.composechili.components.common.periodSelectablePieChart.mock

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.design.composechili.components.common.periodSelectablePieChart.model.DetalizationUiState
import com.design.composechili.components.common.pieChart.model.OModels.DetalizationInfo
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.formatByRegex
import java.time.LocalDateTime

@Composable
fun DatePickerDialog(uiState: MutableState<DetalizationUiState>) {
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