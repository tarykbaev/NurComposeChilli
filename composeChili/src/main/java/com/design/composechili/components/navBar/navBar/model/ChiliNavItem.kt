package com.design.composechili.components.navBar.navBar.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import kotlin.random.Random


@Stable
data class ChiliNavItem(
    val id:Int = Random.nextInt(),
    @DrawableRes val icon: Int,
    val label: String = String(),
)