package com.design.composechili.components.navBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.navBar.model.ChiliNavItems
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Composable
fun ChiliNavBar(
    modifier: Modifier = Modifier,
    items: List<ChiliNavItems>,
    previewInsets: Boolean = false, // add UI bar insets if needed
    navigate: (String) -> Unit
) {
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }

    ChiliTheme {
        Row(
            modifier = modifier
                .padding(8.dp)
                .background(
                    color = ChiliTheme.Colors.chiliScreenBackground,
                    shape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius24Dp)
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
            items.forEachIndexed { index, chiliNavItems ->
                ChiliNavSimpleItem(
                    text = chiliNavItems.text,
                    selectedIcon = chiliNavItems.selectedIcon,
                    unselectedIcon = chiliNavItems.unselectedIcon,
                    isSelected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navigate(chiliNavItems.text)
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
                    ChiliNavItems(
                        selectedIcon = R.drawable.ic_home_filled,
                        unselectedIcon = R.drawable.ic_home,
                        text = "Главная"
                    ),
                    ChiliNavItems(
                        selectedIcon = R.drawable.ic_payment_filled,
                        unselectedIcon = R.drawable.ic_payment,
                        text = "Платежи"
                    ),
                    ChiliNavItems(
                        selectedIcon = R.drawable.ic_history_filled,
                        unselectedIcon = R.drawable.ic_history,
                        text = "История"
                    ),
                    ChiliNavItems(
                        selectedIcon = R.drawable.ic_menu_filled,
                        unselectedIcon = R.drawable.ic_menu,
                        text = "Ещё"
                    ),
                ),
            ) {

            }
        }
    }
}