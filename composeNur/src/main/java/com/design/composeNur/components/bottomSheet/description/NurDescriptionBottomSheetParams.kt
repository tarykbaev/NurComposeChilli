package com.design.composeNur.components.bottomSheet.description

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H7
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H8
import com.design.composenur.R

@Stable
data class NurDescriptionBottomSheetParams(
    val iconWidth: Dp,
    val iconHeight: Dp,
    val titleTextStyle: TextStyle,
    val descriptionTextStyle: TextStyle,
    val secondaryDescriptionTextStyle: TextStyle
) {

    companion object {
        val Default
            @Composable
            get() = NurDescriptionBottomSheetParams(
                iconWidth = dimensionResource(id = R.dimen.view_64dp),
                iconHeight = dimensionResource(id = R.dimen.view_64dp),
                titleTextStyle = H7.Primary.Bold,
                descriptionTextStyle = H7.Primary.Regular,
                secondaryDescriptionTextStyle = H8.Secondary.Regular
            )
    }
}