package com.design.composechili.components.bottomSheet.actionBottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme

/**
 * @param [modifier] Will be applied to bottomSheetContent root composable content. In this is case root is [LazyColumn]
 * @param [sheetState] Bottom sheet state, hosting state like expanded or not
 * @see [BottomSheetScaffoldState]
 * @param [buttons] List of ActionBottomSheetParams. Which will convert to composable [ActionBottomSheetButton].
 * @param [peekHeight] The default peek height used by BottomSheetScaffold.
 * @param [content] Screen content, which should be covered by the [BaseBottomSheet]. Bottom Sheet will show over this content
 * @sample [ActionBottomSheetButton]
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionBottomSheetContent(
    modifier: Modifier = Modifier,
    buttons: List<ActionBottomSheetParams>,
    containerPadding: PaddingValues = PaddingValues(16.dp)
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(containerPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(buttons) { item ->
            ActionBottomSheetButton(
                item.title,
                item.buttonStyle,
                item.onClick
            )
        }
    }
}

@Preview
@Composable
fun ActionBottomSheetPreview() {
    ChiliTheme {
        val buttons = listOf(
            ActionBottomSheetParams("First", ChiliButtonStyle.Secondary) { },
            ActionBottomSheetParams("Second", ChiliButtonStyle.Secondary) { },
            ActionBottomSheetParams("Cancel", ChiliButtonStyle.Additional) { },
        )

        ActionBottomSheetContent(buttons = buttons)
    }
}
