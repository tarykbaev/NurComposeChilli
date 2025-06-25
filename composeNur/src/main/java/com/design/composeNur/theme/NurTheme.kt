package com.design.composeNur.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * Local providers for various properties we connect to our components, for styling.
 */
private val LocalColors = compositionLocalOf<NurColors> {
    error("No colors provided! Make sure to wrap all usages of Nur components in NurTheme.")
}

private val LocalAttribute = compositionLocalOf<NurAttribute> {
    error("No attribute provided! Make sure to wrap all usages of Nur components in NurTheme.")
}

private val LocalButtonAttribute = compositionLocalOf<NurButtonAttribute> {
    error("No attribute provided! Make sure to wrap all usages of Nur components in NurTheme.")
}

@Composable
fun NurTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    colors: NurColors = if (darkTheme) {
        NurColors.defaultDarkColors()
    } else {
        NurColors.defaultLightColors()
    },
    background: NurBackground = NurBackground.Companion.defaultBackground(darkTheme),
    attribute: NurAttribute = NurAttribute.Companion.getDefault(),
    buttonAttribute: NurButtonAttribute = NurButtonAttribute.getDefault(),
    content: @Composable (SystemUiController) -> Unit
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalBackgroundTheme provides background,
        LocalAttribute provides attribute,
        LocalButtonAttribute provides buttonAttribute
    ) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(colors.NurSurfaceBackground)
        content(systemUiController)
    }
}

/**
 * Contains ease-of-use accessors for different properties used to style and customize the app
 * look and feel.
 */
object NurTheme {
    /**
     * Retrieves the current [NurColors] at the call site's position in the hierarchy.
     */
    public val Colors: NurColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    /**
     * Retrieves the current [NurBackground] at the call site's position in the hierarchy.
     */
    public val Background: NurBackground
        @Composable
        @ReadOnlyComposable
        get() = LocalBackgroundTheme.current

    /**
     * Retrieves the current [NurAttribute] at the call site's position in the hierarchy.
     */
    val Attribute: NurAttribute
        @Composable
        @ReadOnlyComposable
        get() = LocalAttribute.current

    /**
     * Retrieves the current [NurButtonAttribute] at the call site's position in the hierarchy.
     */
    val NurButtonAttribute: NurButtonAttribute
        @Composable
        @ReadOnlyComposable
        get() = LocalButtonAttribute.current
}