package com.design.composechili.components.picker.chiliWheelDatePicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.core.SelectorProperties
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.text.DateFormatSymbols
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun ChiliWheelDatePicker(
    modifier: Modifier = Modifier,
    startDate: LocalDate = LocalDate.now(),
    minDate: LocalDate = LocalDate.MIN,
    maxDate: LocalDate = LocalDate.MAX,
    yearsRange: IntRange? = IntRange(1922, 2122),
    size: DpSize = DpSize(256.dp, 128.dp),
    rowCount: Int = 3,
    textStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        ChiliTheme.Colors.ChiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    localeValue:String,
    onSnappedDate : (snappedDate: ChiliSnappedDate) -> Int? = { _ -> null }
) {
    var snappedDate by remember { mutableStateOf(startDate) }

    var dayOfMonths = calculateDayOfMonths(snappedDate.month.value, snappedDate.year)

    val months = (1..12).map {
        Month(
            text = if(size.width / 3 < 55.dp){
                DateFormatSymbols(Locale(localeValue)).shortMonths[it - 1]
            } else DateFormatSymbols(Locale(localeValue)).months[it - 1],
            value = it,
            index = it - 1
        )
    }

    val years = yearsRange?.map {
        Year(
            text = it.toString(),
            value = it,
            index = yearsRange.indexOf(it)
        )
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Row {
            //Day of Month
            ChiliWheelTextPicker(
                modifier = Modifier.padding(horizontal = 8.dp),
                size = DpSize(
                    width = if(yearsRange == null) size.width / 2 else size.width / 3,
                    height = size.height
                ),
                texts = dayOfMonths.map { it.text },
                rowCount = rowCount,
                style = textStyle,
                chiliSelectorProperties = ChiliWheelPickerSelectorProperties.Default,
                startIndex = dayOfMonths.find { it.value== startDate.dayOfMonth }?.index ?: 0,
                onScrollFinished = { snappedIndex ->

                    val newDayOfMonth = dayOfMonths.find { it.index == snappedIndex }?.value

                    newDayOfMonth?.let {
                        val newDate = snappedDate.withDayOfMonth(newDayOfMonth)

                        if(!newDate.isBefore(minDate) && !newDate.isAfter(maxDate)) {
                            snappedDate = newDate
                        }

                        val newIndex =  dayOfMonths.find { it.value == snappedDate.dayOfMonth }?.index

                        newIndex?.let {
                            onSnappedDate(
                                ChiliSnappedDate.DayOfMonth(
                                    localDate = snappedDate,
                                    index = newIndex
                                )
                            )?.let { return@ChiliWheelTextPicker it }
                        }
                    }

                    return@ChiliWheelTextPicker dayOfMonths.find { it.value == snappedDate.dayOfMonth }?.index
                }
            )
            //Month
            ChiliWheelTextPicker(
                modifier = Modifier.padding(horizontal = 8.dp),
                size = DpSize(
                    width = if(yearsRange == null) size.width / 2 else size.width / 3,
                    height = size.height
                ),
                texts = months.map { it.text },
                rowCount = rowCount,
                style = textStyle,
                chiliSelectorProperties = ChiliWheelPickerSelectorProperties.Default,
                startIndex = months.find { it.value== startDate.monthValue }?.index ?: 0,
                onScrollFinished = { snappedIndex ->

                    val newMonth = months.find { it.index == snappedIndex }?.value

                    newMonth?.let {

                        val newDate = snappedDate.withMonth(newMonth)

                        if(!newDate.isBefore(minDate) && !newDate.isAfter(maxDate)) {
                            snappedDate = newDate
                        }

                        dayOfMonths = calculateDayOfMonths(snappedDate.month.value, snappedDate.year)

                        val newIndex =  months.find { it.value == snappedDate.monthValue }?.index

                        newIndex?.let {
                            onSnappedDate(
                                ChiliSnappedDate.Month(
                                    localDate = snappedDate,
                                    index = newIndex
                                )
                            )?.let { return@ChiliWheelTextPicker it }
                        }
                    }


                    return@ChiliWheelTextPicker months.find { it.value == snappedDate.monthValue }?.index
                }
            )
            //Year
            years?.let { years ->
                ChiliWheelTextPicker(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    size = DpSize(
                        width = size.width / 3,
                        height = size.height
                    ),
                    texts = years.map { it.text },
                    rowCount = rowCount,
                    style = textStyle,
                    chiliSelectorProperties = ChiliWheelPickerSelectorProperties.Default,
                    startIndex = years.find { it.value == startDate.year }?.index ?:0,
                    onScrollFinished = { snappedIndex ->

                        val newYear = years.find { it.index == snappedIndex }?.value

                        newYear?.let {

                            val newDate = snappedDate.withYear(newYear)

                            if(!newDate.isBefore(minDate) && !newDate.isAfter(maxDate)) {
                                snappedDate = newDate
                            }

                            dayOfMonths = calculateDayOfMonths(snappedDate.month.value, snappedDate.year)

                            val newIndex =  years.find { it.value == snappedDate.year }?.index

                            newIndex?.let {
                                onSnappedDate(
                                    ChiliSnappedDate.Year(
                                        localDate = snappedDate,
                                        index = newIndex
                                    )
                                )?.let { return@ChiliWheelTextPicker it }

                            }
                        }

                        return@ChiliWheelTextPicker years.find { it.value == snappedDate.year }?.index
                    }
                )
            }
        }
    }
}

internal data class DayOfMonth(
    val text: String,
    val value: Int,
    val index: Int
)

private data class Month(
    val text: String,
    val value: Int,
    val index: Int
)

private data class Year(
    val text: String,
    val value: Int,
    val index: Int
)

@RequiresApi(Build.VERSION_CODES.O)
internal fun calculateDayOfMonths(month: Int, year: Int): List<DayOfMonth> {

    val isLeapYear = LocalDate.of(year, month, 1).isLeapYear

    val month31day = (1..31).map {
        DayOfMonth(
            text = it.toString(),
            value = it,
            index = it - 1
        )
    }
    val month30day = (1..30).map {
        DayOfMonth(
            text = it.toString(),
            value = it,
            index = it - 1
        )
    }
    val month29day = (1..29).map {
        DayOfMonth(
            text = it.toString(),
            value = it,
            index = it - 1
        )
    }
    val month28day = (1..28).map {
        DayOfMonth(
            text = it.toString(),
            value = it,
            index = it - 1
        )
    }

    return when(month){
        1 -> { month31day }
        2 -> { if(isLeapYear) month29day else month28day }
        3 -> { month31day }
        4 -> { month30day }
        5 -> { month31day }
        6 -> { month30day }
        7 -> { month31day }
        8 -> { month31day }
        9 -> { month30day }
        10 -> { month31day }
        11 -> { month30day }
        12 -> { month31day }
        else -> { emptyList() }
    }
}

sealed class ChiliSnappedDateTime(val snappedLocalDateTime: LocalDateTime, val snappedIndex: Int) {
    data class DayOfMonth (val localDateTime: LocalDateTime, val index: Int): ChiliSnappedDateTime(localDateTime, index)
    data class Month (val localDateTime: LocalDateTime, val index: Int): ChiliSnappedDateTime(localDateTime, index)
    data class Year (val localDateTime: LocalDateTime, val index: Int): ChiliSnappedDateTime(localDateTime, index)
    data class Hour (val localDateTime: LocalDateTime, val index: Int): ChiliSnappedDateTime(localDateTime, index)
    data class Minute (val localDateTime: LocalDateTime, val index: Int): ChiliSnappedDateTime(localDateTime, index)
}

internal sealed class ChiliSnappedDate(val snappedLocalDate: LocalDate, val snappedIndex: Int) {
    data class DayOfMonth (val localDate: LocalDate, val index: Int): ChiliSnappedDate(localDate, index)
    data class Month (val localDate: LocalDate, val index: Int): ChiliSnappedDate(localDate, index)
    data class Year (val localDate: LocalDate, val index: Int): ChiliSnappedDate(localDate, index)
}