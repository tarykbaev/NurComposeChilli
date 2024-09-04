package com.design.composechili.components.cell

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class AdditionalTextCellViewParams(
    val titleTextAppearance: TextStyle,
    val additionalTextAppearance: TextStyle,
    val additionalSubTextAppearance: TextStyle,
    val roundedCornerShape: CellCornerMode,
) {

    companion object {
        val roundedShapeTop
            @Composable
            get() = CellCornerMode.Top

        val roundedShapeCenter
            @Composable
            get() = CellCornerMode.Middle

        val roundedShapeBottom
            @Composable
            get() = CellCornerMode.Bottom

        val AdditionalText
            @Composable
            get() = AdditionalTextCellViewParams(
                titleTextAppearance = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                additionalTextAppearance = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                additionalSubTextAppearance = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliSecondaryButtonTextColorPressed,
                ),
                roundedCornerShape = CellCornerMode.Single
            )
    }

}