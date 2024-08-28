package com.design.composechili.components.navBar.model

data class ChiliNavWithFabItems(
    val selectedIcon: Int,
    val text: String = String(),
    val isFab: Boolean = false,
    val unselectedIcon: Int
)
