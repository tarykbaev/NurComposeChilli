package com.design.composechili.components.picker.chiliWheelDatePicker

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
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
import java.time.LocalTime
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
internal fun ChiliWheelTimePicker(
    modifier: Modifier = Modifier,
    startTime: LocalTime = LocalTime.now(),
    minTime: LocalTime = LocalTime.MIN,
    maxTime: LocalTime = LocalTime.MAX,
    size: DpSize = DpSize(128.dp, 128.dp),
    rowCount: Int = 3,
    textStyle: TextStyle,
    onSnappedTime: (snappedTime: ChiliSnappedTime, timeFormat: TimeFormat) -> Int? = { _, _ -> null },
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
    val amPmHours = (1..12).map {
        AmPmHour(
            text = it.toString(),
            value = it,
            index = it - 1
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
            ChiliWheelTextPicker(
                size = DpSize(
                    width = size.width / 2,
                    height = size.height
                ),
                texts = hours.map { it.text },
                rowCount = rowCount,
                style = textStyle,
                startIndex = hours.find { it.value == startTime.hour }?.index ?: 0,
                onScrollFinished = { snappedIndex ->

                    val newHour = hours.find { it.index == snappedIndex }?.value

                    newHour?.let {

                        val newTime = snappedTime.withHour(newHour)

                        if (!newTime.isBefore(minTime) && !newTime.isAfter(maxTime)) {
                            snappedTime = newTime
                        }

                        val newIndex = hours.find { it.value == snappedTime.hour }?.index

                        newIndex?.let {
                            onSnappedTime(
                                ChiliSnappedTime.Hour(
                                    localTime = snappedTime,
                                    index = newIndex
                                ),
                                timeFormat
                            )?.let { return@ChiliWheelTextPicker it }
                        }
                    }

                    return@ChiliWheelTextPicker hours.find { it.value == snappedTime.hour }?.index
                }
            )
            //Minute
            ChiliWheelTextPicker(
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

                            if (!newTime.isBefore(minTime) && !newTime.isAfter(maxTime)) {
                                snappedTime = newTime
                            }

                            val newIndex = minutes.find { it.value == snappedTime.minute }?.index

                            newIndex?.let {
                                onSnappedTime(
                                    ChiliSnappedTime.Minute(
                                        localTime = snappedTime,
                                        index = newIndex
                                    ),
                                    timeFormat
                                )?.let { return@ChiliWheelTextPicker it }
                            }
                        }
                    }

                    return@ChiliWheelTextPicker minutes.find { it.value == snappedTime.minute }?.index
                }
            )
        }
        Box(
            modifier = Modifier
                .size(
                    width = size.width,
                    height = size.height / 3
                )
                .align(
                    alignment = if (timeFormat == TimeFormat.HOUR_24) {
                        Alignment.Center
                    } else Alignment.CenterStart
                ),
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

@RequiresApi(Build.VERSION_CODES.O)
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

@RequiresApi(Build.VERSION_CODES.O)
private fun isBetween(localTime: LocalTime, startTime: LocalTime, endTime: LocalTime): Boolean {
    return localTime in startTime..endTime
}


private data class Minute(
    val text: String,
    val value: Int,
    val index: Int
)
