package com.design.composeChilli.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.design.composechili.components.common.chiliMaterialDesignSlider.ChiliMaterialDesignSlider
import com.design.composechili.components.common.switch.ChiliSwitch
import com.design.composechili.components.navBar.navBar.ChiliNavBar
import com.design.composechili.components.navBar.navBarWithFab.ChiliNavBarWithFab
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavButtonItem
import com.design.composechili.theme.ChiliTheme
import kotlin.math.roundToInt

@Composable
fun NavigationBarScreen(modifier: Modifier = Modifier) {

    var itemsAnimationScale by rememberSaveable {
        mutableFloatStateOf(1.3f)
    }

    var itemsAnimationDuration by rememberSaveable {
        mutableIntStateOf(68)
    }

    var isScaleAnimationEnabled by rememberSaveable {
        mutableStateOf(true)
    }


    Column(
        modifier
            .fillMaxSize()
            .background(ChiliTheme.Colors.ChiliSurfaceBackground)
    ) {
        val context = LocalContext.current

        val navBarItems = remember {
            mutableStateListOf(
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_home,
                    label = "Главная"
                ),
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_market,
                    label = "Маркет"
                ),
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_menu,
                    label = "Меню"
                )
            )
        }

        val navBarItemsWithFab = remember {
            mutableStateListOf<ChiliNavButtonItem>(
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_home,
                    label = "Главная"
                ),
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_payment,
                    label = "Платежи"
                ),
                ChiliNavButtonItem.ChiliNavButtonItemFloatActionButton(
                    icon = com.design.composechili.R.drawable.ic_scaner_48,
                ),
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_history,
                    label = "История"
                ),
                ChiliNavButtonItem.ChiliNavButtonItemButton(
                    icon = com.design.composechili.R.drawable.ic_menu,
                    label = "Еще"
                )
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
        ChiliNavBar(
            modifier = Modifier,
            navBarItems = navBarItems.toList(),
        ) { navItem ->
            Toast.makeText(context, navItem.label, Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.size(32.dp))
        ChiliNavBar(
            modifier = Modifier,
            navBarItems = navBarItems.toList(),
        ) { navItem ->
            Toast.makeText(context, navItem.label, Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.size(32.dp))

        ChiliSwitch(
            modifier = Modifier.wrapContentSize(),
            checkedState = isScaleAnimationEnabled
        ) { isScaleAnimationEnabled = isScaleAnimationEnabled.not() }

        Spacer(modifier = Modifier.size(32.dp))

        ChiliMaterialDesignSlider(
            initialValue = itemsAnimationScale,
            stepsSize = 40,
            range = 0f..4f,
            description = "Items scale on animation:"
        ) {
            itemsAnimationScale = it
        }
        Spacer(modifier = Modifier.size(24.dp))

        ChiliMaterialDesignSlider(
            initialValue = itemsAnimationDuration.toFloat(),
            description = "Items animation duration:",
            range = 0f..800f
        ) { duration ->
            itemsAnimationDuration = duration.roundToInt()
        }

        Spacer(modifier = Modifier.size(24.dp))
        ChiliNavBarWithFab(
            modifier = Modifier,
            scale = itemsAnimationScale,
            navItems = navBarItemsWithFab,
            isScaleAnimationEnabled = isScaleAnimationEnabled,
            scaleAnimationDuration = itemsAnimationDuration
        ) { navItem ->
            Toast.makeText(context, navItem.label, Toast.LENGTH_SHORT).show()
        }
    }


}