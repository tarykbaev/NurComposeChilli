package com.design.composechili.components.bottomSheet.action

import androidx.compose.runtime.Stable
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle

@Stable
data class NurActionBottomSheetParams(
    val title: String,
    val buttonStyle: ChiliButtonStyle,
    val onClick: (() -> Unit),
)