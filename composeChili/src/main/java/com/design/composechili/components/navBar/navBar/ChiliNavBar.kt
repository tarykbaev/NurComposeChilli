package com.design.composechili.components.navBar.navBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.navBar.navBar.model.ChiliNavBarParams
import com.design.composechili.components.navBar.navBar.model.ChiliNavItem
import com.design.composechili.theme.ChiliTheme

/**
 * A customizable navigation bar component that displays a list of navigation items (`ChiliNavItem`).
 * It supports handling item clicks and adjusting parameters for layout and appearance.
 *
 * @param modifier Modifier to be applied to the navigation bar, allowing for layout customizations such as padding, alignment, and size.
 * Default is `Modifier`.
 *
 * @param navBarItems A list of `ChiliNavItem` objects that define the items to display in the navigation bar.
 * Each item typically contains an icon, a label, and state information (e.g., selected or unselected).
 *
 * @param previewInsets A Boolean flag that determines whether to account for insets (e.g., system bars) in the layout.
 * When `true`, the navigation bar adjusts for these insets (useful for previewing in design tools). Default is `true`.
 *
 * @param navBarParams nav bar visual transformation params and paddings. Default is `ChiliNavBarParams.Default`
 *
 * @param onNavItemClicked A lambda function that is invoked when a navigation item is clicked.
 * The clicked `ChiliNavItem` is passed to this lambda, enabling handling of item-specific actions such as navigation or UI updates.
 *
 * @see [ChiliNavBarParams.Default]
 * Example Usage:
 * ```
 * val navItems = listOf(
 *     ChiliNavItem(icon = R.drawable.ic_home, label = "Главная"),
 *     ChiliNavItem(icon = R.drawable.ic_payment, label = "Платежи"),
 * )
 *
 * ChiliNavBar(
 *     navBarItems = navItems,
 *     onNavItemClicked = { navItem ->
 *         // Handle navigation item click
 *     }
 * )
 * ```
 */

@Composable
fun ChiliNavBar(
    modifier: Modifier = Modifier,
    navBarItems: List<ChiliNavItem>,
    previewInsets: Boolean = true,
    navBarParams: ChiliNavBarParams = ChiliNavBarParams.Default,
    onNavItemClicked: (ChiliNavItem) -> Unit
) {
    var selectedItem by remember { mutableStateOf(navBarItems.firstOrNull()) }

    ChiliTheme {
        LazyRow(
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
            items(navBarItems,
                key = {
                    it.id
                }
            ) { item ->
                ChiliNavSimpleItem(
                    label = item.label,
                    icon = item.icon,
                    selectedColorTint = navBarParams.selectedColor,
                    unselectedColorTint = navBarParams.unselectedColor,
                    selected = selectedItem == item,
                    onNavClicked = {
                        selectedItem = item
                        onNavItemClicked(item)
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliNavBarPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.align(Alignment.BottomCenter)) {
            ChiliNavBar(
                navBarItems = listOf(
                    ChiliNavItem(
                        icon = R.drawable.ic_home,
                        label = "Главная",
                    ),
                    ChiliNavItem(
                        icon = R.drawable.ic_payment,
                        label = "Платежи",
                    ),
                    ChiliNavItem(
                        icon = R.drawable.ic_history,
                        label = "История",
                    ),
                    ChiliNavItem(
                        icon = R.drawable.ic_menu,
                        label = "Ещё",
                    ),
                ),
            ) {
            }
        }
    }
}