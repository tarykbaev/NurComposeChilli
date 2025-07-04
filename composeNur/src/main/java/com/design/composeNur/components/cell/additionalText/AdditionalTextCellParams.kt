package com.design.composeNur.components.cell.additionalText

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.baseCell.NurBaseCellParams
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.values.NurPadding
import com.design.composenur.R


data class AdditionalTextCellParams(
    val nurBaseCellParams: NurBaseCellParams,
    val additionalTitlePadding: NurPadding,
    val additionalSubTitlePadding: NurPadding,
    val additionalTitleStyle: TextStyle,
    val additionalSubTitleStyle: TextStyle,
) {

    companion object {

        val Default
            @Composable get() = AdditionalTextCellParams(
                nurBaseCellParams = NurBaseCellParams.Default,
                additionalTitlePadding = NurPadding(
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                additionalSubTitlePadding = NurPadding(
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                additionalTitleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                ),
                additionalSubTitleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurSecondaryTextColor,
                )
            )
    }
}