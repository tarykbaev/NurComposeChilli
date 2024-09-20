package com.design.composeChilli.screen

import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.components.picker.chiliTimePicker.ChiliTimePickerDialog
import com.design.composechili.components.picker.chiliWheelPicker.ChiliWheelTextPicker
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PickersScreen() {

    var showDateRangePickerDialog by remember { mutableStateOf(false) }
    var showDatePickerDialog by remember { mutableStateOf(false) }
    var showTimePickerDialog by remember { mutableStateOf(false) }
    var showTextPicker by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showDateRangePickerDialog = true },
                title = "ChiliDateRangePicker"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showDatePickerDialog = true },
                title = "ChiliDatePicker"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showTimePickerDialog = true },
                title = "ChiliTimePicker"
            )
            Spacer(modifier = Modifier.height(16.dp))
            BaseButton(
                onClick = { showTextPicker = true },
                title = "ChiliWheelTextPicker"
            )
        }
        if (showDateRangePickerDialog) {
            ChiliDatePickerDialog(
                modifier = Modifier,
                onDismissRequest = {},
                startDateTitle = "Начальная Дата",
                endDateTitle = "Конечная Дата",
                submitBtnTitle = "Готово",
                datePickedParams = ChiliDatePickerParams(
                    firstDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    ),
                    secondDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    )
                ),
                onSubmitBtn = { startDate, endDate ->
                    showDateRangePickerDialog = false
                }
            )
        }
        if (showDatePickerDialog) {
            ChiliDatePickerDialog(
                modifier = Modifier,
                onDismissRequest = {},
                startDateTitle = "Дата",
                submitBtnTitle = "Готово",
                datePickedParams = ChiliDatePickerParams(
                    firstDate = DatePickerTimeParams(
                        startDateTime = LocalDateTime.now(),
                        minDateTime = LocalDateTime.of(2020, 1, 1, 10, 0),
                        maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                    )
                ),
                onSubmitBtn = { startDate, _ ->
                    showDatePickerDialog = false
                }
            )
        }
        if (showTimePickerDialog) {
            ChiliTimePickerDialog(
                onDismissRequest = {

                },
                submitBtnTitle = "Готово",
                title = "Выберите время",
                onSubmitBtn = {
                    showTimePickerDialog = false
                }
            )
        }
        if (showTextPicker) {
            Dialog(
                onDismissRequest = { { /*TODO*/ } },
                properties = DialogProperties(usePlatformDefaultWidth = false)
            ) {
                val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
                dialogWindowProvider.window.setGravity(Gravity.BOTTOM)

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = ChiliTheme.Colors.ChiliSurfaceBackground),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 16.dp),
                            text = "TextPicker",
                            style = ChiliTextStyle.get(
                                color = ChiliTheme.Colors.ChiliPrimaryTextColor
                            )
                        )
                        ChiliWheelTextPicker(
                            modifier = Modifier.background(color = ChiliTheme.Colors.chiliScreenBackground),
                            texts = listOf("Text 1", "Text 2", "Text 3", "Text 4", "Text 5"),
                            rowCount = 1,
                            style = ChiliTextStyle.get(
                                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                                color = ChiliTheme.Colors.ChiliPrimaryTextColor
                            )
                        )
                        BaseButton(
                            modifier = Modifier.padding(bottom = 16.dp),
                            onClick = { showTextPicker = false },
                            title = "Готово"
                        )
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview
fun PickersScreenPreview() {
    ChiliTheme {
        PickersScreen()
    }
}