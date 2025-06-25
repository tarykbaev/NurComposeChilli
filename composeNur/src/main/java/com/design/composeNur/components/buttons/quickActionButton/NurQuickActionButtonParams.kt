package com.design.composeNur.components.buttons.quickActionButton

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class NurQuickActionButtonParams(
    val titleEnabledTextStyle: TextStyle,
    val titleDisabledTextStyle: TextStyle,
    val iconSize: Dp,
) {

    companion object {

        val Default
            @Composable
            get() = NurQuickActionButtonParams(
                titleEnabledTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    NurTheme.Colors.NurQuickActionButtonTitleEnabledColor,
                ),
                titleDisabledTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    NurTheme.Colors.NurQuickActionButtonTitleDisabledColor,
                ),
                iconSize = dimensionResource(R.dimen.view_48dp)
            )
    }
}