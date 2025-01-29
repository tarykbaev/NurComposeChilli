package com.design.composechili.components.cell.endIconCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellIconSize
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.values.ChiliPadding

data class EndIconCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val titlePadding: ChiliPadding,
    val subtitlePadding: ChiliPadding,
    val startIconPadding: ChiliPadding,
    val endIconPadding: ChiliPadding,
    val endIconTint: Color,
    val background: Color,
    val startIconSize: CellIconSize,
    val endIconSize: CellIconSize,
    val textMaxLines: Int
) {
    companion object {
        val Default
            @Composable get() = EndIconCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                subTitleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliSecondaryTextColor,
                ),
                titlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ),
                subtitlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                startIconPadding = ChiliPadding(
                    vertical = dimensionResource(id = R.dimen.padding_8dp),
                    horizontal = dimensionResource(id = R.dimen.padding_12dp)
                ),
                endIconPadding = ChiliPadding(
                    end = dimensionResource(R.dimen.padding_8dp)
                ),
                endIconTint = ChiliTheme.Colors.СhiliChevronColor,
                background = ChiliTheme.Colors.ChiliCellBackground,
                startIconSize = CellIconSize.SMALL,
                endIconSize = CellIconSize.SMALL,
                textMaxLines = 2
            )
    }
}