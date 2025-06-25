package com.design.composeNur.components.input.autoComplete

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.design.composeNur.components.input.inputFieldWithDescAndAction.NurAutoCompleteInputParams

/**
 * A composable function for displaying an input field with autocomplete functionality.
 *
 * @param T The type of items in the autocomplete dropdown. Must implement [AutoCompleteItem].
 * @param modifier The [Modifier] to be applied to the container of this composable.
 * @param autoCompleteItems A list of items to be displayed in the autocomplete dropdown menu.
 * @param onDropDownMenuDismiss A callback triggered when the dropdown menu is dismissed. Default is an empty lambda.
 * @param popupProperties [PopupProperties] used to customize the behavior of the dropdown popup.
 * Defaults to focusable = false, dismissOnBackPress = true, dismissOnClickOutside = true.
 * @param params Configuration parameters for the autocomplete input. Defaults to [NurAutoCompleteInputParams.Default].
 * @param onItemClick A callback invoked when an item from the dropdown menu is clicked.
 * The clicked item is passed as a parameter. Default is an empty lambda.
 * @param inputComponent A composable lambda for rendering the input field. This allows for complete customization of the input UI.
 *
 * Example usage:
 * ```
 * NurAutoCompleteInput(
 *     modifier = Modifier.fillMaxWidth(),
 *     autoCompleteItems = listOf(MyItem("Option 1"), MyItem("Option 2")),
 *     onDropDownMenuDismiss = { /* Handle dismiss */ },
 *     onItemClick = { item -> println("Selected: ${item.text}") },
 *     inputComponent = {
 *         TextField(value = text, onValueChange = { text = it })
 *     }
 * )
 * ```
 */

@Composable
fun <T> NurAutoCompleteInput(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp),
    autoCompleteItems: List<T>,
    onDropDownMenuDismiss: () -> Unit = {},
    popupProperties: PopupProperties = PopupProperties(
        focusable = false,
        dismissOnBackPress = true,
        dismissOnClickOutside = true
    ),
    params: NurAutoCompleteInputParams = NurAutoCompleteInputParams.Default,
    onDisplayData: (T) -> String,
    onItemClick: (T) -> Unit = { },
    inputComponent: @Composable () -> Unit
) {
    Column(modifier) {
        inputComponent()
        DropdownMenu(
            modifier = Modifier
                .clip(params.dropDownShape)
                .background(params.dropDownBackgroundColor)
                .animateContentSize(),
            properties = popupProperties,
            expanded = autoCompleteItems.isNotEmpty(),
            onDismissRequest = onDropDownMenuDismiss,
        ) {
            autoCompleteItems.forEach { item ->
                DropdownMenuItem(text = {
                    Text(
                        text = onDisplayData(item),
                        style = params.dropDownItemTextStyle,
                        maxLines = 1
                    )
                }, onClick = {
                    onItemClick(item)
                })
            }
        }
    }
}
