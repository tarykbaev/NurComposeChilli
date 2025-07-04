package com.design.composeNur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.design.composeNur.navigation.LocalComposeNavigator
import com.design.composeNur.navigation.NurComposeNavigator
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {

    private val composeNavigator by lazy { NurComposeNavigator<NurScreens>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(
                LocalComposeNavigator provides composeNavigator,
            ) {
                NurMain(composeNavigator = composeNavigator)
            }
        }
    }
}


sealed interface NurScreens {
    @Serializable
    data object Home : NurScreens

    @Serializable
    data object TextAppearance : NurScreens

    @Serializable
    data object Buttons : NurScreens

    @Serializable
    data object InputFields : NurScreens

    @Serializable
    data object Cards : NurScreens

    @Serializable
    data object Cells : NurScreens

    @Serializable
    data object Snackbar : NurScreens

    @Serializable
    data object Common : NurScreens

    @Serializable
    data object Toolbars : NurScreens

    @Serializable
    data object NavigationBar : NurScreens

    @Serializable
    data object Pickers : NurScreens

    @Serializable
    data object HighlighterContainer : NurScreens

    @Serializable
    data object GroupingContainer : NurScreens

    @Serializable
    data object Tooltip : NurScreens

    @Serializable
    data object Dialog : NurScreens

    @Serializable
    data object BottomSheetPreview : NurScreens

}