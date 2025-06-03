package com.design.composechili.components.card.cardWithExpandableCategories

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import com.design.composechili.values.ChiliPadding

data class ExpandableCategoryCellParams(
    val markerInitialHeight: Dp,
    val cellPaddings: ChiliPadding,
    val canvasContainer: ChiliPadding,
    val canvasPaddings: ChiliPadding,
    val canvasWidth: Dp,
    val canvasTransformedRadius: Dp,
    val titlePaddings: ChiliPadding,
    val titleStyle: TextStyle,
    val rightTitlePaddings: ChiliPadding,
    val rightTitleStyle: TextStyle,
) {
    companion object {
        val Default
            @Composable get() = ExpandableCategoryCellParams(
                markerInitialHeight = dimensionResource(R.dimen.view_8dp),
                cellPaddings = ChiliPadding(
                    top = dimensionResource(R.dimen.padding_4dp),
                    start = dimensionResource(R.dimen.padding_18dp)
                ),
                canvasContainer = ChiliPadding(
                    top = dimensionResource(R.dimen.padding_12dp),
                    bottom = dimensionResource(R.dimen.padding_14dp)
                ),
                canvasPaddings = ChiliPadding(
                    end = dimensionResource(R.dimen.padding_18dp),
                    bottom = dimensionResource(R.dimen.padding_4dp),
                    top = dimensionResource(R.dimen.padding_4dp)
                ),
                canvasWidth = dimensionResource(R.dimen.view_8dp),
                canvasTransformedRadius = dimensionResource(R.dimen.padding_6dp),
                titlePaddings = ChiliPadding(
                    top = dimensionResource(R.dimen.padding_12dp),
                    bottom = dimensionResource(R.dimen.padding_14dp)
                ),
                titleStyle = ChiliTextStyleBuilder.H7.Default,
                rightTitlePaddings = ChiliPadding(
                    end = dimensionResource(R.dimen.padding_8dp)
            ),
                rightTitleStyle = ChiliTextStyleBuilder.H7.Default.copy(color = ChiliTheme.Colors.ChiliValueTextColor)
                )
    }
}