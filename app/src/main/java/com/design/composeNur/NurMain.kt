package com.design.composeNur

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.design.composeNur.components.topAppBar.NurBaseTopAppBar
import com.design.composeNur.components.topAppBar.NurBaseTopAppBarParams
import com.design.composeNur.navigation.NurComposeNavigator
import com.design.composeNur.screen.BottomSheetPreviewScreen
import com.design.composeNur.screen.ButtonsScreen
import com.design.composeNur.screen.CardsScreen
import com.design.composeNur.screen.CellsScreen
import com.design.composeNur.screen.CommonsScreen
import com.design.composeNur.screen.DialogScreen
import com.design.composeNur.screen.GroupingContainerScreen
import com.design.composeNur.screen.HighlighterContainersScreen
import com.design.composeNur.screen.InputFieldsScreen
import com.design.composeNur.screen.NavigationBarScreen
import com.design.composeNur.screen.PickersScreen
import com.design.composeNur.screen.SnackbarScreen
import com.design.composeNur.screen.TextAppearanceScreen
import com.design.composeNur.screen.ToolbarsScreen
import com.design.composeNur.screen.TooltipScreen
import com.design.composeNur.theme.NurTheme

@Composable
fun NurMain(
    composeNavigator: NurComposeNavigator<NurScreens>,
    isDarkTheme: Boolean = isSystemInDarkTheme()
) {

    var darkModeEnabled by remember {
        mutableStateOf(isDarkTheme)
    }

    NurTheme(darkTheme = darkModeEnabled) {
        val navHostController = rememberNavController()

        val backStack = navHostController.currentBackStackEntryAsState()

        LaunchedEffect(Unit) {
            composeNavigator.handleNavigationCommands(navHostController)
        }
        Scaffold(
            containerColor = NurTheme.Colors.NurSurfaceBackground,
            topBar = {
                // TODO (remove in future), this case using reflection
                val isNotHomeScreen =
                    backStack.value?.destination?.route != NurScreens.Home::class.java.canonicalName.orEmpty()

                NurBaseTopAppBar(
                    isNavigationButtonEnabled = isNotHomeScreen,
                    navigationIcon = painterResource(id = com.design.composenur.R.drawable.nur_ic_chevron_left),
                    title = "NurComposeNur",
                    isDividerVisible = true,
                    isCenteredTitle = true,
                    endIcon = painterResource(id = R.drawable.ic_dark_mode),
                    params = NurBaseTopAppBarParams.Default.copy(
                        endIconColorFilter = ColorFilter.tint(
                            NurTheme.Colors.NurPrimaryTextColor
                        )
                    ),
                    onEndIconClick = {
                        darkModeEnabled = darkModeEnabled.not()
                    },
                    onNavigationClick = {
                        composeNavigator.navigateUp()
                    }
                )
            }, content = { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    NurNavHost(navHostController = navHostController)
                }
            })
    }
}


@Composable
fun NurNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = NurScreens.Home,
    ) {
        composable<NurScreens.Home> { HomeScreen() }
        composable<NurScreens.TextAppearance> { TextAppearanceScreen() }
        composable<NurScreens.Buttons> { ButtonsScreen() }
        composable<NurScreens.InputFields> { InputFieldsScreen() }
        composable<NurScreens.Cards> { CardsScreen() }
        composable<NurScreens.Cells> { CellsScreen() }
        composable<NurScreens.Snackbar> { SnackbarScreen() }
        composable<NurScreens.Common> { CommonsScreen() }
        composable<NurScreens.Toolbars> { ToolbarsScreen() }
        composable<NurScreens.NavigationBar> { NavigationBarScreen() }
        composable<NurScreens.Pickers> { PickersScreen() }
        composable<NurScreens.HighlighterContainer> { HighlighterContainersScreen() }
        composable<NurScreens.GroupingContainer> { GroupingContainerScreen() }
        composable<NurScreens.Tooltip> { TooltipScreen() }
        composable<NurScreens.Dialog> { DialogScreen() }
        composable<NurScreens.BottomSheetPreview> { BottomSheetPreviewScreen() }
    }
}