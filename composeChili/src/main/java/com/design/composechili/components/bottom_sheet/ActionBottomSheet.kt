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
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

enum class ActionBottomSheetButtonType {
    SIMPLE, ACCENT
}

data class ActionBottomSheetButton(
    val title: String?,
    val type: ActionBottomSheetButtonType,
    val hideBottomSheetOnClick: Boolean = true,
    val onClick: (() -> Unit)? = null
)

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
                        ActionButton(item, sheetState)
                    }
                }
            }
        ) {
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionButton(
    button: ActionBottomSheetButton,
    sheetState: BottomSheetScaffoldState
) {
    val scope = rememberCoroutineScope()

    ChiliTheme {
        val buttonTextColor = when (button.type) {
            ActionBottomSheetButtonType.SIMPLE -> ChiliTheme.Colors.chiliSecondaryTextColor
            ActionBottomSheetButtonType.ACCENT -> ChiliTheme.Colors.ChiliComponentButtonTextColorActive
        }

        BaseButton(
            onClick = {
                button.onClick?.invoke()
                if (button.hideBottomSheetOnClick) scope.launch {
                    sheetState.bottomSheetState.hide()
                }
            },
            title = button.title ?: String(),
            buttonStyle = ChiliButtonStyle.Secondary,
            titleStyle = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                color = buttonTextColor,
                font = ChiliTheme.Attribute.ChiliBoldTextFont
            ),
        )
    }
}