package com.design.composeChilli.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import com.design.composeChilli.ChiliScreens

public val LocalComposeNavigator: ProvidableCompositionLocal<AppComposeNavigator<ChiliScreens>> =
  compositionLocalOf {
    error(
      "No AppComposeNavigator provided! " +
        "Make sure to wrap all usages of ChiliTheme components in ChiliTheme.",
    )
  }

/**
 * Retrieves the current [AppComposeNavigator] at the call site's position in the hierarchy.
 */
public val currentComposeNavigator: AppComposeNavigator<ChiliScreens>
  @Composable
  @ReadOnlyComposable
  get() = LocalComposeNavigator.current
