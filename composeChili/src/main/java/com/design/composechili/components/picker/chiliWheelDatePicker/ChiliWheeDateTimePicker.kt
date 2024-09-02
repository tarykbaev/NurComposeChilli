package com.design.composechili.components.picker.chiliWheelDatePicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.core.SelectorProperties
import com.commandiron.wheel_picker_compose.core.TimeFormat
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun ChiliWheelDateTimePicker(
    modifier: Modifier = Modifier,
    startDateTime: LocalDateTime = LocalDateTime.now(),
    minDateTime: LocalDateTime = LocalDateTime.MIN,
    maxDateTime: LocalDateTime = LocalDateTime.MAX,
    yearsRange: IntRange? = IntRange(1922, 2122),
    size: DpSize = DpSize(250.dp, 150.dp),
    rowCount: Int = 3,
    textStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        ChiliTheme.Colors.ChiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    localeValue:String = "ru",
    onSnappedDateTime : (snappedDateTime: ChiliSnappedDateTime) -> Int? = { _ -> null }
) {

    var snappedDateTime by remember { mutableStateOf(startDateTime.truncatedTo(ChronoUnit.MINUTES)) }

    val yearTexts = yearsRange?.map { it.toString() } ?: listOf()

    Box(modifier = modifier, contentAlignment = Alignment.Center){
        Row {
            //Date
            ChiliWheelDatePicker(
                startDate = startDateTime.toLocalDate(),
                yearsRange = yearsRange,
                size = DpSize(
                    width = if(yearsRange == null ) size.width * 3 / 6 else size.width * 3 / 5 ,
                    height = size.height
                ),
                rowCount = rowCount,
                textStyle = textStyle,
                localeValue = localeValue,
                onSnappedDate = { snappedDate ->

                    val newDateTime = when(snappedDate) {
                        is ChiliSnappedDate.DayOfMonth -> {
                            snappedDateTime.withDayOfMonth(snappedDate.snappedLocalDate.dayOfMonth)
                        }
                        is ChiliSnappedDate.Month -> {
                            snappedDateTime.withMonth(snappedDate.snappedLocalDate.monthValue)
                        }
                        is ChiliSnappedDate.Year -> {
                            snappedDateTime.withYear(snappedDate.snappedLocalDate.year)
                        }
                    }

                    if(!newDateTime.isBefore(minDateTime) && !newDateTime.isAfter(maxDateTime)) {
                        snappedDateTime = newDateTime
                    }

                    return@ChiliWheelDatePicker when(snappedDate) {
                        is ChiliSnappedDate.DayOfMonth -> {
                            onSnappedDateTime(ChiliSnappedDateTime.DayOfMonth(snappedDateTime,snappedDateTime.dayOfMonth - 1))
                            snappedDateTime.dayOfMonth - 1
                        }
                        is ChiliSnappedDate.Month -> {
                            onSnappedDateTime(ChiliSnappedDateTime.Month(snappedDateTime,snappedDateTime.month.value - 1))
                            snappedDateTime.month.value - 1
                        }
                        is ChiliSnappedDate.Year -> {
                            onSnappedDateTime(ChiliSnappedDateTime.Year(snappedDateTime, yearTexts.indexOf(snappedDateTime.year.toString())))
                            yearTexts.indexOf(snappedDateTime.year.toString())
                        }
                    }
                }
            )
        }
    }
}
