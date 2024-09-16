package com.design.composechili.components.navBar.navBarWithFab

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.navBar.navBar.ChiliNavSimpleItem
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavWithFab
import com.design.composechili.components.navBar.navBarWithFab.model.NavBarWithFabParams
import com.design.composechili.theme.ChiliTheme


/**
 * A navigation bar with an integrated floating action button (FAB), supporting navigation items
 * and optional FAB scale animation.
 *
 * @param navItems A list of `ChiliNavWithFab` objects that define the navigation items to be displayed in the navigation bar.
 * Each item can include an icon, label, and an optional FAB.
 *
 * @param isFabScaleAnimation A Boolean flag that determines whether the FAB should animate its scale when interacted with.
 * If `true`, the FAB will grow and shrink slightly during interactions for a smoother visual experience. Default is `true`.
 *
 * @param params  chili nav bar with floating action button - visual transformation params and paddings. Default is `NavBarWithFabParams.Default`
 *
 * @param onNavigateItemClicked A lambda function that is invoked when a navigation item or FAB is clicked.
 * The clicked `ChiliNavWithFab` item is passed to this lambda, enabling specific actions, such as navigation changes or UI updates.
 *
 * Example Usage:
 * ```
 * val navItems = listOf(
 *     ChiliNavWithFab(icon = R.drawable.ic_home, label = "Home", hasFab = true, selected = true),
 *     ChiliNavWithFab(icon = R.drawable.ic_profile, label = "Profile", hasFab = false, selected = false)
 * )
 *
 * ChiliNavBarWithFab(
 *     navItems = navItems,
 *     isFabScaleAnimation = true,
 *     onNavigateItemClicker = { navItem ->
 *         // Handle navigation or FAB item click
 *     }
 * )
 * ```
 *
 * @see [NavBarWithFabParams.Default]
 */

@Composable
fun ChiliNavBarWithFab(
    navItems: List<ChiliNavWithFab>,
    isFabScaleAnimation: Boolean = true,
    params: NavBarWithFabParams = NavBarWithFabParams.Default,
    onNavigateItemClicked: (ChiliNavWithFab) -> Unit
) {
    var selectedItem by remember {
        mutableStateOf(
            navItems.filterIsInstance<ChiliNavWithFab.ChiliNavButton>().first()
        )
    }

    LazyRow(
        modifier = Modifier
            .background(
                color = params.backgroundColor,
                shape = params.backgroundShape
            )
            .fillMaxWidth()
            .windowInsetsPadding(NavigationBarDefaults.windowInsets)
            .selectableGroup(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(navItems) { item ->
            when (item) {
                is ChiliNavWithFab.ChiliNavButton -> {
                    ChiliNavSimpleItem(
                        icon = item.icon,
                        label = item.label,
                        selected = selectedItem == item,
                        selectedColorTint = params.selectedColor,
                        unselectedColorTint = params.unselectedColor
                    ) {
                        selectedItem = item
                        onNavigateItemClicked.invoke(item)
                    }
                }

                is ChiliNavWithFab.ChiliNavFloatActionButton -> {
                    ChiliNavFabItem(
                        isAnimateScale = isFabScaleAnimation,
                        icon = item.icon
                    ) {
                        onNavigateItemClicked.invoke(item)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliNavBarWithFabPreview() {
    ChiliTheme{
        Scaffold(
            bottomBar = {
                ChiliNavBarWithFab(
                    navItems = listOf(
                        ChiliNavWithFab.ChiliNavButton(icon = R.drawable.ic_home, label = "Главная"),
                        ChiliNavWithFab.ChiliNavButton(
                            icon = R.drawable.ic_payment,
                            label = "Платежи"
                        ),
                        ChiliNavWithFab.ChiliNavFloatActionButton(
                            icon = R.drawable.ic_scaner_48
                        ),
                        ChiliNavWithFab.ChiliNavButton(
                            icon = R.drawable.ic_history,
                            label = "История"
                        ),
                        ChiliNavWithFab.ChiliNavButton(
                            icon = R.drawable.ic_menu,
                            label = "Ещё"
                        ),
                    ),
                    onNavigateItemClicked = { }
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
}