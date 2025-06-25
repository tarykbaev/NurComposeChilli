package com.design.composeNur.components.bottomSheet.lazy.model

import kotlin.random.Random

data class SampleRadioItem(
    val title: String,
    val subtitle: String,
    val id: Int = Random.nextInt(1000)
)