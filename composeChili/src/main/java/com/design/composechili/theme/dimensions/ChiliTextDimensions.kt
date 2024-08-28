package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.TextUnit
import com.design.composechili.R
import com.design.composechili.utils.asSp

@Immutable
data class ChiliTextDimensions(
    val TextSizeH1: TextUnit,
    val TextSizeH2: TextUnit,
    val TextSizeH3: TextUnit,
    val TextSizeH4: TextUnit,
    val TextSizeH5: TextUnit,
    val TextSizeH6: TextUnit,
    val TextSizeH7: TextUnit,
    val TextSizeH8: TextUnit,
    val TextSizeH9: TextUnit,
    val TextSizeH10: TextUnit,
    val ChiliComponentButtonTextSize:TextUnit
) {
    companion object {
        @Composable
        fun fromResources() = ChiliTextDimensions(
            TextSizeH1 = dimensionResource(id = R.dimen.text_64sp).asSp(),
            TextSizeH2 = dimensionResource(id = R.dimen.text_32sp).asSp(),
            TextSizeH3 = dimensionResource(id = R.dimen.text_28sp).asSp(),
            TextSizeH4 = dimensionResource(id = R.dimen.text_24sp).asSp(),
            TextSizeH5 = dimensionResource(id = R.dimen.text_20sp).asSp(),
            TextSizeH6 = dimensionResource(id = R.dimen.text_18sp).asSp(),
            TextSizeH7 = dimensionResource(id = R.dimen.text_16sp).asSp(),
            TextSizeH8 = dimensionResource(id = R.dimen.text_14sp).asSp(),
            TextSizeH9 = dimensionResource(id = R.dimen.text_12sp).asSp(),
            TextSizeH10 = dimensionResource(id = R.dimen.text_10sp).asSp(),
            ChiliComponentButtonTextSize = dimensionResource(id = R.dimen.text_16sp).asSp()
        )
    }
}