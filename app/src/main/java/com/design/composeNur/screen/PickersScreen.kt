package com.design.composeNur.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.picker.nurDatePicker.NurDatePickerDialog
import com.design.composeNur.components.picker.nurDatePicker.NurDatePickerParams
import com.design.composeNur.components.picker.nurDatePicker.DatePickerTimeParams
import com.design.composeNur.components.picker.nurTimePicker.NurTimePickerDialog
import com.design.composeNur.theme.NurTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun PickersScreen() {

    var showDatePickerDialog by remember { mutableStateOf(false) }
    var showDateRangePickerDialog by remember { mutableStateOf(false) }
    var showDatePickerWithStartLimitDialog by remember { mutableStateOf(false) }
    var showDatePickerWithEndLimitDialog by remember { mutableStateOf(false) }
    var showDatePickerWithLimitsDialog by remember { mutableStateOf(false) }
    var showDateRangePickerWithStartLimitDialog by remember { mutableStateOf(false) }
    var showDateRangePickerWithEndLimitDialog by remember { mutableStateOf(false) }
    var showDateRangePickerWithLimitsDialog by remember { mutableStateOf(false) }
    var showTimePickerDialog by remember { mutableStateOf(false) }

    Column(
        Modifier
            .background(NurTheme.Colors.СhiliScreenBackground)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            NurButton(
                onClick = { showDatePickerDialog = true }, title = "Date picker"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDateRangePickerDialog = true }, title = "Date range picker"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDatePickerWithStartLimitDialog = true },
                title = "Date picker with start limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDatePickerWithEndLimitDialog = true },
                title = "Date picker with end limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDatePickerWithLimitsDialog = true },
                title = "Date picker with start and end limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDateRangePickerWithStartLimitDialog = true },
                title = "Range picker with start limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDateRangePickerWithEndLimitDialog = true },
                title = "Range picker with end limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showDateRangePickerWithLimitsDialog = true },
                title = "Range picker with start and end limit"
            )
            Spacer(modifier = Modifier.height(32.dp))
            NurButton(
                onClick = { showTimePickerDialog = true }, title = "Time picker"
            )
        }

        if (showDatePickerDialog) {
            StandardDatePickerWithLimits {
                showDatePickerDialog = false
            }
        }
        if (showDatePickerWithStartLimitDialog) {
            StandardDatePickerWithLimits(
                startLimit = LocalDateTime.now(),
                onSubmitBtn = { showDatePickerWithStartLimitDialog = false }
            )
        }
        if (showDatePickerWithEndLimitDialog) {
            StandardDatePickerWithLimits(
                endLimit = LocalDateTime.now(),
                onSubmitBtn = { showDatePickerWithEndLimitDialog = false }
            )
        }
        if (showDatePickerWithLimitsDialog) {
            StandardDatePickerWithLimits(
                startLimit = LocalDateTime.now(),
                endLimit = LocalDateTime.now().plusMonths(5),
                onSubmitBtn = { showDatePickerWithLimitsDialog = false }
            )
        }
        if (showDateRangePickerDialog) {
            StandardDateRangePickerWithLimits {
                showDateRangePickerDialog = false
            }
        }
        if (showDateRangePickerWithStartLimitDialog) {
            StandardDateRangePickerWithLimits(
                startLimit = LocalDateTime.now(),
                onSubmitBtn = { showDateRangePickerWithStartLimitDialog = false }
            )
        }
        if (showDateRangePickerWithEndLimitDialog) {
            StandardDateRangePickerWithLimits(
                endLimit = LocalDateTime.now(),
                onSubmitBtn = { showDateRangePickerWithEndLimitDialog = false }
            )
        }
        if (showDateRangePickerWithLimitsDialog) {
            StandardDateRangePickerWithLimits(
                startLimit = LocalDateTime.now(),
                endLimit = LocalDateTime.now().plusMonths(5),
                onSubmitBtn = { showDateRangePickerWithLimitsDialog = false }
            )
        }
        if (showTimePickerDialog) {
            NurTimePickerDialog(onDismissRequest = {

            }, submitBtnTitle = "Готово", title = "Выберите время", onSubmitBtn = {
                showTimePickerDialog = false
            })
        }
    }
}

@Composable
fun StandardDatePickerWithLimits(
    startLimit: LocalDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
    endLimit: LocalDateTime = LocalDateTime.of(2100, 1, 1, 0, 0),
    onSubmitBtn: () -> Unit
) {
    val context = LocalContext.current
    val formatter = DateTimeFormatter.ofPattern("yyyy MMM d HH:mm:ss")

    NurDatePickerDialog(
        modifier = Modifier,
        onDismissRequest = {},
        startDateTitle = "Дата",
        submitBtnTitle = "Готово",
        calendarLocale = "ru",
        datePickedParams = NurDatePickerParams(
            firstDate = DatePickerTimeParams(
                startDateTime = LocalDateTime.now(),
                minDateTime = startLimit,
                maxDateTime = endLimit
            )
        ),
        onSubmitBtn = { startDate, _ ->
            onSubmitBtn()
            Toast.makeText(context, startDate?.format(formatter), Toast.LENGTH_SHORT).show()
        })
}

@Composable
fun StandardDateRangePickerWithLimits(
    startLimit: LocalDateTime = LocalDateTime.of(1900, 1, 1, 0, 0),
    endLimit: LocalDateTime = LocalDateTime.of(2100, 1, 1, 0, 0),
    onSubmitBtn: () -> Unit
) {
    val context = LocalContext.current
    val formatter = DateTimeFormatter.ofPattern("yyyy MMM d HH:mm:ss")

    NurDatePickerDialog(
        modifier = Modifier,
        onDismissRequest = {},
        startDateTitle = "Начальная Дата",
        endDateTitle = "Конечная Дата",
        submitBtnTitle = "Готово",
        calendarLocale = "ru",
        datePickedParams = NurDatePickerParams(
            firstDate = DatePickerTimeParams(
                startDateTime = LocalDateTime.now(),
                minDateTime = startLimit,
                maxDateTime = endLimit
            ), secondDate = DatePickerTimeParams(
                startDateTime = LocalDateTime.now(),
                minDateTime = startLimit,
                maxDateTime = endLimit
            )
        ),
        onSubmitBtn = { startDate, endDate ->
            onSubmitBtn()
            Toast.makeText(context, "${formatter.format(startDate)} - ${formatter.format(endDate)}", Toast.LENGTH_LONG).show()
        })
}