package com.design.composechili.components.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H6
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H8

/**
 * A custom composable function that displays a warning dialog with customizable title, message,
 * and action buttons (positive and negative). Additionally, it allows for customization of the icon
 * displayed in the dialog and the dismissal behavior.
 *
 * This dialog is typically used to warn the user about some action or information, with options
 * to proceed (positive action) or cancel (negative action).
 *
 * @param title The title of the warning dialog. Default is an empty string.
 * @param message An optional message displayed under the title. If `null`, no message will be shown.
 * @param positiveButton An optional pair containing the label of the positive button (e.g., "OK")
 * and a lambda function that will be executed when the positive button is clicked. If `null`, no positive button will be displayed.
 * @param negativeButton An optional pair containing the label of the negative button (e.g., "Cancel")
 * and a lambda function that will be executed when the negative button is clicked. If `null`, no negative button will be displayed.
 * @param warningIcon The icon displayed in the dialog. By default, it uses a predefined icon (`ic_cat`).
 * @param onDismissRequest A lambda function that will be executed when the dialog is dismissed, either via user interaction or programmatically.
 *
 * @note This composable function is ideal for showing warning dialogs where users have the option to either
 * confirm the action (positive button) or cancel it (negative button). The custom icon and dismiss behavior
 * provide flexibility in different use cases.
 *
 * @see [Dialog] for the standard dialog implementation.
 */

@Composable
fun NurChiliWarningDialog(
    title: String = String(),
    message: String? = null,

    positiveButton: Pair<String, () -> Unit>? = null,
    negativeButton: Pair<String, () -> Unit>? = null,

    warningIcon: Painter = painterResource(R.drawable.ic_cat),
    onDismissRequest: () -> Unit,
) {

    Dialog(onDismissRequest) {
        Card(
            modifier = Modifier
                .wrapContentSize(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                Modifier
                    .wrapContentSize()
                    .defaultMinSize(minWidth = 300.dp, minHeight = 150.dp)
                    .background(ChiliTheme.Background.color)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.size(64.dp),
                    painter = warningIcon,
                    contentDescription = null
                )
                Spacer(Modifier.size(24.dp))
                Text(text = title, style = H6.Primary.Bold, textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = message.orEmpty(),
                    style = H8.Primary.Regular,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.size(24.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    if (negativeButton != null) {
                        NurChiliButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            title = negativeButton.first,
                            buttonStyle = ChiliButtonStyle.Secondary,
                            buttonPadding = PaddingValues(0.dp)
                        ) {
                            onDismissRequest()
                            negativeButton.second()
                        }
                    }

                    if (positiveButton != null) {
                        NurChiliButton(
                            modifier = Modifier.weight(1f),
                            title = positiveButton.first,
                            buttonStyle = ChiliButtonStyle.Primary,
                            buttonPadding = PaddingValues(0.dp)
                        ) {
                            onDismissRequest()
                            positiveButton.second()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NurChiliWarningDialog_Preview() {
    ChiliTheme {
        NurChiliWarningDialog(
            title = "Title",
            message = "Message",
            positiveButton = "Positive button" to {

            },
            negativeButton = "Negative button" to {

            }

        ) {

        }
    }
}

