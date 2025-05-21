package com.design.composechili.components.bottomSheet.descriptionBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H7
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H8

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
                titleTextStyle = H7.Primary.Bold,
                descriptionTextStyle = H7.Primary.Regular,
                secondaryDescriptionTextStyle = H8.Secondary.Regular
            )
    }
}