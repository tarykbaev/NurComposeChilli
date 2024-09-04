package com.design.composechili.components.cell.model

import androidx.annotation.DrawableRes

data class AdditionalTextCellViewItems(
    val text: String,
    val description: String,
    val chevronEnabled: Boolean = false,
    @DrawableRes val icon: Int? = null,
)