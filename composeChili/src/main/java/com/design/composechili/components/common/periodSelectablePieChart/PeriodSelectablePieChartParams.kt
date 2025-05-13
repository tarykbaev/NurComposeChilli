package com.design.composechili.components.common.periodSelectablePieChart

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder

data class PeriodSelectablePieChartParams(
    val cardCornerRadius: Dp,
    val cardBackgroundColor: Color,
    val chevronSize: Dp,
    val chevronClickableAreaWidth: Dp,
    val chevronClickableAreaHeight: Dp,
    val chevronPainter: Painter,
    val rightChevronRotateDegree: Float,
    val pieChartWithTextVerticalPadding: Dp,
    val pieChartWithTextHorizontalPadding: Dp,
    val periodTextVerticalPadding: Dp,
    val periodTextStyle: TextStyle,
) {
    companion object {
        val Default
            @Composable get() =
                PeriodSelectablePieChartParams(
                    cardCornerRadius = dimensionResource(R.dimen.radius_12dp),
                    cardBackgroundColor = ChiliTheme.Colors.ChiliSurfaceBackground,
                    chevronSize = dimensionResource(R.dimen.view_16dp),
                    chevronClickableAreaWidth = dimensionResource(R.dimen.padding_8dp),
                    chevronClickableAreaHeight = dimensionResource(R.dimen.padding_48dp),
                    chevronPainter = painterResource(R.drawable.chili_ic_chevron_left),
                    rightChevronRotateDegree = 180f,
                    pieChartWithTextVerticalPadding = dimensionResource(id = R.dimen.padding_8dp),
                    pieChartWithTextHorizontalPadding = dimensionResource(id = R.dimen.padding_32dp),
                    periodTextVerticalPadding = dimensionResource(R.dimen.padding_8dp),
                    periodTextStyle = ChiliTextStyleBuilder.H9.Default,
                )
    }
}