package com.design.composeNur.components.picker.nurDatePicker

import android.view.Gravity
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import java.time.LocalDateTime

/**
 * A composable function that displays a date picker dialog, allowing the user to select a start date,
 * an end date, or only start date.
 *
 * @param modifier A [Modifier] to configure the layout or decoration of this composable. Can be used
 * to adjust size, padding, or other layout behavior. Applying to root @Composable function, in this is case root is [Card]
 *
 * @param onDismissRequest A lambda function invoked when the user dismisses the dialog. Typically used
 * to hide the dialog or perform cleanup actions.
 *
 * @param startDateTitle A [String] representing the title for the start date picker. Defaults to an empty string.
 *
 * @param endDateTitle A [String] representing the title for the end date picker. Defaults to an empty string.
 *
 * @param textStyle A [TextStyle] that defines the style of the titles in the dialog (e.g., start and end date
 * titles). The default uses the [NurTheme.Attribute.NurTextDimensions.TextSizeH7] for text size and
 * [NurTheme.Colors.NurPrimaryTextColor] for color.
 *
 * @param datePickedParams A [NurDatePickerParams] instance that holds parameters related to the date picker,
 * such as minimum and maximum selectable dates. Must be provided by the caller to configure the date selection.
 *
 * @param calendarLocale A [String] representing the locale used to format the calendar. Defaults to an empty
 * string, meaning it will use the default locale of the device.
 *
 * @param submitBtnTitle A [String] that represents the label for the submit button. Defaults to an empty string.
 *
 * @param onSubmitBtn A lambda function invoked when the user presses the submit button. The function receives
 * two parameters: the selected start date and the selected end date as [LocalDateTime] values. If no dates are
 * selected, `null` is passed.
 *
 * @param alertDialogGravity An integer that controls the gravity (positioning) of the dialog on the screen.
 * Defaults to [Gravity.BOTTOM], which places the dialog at the bottom of the screen.
 *
 * @sample [NurDatePickerParams]
 * @see [NurWheelDatePicker]
 */

@Composable
fun NurDatePickerDialog(
    modifier: Modifier,
    onDismissRequest: () -> Unit,
    startDateTitle: String = String(),
    endDateTitle: String = String(),
    textStyle: TextStyle = NurTextStyle.get(
        textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
        color = NurTheme.Colors.NurPrimaryTextColor

    ),
    datePickedParams: NurDatePickerParams,
    calendarLocale: String = String(),
    submitBtnTitle: String = String(),
    onSubmitBtn: (LocalDateTime?, LocalDateTime?) -> Unit,
    alertDialogGravity: Int = Gravity.BOTTOM
) {

    var snappedStartDate by remember { mutableStateOf<NurSnappedDateTime?>(null) }
    var snappedEndDate by remember { mutableStateOf<NurSnappedDateTime?>(null) }

    val (firstDate, secondDate) = datePickedParams

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(alertDialogGravity)
        val currentLocale = calendarLocale.ifBlank { Locale.current.language }

        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            colors = CardDefaults.cardColors(containerColor = NurTheme.Colors.NurCellBackground),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    text = startDateTitle,
                    style = textStyle
                )
                NurWheelDateTimePicker(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                    startDateTime = firstDate.startDateTime,
                    minDateTime = firstDate.minDateTime,
                    maxDateTime = firstDate.maxDateTime,
                    localeValue = currentLocale
                ) { NurSnappedTime ->
                    snappedStartDate = NurSnappedTime
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
                    NurWheelDateTimePicker(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        startDateTime = secondDate.startDateTime,
                        minDateTime = secondDate.minDateTime,
                        maxDateTime = secondDate.maxDateTime,
                        localeValue = currentLocale
                    ) { snappedDateTime ->
                        snappedEndDate = snappedDateTime
                        null
                    }
                }
            }

            NurButton(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                onClick = {
                    onSubmitBtn.invoke(
                        snappedStartDate?.snappedLocalDateTime,
                        snappedEndDate?.snappedLocalDateTime
                    )
                },
                title = submitBtnTitle,
                buttonStyle = NurButtonStyle.Primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NurDatePickerPreview() {
    NurTheme {
        NurDatePickerDialog(
            modifier = Modifier,
            onDismissRequest = {},
            startDateTitle = "Начальная Дата",
            endDateTitle = "Конечная Дата",
            submitBtnTitle = "Готово",
            datePickedParams = NurDatePickerParams(
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

            }
        )
    }
}