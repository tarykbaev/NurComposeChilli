package com.design.composechili.components.cell.additionalText

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.components.cell.baseCell.BaseCellParams
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding


data class AdditionalTextCellParams(
    val baseCellParams: BaseCellParams,
    val additionalTitlePadding: ChiliPadding,
    val additionalSubTitlePadding: ChiliPadding,
    val additionalTitleStyle: TextStyle,
    val additionalSubTitleStyle: TextStyle,
) {

    companion object {

        val Default
            @Composable get() = AdditionalTextCellParams(
                baseCellParams = BaseCellParams.Default,
                additionalTitlePadding = ChiliPadding(
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                additionalSubTitlePadding = ChiliPadding(
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                additionalTitleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                additionalSubTitleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliSecondaryTextColor,
                )
            )
    }
}