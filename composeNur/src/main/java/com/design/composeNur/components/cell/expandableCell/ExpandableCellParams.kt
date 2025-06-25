package com.design.composeNur.components.cell.expandableCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.baseCell.NurBaseCellParams
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class ExpandableCellParams(
    val nurBaseCellParams: NurBaseCellParams,
    val descriptionTextStyle: TextStyle,
    val descriptionPadding: NurPadding
) {

    companion object {

        val Default
            @Composable get() = ExpandableCellParams(
                nurBaseCellParams = NurBaseCellParams.Default.copy(
                    titlePadding = NurPadding(
                        top = dimensionResource(R.dimen.padding_16dp),
                        bottom = dimensionResource(R.dimen.padding_16dp),
                        start = dimensionResource(R.dimen.padding_8dp),
                        end = dimensionResource(R.dimen.padding_8dp)
                    ),
                    chevronIconPadding = NurPadding(
                        top = dimensionResource(R.dimen.padding_16dp),
                        bottom = dimensionResource(R.dimen.padding_16dp),
                        end = dimensionResource(R.dimen.padding_8dp)
                    )
                ),
                descriptionTextStyle = NurTextStyleBuilder.H8.Secondary.Default,
                descriptionPadding = NurPadding(
                    top = dimensionResource(R.dimen.padding_8dp),
                    bottom = dimensionResource(R.dimen.padding_8dp),
                    start = dimensionResource(R.dimen.padding_8dp),
                    end = dimensionResource(R.dimen.padding_8dp)
                )
            )
    }
}