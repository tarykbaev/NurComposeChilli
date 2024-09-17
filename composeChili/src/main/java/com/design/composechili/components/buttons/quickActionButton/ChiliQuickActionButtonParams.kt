package com.design.composechili.components.buttons.quickActionButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ChiliQuickActionButtonParams(
    val titleEnabledTextStyle: TextStyle,
    val titleDisabledTextStyle: TextStyle,
    val iconSize: Dp,
) {

    companion object {

        val Default
            @Composable
            get() = ChiliQuickActionButtonParams(
                titleEnabledTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    ChiliTheme.Colors.ChiliQuickActionButtonTitleEnabledColor,
                ),
                titleDisabledTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    ChiliTheme.Colors.ChiliQuickActionButtonTitleDisabledColor,
                ),
                iconSize = dimensionResource(R.dimen.view_48dp)
            )
    }
}