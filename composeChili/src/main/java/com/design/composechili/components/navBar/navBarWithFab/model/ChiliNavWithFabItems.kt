package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.annotation.DrawableRes

data class ChiliNavWithFabItems(
    @DrawableRes val icon: Int,
    @DrawableRes val selectedIcon: Int? = null,
    val label: String = String(),
    val route: String,
    val isFab: Boolean = false
)
