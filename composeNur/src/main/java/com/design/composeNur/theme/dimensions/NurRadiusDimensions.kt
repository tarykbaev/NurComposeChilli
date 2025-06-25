package com.design.composeNur.theme.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composenur.R

@Immutable
data class NurRadiusDimensions(
    val radius0Dp: Dp,
    val radius4Dp: Dp,
    val radius6Dp: Dp,
    val radius8Dp: Dp,
    val radius10Dp: Dp,
    val radius12Dp: Dp,
    val radius14Dp: Dp,
    val radius15Dp: Dp,
    val radius21Dp: Dp,
    val radius22Dp: Dp,
    val radius24Dp: Dp
) {
    companion object {
        @Composable
        fun fromResources() = NurRadiusDimensions(
            radius0Dp = dimensionResource(R.dimen.radius_0dp),
            radius4Dp = dimensionResource(R.dimen.radius_4dp),
            radius6Dp = dimensionResource(R.dimen.radius_6dp),
            radius8Dp = dimensionResource(R.dimen.radius_8dp),
            radius10Dp = dimensionResource(R.dimen.radius_10dp),
            radius12Dp = dimensionResource(R.dimen.radius_12dp),
            radius14Dp = dimensionResource(R.dimen.radius_14dp),
            radius15Dp = dimensionResource(R.dimen.radius_15dp),
            radius21Dp = dimensionResource(R.dimen.radius_21dp),
            radius22Dp = dimensionResource(R.dimen.radius_22dp),
            radius24Dp = dimensionResource(R.dimen.radius_24dp)
        )
    }
}