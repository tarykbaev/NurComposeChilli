package com.design.composechili.components.bottom_sheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

enum class ActionBottomSheetButtonType {
    SIMPLE, ACCENT
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionBottomSheet(
    sheetState: BottomSheetScaffoldState,
    buttons: List<ActionBottomSheetButton>,
    content: @Composable () -> Unit
) {
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            bottomSheetContent = {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(buttons) { item ->
                        ActionButton(item)
                    }
                }
            }
        ) {
            content()
        }
    }
}
