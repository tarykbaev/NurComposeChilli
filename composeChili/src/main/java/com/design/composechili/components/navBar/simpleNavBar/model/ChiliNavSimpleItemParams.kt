package com.design.composechili.components.navBar.simpleNavBar.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ChiliNavSimpleItemParams(
    val labelTextStyle: TextStyle,
    val verticalPadding: Dp,
) {
    companion object {
        val Default
            @Composable get() = ChiliNavSimpleItemParams(
                labelTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                    color = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ),
                verticalPadding = dimensionResource(id = R.dimen.padding_10dp)
            )
    }
}