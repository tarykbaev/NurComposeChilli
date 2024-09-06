package com.design.composechili.components.cell.expandableCell

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

data class ExpandableCellParams(
    val titleTextStyle: TextStyle,
    val descriptionTextStyle: TextStyle,
    val titlePadding: ChiliPadding,
    val descriptionPadding: ChiliPadding,
    val chevronIconTint: Color
) {
    companion object {
        val Default
            @Composable get() = ExpandableCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ), descriptionTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliSecondaryTextColor,
                ), titlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ), descriptionPadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_12dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp)
                ), chevronIconTint = ChiliTheme.Colors.chiliChevronColor
            )
    }
}