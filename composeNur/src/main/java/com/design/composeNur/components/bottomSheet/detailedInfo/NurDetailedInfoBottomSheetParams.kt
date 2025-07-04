package com.design.composeNur.components.bottomSheet.detailedInfo

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class NurDetailedInfoBottomSheetParams(
    val textStyle: TextStyle,
    val iconSize: Dp,
    @DrawableRes val icon: Int,
) {
    companion object {
        val BigIconWithSingleButton
            @Composable get() = NurDetailedInfoBottomSheetParams(
                textStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_125dp),
                icon = R.drawable.ic_cat
            )
        val SmallIconWithTwoButtons
            @Composable get() = NurDetailedInfoBottomSheetParams(
                textStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_72dp),
                icon = R.drawable.ic_cat
            )
    }
}