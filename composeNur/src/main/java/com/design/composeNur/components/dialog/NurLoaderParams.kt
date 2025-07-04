package com.design.composeNur.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H6

data class NurLoaderParams(
    val textStyle: TextStyle,
    val backgroundColor: Color,
    val backgroundCornerRadius: Dp,
    val progressColor: Color,
    val progressWidth: Dp,
    val dialogProperties: DialogProperties
) {

    companion object {
        val Default
            @Composable get() = NurLoaderParams(
                textStyle = H6.Primary.Medium,
                backgroundColor = NurTheme.Colors.NurSurfaceBackground,
                backgroundCornerRadius = 16.dp,
                progressColor = NurTheme.Colors.NurLoaderColor,
                progressWidth = 4.dp,
                dialogProperties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false,
                    usePlatformDefaultWidth = false
                )
            )
    }
}