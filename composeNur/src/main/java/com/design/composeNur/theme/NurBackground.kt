package com.design.composeNur.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Immutable
data class NurBackground(
    val color: Color = Color.Unspecified,
    val tonalElevation: Dp = Dp.Unspecified,
) {
    public companion object {
        @Composable
        public fun defaultBackground(darkTheme: Boolean): NurBackground {
            return if (darkTheme) {
                NurBackground(
                    color = NurColors.defaultDarkColors().NurSurfaceBackground,
                    tonalElevation = 0.dp,
                )
            } else {
                NurBackground(
                    color = NurColors.defaultLightColors().NurSurfaceBackground,
                    tonalElevation = 0.dp,
                )
            }
        }
    }
}

val LocalBackgroundTheme: ProvidableCompositionLocal<NurBackground> =
    staticCompositionLocalOf { NurBackground() }