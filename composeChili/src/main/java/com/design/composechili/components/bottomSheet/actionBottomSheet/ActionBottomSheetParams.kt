package com.design.composechili.components.bottomSheet.actionBottomSheet

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle

@Stable
data class ActionBottomSheetParams(
    val title: String,
    val buttonStyle: ChiliButtonStyle,
    val onClick: (() -> Unit),
)