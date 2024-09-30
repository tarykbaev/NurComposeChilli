package com.design.composechili.components.cell.toggle

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composechili.R
import com.design.composechili.components.cell.baseCell.BaseCellParams
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

data class ToggleCellParams(
    val baseCellParams: BaseCellParams,
    val switchTextStyle: TextStyle,
    val switchOnOffTextStyle: TextStyle,
    val switchPadding: ChiliPadding,
    val toggleColors: SwitchColors
) {

    companion object {
        val Default
            @Composable get() = ToggleCellParams(
                baseCellParams = BaseCellParams.Default,
                switchTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                switchOnOffTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                switchPadding = ChiliPadding(
                    end = dimensionResource(id = R.dimen.padding_12dp)
                ),
                toggleColors = SwitchDefaults.colors(
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    uncheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    checkedTrackColor = colorResource(id = R.color.magenta_1_alpha_40),
                    disabledCheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    disabledUncheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    checkedThumbColor = colorResource(id = R.color.magenta_1),
                    uncheckedThumbColor = ChiliTheme.Colors.ChiliToggleCellViewThumbNormalColor
                )
            )
    }
}