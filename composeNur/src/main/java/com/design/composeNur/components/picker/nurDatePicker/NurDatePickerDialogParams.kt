package com.design.composeNur.components.picker.nurDatePicker

import java.time.LocalDateTime

data class NurDatePickerParams(
    val firstDate: DatePickerTimeParams,
    val secondDate: DatePickerTimeParams? = null,
)

data class DatePickerTimeParams(
    val startDateTime: LocalDateTime,
    val minDateTime: LocalDateTime,
    val maxDateTime: LocalDateTime,
)