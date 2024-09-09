package com.design.composechili.components.navBar.simpleNavBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.navBar.simpleNavBar.model.ChiliNavBarParams
import com.design.composechili.components.navBar.simpleNavBar.model.ChiliNavItem
import com.design.composechili.theme.ChiliTheme

/**
 *
 * Chili Simple Navigation bar to display NavigationItems without FAB
 * @param [items] accepts list of [ChiliNavItem] and shows that items in a row
 * @param [previewInsets] accepts [Boolean] true: Adds [windowInsetsPadding] - 0 false: [NavigationBarDefaults.windowInsets]
 * @param [navBarParams] accepts [ChiliNavBarParams] adds visual transformation to navBar
 * @param [navigate] called when [ChiliNavSimpleItem] clicked, returns route as parameter
 *
 */

@Composable
fun ChiliNavBar(
    modifier: Modifier = Modifier,
    items: List<ChiliNavItem>,
    previewInsets: Boolean = true,
    navBarParams: ChiliNavBarParams = ChiliNavBarParams.Default,
    navigate: (String) -> Unit
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    ChiliTheme {
        Row(
            modifier = modifier
                .background(
                    color = navBarParams.backgroundColor,
                    shape = navBarParams.backgroundShape
                )
                .fillMaxWidth()
                .windowInsetsPadding(
                    if (previewInsets) WindowInsets(
                        0,
                        0,
                        0,
                        0
                    ) else NavigationBarDefaults.windowInsets
                )
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->
                ChiliNavSimpleItem(
                    label = item.label,
                    icon = when {
                        item.selectedIcon == null -> item.icon
                        selectedItem == index -> item.selectedIcon
                        else -> item.icon
                    },
                    iconTint = when {
                        item.selectedIcon != null -> null
                        selectedItem == index -> navBarParams.selectedColor
                        else -> navBarParams.unselectedColor
                    },
                    navItemParams = navBarParams.navItemParams.copy(
                        labelTextStyle = navBarParams.navItemParams.labelTextStyle.copy(
                            color = if (selectedItem == index) navBarParams.selectedColor
                            else navBarParams.unselectedColor
                        )
                    ),
                    onClick = {
                        selectedItem = index
                        navigate(item.route)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Nav_Preview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            ChiliNavBar(
                items = listOf(
                    ChiliNavItem(
                        selectedIcon = R.drawable.ic_home_filled,
                        icon = R.drawable.ic_home,
                        label = "Главная",
                        route = ""
                    ),
                    ChiliNavItem(
                        selectedIcon = R.drawable.ic_payment_filled,
                        icon = R.drawable.ic_payment,
                        label = "Платежи",
                        route = ""
                    ),
                    ChiliNavItem(
                        selectedIcon = R.drawable.ic_history_filled,
                        icon = R.drawable.ic_history,
                        label = "История",
                        route = ""
                    ),
                    ChiliNavItem(
                        selectedIcon = R.drawable.ic_menu_filled,
                        icon = R.drawable.ic_menu,
                        label = "Ещё",
                        route = ""
                    ),
                ),
            ) {

            }
        }
    }
}