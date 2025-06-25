package com.design.composeNur.theme.dimensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.design.composenur.R

@Immutable
data class NurElevationDimensions(
    val elevation0Dp: Dp,
    val elevation4Dp: Dp,
    val elevation8Dp: Dp
) {
    companion object {
        @Composable
        fun fromResources() = NurElevationDimensions(
            elevation0Dp = dimensionResource(id = R.dimen.elevation_0dp),
            elevation4Dp = dimensionResource(id = R.dimen.elevation_4dp),
            elevation8Dp = dimensionResource(id = R.dimen.elevation_8dp)
        )
    }
}