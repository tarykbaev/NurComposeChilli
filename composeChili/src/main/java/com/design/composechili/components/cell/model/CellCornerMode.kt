package com.design.composechili.components.cell.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

data class CellCornerMode(
    val topStart: Dp = 0.dp,
    val topEnd: Dp = 0.dp,
    val bottomStart: Dp = 0.dp,
    val bottomEnd: Dp = 0.dp
) {

    constructor(size: Dp) : this(
        topStart = size,
        topEnd = size,
        bottomStart = size,
        bottomEnd = size
    )

    fun toRoundedShape(): RoundedCornerShape {
        return RoundedCornerShape(topStart = topStart, topEnd = topEnd, bottomStart = bottomStart, bottomEnd = bottomEnd)
    }



    companion object {
        val Top
            @Composable
            get() = CellCornerMode(
                topStart = ChiliTheme.attribute.ChiliCellCornerRadius,
                topEnd = ChiliTheme.attribute.ChiliCellCornerRadius
            )

        val Bottom
            @Composable
            get() = CellCornerMode(
                bottomStart = ChiliTheme.attribute.ChiliCellCornerRadius,
                bottomEnd = ChiliTheme.attribute.ChiliCellCornerRadius
            )

        val Middle
            @Composable
            get() = CellCornerMode(0.dp)

        val Single
            @Composable
            get() = CellCornerMode(ChiliTheme.attribute.ChiliCellCornerRadius)

    }
}