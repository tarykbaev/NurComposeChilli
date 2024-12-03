package com.design.composechili.components.snackbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

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
                containerColor = ChiliTheme.Colors.ChiliSnackbarBackground,
                cornersSize = ChiliTheme.Attribute.ChiliSnackbarBackgroundCornerRadius,
                textColor = ChiliTheme.Colors.ChiliSnackbarTextColor,
                actionTextColor = ChiliTheme.Colors.ChiliComponentButtonTextColorActive,
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = Font(R.font.roboto_medium)
                )
            )
    }

}