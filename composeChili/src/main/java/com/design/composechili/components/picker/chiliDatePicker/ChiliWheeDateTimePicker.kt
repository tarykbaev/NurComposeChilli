package com.design.composechili.components.picker.chiliDatePicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit

/**
 * A composable function that displays a wheel-style date-time picker, allowing users to scroll through
 * and select a date and time within a specified range.
 *
 * @param modifier A [Modifier] to configure the layout or decoration of this composable. Can be used to adjust
 * size, padding, or other layout behavior. Defaults to [Modifier] with no modifications. Applied to root @Composable function, in this case root is [Box]
 *
 * @param startDateTime A [LocalDateTime] representing the initial date and time displayed in the picker.
 * Defaults to the current system date and time via [LocalDateTime.now()].
 *
 * @param minDateTime A [LocalDateTime] representing the minimum date and time selectable by the user.
 * Defaults to [LocalDateTime.MIN], the earliest possible date.
 *
 * @param maxDateTime A [LocalDateTime] representing the maximum date and time selectable by the user.
 * Defaults to [LocalDateTime.MAX], the latest possible date.
 *
 * @param yearsRange An optional [IntRange] specifying the range of years available for selection.
 * Defaults to the range from 1922 to 2122. If `null`, no year range restriction is applied.
 *
 * @param size A [DpSize] specifying the width and height of the date-time picker. Defaults to 250.dp in width
 * and 150.dp in height.
 *
 * @param rowCount An integer representing the number of visible rows in the picker, which controls how many
 * items (dates/times) are visible at one time. Defaults to 3 rows.
 *
 * @param textStyle A [TextStyle] defining the appearance of the text inside the picker, such as font size,
 * color, and font family. The default style uses:
 *  - Text size from [ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7].
 *  - Primary text color from [ChiliTheme.Colors.ChiliPrimaryTextColor].
 *  - Regular font from [ChiliTheme.Attribute.ChiliBoldTextFont].
 *
 * @param localeValue A [String] representing the locale for formatting the date-time picker,
 * such as "ru" for Russian. Defaults to "ru" (Russian).
 *
 * @param onSnappedDateTime A callback function that is triggered when the date-time picker snaps to a
 * selected date and time. It provides a [ChiliSnappedDateTime] object representing the snapped date-time and
 * returns an optional [Int?]. Defaults to a no-op that returns `null`.
 *
* @suppress required [Build.VERSION_CODES.O] This function requires API level 26 (Oreo) or above due to its
 * use of [LocalTime].
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun ChiliWheelDateTimePicker(
    modifier: Modifier = Modifier,
    startDateTime: LocalDateTime = LocalDateTime.now(),
    minDateTime: LocalDateTime = LocalDateTime.MIN,
    maxDateTime: LocalDateTime = LocalDateTime.MAX,
    yearsRange: IntRange? = IntRange(minDateTime.year, maxDateTime.year.minus(1)),
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
