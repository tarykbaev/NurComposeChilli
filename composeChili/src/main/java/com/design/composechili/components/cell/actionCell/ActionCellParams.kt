package com.design.composechili.components.cell.actionCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellIconSize
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H6
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H7
import com.design.composechili.values.ChiliPadding

data class ActionCellParams(
    val titleStyle: TextStyle,
    val actionStyle: TextStyle,
    val startIconSize: CellIconSize,
    val chevronIconTint: Color,
    val background: Color,
    val textMaxLines: Int,
    val titlePadding: ChiliPadding
) {

    companion object {
        val Default
            @Composable get() = ActionCellParams(
                titleStyle = H7.Primary.Regular,
                actionStyle = H7.Marked.Regular,
                startIconSize = CellIconSize.SMALL,
                chevronIconTint = ChiliTheme.Colors.СhiliChevronColor,
                background = ChiliTheme.Colors.ChiliCellBackground,
                textMaxLines = 2,
                titlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                )
            )
    }

}