package com.design.composechili.components.picker

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiliDatePicker(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    title: String = String(),
    titleTextStyle: TextStyle = ChiliTextStyle.get(
        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        color = ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
    calendarLocale: String = String(),
    submitBtnTitle:String = String(),
    onSubmitBtn: (DatePickerState) -> Unit
) {

    var datePickerState by remember { mutableStateOf(DatePickerState(CalendarLocale("ru"))) }

    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties()) {
        ChiliTheme {

            val currentLocale = calendarLocale.ifBlank { Locale.current.language }
            val chiliDatePickerState by remember {
                mutableStateOf(
                    DatePickerState(
                        CalendarLocale(
                            currentLocale
                        )
                    )
                )
            }


            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(containerColor = ChiliTheme.Colors.ChiliSurfaceBackground),
                shape = RoundedCornerShape(16.dp),
            ) {
                Text(modifier = Modifier.padding(16.dp), text = title, style = titleTextStyle)
                DatePicker(state = chiliDatePickerState, title = null, headline = null)
                BaseButton(
                    modifier = Modifier.padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
                    onClick = { onSubmitBtn.invoke(datePickerState) },
                    title = submitBtnTitle,
                    buttonStyle = ChiliButtonStyle.Primary
                )
            }

        }
    }

}