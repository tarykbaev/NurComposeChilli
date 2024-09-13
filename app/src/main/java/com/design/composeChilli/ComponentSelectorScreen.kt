package com.design.composeChilli

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBar
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.spacerVerticalDefaultPadding

@Composable
fun ComponentSelectorScreen(
    onDarkModeClicked: () -> Unit,
    onTextAppearanceItemClicked: () -> Unit,
    onButtonItemClicked: () -> Unit,
    onInputFieldsItemClicked: () -> Unit,
    onCardsItemClicked: () -> Unit,
    onCellsItemClicked: () -> Unit,
    onSnackBarItemClicked: () -> Unit,
    onCommonItemClicked: () -> Unit,
    onBottomSheetItemClicked: () -> Unit,
    onToolbarsItemClicked: () -> Unit,
    onNavigationBarItemClicked: () -> Unit,
    onPickersItemClicked: () -> Unit,
    onHighlighterContainerItemClicked: () -> Unit,
    onCameraOverlaysItemClicked: () -> Unit,
    onGroupingContainersItemClicked: () -> Unit,
    onTooltipsItemClicked: () -> Unit,
    onDividersItemClicked: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ChiliTheme.Colors.ChiliSurfaceBackground)
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cover),
            contentDescription = String()
        )
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(
            onClick = onTextAppearanceItemClicked,
            title = "Text Appearance"
        )
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onButtonItemClicked, title = "Buttons")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onInputFieldsItemClicked, title = "Input fields")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onCardsItemClicked, title = "Cards")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onCellsItemClicked, title = "Cells ALL")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onSnackBarItemClicked, title = "Snackbar")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onCommonItemClicked, title = "Common")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onBottomSheetItemClicked, title = "Bottom sheets")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onToolbarsItemClicked, title = "Toolbars")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onNavigationBarItemClicked, title = "Navigation bar")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onPickersItemClicked, title = "Pickers")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(
            onClick = onHighlighterContainerItemClicked,
            title = "Highlighter container"
        )
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onCameraOverlaysItemClicked, title = "Camera overlays")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onGroupingContainersItemClicked, title = "Grouping containers")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onTooltipsItemClicked, title = "Tooltips")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
        BaseButton(onClick = onDividersItemClicked, title = "Dividers")
        Spacer(modifier = Modifier.spacerVerticalDefaultPadding(topPadding = 24.dp))
    }
}