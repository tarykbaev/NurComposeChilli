package com.design.composechili.components.bottomSheet.actionBottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

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
fun ActionBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    buttons: List<ActionBottomSheetParams>,
    peekHeight: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            bottomSheetContent = {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(buttons) { item ->
                        ActionBottomSheetButton(item)
                    }
                }
            },
            screenContent = { content() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ActionBottomSheetPreview() {
    ChiliTheme {
        val scope = rememberCoroutineScope()
        val sheetState = getBottomSheetState()

        val buttons = listOf(
            ActionBottomSheetParams("First", ChiliTheme.Colors.chiliSecondaryTextColor),
            ActionBottomSheetParams("Second", ChiliTheme.Colors.chiliSecondaryTextColor),
            ActionBottomSheetParams(
                "Cancel",
                ChiliTheme.Colors.ChiliComponentButtonTextColorActive,
                onClick = {
                    scope.launch { sheetState.bottomSheetState.hide() }
                }),
        )

        ActionBottomSheet(sheetState = sheetState, buttons = buttons, peekHeight = 200.dp) {

        }
    }
}
