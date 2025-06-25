package com.design.composeNur.components.cell.baseCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.model.CellIconSize
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class NurBaseCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val titlePadding: NurPadding,
    val subtitlePadding: NurPadding,
    val startIconPadding: NurPadding,
    val chevronIconPadding: NurPadding,
    val chevronIconTint: Color,
    val background: Color,
    val iconSize: CellIconSize,
    val textMaxLines: Int
) {
    companion object {
        val Default
            @Composable get() = NurBaseCellParams(
                titleTextStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                ),
                subTitleTextStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurSecondaryTextColor,
                ),
                titlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ),
                subtitlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                startIconPadding = NurPadding(
                    vertical = dimensionResource(id = R.dimen.padding_8dp),
                    horizontal = dimensionResource(id = R.dimen.padding_12dp)
                ),
                chevronIconPadding = NurPadding(
                    end = dimensionResource(R.dimen.padding_8dp)
                ),
                chevronIconTint = NurTheme.Colors.СhiliChevronColor,
                background = NurTheme.Colors.NurCellBackground,
                iconSize = CellIconSize.SMALL,
                textMaxLines = 2
            )
    }
}