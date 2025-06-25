package com.design.composeNur.components.cell.toggle

import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class ToggleCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val switchTextStyle: TextStyle,
    val switchOnOffTextStyle: TextStyle,
    val titlePadding: NurPadding,
    val subtitlePadding: NurPadding,
    val cornerMode: CellCornerMode,
    val startIconPadding: NurPadding,
    val switchPadding: NurPadding,
    val toggleColors: SwitchColors
) {
    companion object {
        val Default
            @Composable get() = ToggleCellParams(
                titleTextStyle = NurTextStyleBuilder.H7.Primary.Default,
                subTitleTextStyle = NurTextStyleBuilder.H8.Secondary.Default,
                switchTextStyle = NurTextStyleBuilder.H8.Primary.Default,
                switchOnOffTextStyle = NurTextStyleBuilder.H8.Primary.Default,
                titlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ),
                subtitlePadding = NurPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ),
                cornerMode = CellCornerMode.Single,
                startIconPadding = NurPadding(
                    vertical = dimensionResource(id = R.dimen.padding_8dp),
                    horizontal = dimensionResource(id = R.dimen.padding_12dp)
                ),
                switchPadding = NurPadding(
                    end = dimensionResource(id = R.dimen.padding_12dp)
                ),
                toggleColors = SwitchDefaults.colors(
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    uncheckedTrackColor = NurTheme.Colors.NurToggleCellViewTrackColor,
                    checkedTrackColor = colorResource(id = R.color.magenta_1_alpha_40),
                    disabledCheckedTrackColor = NurTheme.Colors.NurToggleCellViewTrackColor,
                    disabledUncheckedTrackColor = NurTheme.Colors.NurToggleCellViewTrackColor,
                    checkedThumbColor = colorResource(id = R.color.magenta_1),
                    uncheckedThumbColor = NurTheme.Colors.NurToggleCellViewThumbNormalColor
                )
            )
    }
}