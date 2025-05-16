package com.design.composechili.components.bottomSheet.baseBottomSheet.nur

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
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
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheetParams
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurChiliModalBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    swipeToDismissEnabled: Boolean = true,
    hasCloseIcon: Boolean = true,
    hasDragTab: Boolean = false,
    params: BaseBottomSheetParams = BaseBottomSheetParams.Default,
    dragHandle: @Composable () -> Unit = { BottomSheetDefaults.DragHandle() },
    properties: ModalBottomSheetProperties = ModalBottomSheetDefaults.properties(),
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    var internalVisibleState by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { swipeToDismissEnabled }
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
            containerColor = Color.Transparent,
            contentColor = Color.Unspecified,
            shape = RoundedCornerShape(params.topCornerRadius),
            dragHandle = null,
            onDismissRequest = onDismissRequest
        ) {
            NurChiliModalBottomSheetContent(
                modifier = modifier,
                hasCloseIcon = hasCloseIcon,
                params = params,
                onDismissRequest = onDismissRequest,
                content = content
            )
        }
    }
}