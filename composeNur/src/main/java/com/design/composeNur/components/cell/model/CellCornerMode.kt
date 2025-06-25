package com.design.composeNur.components.cell.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme

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
        return RoundedCornerShape(
            topStart = topStart,
            topEnd = topEnd,
            bottomStart = bottomStart,
            bottomEnd = bottomEnd
        )
    }


    companion object {
        val Top
            @Composable
            get() = CellCornerMode(
                topStart = NurTheme.Attribute.NurCellCornerRadius,
                topEnd = NurTheme.Attribute.NurCellCornerRadius
            )

        val Bottom
            @Composable
            get() = CellCornerMode(
                bottomStart = NurTheme.Attribute.NurCellCornerRadius,
                bottomEnd = NurTheme.Attribute.NurCellCornerRadius
            )

        val Middle
            @Composable
            get() = CellCornerMode(0.dp)

        val Single
            @Composable
            get() = CellCornerMode(NurTheme.Attribute.NurCellCornerRadius)

    }
}