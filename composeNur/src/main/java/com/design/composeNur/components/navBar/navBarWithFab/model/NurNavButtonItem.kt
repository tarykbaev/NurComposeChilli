package com.design.composeNur.components.navBar.navBarWithFab.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Stable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Stable
sealed class NurNavButtonItem(
    val id: Int = Random.nextInt(),
    @DrawableRes open val icon: Int,
    open val label: String = String(),
) {
    @Stable
    @Parcelize
    data class NurNavButtonItemFloatActionButton(
        override val icon: Int,
        override val label: String = String(),
    ) : NurNavButtonItem(icon = icon, label = label), Parcelable

    @Stable
    @Parcelize
    data class NurNavButtonItemButton(
        override val icon: Int,
        override val label: String = String()
    ) : NurNavButtonItem(icon = icon, label = label), Parcelable
}
