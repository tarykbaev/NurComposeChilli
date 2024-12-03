package com.design.composechili.components.navBar.navBar.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Stable
data class ChiliNavBarParams(
    val backgroundColor: Color,
    val backgroundShape: Shape,
    val selectedColor: Color,
    val unselectedColor: Color,
    val navItemParams: ChiliNavSimpleItemParams
) {
    companion object {
        val Default
            @Composable get() = ChiliNavBarParams(
                backgroundColor = ChiliTheme.Colors.ChiliNavBarBackgroundColor,
                backgroundShape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius24Dp),
                selectedColor = ChiliTheme.Colors.ChiliNavBarSelectedItemColor,
                unselectedColor = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                navItemParams = ChiliNavSimpleItemParams.Default
            )
    }
}

@Stable
data class ChiliNavSimpleItemParams(
    val labelTextStyle: TextStyle,
    val verticalPadding: Dp,
    val selectedColorTint: Color,
    val unselectedColorTint: Color,
) {
    companion object {
        val Default
            @Composable get() = ChiliNavSimpleItemParams(
                labelTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                    color = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ),
                verticalPadding = dimensionResource(id = R.dimen.padding_10dp),
                selectedColorTint = ChiliTheme.Colors.ChiliNavBarSelectedItemColor,
                unselectedColorTint = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor
            )
    }
}