package com.design.composechili.components.navBar.navBarWithFab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavWithFabItems
import com.design.composechili.components.navBar.navBarWithFab.model.NavBarWithFabParams
import com.design.composechili.theme.ChiliTheme


/**
 *
 * Chili Navigation bar with FAB that shows [ChiliNavItem]
 * @param [items] accepts [List] of [ChiliNavWithFabItems] and displays it in a row
 * @param [isAnimated] accepts [Boolean] adds Bounce animation to [ChiliNavItem] and [ChiliNavFabItem]
 * @param [navBarWithFabParams] accepts [NavBarWithFabParams] adds visual transformation to component
 * @param] called when [ChiliNavItem] clicked, returns route as parameter
 *
 */

@Composable
fun NavBarWithFab(
    items: List<ChiliNavWithFabItems>,
    isAnimated: Boolean = false,
    navBarWithFabParams: NavBarWithFabParams = NavBarWithFabParams.Default,
    navigate: (String) -> Unit
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    ChiliTheme {
        Row(
            modifier = Modifier
                .background(
                    color = navBarWithFabParams.backgroundColor,
                    shape = navBarWithFabParams.backgroundShape
                )
                .fillMaxWidth()
                .windowInsetsPadding(NavigationBarDefaults.windowInsets)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, item ->
                if (item.isFab) {
                    ChiliNavFabItem(
                        isAnimated = isAnimated,
                        icon = item.icon,
                        navItemParams = navBarWithFabParams.navFabItemParams
                    ) { navigate(item.route) }
                } else {
                    ChiliNavItem(
                        label = item.label,
                        icon = when {
                            item.selectedIcon == null -> item.icon
                            selectedItem == index -> item.selectedIcon
                            else -> item.icon
                        },
                        iconTint = when {
                            item.selectedIcon != null -> null
                            selectedItem == index -> navBarWithFabParams.selectedColor
                            else -> navBarWithFabParams.unselectedColor
                        },
                        isAnimated = isAnimated,
                        onClick = {
                            selectedItem = index
                            navigate(item.route)
                        },
                        navItemParams = navBarWithFabParams.navItemParams.copy(
                            labelTextStyle = navBarWithFabParams.navItemParams.labelTextStyle.copy(
                                color = if (selectedItem == index) navBarWithFabParams.selectedColor
                                else navBarWithFabParams.unselectedColor
                            )
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavBar_Preview() {
    Scaffold(
        bottomBar = {
            NavBarWithFab(
                items = listOf(
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_home_filled,
                        icon = R.drawable.ic_home,
                        label = "Главная",
                        route = ""
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_payment_filled,
                        icon = R.drawable.ic_payment,
                        label = "Платежи",
                        route = ""
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_scaner_48,
                        icon = R.drawable.ic_scaner_48,
                        isFab = true,
                        route = ""
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_history_filled,
                        icon = R.drawable.ic_history,
                        label = "История",
                        route = ""
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_menu_filled,
                        icon = R.drawable.ic_menu,
                        label = "Ещё",
                        route = ""
                    ),
                ),
                navigate = { }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.background(color = Color.Black)) {
            Image(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_cat),
                contentDescription = null
            )
        }
    }
}