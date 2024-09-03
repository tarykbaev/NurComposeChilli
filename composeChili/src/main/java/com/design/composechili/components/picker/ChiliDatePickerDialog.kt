package com.design.composechili.components.picker

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
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliSnappedDateTime
import com.design.composechili.components.picker.chiliWheelDatePicker.ChiliWheelDateTimePicker
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiliDatePicker(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    startDateTitle: String = String(),
    endDateTitle: String = String(),
    textStyle: TextStyle = ChiliTextStyle.get(
        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        color = ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
    datePickedParams: ChiliDatePickerParams,
    calendarLocale: String = String(),
    submitBtnTitle: String = String(),
    onSubmitBtn: (LocalDateTime?, LocalDateTime?) -> Unit,
    alertDialogGravity: Int = Gravity.BOTTOM
) {

    var snappedStartDate by remember { mutableStateOf<ChiliSnappedDateTime?>(null) }
    var snappedEndDate by remember { mutableStateOf<ChiliSnappedDateTime?>(null) }

    val (firstDate, secondDate) = datePickedParams

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(alertDialogGravity)
        ChiliTheme {
            val currentLocale = calendarLocale.ifBlank { Locale.current.language }

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
                        text = startDateTitle,
                        style = textStyle
                    )
                    ChiliWheelDateTimePicker(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        startDateTime = firstDate.startDateTime,
                        yearsRange = firstDate.yearsRange,
                        minDateTime = firstDate.minDateTime,
                        maxDateTime = firstDate.maxDateTime,
                        localeValue = currentLocale
                    ) { chiliSnappedTime ->
                        snappedStartDate = chiliSnappedTime
                        null
                    }
                }
                if (secondDate != null) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        if (endDateTitle.isNotBlank()) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                                text = endDateTitle,
                                style = textStyle
                            )
                        }
                        ChiliWheelDateTimePicker(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                            startDateTime = secondDate.startDateTime,
                            yearsRange = secondDate.yearsRange,
                            minDateTime = secondDate.minDateTime,
                            maxDateTime = secondDate.maxDateTime,
                            localeValue = currentLocale
                        ){ snappedDateTime ->
                            snappedEndDate = snappedDateTime
                            null
                        }
                    }
                }

                BaseButton(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        onSubmitBtn.invoke(
                            snappedStartDate?.snappedLocalDateTime,
                            snappedEndDate?.snappedLocalDateTime
                        )
                    },
                    title = submitBtnTitle,
                    buttonStyle = ChiliButtonStyle.Primary
                )
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ChiliDatePickerPreview(){
    ChiliTheme{
        ChiliDatePicker(
            modifier = Modifier,
            onDismissRequest = {},
            startDateTitle = "Начальная Дата",
            endDateTitle = "Конечная Дата",
            submitBtnTitle = "Готово",
            datePickedParams = ChiliDatePickerParams(
                firstDate = DatePickerTimeParams(
                    startDateTime = LocalDateTime.now(),
                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0),
                    yearsRange = IntRange(2020, 2025)
                ),
                secondDate = DatePickerTimeParams(
                    startDateTime = LocalDateTime.now(),
                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0),
                    yearsRange = IntRange(2020,2025)
                )
            ),
            onSubmitBtn = { startDate, endDate ->

            }
        )
    }
}