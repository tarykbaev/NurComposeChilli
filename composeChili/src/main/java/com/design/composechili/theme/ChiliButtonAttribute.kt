package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.utils.asSp

@Immutable
data class ChiliButtonAttribute(
    // Button
    val ChiliButtonPaddingTop: Dp,
    val ChiliButtonPaddingBottom: Dp,
    val ChiliButtonPaddingStart: Dp,
    val ChiliButtonPaddingEnd: Dp,

    // Primary Button
    val ChiliPrimaryButtonCornerRadius: Dp,
    val ChiliPrimaryButtonTextSize: TextUnit,
    val ChiliPrimaryButtonTextFont: Font,
    val ChiliPrimaryButtonTextAllCaps: Boolean,

    // Secondary Button
    val ChiliSecondaryButtonCornerRadius: Dp,
    val ChiliSecondaryButtonTextSize: TextUnit,
    val ChiliSecondaryButtonTextFont: Font,
    val ChiliSecondaryButtonTextAllCaps: Boolean,

    // Additional
    val ChiliAdditionalButtonCornerRadius: Dp,
    val ChiliAdditionalButtonTextSize: TextUnit,
    val ChiliAdditionalButtonTextFont: Font,
    val ChiliAdditionalButtonTextAllCaps: Boolean
) {
    companion object {
        @Composable
        fun getDefault() = ChiliButtonAttribute(
            ChiliButtonPaddingTop = dimensionResource(R.dimen.padding_14dp),
            ChiliButtonPaddingBottom = dimensionResource(R.dimen.padding_14dp),
            ChiliButtonPaddingStart = dimensionResource(R.dimen.padding_24dp),
            ChiliButtonPaddingEnd = dimensionResource(R.dimen.padding_24dp),
            ChiliPrimaryButtonCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliPrimaryButtonTextSize = dimensionResource(R.dimen.text_14sp).asSp(),
            ChiliPrimaryButtonTextFont = Font(R.font.roboto_medium),
            ChiliPrimaryButtonTextAllCaps = false,
            ChiliSecondaryButtonCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliSecondaryButtonTextSize = dimensionResource(R.dimen.text_14sp).asSp(),
            ChiliSecondaryButtonTextFont = Font(R.font.roboto_medium),
            ChiliSecondaryButtonTextAllCaps = false,
            ChiliAdditionalButtonCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliAdditionalButtonTextSize = dimensionResource(R.dimen.text_14sp).asSp(),
            ChiliAdditionalButtonTextFont = Font(R.font.roboto_medium),
            ChiliAdditionalButtonTextAllCaps = false
        )
    }
}