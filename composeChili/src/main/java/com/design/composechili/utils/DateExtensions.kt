package com.design.composechili.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun Date.formatByRegex(regex: String): String {
    return SimpleDateFormat(regex, Locale.getDefault()).format(this)
}

fun LocalDateTime.formatByRegex(regex: String): String {
    return this.format(DateTimeFormatter.ofPattern(regex))
}

const val DATE_PATTERN = "dd.MM.yyyy"