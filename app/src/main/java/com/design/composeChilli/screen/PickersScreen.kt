package com.design.composeChilli.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.components.picker.chiliTimePicker.ChiliTimePickerDialog
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickersScreen() {

    var showDateRangePickerDialog by remember { mutableStateOf(false) }
    var showDatePickerDialog by remember { mutableStateOf(false) }
    var showTimePickerDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(ChiliTheme.Colors.ChiliSurfaceBackground)) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showDateRangePickerDialog = true },
                title = "ChiliDateRangePicker"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showDatePickerDialog = true },
                title = "ChiliDatePicker"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showTimePickerDialog = true },
                title = "ChiliTimePicker"
            )
        }
        if (showDateRangePickerDialog) {
            ChiliDatePickerDialog(
                modifier = Modifier,
                onDismissRequest = {},
                startDateTitle = "Начальная Дата",
                endDateTitle = "Конечная Дата",
                submitBtnTitle = "Готово",
                calendarLocale = "ru",
                datePickedParams = ChiliDatePickerParams(
                    firstDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    ),
                    secondDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    )
                ),
                onSubmitBtn = { startDate, endDate ->
                    showDateRangePickerDialog = false
                }
            )
        }
        if (showDatePickerDialog) {
            ChiliDatePickerDialog(
                modifier = Modifier,
                onDismissRequest = {},
                startDateTitle = "Дата",
                submitBtnTitle = "Готово",
                calendarLocale = "ru",
                datePickedParams = ChiliDatePickerParams(
                    firstDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    )
                ),
                onSubmitBtn = { startDate, _ ->
                    showDatePickerDialog = false
                }
            )
        }
        if (showTimePickerDialog) {
            ChiliTimePickerDialog(
                onDismissRequest = {

                },
                submitBtnTitle = "Готово",
                title = "Выберите время",
                onSubmitBtn = {
                    showTimePickerDialog = false
                }
            )
        }
    }
}