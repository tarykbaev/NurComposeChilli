package com.design.composeChilli

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerDialog
import com.design.composechili.components.picker.chiliDatePicker.ChiliDatePickerParams
import com.design.composechili.components.picker.chiliDatePicker.DatePickerTimeParams
import com.design.composechili.components.picker.chiliTimePicker.ChiliTimePickerDialog
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChiliTheme {
                var alertDialogState by rememberSaveable { mutableStateOf(true) }
                var banner by rememberSaveable { mutableStateOf(String()) }

                Column {
                    Spacer(modifier = Modifier.size(80.dp))
                    BaseButton(onClick = {
                        alertDialogState = !alertDialogState
                    }, title = "Show dialog")
                }

                if (alertDialogState) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        ChiliDatePickerDialog(
                            modifier = Modifier,
                            onDismissRequest = {},
                            startDateTitle = "Начальная Дата",
                            endDateTitle = "Конечная Дата",
                            submitBtnTitle = "Готово",
                            datePickedParams = ChiliDatePickerParams(
                                firstDate = DatePickerTimeParams(
                                    startDateTime = LocalDateTime.now(),
                                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0)
                                ),
                                secondDate = DatePickerTimeParams(
                                    startDateTime = LocalDateTime.now(),
                                    minDateTime = LocalDateTime.of(2020, 1, 1, 10,0),
                                    maxDateTime = LocalDateTime.of(2026, 1, 1, 10, 0),
                                )
                            ),
                            onSubmitBtn = { startDate, endDate ->

                            }
                        )
                    }
                }

            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}