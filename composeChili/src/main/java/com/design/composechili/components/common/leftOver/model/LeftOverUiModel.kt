package com.design.composechili.components.common.leftOver.model

import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams

data class LeftOverUiModel(
    val packageType: AnimatedLeftOverParams,
    var limit: Long = 0,
    var remain: Long = 0,
    var expiryDate: String? = null,
    var showUnlim: Boolean = false,
    var isSuspended: Boolean = false,
    var pieChartIcons: List<String>? = null
)