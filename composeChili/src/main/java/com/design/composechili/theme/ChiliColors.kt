package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

@Immutable
public data class ChiliColors(
    val chiliPrimaryTextColor:Color,
    val chiliSecondaryTextColor:Color,
    val chiliMarkedTextColor:Color,
    val chiliErrorTextColor:Color,
    val chiliValueTextColor:Color,
    val chiliLinkTextColor:Color,

    // Screen Background
    val chiliScreenBackground:Color,
    val chiliSurfaceBackground:Color,

    // Ripple
    val chiliRippleForegroundColor:Color,

    // Divider
    val chiliDividerColor:Color,

    // Chevron
    val chiliChevronColor:Color,

    // Snackbar
    val chiliSnackbarBackground:Color,
    val chiliSnackbarTextColor:Color,

    // Segmented Picker
    val chiliSegmentedPickerBackgroundColor:Color,
    val chiliSegmentedPickerTabIndicatorColor:Color,
    val chiliSegmentedPickerTabTextColor:Color,

    // CheckBox
    val chiliCheckBoxCheckedColor:Color,
    val chiliCheckedBoxUncheckedColor:Color,
    val chiliCheckBoxDisabledColor:Color,

    // Primary Button
    val ChiliPrimaryButtonBackgroundActive:Color,
    val ChiliPrimaryButtonBackgroundDisabled:Color,
    val ChiliPrimaryButtonTextColorActive:Color,
    val ChiliPrimaryButtonTextColorPressed:Color,
    val ChiliPrimaryButtonTextColorDisabled:Color,

    val ChiliPrimaryButtonRippleColor:Color,
    val ChiliPrimaryButtonBorderColor:Color,





){

    companion object{
        @Composable
        fun defaultDarkColors() : ChiliColors = ChiliColors(
            chiliPrimaryTextColor = colorResource(id = R.color.white_1),
            chiliSecondaryTextColor = colorResource(id = R.color.gray_3),
            chiliMarkedTextColor = colorResource(id = R.color.white_1),
            chiliErrorTextColor = colorResource(id = R.color.red_1),
            chiliValueTextColor = colorResource(id = R.color.gray_1),
            chiliLinkTextColor = colorResource(id = R.color.magenta_1),
            chiliScreenBackground = colorResource(id = R.color.black_2),
            chiliSurfaceBackground = colorResource(id = R.color.black_1),
            chiliRippleForegroundColor = colorResource(id = R.color.gray_1_alpha_50),
            chiliDividerColor = colorResource(id = R.color.black_4),
            chiliChevronColor = colorResource(id = R.color.white_1),
            chiliSnackbarTextColor = colorResource(id = R.color.gray_3),
            chiliSnackbarBackground = colorResource(id = R.color.black_3),
            chiliSegmentedPickerBackgroundColor = colorResource(id = R.color.black_4),
            chiliSegmentedPickerTabIndicatorColor = colorResource(id =R.color.black_3),
            chiliSegmentedPickerTabTextColor = colorResource(id = R.color.gray_3),
            chiliCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            chiliCheckBoxDisabledColor = colorResource(id = R.color.gray_1_alpha_50),
            chiliCheckedBoxUncheckedColor = colorResource(id = R.color.gray_3),
            ChiliPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            ChiliPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_3),
            ChiliPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliPrimaryButtonBorderColor = Color.Transparent,
        )

        @Composable
        fun defaultLightColors() : ChiliColors = ChiliColors(
            chiliPrimaryTextColor = colorResource(id = R.color.black_1),
            chiliSecondaryTextColor = colorResource(id = R.color.black_4),
            chiliMarkedTextColor = colorResource(id = R.color.black_1),
            chiliErrorTextColor = colorResource(id = R.color.red_1),
            chiliValueTextColor = colorResource(id = R.color.gray_1),
            chiliLinkTextColor = colorResource(id = R.color.magenta_1),
            chiliScreenBackground = colorResource(id = R.color.gray_4),
            chiliSurfaceBackground = colorResource(id = R.color.white_1),
            chiliRippleForegroundColor = colorResource(id = R.color.black_1_alpha_20),
            chiliDividerColor = colorResource(id = R.color.gray_6),
            chiliChevronColor = colorResource(id = R.color.gray_2),
            chiliSnackbarBackground = colorResource(id = R.color.white_1),
            chiliSnackbarTextColor = colorResource(id = R.color.black_5),
            chiliSegmentedPickerBackgroundColor = colorResource(id = R.color.gray_6),
            chiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.white_1),
            chiliSegmentedPickerTabTextColor = colorResource(id = R.color.black_5),
            chiliCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            chiliCheckedBoxUncheckedColor = colorResource(id = R.color.black_5),
            chiliCheckBoxDisabledColor = colorResource(id = R.color.gray_2),
            ChiliPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            ChiliPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_2),
            ChiliPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliPrimaryButtonBorderColor = Color.Transparent
        )
    }

}

