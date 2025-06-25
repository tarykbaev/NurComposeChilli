package com.design.composechili.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H6

data class NurChiliLoaderParams(
    val textStyle: TextStyle,
    val backgroundColor: Color,
    val backgroundCornerRadius: Dp,
    val progressColor: Color,
    val progressWidth: Dp,
    val dialogProperties: DialogProperties
) {

    companion object {
        val Default
            @Composable get() = NurChiliLoaderParams(
                textStyle = H6.Primary.Medium,
                backgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                backgroundCornerRadius = 16.dp,
                progressColor = ChiliTheme.Colors.ChiliLoaderColor,
                progressWidth = 4.dp,
                dialogProperties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false,
                    usePlatformDefaultWidth = false
                )
            )
    }
}