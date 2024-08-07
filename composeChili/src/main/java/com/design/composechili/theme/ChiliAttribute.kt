package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.design.composechili.R

@Immutable
data class ChiliAttribute(
    val chiliTextSizeH1: TextUnit,
    val chiliTextSizeH2:TextUnit,
    val chiliTextSizeH3:TextUnit,
    val chiliTextSizeH4:TextUnit,
    val chiliTextSizeH5:TextUnit,
    val chiliTextSizeH6:TextUnit,
    val chiliTextSizeH7:TextUnit,
    val chiliTextSizeH8:TextUnit,
    val chiliTextSizeH9:TextUnit,
    val chiliTextSizeH10:TextUnit,

    val chiliRegularTextFont: Font,
    val chiliBoldTextFont:Font,
    val chiliItalicTextFont:Font,
    val chili700TextFont:Font,

    // Ripple
    val chiliRippleForegroundCornerRadius:Dp,

    // Divider
    val chiliDividerHeightSize:Dp,

    // Chevron
    val chiliChevronDrawable:Painter,

    // Snackbar
    val chiliSnackbarBackgroundCornerRadius:Dp,
    val chiliSnackbarElevation:Dp,

    // Button
    val ChiliPrimaryButtonPaddingTop:Dp,
    val ChiliPrimaryButtonPaddingBottom:Dp,
    val ChiliPrimaryButtonPaddingStart:Dp,
    val ChiliPrimaryButtonPaddingEnd:Dp,

    // PrimaryButton
    val ChiliPrimaryButtonCornerRadius:Dp,
    val ChiliPrimaryButtonTextSize:TextUnit,
    val ChiliPrimaryButtonTextFont:Font,
    val ChiliPrimaryButtonTextAllCaps:Boolean


){

    companion object{

        @Composable
        fun getDefault() = ChiliAttribute(

            chiliTextSizeH1 = dimensionResource(R.dimen.text_64sp).asSp(),
            chiliTextSizeH2 = dimensionResource(R.dimen.text_32sp).asSp(),
            chiliTextSizeH3 = dimensionResource(R.dimen.text_28sp).asSp(),
            chiliTextSizeH4 = dimensionResource(R.dimen.text_24sp).asSp(),
            chiliTextSizeH5 = dimensionResource(R.dimen.text_20sp).asSp(),
            chiliTextSizeH6 = dimensionResource(R.dimen.text_18sp).asSp(),
            chiliTextSizeH7 = dimensionResource(R.dimen.text_16sp).asSp(),
            chiliTextSizeH8 = dimensionResource(R.dimen.text_14sp).asSp(),
            chiliTextSizeH9 = dimensionResource(R.dimen.text_12sp).asSp(),
            chiliTextSizeH10 = dimensionResource(R.dimen.text_10sp).asSp(),
            chiliRegularTextFont = Font(R.font.roboto_regular),
            chiliBoldTextFont = Font(R.font.roboto_medium),
            chiliItalicTextFont = Font(R.font.roboto_italic),
            chili700TextFont = Font(R.font.roboto_700),
            chiliRippleForegroundCornerRadius = dimensionResource(R.dimen.radius_4dp),
            chiliDividerHeightSize = dimensionResource(R.dimen.view_1dp),
            chiliChevronDrawable = painterResource(R.drawable.chili_ic_chevron),
            chiliSnackbarBackgroundCornerRadius = dimensionResource(R.dimen.radius_12dp),
            chiliSnackbarElevation = dimensionResource(R.dimen.elevation_4dp),
            ChiliPrimaryButtonPaddingTop = dimensionResource(R.dimen.padding_14dp),
            ChiliPrimaryButtonPaddingBottom = dimensionResource(R.dimen.padding_14dp),
            ChiliPrimaryButtonPaddingEnd = dimensionResource(R.dimen.padding_24dp),
            ChiliPrimaryButtonPaddingStart = dimensionResource(R.dimen.padding_24dp),
            ChiliPrimaryButtonCornerRadius = dimensionResource(R.dimen.radius_12dp),
            ChiliPrimaryButtonTextFont = Font(R.font.roboto_medium),
            ChiliPrimaryButtonTextSize = dimensionResource(R.dimen.text_14sp).asSp(),
            ChiliPrimaryButtonTextAllCaps = false
        )


        //
        private fun Dp.asSp() = this.value.sp
    }

}