package com.design.composeNur.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.design.composeNur.NurScreens

public val LocalComposeNavigator: ProvidableCompositionLocal<AppComposeNavigator<NurScreens>> =
  compositionLocalOf {
    error(
      "No AppComposeNavigator provided! " +
        "Make sure to wrap all usages of NurTheme components in NurTheme.",
    )
  }

/**
 * Retrieves the current [AppComposeNavigator] at the call site's position in the hierarchy.
 */
public val currentComposeNavigator: AppComposeNavigator<NurScreens>
  @Composable
  @ReadOnlyComposable
  get() = LocalComposeNavigator.current
