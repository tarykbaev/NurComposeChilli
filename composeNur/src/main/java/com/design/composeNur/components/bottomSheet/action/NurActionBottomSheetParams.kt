package com.design.composeNur.components.bottomSheet.action

import androidx.compose.runtime.Stable
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle

@Stable
data class NurActionBottomSheetParams(
    val title: String,
    val buttonStyle: NurButtonStyle,
    val onClick: (() -> Unit),
)