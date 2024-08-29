package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

@Immutable
public data class ChiliColors(
    val ChiliPrimaryTextColor: Color,
    val chiliSecondaryTextColor: Color,
    val ChiliMarkedTextColor: Color,
    val chiliErrorTextColor: Color,
    val chiliValueTextColor: Color,
    val chiliLinkTextColor: Color,

    // Screen Background
    val chiliScreenBackground: Color,
    val chiliSurfaceBackground: Color,

    // Ripple
    val chiliRippleForegroundColor: Color,

    // Divider
    val ChiliDividerColor: Color,

    // Chevron
    val chiliChevronColor: Color,

    // Snackbar
    val ChiliSnackbarBackground: Color,
    val ChiliSnackbarTextColor: Color,

    // Segmented Picker
    val chiliSegmentedPickerBackgroundColor: Color,
    val chiliSegmentedPickerTabIndicatorColor: Color,
    val chiliSegmentedPickerTabTextColor: Color,

    // CheckBox
    val chiliCheckBoxCheckedColor: Color,
    val chiliCheckedBoxUncheckedColor: Color,
    val chiliCheckBoxDisabledColor: Color,

    // Primary Button
    val ChiliPrimaryButtonBackgroundActive: Color,
    val ChiliPrimaryButtonBackgroundDisabled: Color,
    val ChiliPrimaryButtonTextColorActive: Color,
    val ChiliPrimaryButtonTextColorPressed: Color,
    val ChiliPrimaryButtonTextColorDisabled: Color,

    val ChiliPrimaryButtonRippleColor: Color,
    val ChiliPrimaryButtonBorderColor: Color,

    // Secondary Button
    val ChiliSecondaryButtonBackgroundActive: Color,
    val ChiliSecondaryButtonBackgroundDisabled: Color,
    val ChiliSecondaryButtonTextColorActive: Color,
    val ChiliSecondaryButtonTextColorPressed: Color,
    val ChiliSecondaryButtonTextColorDisabled: Color,

    // Additional Button
    val ChiliAdditionalButtonBackgroundActive: Color,
    val ChiliAdditionalButtonBackgroundDisabled: Color,
    val ChiliAdditionalButtonTextColorActive: Color,
    val ChiliAdditionalButtonTextColorPressed: Color,
    val ChiliAdditionalButtonTextColorDisabled: Color,
    val ChiliAdditionalButtonBorderColor: Color,

    // Component Button Attributes
    val ChiliComponentButtonBackgroundActive: Color,
    val ChiliComponentButtonBackgroundDisabled: Color,
    val ChiliComponentButtonTextColorActive: Color,
    val ChiliComponentButtonTextColorPressed: Color,
    val ChiliComponentButtonTextColorDisabled: Color,

    // Accent Button Attributes
    val ChiliAccentButtonBackgroundActive: Color,
    val ChiliAccentButtonBackgroundDisabled: Color,

    // Cell View
    val ChiliCellViewBackground: Color,
    val ChilicellSquircleIconBackground: Color,

    val ChiliTooltipBackground: Color,

    // TopAppBar
    val ChiliTopAppBarDividerColor: Color,
    val ChiliTopAppBarIconsTint: Color,
    val ChiliTopAppBarBackground: Color,
    val ChiliStartIconTopAppBarBackground: Color
) {
    // Code Input View
    val ChiliCodeInputViewMessageColor: Color,
    val ChiliCodeInputViewActionTextActiveColor: Color,
    val ChiliCodeInputViewActionTextInActiveColor: Color,
    val ChiliCodeInputItemBorderColor: Color,
    val ChiliCodeInputItemBackgroundColor: Color,
    val ChiliCodeInputItemErrorBackgroundColor: Color

    ){

    companion object {
        @Composable
        fun defaultDarkColors(): ChiliColors = ChiliColors(
            ChiliPrimaryTextColor = colorResource(id = R.color.white_1),
            chiliSecondaryTextColor = colorResource(id = R.color.gray_3),
            ChiliMarkedTextColor = colorResource(id = R.color.white_1),
            chiliErrorTextColor = colorResource(id = R.color.red_1),
            chiliValueTextColor = colorResource(id = R.color.gray_1),
            chiliLinkTextColor = colorResource(id = R.color.magenta_1),
            chiliScreenBackground = colorResource(id = R.color.black_2),
            chiliSurfaceBackground = colorResource(id = R.color.black_1),
            chiliRippleForegroundColor = colorResource(id = R.color.gray_1_alpha_50),
            ChiliDividerColor = colorResource(id = R.color.black_4),
            chiliChevronColor = colorResource(id = R.color.white_1),
            ChiliSnackbarTextColor = colorResource(id = R.color.gray_3),
            ChiliSnackbarBackground = colorResource(id = R.color.black_3),
            chiliSegmentedPickerBackgroundColor = colorResource(id = R.color.black_4),
            chiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.black_3),
            chiliSegmentedPickerTabTextColor = colorResource(id = R.color.gray_3),
            chiliCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            chiliCheckBoxDisabledColor = colorResource(id = R.color.gray_1_alpha_50),
            chiliCheckedBoxUncheckedColor = colorResource(id = R.color.gray_3),
            ChiliPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            ChiliPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_2),
            ChiliPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliPrimaryButtonBorderColor = Color.Transparent,
            ChiliSecondaryButtonBackgroundActive = Color.Transparent,
            ChiliSecondaryButtonBackgroundDisabled = Color.Transparent,
            ChiliSecondaryButtonTextColorDisabled = colorResource(id = R.color.black_1_alpha_50),
            ChiliSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBackgroundActive = colorResource(id = R.color.black_5),
            ChiliAdditionalButtonBackgroundDisabled = colorResource(id = R.color.black_5),
            ChiliAdditionalButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliAdditionalButtonTextColorDisabled = colorResource(id = R.color.white_1),
            ChiliAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBorderColor = colorResource(id = R.color.black_5),
            ChiliCellViewBackground = colorResource(id = R.color.black_3),
            ChilicellSquircleIconBackground = colorResource(id = R.color.black_2),
            ChiliComponentButtonBackgroundActive = Color.Transparent,
            ChiliComponentButtonBackgroundDisabled = Color.Transparent,
            ChiliComponentButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliComponentButtonTextColorPressed = colorResource(id = R.color.blue_1),
            ChiliComponentButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            ChiliAccentButtonBackgroundActive = colorResource(id = R.color.magenta_1),
            ChiliAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            ChiliTooltipBackground = colorResource(id = R.color.black_3),
            ChiliTopAppBarDividerColor = colorResource(id = R.color.black_4),
            ChiliTopAppBarIconsTint = colorResource(id = R.color.white_1),
            ChiliTopAppBarBackground = colorResource(id = R.color.black_3),
            ChiliStartIconTopAppBarBackground = colorResource(R.color.black_1)
            ChiliTooltipBackground = colorResource(id = R.color.black_3)
            ChiliAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            ChiliCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            ChiliCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            ChiliCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            ChiliCodeInputItemBackgroundColor = colorResource(id = R.color.black_4),
            ChiliCodeInputItemBorderColor = colorResource(id = R.color.white_1),
            ChiliCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_2)
        )

        @Composable
        fun defaultLightColors(): ChiliColors = ChiliColors(
            ChiliPrimaryTextColor = colorResource(id = R.color.black_1),
            chiliSecondaryTextColor = colorResource(id = R.color.black_4),
            ChiliMarkedTextColor = colorResource(id = R.color.black_1),
            chiliErrorTextColor = colorResource(id = R.color.red_1),
            chiliValueTextColor = colorResource(id = R.color.gray_1),
            chiliLinkTextColor = colorResource(id = R.color.magenta_1),
            chiliScreenBackground = colorResource(id = R.color.gray_4),
            chiliSurfaceBackground = colorResource(id = R.color.white_1),
            chiliRippleForegroundColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliDividerColor = colorResource(id = R.color.gray_6),
            chiliChevronColor = colorResource(id = R.color.gray_2),
            ChiliSnackbarBackground = colorResource(id = R.color.white_1),
            ChiliSnackbarTextColor = colorResource(id = R.color.black_5),
            chiliSegmentedPickerBackgroundColor = colorResource(id = R.color.gray_6),
            chiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.white_1),
            chiliSegmentedPickerTabTextColor = colorResource(id = R.color.black_5),
            chiliCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            chiliCheckedBoxUncheckedColor = colorResource(id = R.color.black_5),
            chiliCheckBoxDisabledColor = colorResource(id = R.color.gray_2),
            ChiliPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            ChiliPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_3),
            ChiliPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            ChiliPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliPrimaryButtonBorderColor = Color.Transparent,
            ChiliSecondaryButtonBackgroundActive = Color.Transparent,
            ChiliSecondaryButtonBackgroundDisabled = Color.Transparent,
            ChiliSecondaryButtonTextColorDisabled = colorResource(id = R.color.black_1_alpha_50),
            ChiliSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBackgroundActive = colorResource(id = R.color.gray_5),
            ChiliAdditionalButtonBackgroundDisabled = colorResource(id = R.color.gray_5),
            ChiliAdditionalButtonTextColorActive = colorResource(id = R.color.black_1),
            ChiliAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonTextColorDisabled = colorResource(id = R.color.gray_1_alpha_50),
            ChiliAdditionalButtonBorderColor = colorResource(id = R.color.gray_5),
            ChilicellSquircleIconBackground = colorResource(id = R.color.gray_3),
            ChiliCellViewBackground = colorResource(id = R.color.white_1),
            ChiliComponentButtonBackgroundActive = Color.Transparent,
            ChiliComponentButtonBackgroundDisabled = Color.Transparent,
            ChiliComponentButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliComponentButtonTextColorPressed = colorResource(id = R.color.blue_1),
            ChiliComponentButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            ChiliAccentButtonBackgroundActive = colorResource(id = R.color.magenta_1),
            ChiliAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            ChiliTooltipBackground = colorResource(id = R.color.black_3),
            ChiliTopAppBarDividerColor = colorResource(id = R.color.gray_8),
            ChiliTopAppBarIconsTint = colorResource(id = R.color.black_1),
            ChiliTopAppBarBackground = colorResource(id = R.color.white_1),
            ChiliStartIconTopAppBarBackground = colorResource(R.color.white_1)
            ChiliTooltipBackground = colorResource(id = R.color.black_3)
            ChiliAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            ChiliCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            ChiliCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            ChiliCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            ChiliCodeInputItemBackgroundColor = colorResource(id = R.color.gray_5),
            ChiliCodeInputItemBorderColor = colorResource(id = R.color.magenta_1),
            ChiliCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_3)
        )
    }
}