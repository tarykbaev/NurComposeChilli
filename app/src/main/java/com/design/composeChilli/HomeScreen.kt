package com.design.composeChilli

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composeChilli.navigation.currentComposeNavigator
import com.design.composechili.components.buttons.baseButton.NurChiliButton

@Composable
fun HomeScreen() {

    val composeNavigator = currentComposeNavigator

    val homeScreenItems = listOf(
        Pair("Text Appearances", ChiliScreens.TextAppearance),
        Pair("Buttons", ChiliScreens.Buttons),
        Pair("Input fields", ChiliScreens.InputFields),
        Pair("Cards", ChiliScreens.Cards),
        Pair("Cells ALL", ChiliScreens.Cells),
        Pair("Snackbar", ChiliScreens.Snackbar),
        Pair("Common", ChiliScreens.Common),
        Pair("Toolbars", ChiliScreens.Toolbars),
        Pair("Navigation bar", ChiliScreens.NavigationBar),
        Pair("Pickers", ChiliScreens.Pickers),
        Pair("Highlighter container", ChiliScreens.HighlighterContainer),
        Pair("Grouping container", ChiliScreens.GroupingContainer),
        Pair("Tooltip", ChiliScreens.Tooltip),
        Pair("Dialog", ChiliScreens.Dialog),
        Pair("BottomSheetPreview", ChiliScreens.BottomSheetPreview),
        Pair("PieChartPreview", ChiliScreens.PieChart)
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.cover),
                contentDescription = null
            )
        }
        items(homeScreenItems){
            NurChiliButton(
                onClick = {
                    composeNavigator.navigate(it.second)
                }, title = it.first
            )
        }
    }

}