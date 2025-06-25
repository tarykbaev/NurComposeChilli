package com.design.composeNur.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class BaseSnackBarParams(
    val containerColor: Color,
    val cornersSize: Dp,
    val textColor: Color,
    val actionTextColor: Color,
    val textStyle: TextStyle,
) {
    companion object {
        val Default
            @Composable
            get() = BaseSnackBarParams(
                containerColor = NurTheme.Colors.NurSnackbarBackground,
                cornersSize = NurTheme.Attribute.NurSnackbarBackgroundCornerRadius,
                textColor = NurTheme.Colors.NurSnackbarTextColor,
                actionTextColor = NurTheme.Colors.NurComponentButtonTextColorActive,
                textStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = Font(R.font.roboto_medium)
                )
            )
    }

}