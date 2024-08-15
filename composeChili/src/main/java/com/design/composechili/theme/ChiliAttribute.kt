package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.dimensions.ChiliElevationDimensions
import com.design.composechili.theme.dimensions.ChiliPaddingDimensions
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions
import com.design.composechili.theme.dimensions.ChiliViewDimensions

@Immutable
data class ChiliAttribute(

    // Dimens
    val ChiliTextDimensions: ChiliTextDimensions,
    val ChiliViewDimensions: ChiliViewDimensions,
    val ChiliPaddingDimensions: ChiliPaddingDimensions,
    val ChiliRadiusDimensions: ChiliRadiusDimensions,
    val ChiliElevationDimensions: ChiliElevationDimensions,

    // Font
    val ChiliRegularTextFont: Font,
    val ChiliBoldTextFont: Font,
    val ChiliItalicTextFont: Font,
    val Chili700TextFont: Font,

    // Ripple
    val ChiliRippleForegroundCornerRadius: Dp,

    // Divider
    val ChiliDividerHeightSize: Dp,

    // Chevron
    val ChiliChevronDrawable: Painter,

    // Snackbar
    val ChiliSnackbarBackgroundCornerRadius: Dp,
    val ChiliSnackbarElevation: Dp,
    val ChiliSnackbarMarginStart:Dp,
    val ChiliSnackbarMarginEnd:Dp,
    val ChiliSnackbarMarginTop:Dp,
    val ChiliSnackbarMarginBottom:Dp,
    val ChiliSnackbarContentPaddingHorizontal:Dp,
    val ChiliSnackbarContentPaddingVertical:Dp,
    val ChiliSnackbarIconWidth:Dp,
    val ChiliSnackbarIconHeight:Dp,
    val ChiliSnackbarTextMarginStart:Dp,

    // Cell
    val ChiliCellCornerRadius:Dp,

    // Toolbar
    val ChiliToolbarThicknessSize: Dp,
    val ChiliToolbarHeightSize: Dp

    ) {
    companion object {
        @Composable
        fun getDefault() = ChiliAttribute(
            ChiliTextDimensions = ChiliTextDimensions.fromResources(),
            ChiliViewDimensions = ChiliViewDimensions.fromResources(),
            ChiliPaddingDimensions = ChiliPaddingDimensions.fromResources(),
            ChiliRadiusDimensions = ChiliRadiusDimensions.fromResources(),
            ChiliElevationDimensions = ChiliElevationDimensions.fromResources(),
            ChiliRegularTextFont = Font(R.font.roboto_regular),
            ChiliBoldTextFont = Font(R.font.roboto_medium),
            ChiliItalicTextFont = Font(R.font.roboto_italic),
            Chili700TextFont = Font(R.font.roboto_700),
            ChiliRippleForegroundCornerRadius = dimensionResource(id = R.dimen.radius_4dp),
            ChiliDividerHeightSize = dimensionResource(id = R.dimen.view_1dp),
            ChiliChevronDrawable = painterResource(R.drawable.chili_ic_chevron),
            ChiliSnackbarBackgroundCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliSnackbarElevation = dimensionResource(R.dimen.elevation_4dp),
            ChiliCellCornerRadius = dimensionResource(id = R.dimen.padding_12dp),
            ChiliSnackbarMarginTop = dimensionResource(id = R.dimen.padding_0dp),
            ChiliSnackbarMarginEnd = dimensionResource(id = R.dimen.padding_16dp),
            ChiliSnackbarMarginStart = dimensionResource(id = R.dimen.padding_16dp),
            ChiliSnackbarMarginBottom = dimensionResource(id = R.dimen.padding_16dp),
            ChiliSnackbarIconWidth = dimensionResource(id = R.dimen.view_32dp),
            ChiliSnackbarIconHeight = dimensionResource(id = R.dimen.view_32dp),
            ChiliSnackbarContentPaddingVertical = dimensionResource(id = R.dimen.padding_10dp),
            ChiliSnackbarContentPaddingHorizontal = dimensionResource(id = R.dimen.padding_8dp),
            ChiliSnackbarTextMarginStart = dimensionResource(id = R.dimen.padding_8dp),
            ChiliToolbarThicknessSize = dimensionResource(id = R.dimen.view_1dp),
            ChiliToolbarHeightSize = dimensionResource(id = R.dimen.view_56dp)
        )
    }
}