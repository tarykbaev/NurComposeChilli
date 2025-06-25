package com.design.composeNur.components.navBar.navBarWithFab.model

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.dimensions.NurRadiusDimensions
import com.design.composeNur.theme.dimensions.NurTextDimensions
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

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
                selectedColor = NurTheme.Colors.NurNavBarSelectedItemColor,
                unselectedColor = NurTheme.Colors.NurNavBarUnSelectedItemColor,
                backgroundColor = NurTheme.Colors.СhiliScreenBackground,
                backgroundShape = RoundedCornerShape(
                    NurRadiusDimensions.fromResources().radius24Dp,
                    NurRadiusDimensions.fromResources().radius24Dp,
                    NurRadiusDimensions.fromResources().radius0Dp,
                    NurRadiusDimensions.fromResources().radius0Dp,
                )
            )
    }
}

@Stable
data class NurNavWithFabSimpleItemParams(
    val labelTextStyle: TextStyle,
    val verticalPadding: Dp,
    val selectedColorTint: Color,
    val unselectedColorTint: Color
) {

    companion object {
        val Default
            @Composable get() = NurNavWithFabSimpleItemParams(
                labelTextStyle = NurTextStyle.get(
                    textSize = NurTextDimensions.fromResources().TextSizeH10,
                    color = NurTheme.Colors.NurNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ),
                verticalPadding = dimensionResource(id = R.dimen.padding_10dp),
                selectedColorTint = NurTheme.Colors.NurNavBarAlternativeSelectedItemColor,
                unselectedColorTint = NurTheme.Colors.NurNavBarAlternativeUnSelectedItemColor
            )
    }

}