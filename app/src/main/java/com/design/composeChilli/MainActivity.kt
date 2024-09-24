package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import com.design.composeChilli.screen.NavigationBarScreen
import com.design.composeChilli.screen.SnackbarScreen
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBar
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBarParams
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkModeEnable by rememberSaveable {
                mutableStateOf(false)
            }

            ChiliTheme(darkTheme = isDarkModeEnable) {
                Column(modifier = Modifier.safeDrawingPadding()) {
                    ChiliBaseTopAppBar(
                        title = "NurComposeChili",
                        isDividerVisible = false,
                        endIcon = R.drawable.ic_dark_mode,
                        params = ChiliBaseTopAppBarParams.Default.copy(
                            endIconColorFilter = ColorFilter.tint(
                                ChiliTheme.Colors.ChiliPrimaryTextColor
                            )
                        ),
                        onEndIconClick = { isDarkModeEnable = !isDarkModeEnable }
                    )
                    NavigationBarScreen()
                }
                /*ComponentSelectorScreen(
                    onTextAppearanceItemClicked = {},
                    onButtonItemClicked = {},
                    onInputFieldsItemClicked = {},
                    onCardsItemClicked = {},
                    onCellsItemClicked = {},
                    onSnackBarItemClicked = {},
                    onCommonItemClicked = {},
                    onBottomSheetItemClicked = {},
                    onToolbarsItemClicked = {},
                    onNavigationBarItemClicked = {},
                    onPickersItemClicked = {},
                    onHighlighterContainerItemClicked = {},
                    onCameraOverlaysItemClicked = {},
                    onGroupingContainersItemClicked = {},
                    onTooltipsItemClicked = {},
                    onDividersItemClicked = {},
                    onDarkModeClicked = {
                        isDarkModeEnable = isDarkModeEnable.not()
                    }
                )*/
            }
        }
    }
}
