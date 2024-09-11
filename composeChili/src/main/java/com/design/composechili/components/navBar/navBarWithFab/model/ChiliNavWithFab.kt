package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.annotation.DrawableRes
import kotlin.random.Random

sealed class ChiliNavWithFab(
    val id:Int = Random.nextInt(),
    @DrawableRes open val icon: Int,
    open val label: String = String(),
) {
    data class ChiliNavFloatActionButton(
        override val icon: Int,
        override val label: String = String(),
    ) : ChiliNavWithFab(icon = icon, label = label)

    data class ChiliNavButton(
        override val icon: Int,
        override val label: String = String()
    ) : ChiliNavWithFab(icon = icon, label = label)
}
