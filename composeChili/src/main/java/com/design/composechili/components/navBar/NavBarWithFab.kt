package com.design.composechili.components.navBar

import androidx.compose.animation.core.Spring
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.navBar.model.ChiliNavWithFabItems
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions


@Composable
fun NavBarWithFab(
    items: List<ChiliNavWithFabItems>,
    navigate: (String) -> Unit,
    animationSize: Float = 1.4f,
    stiffness: Float = Spring.StiffnessLow,
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    ChiliTheme {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .background(
                    color = ChiliTheme.Colors.chiliScreenBackground,
                    shape = RoundedCornerShape(
                        ChiliRadiusDimensions.fromResources().radius24Dp,
                        ChiliRadiusDimensions.fromResources().radius24Dp,
                        ChiliRadiusDimensions.fromResources().radius0Dp,
                        ChiliRadiusDimensions.fromResources().radius0Dp,
                    )
                )
                .fillMaxWidth()
                .windowInsetsPadding(NavigationBarDefaults.windowInsets)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            items.forEachIndexed { index, chiliNavItems ->
                if (chiliNavItems.isFab) {
                    ChiliNavFabItem(
                        icon = chiliNavItems.selectedIcon,
                        animationSize = animationSize,
                        stiffness = stiffness
                    ) { navigate(chiliNavItems.text) }
                } else {
                    ChiliNavItem(
                        text = chiliNavItems.text,
                        selectedIcon = chiliNavItems.selectedIcon,
                        unselectedIcon = chiliNavItems.unselectedIcon,
                        isSelected = selectedItem == index,
                        animationSize = animationSize,
                        stiffness = stiffness,
                        onClick = {
                            selectedItem = index
                            navigate(chiliNavItems.text)
                        }
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
                        unselectedIcon = R.drawable.ic_home,
                        text = "Главная"
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_payment_filled,
                        unselectedIcon = R.drawable.ic_payment,
                        text = "Платежи"
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_scaner_48,
                        unselectedIcon = R.drawable.ic_scaner_48,
                        isFab = true
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_history_filled,
                        unselectedIcon = R.drawable.ic_history,
                        text = "История"
                    ),
                    ChiliNavWithFabItems(
                        selectedIcon = R.drawable.ic_menu_filled,
                        unselectedIcon = R.drawable.ic_menu,
                        text = "Ещё"
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