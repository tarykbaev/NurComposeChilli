package com.design.composechili.components.cell.expandableCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.components.cell.baseCell.BaseCellParams
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import com.design.composechili.values.ChiliPadding

data class ExpandableCellParams(
    val baseCellParams: BaseCellParams,
    val descriptionTextStyle: TextStyle,
    val descriptionPadding: ChiliPadding
) {

    companion object {

        val Default
            @Composable get() = ExpandableCellParams(
                baseCellParams = BaseCellParams.Default.copy(
                    titlePadding = ChiliPadding(
                        top = dimensionResource(R.dimen.padding_16dp),
                        bottom = dimensionResource(R.dimen.padding_16dp),
                        start = dimensionResource(R.dimen.padding_8dp),
                        end = dimensionResource(R.dimen.padding_8dp)
                    ),
                    chevronIconPadding = ChiliPadding(
                        top = dimensionResource(R.dimen.padding_16dp),
                        bottom = dimensionResource(R.dimen.padding_16dp),
                        end = dimensionResource(R.dimen.padding_8dp)
                    )
                ),
                descriptionTextStyle = ChiliTextStyleBuilder.H8.Secondary.Default,
                descriptionPadding = ChiliPadding(
                    top = dimensionResource(R.dimen.padding_8dp),
                    bottom = dimensionResource(R.dimen.padding_8dp),
                    start = dimensionResource(R.dimen.padding_8dp),
                    end = dimensionResource(R.dimen.padding_8dp)
                )
            )
    }
}