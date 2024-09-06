package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class ChiliBackground(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified,
) {
    public companion object {
        @Composable
        public fun defaultBackground(darkTheme: Boolean): ChiliBackground {
            return if (darkTheme) {
                ChiliBackground(
                    color = ChiliColors.defaultDarkColors().ChiliSurfaceBackground,
                    tonalElevation = 0.dp,
                )
            } else {
                ChiliBackground(
                    color = ChiliColors.defaultLightColors().ChiliSurfaceBackground,
                    tonalElevation = 0.dp,
                )
            }
        }
    }
}

val LocalBackgroundTheme: ProvidableCompositionLocal<ChiliBackground> =
    staticCompositionLocalOf { ChiliBackground() }