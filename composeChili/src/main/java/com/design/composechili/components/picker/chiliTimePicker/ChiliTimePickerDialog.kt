package com.design.composechili.components.picker.chiliTimePicker

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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.picker.chiliDatePicker.ChiliSnappedTime
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

/**
 * A custom Composable function for displaying a time picker dialog.
 *
 * @param modifier A [Modifier] instance to specify layout behavior or add decorations to this composable.
 * Useful for customizing appearance or adding interaction (e.g., padding, size).
 *
 * @param onDismissRequest A lambda function to be invoked when the user dismisses the dialog. Typically used
 * to hide the dialog or perform cleanup actions. Must be provided by the caller.
 *
 * @param alertDialogGravity An optional integer value that sets the gravity (positioning) of the dialog
 * on the screen. Default is [Gravity.BOTTOM], which positions the dialog at the bottom of the screen.
 *
 * @param title A [String] value representing the title of the dialog, displayed at the top|start of the dialog.
 * The title provides context or instructions for the user.
 *
 * @param titleStyle An optional [TextStyle] parameter that defines the style for the dialog's title text.
 * The default style uses a predefined set of text attributes:
 * - Text size from [ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7].
 * - Primary text color from [ChiliTheme.Colors.ChiliPrimaryTextColor].
 * - Regular font from [ChiliTheme.Attribute.ChiliBoldTextFont].
 *
 * @param submitBtnTitle An optional [String] for the label of the submit button. Defaults to an empty string if
 * not provided. The button is typically used to confirm the selected time.
 *
 * @param onSubmitBtn A callback function that is triggered when the user presses the submit button. The selected
 * [LocalDateTime] is passed as a parameter to this lambda, allowing the caller to handle the time selection.
 *
 * @see [ChiliWheelTimePicker]
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChiliTimePickerDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    alertDialogGravity: Int = Gravity.BOTTOM,
    title: String,
    titleStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        ChiliTheme.Colors.ChiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    submitBtnTitle: String = String(),
    onSubmitBtn: (LocalDateTime) -> Unit,
) {

    val startDateTime: LocalDateTime = LocalDateTime.now().withHour(10).withMinute(10)
    val minDateTime: LocalDateTime = LocalDateTime.now().withHour(0).withMinute(0)
    val maxDateTime: LocalDateTime = LocalDateTime.now().withHour(23).withMinute(59)

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
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16dp)),
                        text = title,
                        style = titleStyle
                    )
                    ChiliWheelTimePicker(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        startTime = startDateTime.toLocalTime(),
                        rowCount = 3,
                        textStyle = titleStyle,
                        onSnappedTime = { snappedTime, _ ->
                            val newDateTime = when (snappedTime) {
                                is ChiliSnappedTime.Hour -> {
                                    snappedDateTime.withHour(snappedTime.snappedLocalTime.hour)
                                }

                                is ChiliSnappedTime.Minute -> {
                                    snappedDateTime.withMinute(snappedTime.snappedLocalTime.minute)
                                }
                            }

                            if (!newDateTime.isBefore(minDateTime) && !newDateTime.isAfter(
                                    maxDateTime
                                )
                            ) {
                                snappedDateTime = newDateTime
                            }

                            return@ChiliWheelTimePicker when (snappedTime) {
                                is ChiliSnappedTime.Hour -> {
                                    snappedDateTime.hour
                                }

                                is ChiliSnappedTime.Minute -> {
                                    snappedDateTime.minute
                                }
                            }
                        }
                    )
                    BaseButton(
                        modifier = Modifier.padding(16.dp),
                        onClick = { onSubmitBtn.invoke(snappedDateTime) },
                        title = submitBtnTitle,
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ChiliTimePickerDialogPreview() {
    ChiliTheme{
        ChiliTimePickerDialog(
            modifier = Modifier,
            onDismissRequest = {

            },
            submitBtnTitle = "TimePickerSubmitButtonTitle",
            title = "TimePickerDialogTitle") {
        }
    }
}
