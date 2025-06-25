package com.design.composeNur.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.dimensions.NurElevationDimensions
import com.design.composeNur.theme.dimensions.NurPaddingDimensions
import com.design.composeNur.theme.dimensions.NurRadiusDimensions
import com.design.composeNur.theme.dimensions.NurTextDimensions
import com.design.composeNur.theme.dimensions.NurViewDimensions
import com.design.composenur.R

@Immutable
data class NurAttribute(

    // Dimens
    val NurTextDimensions: NurTextDimensions,
    val NurViewDimensions: NurViewDimensions,
    val NurPaddingDimensions: NurPaddingDimensions,
    val NurRadiusDimensions: NurRadiusDimensions,
    val NurElevationDimensions: NurElevationDimensions,

    // Font
    val NurRegularTextFont: Font,
    val NurBoldTextFont: Font,
    val NurItalicTextFont: Font,
    val Nur700TextFont: Font,
    val NurComponentButtonTextFont: Font,

    // Ripple
    val NurRippleForegroundCornerRadius: Dp,

    // Divider
    val NurDividerHeightSize: Dp,

    // Chevron
    val NurChevronDrawable: Painter,

    // Snackbar
    val NurSnackbarBackgroundCornerRadius: Dp,
    val NurSnackbarElevation: Dp,
    val NurSnackbarMarginStart: Dp,
    val NurSnackbarMarginEnd: Dp,
    val NurSnackbarMarginTop: Dp,
    val NurSnackbarMarginBottom: Dp,
    val NurSnackbarContentPaddingHorizontal: Dp,
    val NurSnackbarContentPaddingVertical: Dp,
    val NurSnackbarIconWidth: Dp,
    val NurSnackbarIconHeight: Dp,
    val NurSnackbarTextMarginStart: Dp,

    // Cell
    val NurCellCornerRadius: Dp,

    // Tooltip
    val NurToolipCornerRadius: Dp,

    // TopAppBar
    val NurTopAppBarThicknessSize: Dp,
    val NurTopAppBarHeightSize: Dp,

    // Highlight Container
    val NurHighLightContainerBorderWidth: Dp,
    val NurHighLightContainerCornerRadius: Dp,

    // Nur Bottom Sheet
    val NurBottomSheetTopCornerRadius: Dp,
    val NurBottomSheetBottomCornerRadius: Dp,
    val NurBottomSheetContainerHorizontalMargin: Dp,
    val NurBottomSheetContainerBottomMargin: Dp,

    // In App Push
    val NurInAppPushCornerRadius: Dp
) {
    companion object {
        @Composable
        fun getDefault() = NurAttribute(
            NurTextDimensions = NurTextDimensions.fromResources(),
            NurViewDimensions = NurViewDimensions.fromResources(),
            NurPaddingDimensions = NurPaddingDimensions.fromResources(),
            NurRadiusDimensions = NurRadiusDimensions.fromResources(),
            NurElevationDimensions = NurElevationDimensions.fromResources(),
            NurRegularTextFont = Font(R.font.roboto_regular),
            NurBoldTextFont = Font(R.font.roboto_medium),
            NurItalicTextFont = Font(R.font.roboto_italic),
            Nur700TextFont = Font(R.font.roboto_700),
            NurRippleForegroundCornerRadius = dimensionResource(id = R.dimen.radius_4dp),
            NurDividerHeightSize = dimensionResource(id = R.dimen.view_1dp),
            NurChevronDrawable = painterResource(R.drawable.nur_ic_chevron),
            NurSnackbarBackgroundCornerRadius = dimensionResource(R.dimen.radius_12dp),
            NurSnackbarElevation = dimensionResource(R.dimen.elevation_4dp),
            NurCellCornerRadius = dimensionResource(id = R.dimen.padding_12dp),
            NurSnackbarMarginTop = dimensionResource(id = R.dimen.padding_0dp),
            NurSnackbarMarginEnd = dimensionResource(id = R.dimen.padding_16dp),
            NurSnackbarMarginStart = dimensionResource(id = R.dimen.padding_16dp),
            NurSnackbarMarginBottom = dimensionResource(id = R.dimen.padding_16dp),
            NurSnackbarIconWidth = dimensionResource(id = R.dimen.view_32dp),
            NurSnackbarIconHeight = dimensionResource(id = R.dimen.view_32dp),
            NurSnackbarContentPaddingVertical = dimensionResource(id = R.dimen.padding_10dp),
            NurSnackbarContentPaddingHorizontal = dimensionResource(id = R.dimen.padding_8dp),
            NurSnackbarTextMarginStart = dimensionResource(id = R.dimen.padding_8dp),
            NurComponentButtonTextFont = Font(R.font.roboto_regular),
            NurToolipCornerRadius = dimensionResource(id = R.dimen.radius_12dp),
            NurTopAppBarThicknessSize = dimensionResource(id = R.dimen.view_1dp),
            NurTopAppBarHeightSize = dimensionResource(id = R.dimen.view_56dp),
            NurHighLightContainerBorderWidth = dimensionResource(R.dimen.view_2dp),
            NurHighLightContainerCornerRadius = dimensionResource(R.dimen.radius_14dp),
            NurBottomSheetTopCornerRadius = dimensionResource(id = R.dimen.radius_12dp),
            NurBottomSheetBottomCornerRadius = dimensionResource(id = R.dimen.radius_0dp),
            NurBottomSheetContainerBottomMargin = dimensionResource(id = R.dimen.padding_0dp),
            NurBottomSheetContainerHorizontalMargin = dimensionResource(id = R.dimen.padding_0dp),
            NurInAppPushCornerRadius = dimensionResource(id = R.dimen.radius_24dp)
        )
    }
}