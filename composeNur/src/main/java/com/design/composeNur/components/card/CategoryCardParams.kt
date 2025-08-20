package com.design.composeNur.components.card

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.cell.model.CellIconSize
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

@Stable
data class CategoryCardParams(
    val textStyle: TextStyle,
    val containerPadding: PaddingValues,
    val titlePadding: PaddingValues,
    val iconAlignment: Alignment.Horizontal,
    val iconSize: Dp
) {
    companion object {
        val Default
            @Composable get() = CategoryCardParams(
                textStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.NurBoldTextFont
                ),
                iconAlignment = Alignment.Start,
                containerPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                titlePadding = PaddingValues(top = 12.dp),
                iconSize = dimensionResource(R.dimen.view_24dp)
            )
    }
}
