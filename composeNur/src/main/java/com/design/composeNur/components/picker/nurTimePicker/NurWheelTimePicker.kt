package com.design.composeNur.components.picker.nurTimePicker

import android.os.Build
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
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
import com.design.composeNur.components.picker.nurDatePicker.NurSnappedTime
import com.design.composeNur.components.picker.nurWheelPicker.NurWheelTextPicker
import java.time.LocalTime
import java.time.temporal.ChronoUnit

/**
 * A custom composable function that displays a wheel-style time picker, allowing the user to scroll
 * and select a time interactively.
 *
 * @suppress required [Build.VERSION_CODES.O] This function requires API level 26 (Oreo) or above due to its
 * use of [LocalTime].
 *
 * @param modifier A [Modifier] to specify layout behavior or decorations for this composable.
 * Can be used to customize size, padding, etc. Defaults to [Modifier] with no changes.
 *
 * @param startTime A [LocalTime] representing the initial time selected when the time picker is first displayed.
 * Defaults to the current system time via [LocalTime.now()].
 *
 * @param size A [DpSize] defining the width and height of the time picker. Defaults to a size of
 * 140.dp in width and 150.dp in height.
 *
 * @param rowCount An integer specifying the number of visible rows in the wheel picker. This controls how
 * many time options are visible to the user at once. Defaults to 3 rows.
 *
 * @param textStyle A [TextStyle] defining the appearance of the text inside the time picker, such as font size,
 * color, and font family. Must be provided by the caller for consistent styling.
 *
 * @param onSnappedTime A callback function that is triggered when the wheel picker "snaps" to a selected time.
 * The function provides two parameters:
 *  - [NurSnappedTime]: The snapped (selected) time.
 *  - [TimeFormat]: The time format (12-hour or 24-hour) currently in use.
 * The callback function returns an [Int?], allowing the caller to perform some action with the snapped time
 * and potentially return an integer result. Defaults to a no-op that returns `null`.
 */

@Composable
internal fun NurWheelTimePicker(
    modifier: Modifier = Modifier,
    startTime: LocalTime = LocalTime.now(),
    size: DpSize = DpSize(140.dp, 150.dp),
    rowCount: Int = 3,
    textStyle: TextStyle,
    onSnappedTime: (snappedTime: NurSnappedTime, timeFormat: TimeFormat) -> Int? = { _, _ -> null },
) {

    val timeFormat: TimeFormat = TimeFormat.HOUR_24

    var snappedTime by remember { mutableStateOf(startTime.truncatedTo(ChronoUnit.MINUTES)) }

    val hours = (0..23).map {
        Hour(
            text = it.toString().padStart(2, '0'),
            value = it,
            index = it
        )
    }

    val minutes = (0..59).map {
        Minute(
            text = it.toString().padStart(2, '0'),
            value = it,
            index = it
        )
    }

    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Row {
            //Hour
            NurWheelTextPicker(
                size = DpSize(
                    width = size.width / 2,
                    height = size.height
                ),
                texts = hours.map { it.text },
                rowCount = 3,
                style = textStyle,
                startIndex = hours.find { it.value == startTime.hour }?.index ?: 3,
                onScrollFinished = { snappedIndex ->
                    val newHour = hours.find { it.index == snappedIndex }?.value

                    newHour?.let {
                        val newTime = snappedTime.withHour(newHour)

                        snappedTime = newTime

                        val newIndex = hours.find { it.value == snappedTime.hour }?.index

                        newIndex?.let {
                            onSnappedTime(
                                NurSnappedTime.Hour(
                                    localTime = snappedTime,
                                    index = newIndex
                                ),
                                timeFormat
                            )?.let { return@NurWheelTextPicker it }
                        }
                    }

                    return@NurWheelTextPicker hours.find { it.value == snappedTime.hour }?.index
                }
            )
            //Minute
            NurWheelTextPicker(
                size = DpSize(
                    width = size.width / 2,
                    height = size.height
                ),
                texts = minutes.map { it.text },
                rowCount = rowCount,
                style = textStyle,
                startIndex = minutes.find { it.value == startTime.minute }?.index ?: 0,
                onScrollFinished = { snappedIndex ->

                    val newMinute = minutes.find { it.index == snappedIndex }?.value

                    val newHour = hours.find { it.value == snappedTime.hour }?.value

                    newMinute?.let {
                        newHour?.let {
                            val newTime = snappedTime.withMinute(newMinute).withHour(newHour)

                            snappedTime = newTime

                            val newIndex = minutes.find { it.value == snappedTime.minute }?.index

                            newIndex?.let {
                                onSnappedTime(
                                    NurSnappedTime.Minute(
                                        localTime = snappedTime,
                                        index = newIndex
                                    ),
                                    timeFormat
                                )?.let { return@NurWheelTextPicker it }
                            }
                        }
                    }

                    return@NurWheelTextPicker minutes.find { it.value == snappedTime.minute }?.index
                }
            )
        }
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = ":",
                style = textStyle
            )
        }
    }
}

enum class TimeFormat {
    HOUR_24, AM_PM
}

private data class Hour(
    val text: String,
    val value: Int,
    val index: Int
)

private data class AmPmHour(
    val text: String,
    val value: Int,
    val index: Int
)

internal fun localTimeToAmPmHour(localTime: LocalTime): Int {

    if (
        isBetween(
            localTime,
            LocalTime.of(0, 0),
            LocalTime.of(0, 59)
        )
    ) {
        return localTime.hour + 12
    }

    if (
        isBetween(
            localTime,
            LocalTime.of(1, 0),
            LocalTime.of(11, 59)
        )
    ) {
        return localTime.hour
    }

    if (
        isBetween(
            localTime,
            LocalTime.of(12, 0),
            LocalTime.of(12, 59)
        )
    ) {
        return localTime.hour
    }

    if (
        isBetween(
            localTime,
            LocalTime.of(13, 0),
            LocalTime.of(23, 59)
        )
    ) {
        return localTime.hour - 12
    }

    return localTime.hour
}

private fun isBetween(localTime: LocalTime, startTime: LocalTime, endTime: LocalTime): Boolean {
    return localTime in startTime..endTime
}


private data class Minute(
    val text: String,
    val value: Int,
    val index: Int
)
