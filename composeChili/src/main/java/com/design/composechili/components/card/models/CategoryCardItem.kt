package com.design.composechili.components.card.models

import androidx.annotation.DrawableRes

data class CategoryCardItem(
    val title: String,
    val subtitle: String,
    val description: String,
    val discount: String,
    @DrawableRes val image: Int,
)