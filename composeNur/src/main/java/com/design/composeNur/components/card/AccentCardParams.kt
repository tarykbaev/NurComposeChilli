package com.design.composeNur.components.card

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R


data class AccentCardParams(
    val containerColor: Color,
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
    val startIconSize: Dp
) {
    companion object {
        val accentCardFucsia
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.folly_1),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                startIconSize = dimensionResource(id = R.dimen.view_20dp)
            )
        val accentCardBlack
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.black_4),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                startIconSize = dimensionResource(id = R.dimen.view_20dp)
            )
        val accentCardWhite
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.white_1),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.black_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.black_1)
                ),
                startIconSize = dimensionResource(id = R.dimen.view_20dp)
            )
    }
}