package com.design.composeNur.components.cell.actionCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.model.CellIconSize
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H7
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class NurActionCellParams(
    val titleStyle: TextStyle,
    val actionStyle: TextStyle,
    val startIconSize: CellIconSize,
    val chevronIconTint: Color,
    val background: Color,
    val textMaxLines: Int,
    val titlePadding: NurPadding
) {

    companion object {
        val Default
            @Composable get() = NurActionCellParams(
                titleStyle = H7.Primary.Regular,
                actionStyle = H7.Marked.Regular,
                startIconSize = CellIconSize.SMALL,
                chevronIconTint = NurTheme.Colors.СhiliChevronColor,
                background = NurTheme.Colors.NurCellBackground,
                textMaxLines = 2,
                titlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                )
            )
    }

}