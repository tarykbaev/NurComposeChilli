package com.design.composechili.components.bottomSheet.base

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurModalBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    hasCloseIcon: Boolean = true,
    swipeToDismissEnabled: Boolean = true,
    dragHandle: @Composable () -> Unit = { BottomSheetDefaults.DragHandle() },
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties,
    params: NurModalBottomSheetParams = NurModalBottomSheetParams.Default,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    var internalVisibleState by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { newState ->
            if (!swipeToDismissEnabled) newState != SheetValue.Hidden else true
        }
    )
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(isVisible) {
        if (isVisible) {
            internalVisibleState = true
        } else {
            coroutineScope.launch {
                sheetState.hide()
            }.invokeOnCompletion {
                internalVisibleState = false
            }
        }
    }

    if (internalVisibleState) {
        ModalBottomSheet(
            sheetState = sheetState,
            containerColor = Color.Unspecified,
            contentColor = Color.Unspecified,
            shape = RectangleShape,
            tonalElevation = params.shadowElevation,
            dragHandle = dragHandle,
            contentWindowInsets = params.contentWindowInsets,
            properties = properties,
            onDismissRequest = onDismissRequest
        ) {
            NurModalBottomSheetContent(
                modifier = modifier,
                hasCloseIcon = hasCloseIcon,
                params = params,
                onDismissRequest = onDismissRequest,
                content = content
            )
        }
    }
}