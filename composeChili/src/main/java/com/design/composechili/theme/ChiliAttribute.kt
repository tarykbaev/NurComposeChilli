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
    val ChiliTextDimensions: ChiliTextDimensions,
    val ChiliViewDimensions: ChiliViewDimensions,
    val ChiliPaddingDimensions: ChiliPaddingDimensions,
    val ChiliRadiusDimensions: ChiliRadiusDimensions,
    val ChiliElevationDimensions: ChiliElevationDimensions,
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

    //PrimaryButton
    val ChiliPrimaryButtonAttribute: ChiliPrimaryButtonAttribute
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
            ChiliRippleForegroundCornerRadius = dimensionResource(R.dimen.radius_4dp),
            ChiliDividerHeightSize = dimensionResource(R.dimen.view_1dp),
            ChiliChevronDrawable = painterResource(R.drawable.chili_ic_chevron),
            ChiliSnackbarBackgroundCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliSnackbarElevation = dimensionResource(R.dimen.elevation_4dp),
            ChiliPrimaryButtonAttribute = ChiliPrimaryButtonAttribute.getDefault()
        )
    }
}