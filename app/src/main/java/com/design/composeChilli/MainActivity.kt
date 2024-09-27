package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.design.composeChilli.navigation.ChiliComposeNavigator
import com.design.composeChilli.navigation.LocalComposeNavigator
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    private val composeNavigator by lazy { ChiliComposeNavigator<ChiliScreens>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(
                LocalComposeNavigator provides composeNavigator,
            ) {
                ChiliMain(composeNavigator = composeNavigator)
            }
        }
    }
}

sealed interface ChiliScreens {
    @Serializable
    data object Home : ChiliScreens

    @Serializable
    data object TextAppearance : ChiliScreens

    @Serializable
    data object Buttons : ChiliScreens

    @Serializable
    data object InputFields : ChiliScreens

    @Serializable
    data object Cards : ChiliScreens

    @Serializable
    data object Cells : ChiliScreens

    @Serializable
    data object Snackbar : ChiliScreens

    @Serializable
    data object Common : ChiliScreens

    @Serializable
    data object BottomSheets : ChiliScreens

    @Serializable
    data object Toolbars : ChiliScreens

    @Serializable
    data object NavigationBar : ChiliScreens

    @Serializable
    data object Pickers : ChiliScreens

    @Serializable
    data object HighlighterContainer : ChiliScreens

    @Serializable
    data object GroupingContainer : ChiliScreens

    @Serializable
    data object Tooltip : ChiliScreens
}