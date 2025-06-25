package com.design.composeNur.components.bottomSheet.searchSelector.optionItem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H7
import com.design.composeNur.values.NurPadding
import com.design.composenur.R

data class NurSearchSelectorBottomSheetOptionParams(
    val contentPadding: NurPadding,
    val valueTextStyle: TextStyle,
    val backgroundColor: Color,
    val icon: Painter
) {
    companion object {

        val Default
            @Composable get() = NurSearchSelectorBottomSheetOptionParams(
                contentPadding = NurPadding(
                    top = dimensionResource(id = R.dimen.padding_16dp),
                    bottom = dimensionResource(id = R.dimen.padding_16dp),
                    start = dimensionResource(id = R.dimen.padding_16dp),
                    end = dimensionResource(id = R.dimen.padding_8dp)
                ),
                valueTextStyle = H7.Primary.Default,
                backgroundColor = NurTheme.Colors.NurSurfaceBackground,
                icon = painterResource(R.drawable.nur_ic_checkmark)
            )
    }
}