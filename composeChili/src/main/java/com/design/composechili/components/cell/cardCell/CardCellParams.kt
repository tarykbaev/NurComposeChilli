package com.design.composechili.components.cell.cardCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

data class CardCellParams(
    val titleTextStyle: TextStyle,
    val subtitleTextStyle: TextStyle,
    val valueTextStyle: TextStyle,
    val titlePadding: ChiliPadding,
    val subtitlePadding: ChiliPadding,
    val valuePadding: ChiliPadding,
    val titleMaxLines: Int,
    val subtitleMaxLines: Int,
    val valueMaxLines: Int,
    val cornerMode: CellCornerMode,
    val iconWidth: Dp,
    val iconHeight: Dp,
    val iconPadding: ChiliPadding,
    val isChevronVisible: Boolean,
    val overlayRes: Int,
    val overlayAlpha: Float,
    val overlayIconRes: Int
) {
    companion object {
        val Default
            @Composable get() = CardCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ), subtitleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliSecondaryTextColor,
                ), valueTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ), titlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ), subtitlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ), valuePadding = ChiliPadding(
                    end = dimensionResource(id = R.dimen.padding_12dp),
                ), cornerMode = CellCornerMode.Single,
                titleMaxLines = 3,
                subtitleMaxLines = 1,
                valueMaxLines = 2,
                isChevronVisible = false,
                overlayAlpha = 0.4f,
                overlayRes = R.drawable.chili_card_overlay,
                overlayIconRes = R.drawable.chili_ic_lock,
                iconWidth = dimensionResource(id = R.dimen.view_60dp),
                iconHeight = dimensionResource(id = R.dimen.view_40dp),
                iconPadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_8dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                )
            )
    }
}