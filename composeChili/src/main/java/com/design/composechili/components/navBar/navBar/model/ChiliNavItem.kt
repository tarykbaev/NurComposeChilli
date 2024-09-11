package com.design.composechili.components.navBar.navBar.model

import androidx.annotation.DrawableRes
import kotlin.random.Random

data class ChiliNavItem(
    val id:Int = Random.nextInt(),
    @DrawableRes val icon: Int,
    val label: String = String(),
)