package com.design.composeNur.screen

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
import com.design.composeNur.components.common.nurMaterialDesignSlider.NurMaterialDesignSlider
import com.design.composeNur.components.common.switch.NurSwitch
import com.design.composeNur.components.navBar.navBar.NurNavBar
import com.design.composeNur.components.navBar.navBarWithFab.NurNavBarWithFab
import com.design.composeNur.components.navBar.navBarWithFab.model.NurNavButtonItem
import com.design.composeNur.theme.NurTheme
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
            .background(NurTheme.Colors.NurSurfaceBackground)
    ) {
        val context = LocalContext.current

        val navBarItems = remember {
            mutableStateListOf(
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_home,
                    label = "Главная"
                ),
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_market,
                    label = "Маркет"
                ),
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_menu,
                    label = "Меню"
                )
            )
        }

        val navBarItemsWithFab = remember {
            mutableStateListOf<NurNavButtonItem>(
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_home,
                    label = "Главная"
                ),
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_payment,
                    label = "Платежи"
                ),
                NurNavButtonItem.NurNavButtonItemFloatActionButton(
                    icon = com.design.composenur.R.drawable.ic_scaner_48,
                ),
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_history,
                    label = "История"
                ),
                NurNavButtonItem.NurNavButtonItemButton(
                    icon = com.design.composenur.R.drawable.ic_menu,
                    label = "Еще"
                )
            )
        }
        Spacer(modifier = Modifier.size(32.dp))
        NurNavBar(
            modifier = Modifier,
            navBarItems = navBarItems.toList(),
        ) { navItem ->
            Toast.makeText(context, navItem.label, Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.size(32.dp))
        NurNavBar(
            modifier = Modifier,
            navBarItems = navBarItems.toList(),
        ) { navItem ->
            Toast.makeText(context, navItem.label, Toast.LENGTH_SHORT).show()
        }
        Spacer(modifier = Modifier.size(32.dp))

        NurSwitch(
            modifier = Modifier.wrapContentSize(),
            checkedState = isScaleAnimationEnabled
        ) { isScaleAnimationEnabled = isScaleAnimationEnabled.not() }

        Spacer(modifier = Modifier.size(32.dp))

        NurMaterialDesignSlider(
            initialValue = itemsAnimationScale,
            stepsSize = 40,
            range = 0f..4f,
            description = "Items scale on animation:"
        ) {
            itemsAnimationScale = it
        }
        Spacer(modifier = Modifier.size(24.dp))

        NurMaterialDesignSlider(
            initialValue = itemsAnimationDuration.toFloat(),
            description = "Items animation duration:",
            range = 0f..800f
        ) { duration ->
            itemsAnimationDuration = duration.roundToInt()
        }

        Spacer(modifier = Modifier.size(24.dp))
        NurNavBarWithFab(
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