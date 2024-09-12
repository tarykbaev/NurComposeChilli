package com.design.composechili.components.navBar.navBarWithFab.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import kotlin.random.Random

@Stable
sealed class ChiliNavWithFab(
    val id:Int = Random.nextInt(),
    @DrawableRes open val icon: Int,
    open val label: String = String(),
) {
    @Stable
    data class ChiliNavFloatActionButton(
        override val icon: Int,
        override val label: String = String(),
    ) : ChiliNavWithFab(icon = icon, label = label)

    @Stable
    data class ChiliNavButton(
        override val icon: Int,
        override val label: String = String()
    ) : ChiliNavWithFab(icon = icon, label = label)
}
