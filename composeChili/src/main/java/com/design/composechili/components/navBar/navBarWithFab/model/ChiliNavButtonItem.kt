package com.design.composechili.components.navBar.navBarWithFab.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Stable
sealed class ChiliNavButtonItem(
    val id:Int = Random.nextInt(),
    @DrawableRes open val icon: Int,
    open val label: String = String(),
) {
    @Stable
    @Parcelize
    data class ChiliNavButtonItemFloatActionButton(
        override val icon: Int,
        override val label: String = String(),
    ) : ChiliNavButtonItem(icon = icon, label = label), Parcelable

    @Stable
    @Parcelize
    data class ChiliNavButtonItemButton(
        override val icon: Int,
        override val label: String = String()
    ) : ChiliNavButtonItem(icon = icon, label = label), Parcelable
}
