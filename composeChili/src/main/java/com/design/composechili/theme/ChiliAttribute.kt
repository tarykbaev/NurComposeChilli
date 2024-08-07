package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.design.composechili.R

@Immutable
data class ChiliAttribute(
    val chiliTextDimensions: ChiliTextDimensions,
    val chiliViewDimensions: ChiliViewDimensions,
    val chiliPaddingDimensions: ChiliPaddingDimensions,
    val chiliCornerDimensions: ChiliCornerDimensions,
    val chiliOtherDimensions: ChiliOtherDimensions,
    val chiliRegularTextFont: Font,
    val chiliBoldTextFont: Font,
    val chiliItalicTextFont: Font,
    val chili700TextFont: Font,

    // Ripple
    val chiliRippleForegroundCornerRadius: Dp,

    // Divider
    val chiliDividerHeightSize: Dp,

    // Chevron
    val chiliChevronDrawable: Painter,

    // Snackbar
    val chiliSnackbarBackgroundCornerRadius: Dp,
    val chiliSnackbarElevation: Dp,


    ) {

    companion object {

        @Composable
        fun getDefault() = ChiliAttribute(
            chiliTextDimensions = ChiliTextDimensions(),
            chiliViewDimensions = ChiliViewDimensions(),
            chiliPaddingDimensions = ChiliPaddingDimensions(),
            chiliCornerDimensions = ChiliCornerDimensions(),
            chiliOtherDimensions = ChiliOtherDimensions(),
            chiliRegularTextFont = Font(R.font.roboto_regular),
            chiliBoldTextFont = Font(R.font.roboto_medium),
            chiliItalicTextFont = Font(R.font.roboto_italic),
            chili700TextFont = Font(R.font.roboto_700),
            chiliRippleForegroundCornerRadius = dimensionResource(R.dimen.radius_4dp),
            chiliDividerHeightSize = dimensionResource(R.dimen.view_1dp),
            chiliChevronDrawable = painterResource(R.drawable.chili_ic_chevron),
            chiliSnackbarBackgroundCornerRadius = dimensionResource(R.dimen.radius_12dp),
            chiliSnackbarElevation = dimensionResource(R.dimen.elevation_4dp)
        )


        //
        private fun Dp.asSp() = this.value.sp
    }

}