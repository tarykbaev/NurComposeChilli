package com.design.composechili.components.bottomSheet.info

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.base.NurModalBottomSheet
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.theme.ChiliTheme

/**
 * A composable function that displays a customizable bottom sheet with a title, description and icon.
 *
 * @param [modifier] Modifier to be applied to the root composable of the sheet content.
 * @param [isVisible] Controls the visibility of the bottom sheet.
 * @param [title] The title text displayed at the top of the bottom sheet.
 * @param [description] The description text displayed below the title.
 * @param [icon] Drawable resource ID for the icon displayed next to the title.
 * @param [buttons] A list of buttons to be displayed as action buttons within the bottom sheet.
 * @param [infoBottomSheetsParams] Parameters controlling the visual styles and character limits of the description.
 * @param [onDismissRequest] Callback triggered when the bottom sheet is requested to be dismissed.
 *
 * @see [NurModalBottomSheet]
 * @see [NurChiliButton]
 * @see [InfoBottomSheetsParams]
 * @see [NurInfoBottomSheetButton]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurInfoBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    title: String,
    description: String,
    @DrawableRes icon: Int,
    buttons: List<NurInfoBottomSheetButton>,
    infoBottomSheetsParams: InfoBottomSheetsParams = InfoBottomSheetsParams.Default,
    onDismissRequest: () -> Unit
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        dragHandle = {},
        onDismissRequest = onDismissRequest
    ) {
        NurInfoBottomSheetContent(
            title = title,
            description = description,
            icon = icon,
            buttons = buttons,
            infoBottomSheetsParams = infoBottomSheetsParams
        )
    }
}

@Composable
private fun NurInfoBottomSheetContent(
    title: String,
    description: String,
    @DrawableRes icon: Int,
    buttons: List<NurInfoBottomSheetButton>,
    infoBottomSheetsParams: InfoBottomSheetsParams
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "icon"
            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = title.take(infoBottomSheetsParams.maxChars),
                    style = infoBottomSheetsParams.titleStyle
                )
                Text(
                    text = description,
                    style = infoBottomSheetsParams.descriptionStyle
                )
            }
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(buttons) {
                NurChiliButton(
                    onClick = it.onClick,
                    title = it.title,
                    buttonStyle = it.buttonStyle
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun NurInfoBottomSheetContentPreview() {
    ChiliTheme {
        NurInfoBottomSheetContent(
            title = "Заголовок окна",
            description = "LALALLA Текстовый блок, который содержит 120 символов, и этого количества должно хватить для информации ...",
            icon = R.drawable.ic_cat,
            buttons = listOf(
                NurInfoBottomSheetButton(
                    title = "First",
                    buttonStyle = ChiliButtonStyle.Primary,
                    onClick = { }
                ),
                NurInfoBottomSheetButton(
                    title = "Cancel",
                    buttonStyle = ChiliButtonStyle.Additional,
                    onClick = { }
                ),
            ),
            infoBottomSheetsParams = InfoBottomSheetsParams.Default
        )
    }
}