package com.design.composechili.utils

import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun Date.formatByRegex(regex: String): String {
    return SimpleDateFormat(regex, Locale.getDefault()).format(this)
}

fun LocalDateTime.formatByRegex(regex: String): String {
    return this.format(DateTimeFormatter.ofPattern(regex))
}

fun LocalDateTime.getFirstDayOfMonth(): String {
    return this.withDayOfMonth(1).formatByRegex(DATE_PATTERN)
}

fun LocalDateTime.getLastDayOfMonth(): String {
    return this.withDayOfMonth(this.toLocalDate().lengthOfMonth()).formatByRegex(DATE_PATTERN)
}

fun LocalDateTime.getLastDayOfMonthNotInFuture(): String {
    val lastDayOfMonth = this.withDayOfMonth(this.toLocalDate().lengthOfMonth()).toLocalDate()
    return if (lastDayOfMonth.isNotFutureDate()) lastDayOfMonth.formatByRegex() else LocalDate.now()
        .formatByRegex()
}

fun String.toLocalDateTime(): LocalDateTime {
    return LocalDateTime.parse("$this 00:00", DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
}

fun LocalDate.formatByRegex(): String {
    return this.format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

fun String.toLocalDate(): LocalDate {
    return LocalDate.parse(this, DateTimeFormatter.ofPattern(DATE_PATTERN))
}

fun LocalDate.isNotFutureDate(): Boolean {
    return this < LocalDate.now()
}

fun LocalDate.getFirstDayOfWeek(): String {
    val currentDayOfWeek = this.dayOfWeek
    val daysToSubtract = currentDayOfWeek.value - DayOfWeek.MONDAY.value
    return this.minusDays(daysToSubtract.toLong()).format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

fun LocalDate.getLastDayOfWeek(): String {
    val currentDayOfWeek = this.dayOfWeek
    val daysToSubtract = DayOfWeek.SUNDAY.value - currentDayOfWeek.value
    return this.plusDays(daysToSubtract.toLong()).format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

fun LocalDate.getLastDayOfWeekNotInFuture(): String {
    val currentDayOfWeek = this.dayOfWeek
    val daysToSubtract = DayOfWeek.SUNDAY.value - currentDayOfWeek.value
    val lastDayOfWeek = this.plusDays(daysToSubtract.toLong())
    return if (lastDayOfWeek.isNotFutureDate()) lastDayOfWeek
        .format(DateTimeFormatter.ofPattern(DATE_PATTERN)) else LocalDate.now()
        .format(DateTimeFormatter.ofPattern(DATE_PATTERN))
}

const val DATE_PATTERN = "dd.MM.yyyy"
const val DATE_TIME_PATTERN = "dd.MM.yyyy HH:mm"