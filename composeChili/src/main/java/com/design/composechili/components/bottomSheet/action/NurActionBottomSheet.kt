package com.design.composechili.components.bottomSheet.action

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.base.NurModalBottomSheet
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A reusable bottom sheet component that displays a list of action buttons.
 *
 * This composable wraps [NurModalBottomSheet] and uses [NurActionBottomSheetContent]
 * to render the provided list of [NurActionBottomSheetParams] as [NurActionBottomSheetButton]s.
 *
 * @param modifier Modifier applied to the root container.
 * @param isVisible Controls the visibility of the bottom sheet.
 * @param buttons List of [NurActionBottomSheetParams] that define each action button inside the sheet.
 * @param containerPadding Padding applied around the entire content of the bottom sheet.
 * @param onDismissRequest Callback triggered when the bottom sheet is requested to be dismissed.
 *
 * @see NurActionBottomSheetButton
 * @see NurActionBottomSheetParams
 * @see NurModalBottomSheet
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurActionBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    buttons: List<NurActionBottomSheetParams>,
    containerPadding: PaddingValues = PaddingValues(16.dp),
    onDismissRequest: () -> Unit
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        hasCloseIcon = false,
        dragHandle = {},
        onDismissRequest = onDismissRequest
    ) {
        NurActionBottomSheetContent(
            buttons = buttons,
            containerPadding = containerPadding
        )
    }
}

@Composable
private fun NurActionBottomSheetContent(
    buttons: List<NurActionBottomSheetParams>,
    containerPadding: PaddingValues = PaddingValues(16.dp)
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(containerPadding),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(buttons) { item ->
            NurActionBottomSheetButton(
                item.title,
                item.buttonStyle,
                item.onClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NurActionBottomSheetContentPreview() {
    ChiliTheme {
        NurActionBottomSheetContent(
            buttons = listOf(
                NurActionBottomSheetParams(
                    title = "Primary Button",
                    buttonStyle = ChiliButtonStyle.Primary,
                    onClick = {}
                ),
                NurActionBottomSheetParams(
                    title = "Secondary Button",
                    buttonStyle = ChiliButtonStyle.Secondary,
                    onClick = {}
                )
            )
        )
    }
}