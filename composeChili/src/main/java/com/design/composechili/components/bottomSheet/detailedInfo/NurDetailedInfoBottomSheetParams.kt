package com.design.composechili.components.bottomSheet.detailedInfo

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class NurDetailedInfoBottomSheetParams(
    val textStyle: TextStyle,
    val iconSize: Dp,
    @DrawableRes val icon: Int,
) {
    companion object {
        val BigIconWithSingleButton
            @Composable get() = NurDetailedInfoBottomSheetParams(
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_125dp),
                icon = R.drawable.ic_cat
            )
        val SmallIconWithTwoButtons
            @Composable get() = NurDetailedInfoBottomSheetParams(
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                iconSize = dimensionResource(id = R.dimen.view_72dp),
                icon = R.drawable.ic_cat
            )
    }
}