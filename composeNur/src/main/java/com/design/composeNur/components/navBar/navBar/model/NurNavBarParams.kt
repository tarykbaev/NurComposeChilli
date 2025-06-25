package com.design.composeNur.components.navBar.navBar.model

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
data class NurNavBarParams(
    val backgroundColor: Color,
    val backgroundShape: Shape,
    val selectedColor: Color,
    val unselectedColor: Color,
    val navItemParams: NurNavSimpleItemParams
) {
    companion object {
        val Default
            @Composable get() = NurNavBarParams(
                backgroundColor = NurTheme.Colors.NurNavBarBackgroundColor,
                backgroundShape = RoundedCornerShape(NurRadiusDimensions.fromResources().radius24Dp),
                selectedColor = NurTheme.Colors.NurNavBarSelectedItemColor,
                unselectedColor = NurTheme.Colors.NurNavBarUnSelectedItemColor,
                navItemParams = NurNavSimpleItemParams.Default
            )
    }
}

@Stable
data class NurNavSimpleItemParams(
    val labelTextStyle: TextStyle,
    val verticalPadding: Dp,
    val selectedColorTint: Color,
    val unselectedColorTint: Color,
) {
    companion object {
        val Default
            @Composable get() = NurNavSimpleItemParams(
                labelTextStyle = NurTextStyle.get(
                    textSize = NurTextDimensions.fromResources().TextSizeH10,
                    color = NurTheme.Colors.NurNavBarUnSelectedItemColor,
                    font = Font(R.font.roboto_medium)
                ),
                verticalPadding = dimensionResource(id = R.dimen.padding_10dp),
                selectedColorTint = NurTheme.Colors.NurNavBarSelectedItemColor,
                unselectedColorTint = NurTheme.Colors.NurNavBarUnSelectedItemColor
            )
    }
}