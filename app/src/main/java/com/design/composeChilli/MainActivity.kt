package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var isDarkModeEnable by rememberSaveable {
                mutableStateOf(false)
            }

            ChiliTheme(darkTheme = isDarkModeEnable) {
                ComponentSelectorScreen(
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
                )
            }
        }
    }
}
