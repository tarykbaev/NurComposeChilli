package com.design.composechili.components.picker.chiliDatePicker

import java.time.LocalDateTime

data class ChiliDatePickerParams(
    val firstDate: DatePickerTimeParams,
    val secondDate: DatePickerTimeParams? = null,
)

data class DatePickerTimeParams(
    val startDateTime: LocalDateTime,
    val minDateTime: LocalDateTime,
    val maxDateTime: LocalDateTime,
)