package com.design.composechili.components.navBar.navBarWithFab.model

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
import com.design.composechili.theme.dimensions.ChiliTextDimensions
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Stable
data class NavBarWithFabParams(
    val selectedColor: Color,
    val unselectedColor: Color,
    val backgroundColor: Color,
    val backgroundShape: Shape,
) {
    companion object {
        val Default
            @Composable get() = NavBarWithFabParams(
                selectedColor = ChiliTheme.Colors.ChiliNavBarSelectedItemColor,
                unselectedColor = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                backgroundColor = ChiliTheme.Colors.СhiliScreenBackground,
                backgroundShape = RoundedCornerShape(
                    ChiliRadiusDimensions.fromResources().radius24Dp,
                    ChiliRadiusDimensions.fromResources().radius24Dp,
                    ChiliRadiusDimensions.fromResources().radius0Dp,
                    ChiliRadiusDimensions.fromResources().radius0Dp,
                )
            )
    }
}

@Stable
data class ChiliNavWithFabSimpleItemParams(
    val labelTextStyle: TextStyle,
    val verticalPadding: Dp,
    val selectedColorTint: Color,
    val unselectedColorTint: Color){

    companion object{
        val Default
            @Composable get() = ChiliNavWithFabSimpleItemParams(
                labelTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                    color = ChiliTheme.Colors.ChiliNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ),
                verticalPadding = dimensionResource(id = R.dimen.padding_10dp),
                selectedColorTint = ChiliTheme.Colors.ChiliNavBarAlternativeSelectedItemColor,
                unselectedColorTint = ChiliTheme.Colors.ChiliNavBarAlternativeUnSelectedItemColor
            )
    }

}