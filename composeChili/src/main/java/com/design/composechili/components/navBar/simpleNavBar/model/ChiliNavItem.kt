package com.design.composechili.components.navBar.simpleNavBar.model

import androidx.annotation.DrawableRes

data class ChiliNavItem(
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int? = null,
    val label: String = String(),
    val route: String
)