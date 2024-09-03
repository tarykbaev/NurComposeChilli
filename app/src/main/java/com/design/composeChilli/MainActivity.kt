package com.design.composeChilli

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.picker.ChiliDatePicker
import com.design.composechili.components.picker.ChiliDatePickerParams
import com.design.composechili.components.picker.DatePickerTimeParams
import com.design.composechili.components.picker.chiliTimePickerDialog.ChiliTimePickerDialog
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime

class MainActivity : ComponentActivity() {


    @RequiresApi(Build.VERSION_CODES.O)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChiliTheme {
                var isDialogVisible: Boolean by remember {
                    mutableStateOf(true)
                }
                Column {
                    Spacer(modifier = Modifier.height(80.dp))
                    if (isDialogVisible) {
                        ChiliTimePickerDialog(
                            modifier = Modifier,
                            onDismissRequest = {
                                isDialogVisible = false
                            },
                            title = "Выберите время",
                            startDateTime = LocalDateTime.now(),
                            minDateTime = LocalDateTime.of(2020, 1, 1, 0,0),
                            maxDateTime = LocalDateTime.of(2025, 1, 1, 23,0),
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}