package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme.asSp

@Immutable
public data class ChiliPrimaryButtonAttribute(
    val PaddingTop: Dp,
    val PaddingBottom: Dp,
    val PaddingStart: Dp,
    val PaddingEnd: Dp,
    val CornerRadius: Dp,
    val TextSize: TextUnit,
    val TextFont: Font,
    val TextAllCaps: Boolean
) {
    companion object {
        @Composable
        fun getDefault() = ChiliPrimaryButtonAttribute(
            PaddingTop = dimensionResource(R.dimen.padding_14dp),
            PaddingBottom = dimensionResource(R.dimen.padding_14dp),
            PaddingStart = dimensionResource(R.dimen.padding_24dp),
            PaddingEnd = dimensionResource(R.dimen.padding_24dp),
            CornerRadius = dimensionResource(R.dimen.radius_12dp),
            TextSize = dimensionResource(R.dimen.text_14sp).asSp(),
            TextFont = Font(R.font.roboto_medium),
            TextAllCaps = false
        )
    }
}