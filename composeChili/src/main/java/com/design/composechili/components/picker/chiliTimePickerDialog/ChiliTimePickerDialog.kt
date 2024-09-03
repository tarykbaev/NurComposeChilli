package com.design.composechili.components.picker.chiliTimePickerDialog

import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliSnappedDateTime
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliSnappedTime
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliWheelDateTimePicker
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliWheelTimePicker
import com.design.composechili.components.picker.chiliWheelDatePicker.localTimeToAmPmHour
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChiliTimePickerDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    alertDialogGravity: Int = Gravity.BOTTOM,
    title: String,
    titleStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        ChiliTheme.Colors.ChiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    startDateTime:LocalDateTime,
    minDateTime: LocalDateTime,
    maxDateTime: LocalDateTime,
) {

    var snappedDateTime by remember { mutableStateOf(startDateTime.truncatedTo(ChronoUnit.MINUTES)) }

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(alertDialogGravity)
        ChiliTheme {

            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = ChiliTheme.Colors.ChiliSurfaceBackground),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                        text = title,
                        style = titleStyle
                    )
                    ChiliWheelTimePicker(
                        startTime = startDateTime.toLocalTime(),
                        rowCount = 2,
                        textStyle = titleStyle,
                        onSnappedTime = { snappedTime, timeFormat ->

                            val newDateTime = when(snappedTime) {
                                is ChiliSnappedTime.Hour -> {
                                    snappedDateTime.withHour(snappedTime.snappedLocalTime.hour)
                                }
                                is ChiliSnappedTime.Minute -> {
                                    snappedDateTime.withMinute(snappedTime.snappedLocalTime.minute)
                                }
                            }

                            if(!newDateTime.isBefore(minDateTime) && !newDateTime.isAfter(maxDateTime)) {
                                snappedDateTime = newDateTime
                            }

                            return@ChiliWheelTimePicker when(snappedTime) {
                                is ChiliSnappedTime.Hour -> {
                                    snappedDateTime.hour
                                }
                                is ChiliSnappedTime.Minute -> {
                                    snappedDateTime.minute
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}