package com.design.composechili.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Local providers for various properties we connect to our components, for styling.
 */
private val LocalColors = compositionLocalOf<ChiliColors> {
    error("No colors provided! Make sure to wrap all usages of Chili components in ChiliTheme.")
}

private val LocalAttribute = compositionLocalOf<ChiliAttribute> {
    error("No attribute provided! Make sure to wrap all usages of Chili components in ChiliTheme.")
}

private val LocalButtonAttribute = compositionLocalOf<ChiliButtonAttribute> {
    error("No attribute provided! Make sure to wrap all usages of Chili components in ChiliTheme.")
}

@Composable
fun ChiliTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: ChiliColors = if (darkTheme) {
        ChiliColors.defaultDarkColors()
    } else {
        ChiliColors.defaultLightColors()
    },
    background: ChiliBackground = ChiliBackground.defaultBackground(darkTheme),
    attribute: ChiliAttribute = ChiliAttribute.getDefault(),
    buttonAttribute: ChiliButtonAttribute = ChiliButtonAttribute.getDefault(),
    content: @Composable (SystemUiController) -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalBackgroundTheme provides background,
        LocalAttribute provides attribute,
        LocalButtonAttribute provides buttonAttribute
    ) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(colors.ChiliSurfaceBackground)
        content(systemUiController)
    }
}

/**
 * Contains ease-of-use accessors for different properties used to style and customize the app
 * look and feel.
 */
object ChiliTheme {
    /**
     * Retrieves the current [ChiliColors] at the call site's position in the hierarchy.
     */
    public val Colors: ChiliColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    /**
     * Retrieves the current [ChiliBackground] at the call site's position in the hierarchy.
     */
    public val Background: ChiliBackground
        @Composable
        @ReadOnlyComposable
        get() = LocalBackgroundTheme.current

    /**
     * Retrieves the current [ChiliAttribute] at the call site's position in the hierarchy.
     */
    val Attribute: ChiliAttribute
        @Composable
        @ReadOnlyComposable
        get() = LocalAttribute.current

    /**
     * Retrieves the current [ChiliButtonAttribute] at the call site's position in the hierarchy.
     */
    val ChiliButtonAttribute: ChiliButtonAttribute
        @Composable
        @ReadOnlyComposable
        get() = LocalButtonAttribute.current
}