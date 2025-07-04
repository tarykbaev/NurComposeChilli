package com.design.composeNur.components.cell.endIconCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.model.CellIconSize
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class NurEndIconCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val titlePadding: NurPadding,
    val subtitlePadding: NurPadding,
    val startIconPadding: NurPadding,
    val endIconPadding: NurPadding,
    val endIconTint: Color,
    val background: Color,
    val startIconSize: CellIconSize,
    val endIconSize: CellIconSize,
    val textMaxLines: Int
) {
    companion object {
        val Default
            @Composable get() = NurEndIconCellParams(
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
                endIconPadding = NurPadding(
                    end = dimensionResource(R.dimen.padding_8dp)
                ),
                endIconTint = NurTheme.Colors.СhiliChevronColor,
                background = NurTheme.Colors.NurCellBackground,
                startIconSize = CellIconSize.SMALL,
                endIconSize = CellIconSize.SMALL,
                textMaxLines = 2
            )
    }
}