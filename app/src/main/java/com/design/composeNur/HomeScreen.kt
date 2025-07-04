package com.design.composeNur

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composeNur.navigation.currentComposeNavigator
import com.design.composeNur.components.buttons.baseButton.NurButton

@Composable
fun HomeScreen() {

    val composeNavigator = currentComposeNavigator

    val homeScreenItems = listOf(
        Pair("Text Appearances", NurScreens.TextAppearance),
        Pair("Buttons", NurScreens.Buttons),
        Pair("Input fields", NurScreens.InputFields),
        Pair("Cards", NurScreens.Cards),
        Pair("Cells ALL", NurScreens.Cells),
        Pair("Snackbar", NurScreens.Snackbar),
        Pair("Common", NurScreens.Common),
        Pair("Toolbars", NurScreens.Toolbars),
        Pair("Navigation bar", NurScreens.NavigationBar),
        Pair("Pickers", NurScreens.Pickers),
        Pair("Highlighter container", NurScreens.HighlighterContainer),
        Pair("Grouping container", NurScreens.GroupingContainer),
        Pair("Tooltip", NurScreens.Tooltip),
        Pair("Dialog", NurScreens.Dialog),
        Pair("BottomSheetPreview", NurScreens.BottomSheetPreview)
    )

    LazyColumn(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        item {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.cover),
                contentDescription = null
            )
        }
        items(homeScreenItems) {
            NurButton(
                onClick = {
                    composeNavigator.navigate(it.second)
                }, title = it.first
            )
        }
    }

}