package com.design.composeChilli

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.design.composeChilli.navigation.ChiliComposeNavigator
import com.design.composeChilli.screen.ButtonsScreen
import com.design.composeChilli.screen.CardsScreen
import com.design.composeChilli.screen.CellsScreen
import com.design.composeChilli.screen.CommonsScreen
import com.design.composeChilli.screen.HighlighterContainersScreen
import com.design.composeChilli.screen.InputFieldsScreen
import com.design.composeChilli.screen.NavigationBarScreen
import com.design.composeChilli.screen.PickersScreen
import com.design.composeChilli.screen.SnackbarScreen
import com.design.composeChilli.screen.TextAppearanceScreen
import com.design.composeChilli.screen.ToolbarsScreen
import com.design.composeChilli.screen.TooltipScreen
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBar
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBarParams
import com.design.composechili.theme.ChiliTheme

@Composable
fun ChiliMain(
    composeNavigator: ChiliComposeNavigator<ChiliScreens>,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {

    var darkModeEnabled by rememberSaveable {
        mutableStateOf(isDarkTheme)
    }


    ChiliTheme(darkTheme = darkModeEnabled) {
        val navHostController = rememberNavController()

        LaunchedEffect(Unit) {
            composeNavigator.handleNavigationCommands(navHostController)
        }
        Scaffold(
            backgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
            topBar = {
                ChiliBaseTopAppBar(
                    title = "NurComposeChili",
                    isDividerVisible = false,
                    endIcon = R.drawable.ic_dark_mode,
                    params = ChiliBaseTopAppBarParams.Default.copy(
                        endIconColorFilter = ColorFilter.tint(
                            ChiliTheme.Colors.ChiliPrimaryTextColor
                        )
                    ),
                    onEndIconClick = {
                        darkModeEnabled = darkModeEnabled.not()
                    }
                )
            }, content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    ChiliNavHost(navHostController = navHostController)
                }
            })
    }
}


@Composable
fun ChiliNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ChiliScreens.Home,
    ) {
        composable<ChiliScreens.Home> { HomeScreen() }
        composable<ChiliScreens.TextAppearance> { TextAppearanceScreen() }
        composable<ChiliScreens.Buttons> { ButtonsScreen() }
        composable<ChiliScreens.InputFields> { InputFieldsScreen() }
        composable<ChiliScreens.Cards> { CardsScreen() }
        composable<ChiliScreens.Cells> { CellsScreen() }
        composable<ChiliScreens.Snackbar> { SnackbarScreen() }
        composable<ChiliScreens.Common> { CommonsScreen() }
        composable<ChiliScreens.BottomSheets> { throw IllegalStateException("BottomSheet screen not implemented yet") }
        composable<ChiliScreens.Toolbars> { ToolbarsScreen() }
        composable<ChiliScreens.NavigationBar> { NavigationBarScreen() }
        composable<ChiliScreens.Pickers> { PickersScreen() }
        composable<ChiliScreens.HighlighterContainer> { HighlighterContainersScreen() }
        composable<ChiliScreens.GroupingContainer> { throw IllegalStateException("GroupingContainer screen not implemented yet") }
        composable<ChiliScreens.Tooltip> { TooltipScreen() }
    }


}

