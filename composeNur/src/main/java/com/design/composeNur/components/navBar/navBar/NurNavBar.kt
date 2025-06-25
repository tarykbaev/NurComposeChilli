package com.design.composeNur.components.navBar.navBar

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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.components.navBar.navBar.model.NurNavBarParams
import com.design.composeNur.components.navBar.navBarWithFab.model.NurNavButtonItem
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A customizable navigation bar component that displays a list of navigation items (`NurNavItem`).
 * It supports handling item clicks and adjusting parameters for layout and appearance.
 *
 * @param modifier Modifier to be applied to the navigation bar, allowing for layout customizations such as padding, alignment, and size.
 * Default is `Modifier`.
 *
 * @param navBarItems A list of `NurNavItem` objects that define the items to display in the navigation bar.
 * Each item typically contains an icon, a label, and state information (e.g., selected or unselected).
 *
 * @param previewInsets A Boolean flag that determines whether to account for insets (e.g., system bars) in the layout.
 * When `true`, the navigation bar adjusts for these insets (useful for previewing in design tools). Default is `true`.
 *
 * @param navBarParams nav bar visual transformation params and paddings. Default is `NurNavBarParams.Default`
 *
 * @param onNavItemClicked A lambda function that is invoked when a navigation item is clicked.
 * The clicked `NurNavItem` is passed to this lambda, enabling handling of item-specific actions such as navigation or UI updates.
 *
 * @see [NurNavBarParams.Default]
 * Example Usage:
 * ```
 * val navItems = listOf(
 *     NurNavItem(icon = R.drawable.ic_home, label = "Главная"),
 *     NurNavItem(icon = R.drawable.ic_payment, label = "Платежи"),
 * )
 *
 * NurNavBar(
 *     navBarItems = navItems,
 *     onNavItemClicked = { navItem ->
 *         // Handle navigation item click
 *     }
 * )
 * ```
 */

@Composable
fun NurNavBar(
    modifier: Modifier = Modifier,
    navBarItems: List<NurNavButtonItem.NurNavButtonItemButton>,
    previewInsets: Boolean = true,
    navBarParams: NurNavBarParams = NurNavBarParams.Default,
    onNavItemClicked: (NurNavButtonItem.NurNavButtonItemButton) -> Unit
) {
    var selectedItem by rememberSaveable { mutableStateOf(navBarItems.firstOrNull()) }

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
        items(
            navBarItems,
            key = {
                it.id
            }
        ) { item ->
            NurNavSimpleItem(
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

@Preview(showBackground = true)
@Composable
fun NurNavBarPreview() {
    NurTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.align(Alignment.BottomCenter)) {
                NurNavBar(
                    navBarItems = listOf(
                        NurNavButtonItem.NurNavButtonItemButton(
                            icon = R.drawable.ic_home,
                            label = "Главная",
                        ),
                        NurNavButtonItem.NurNavButtonItemButton(
                            icon = R.drawable.ic_payment,
                            label = "Платежи",
                        ),
                        NurNavButtonItem.NurNavButtonItemButton(
                            icon = R.drawable.ic_history,
                            label = "История",
                        ),
                        NurNavButtonItem.NurNavButtonItemButton(
                            icon = R.drawable.ic_menu,
                            label = "Ещё",
                        ),
                    ),
                ) {
                }
            }
        }
    }
}