package com.design.composeNur.theme.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composenur.R

@Immutable
data class NurPaddingDimensions(
    val paddingDesc4Dp: Dp,
    val padding0Dp: Dp,
    val padding1Dp: Dp,
    val padding2Dp: Dp,
    val padding4Dp: Dp,
    val padding6Dp: Dp,
    val padding8Dp: Dp,
    val padding10Dp: Dp,
    val padding12Dp: Dp,
    val padding14Dp: Dp,
    val padding16Dp: Dp,
    val padding17Dp: Dp,
    val padding18Dp: Dp,
    val padding20Dp: Dp,
    val padding24Dp: Dp,
    val padding28Dp: Dp,
    val padding32Dp: Dp,
    val padding34Dp: Dp,
    val padding36Dp: Dp,
    val padding40Dp: Dp,
    val padding44Dp: Dp,
    val padding48Dp: Dp
) {
    companion object {
        @Composable
        fun fromResources() = NurPaddingDimensions(
            paddingDesc4Dp = dimensionResource(R.dimen.padding_desc_4dp),
            padding0Dp = dimensionResource(R.dimen.padding_0dp),
            padding1Dp = dimensionResource(R.dimen.padding_1dp),
            padding2Dp = dimensionResource(R.dimen.padding_2dp),
            padding4Dp = dimensionResource(R.dimen.padding_4dp),
            padding6Dp = dimensionResource(R.dimen.padding_6dp),
            padding8Dp = dimensionResource(R.dimen.padding_8dp),
            padding10Dp = dimensionResource(R.dimen.padding_10dp),
            padding12Dp = dimensionResource(R.dimen.padding_12dp),
            padding14Dp = dimensionResource(R.dimen.padding_14dp),
            padding16Dp = dimensionResource(R.dimen.padding_16dp),
            padding17Dp = dimensionResource(R.dimen.padding_17dp),
            padding18Dp = dimensionResource(R.dimen.padding_18dp),
            padding20Dp = dimensionResource(R.dimen.padding_20dp),
            padding24Dp = dimensionResource(R.dimen.padding_24dp),
            padding28Dp = dimensionResource(R.dimen.padding_28dp),
            padding32Dp = dimensionResource(R.dimen.padding_32dp),
            padding34Dp = dimensionResource(R.dimen.padding_34dp),
            padding36Dp = dimensionResource(R.dimen.padding_36dp),
            padding40Dp = dimensionResource(R.dimen.padding_40dp),
            padding44Dp = dimensionResource(R.dimen.padding_44dp),
            padding48Dp = dimensionResource(R.dimen.padding_48dp)
        )
    }
}