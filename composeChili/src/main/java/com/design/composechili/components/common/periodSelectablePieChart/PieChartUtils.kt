package com.design.composechili.components.common.periodSelectablePieChart

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import com.design.composechili.utils.DATE_PATTERN
import com.design.composechili.utils.formatByRegex
import com.design.composechili.utils.getLastDayOfMonth
import com.design.composechili.utils.getLastDayOfMonthNotInFuture
import com.design.composechili.utils.getLastDayOfWeek
import com.design.composechili.utils.getLastDayOfWeekNotInFuture
import com.design.composechili.utils.toLocalDate
import com.design.composechili.utils.toLocalDateTime
import java.time.LocalDate
import java.time.LocalDateTime

object PieChartUtils {

    fun disableColorFilter(detalizationPeriod: Pair<String, String>?) =
        if (checkIfPeriodAvailable(detalizationPeriod))
            ColorFilter.lighting(Color.Transparent, Color.Transparent)
        else ColorFilter.lighting(Color.Gray, Color.Gray)

    fun checkIfPeriodAvailable(detalizationPeriod: Pair<String, String>?) =
        detalizationPeriod?.let { it.second.toLocalDate() < LocalDate.now() } ?: false

    fun getPeriodText(
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

    fun getInitDate(periodTitleSingle: String): String {
        return periodTitleSingle.plus(LocalDateTime.now().formatByRegex(DATE_PATTERN))
    }

    fun getPreviousPeriod(
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

    fun getNextPeriod(
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
}