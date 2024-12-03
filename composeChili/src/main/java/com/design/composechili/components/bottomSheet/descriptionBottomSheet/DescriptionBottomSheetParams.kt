package com.design.composechili.components.bottomSheet.descriptionBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliAttribute
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class DescriptionBottomSheetParams(
    val iconWidth: Dp,
    val iconHeight: Dp,
    val titleTextStyle: TextStyle,
    val descriptionTextStyle: TextStyle,
    val secondaryDescriptionTextStyle: TextStyle
) {

    companion object {

        val Default
            @Composable
            get() = DescriptionBottomSheetParams(
                iconWidth = dimensionResource(id = R.dimen.view_64dp),
                iconHeight = dimensionResource(id = R.dimen.view_64dp),
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliAttribute.getDefault().ChiliBoldTextFont
                ), descriptionTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ), secondaryDescriptionTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliSecondaryTextColor
                )
            )
    }

}