package com.design.composeNur.components.cell.cardCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class CardCellParams(
    val titleTextStyle: TextStyle,
    val subtitleTextStyle: TextStyle,
    val valueTextStyle: TextStyle,
    val titlePadding: NurPadding,
    val subtitlePadding: NurPadding,
    val valuePadding: NurPadding,
    val titleMaxLines: Int,
    val subtitleMaxLines: Int,
    val valueMaxLines: Int,
    val cornerMode: CellCornerMode,
    val iconWidth: Dp,
    val iconHeight: Dp,
    val iconPadding: NurPadding,
    val isChevronVisible: Boolean,
    val overlayRes: Int,
    val overlayAlpha: Float,
    val overlayIconRes: Int
) {
    companion object {
        val Default
            @Composable get() = CardCellParams(
                titleTextStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                ), subtitleTextStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurSecondaryTextColor,
                ), valueTextStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurPrimaryTextColor
                ), titlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ), subtitlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ), valuePadding = NurPadding(
                    end = dimensionResource(id = R.dimen.padding_12dp),
                ), cornerMode = CellCornerMode.Single,
                titleMaxLines = 3,
                subtitleMaxLines = 1,
                valueMaxLines = 2,
                isChevronVisible = false,
                overlayAlpha = 0.4f,
                overlayRes = R.drawable.nur_card_overlay,
                overlayIconRes = R.drawable.nur_ic_lock,
                iconWidth = dimensionResource(id = R.dimen.view_60dp),
                iconHeight = dimensionResource(id = R.dimen.view_40dp),
                iconPadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_8dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                )
            )
    }
}