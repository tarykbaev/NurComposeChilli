package com.design.composechili.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composechili.R

@Immutable
data class ChiliColors(
    val ChiliPrimaryTextColor: Color,
    val ChiliSecondaryTextColor: Color,
    val ChiliMarkedTextColor: Color,
    val ChiliErrorTextColor: Color,
    val ChiliValueTextColor: Color,
    val ChiliLinkTextColor: Color,

    // Screen Background
    val СhiliScreenBackground: Color,
    val ChiliSurfaceBackground: Color,

    // Ripple
    val СhiliRippleForegroundColor: Color,

    // Divider
    val ChiliDividerColor: Color,

    // Chevron
    val СhiliChevronColor: Color,

    // Snackbar
    val ChiliSnackbarBackground: Color,
    val ChiliSnackbarTextColor: Color,

    // Segmented Picker
    val СhiliSegmentedPickerBackgroundColor: Color,
    val СhiliSegmentedPickerTabIndicatorColor: Color,
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
    val ChiliCellBackground: Color,
    val ChilicellSquircleIconBackground: Color,

    // ToggleCellView
    val ChiliToggleCellViewTrackColor: Color,
    val ChiliToggleCellViewThumbNormalColor: Color,
    val ChiliToggleCellViewTextOnOffCheckedEnabledColor: Color,
    val ChiliToggleCellViewTextOnOffCheckedDisabledColor: Color,

    val ChiliTooltipBackground: Color,


    // TopAppBar
    val ChiliTopAppBarDividerColor: Color,
    val ChiliTopAppBarIconsTint: Color,
    val ChiliTopAppBarBackground: Color,
    val ChiliStartIconTopAppBarBackground: Color,

    // Code Input View
    val ChiliCodeInputViewMessageColor: Color,
    val ChiliCodeInputViewActionTextActiveColor: Color,
    val ChiliCodeInputViewActionTextInActiveColor: Color,
    val ChiliCodeInputItemBorderColor: Color,
    val ChiliCodeInputItemBackgroundColor: Color,
    val ChiliCodeInputItemErrorBackgroundColor: Color,

    // NavBar
    val ChiliNavBarSelectedItemColor: Color,
    val ChiliNavBarUnSelectedItemColor: Color,

    val ChiliNavBarAlternativeSelectedItemColor: Color,
    val ChiliNavBarAlternativeUnSelectedItemColor: Color,

    val ChiliNavBarItemBackgroundColor: Color,
    val ChiliNavBarItemStrokeColor: Color,
    val ChiliNavBarBackgroundColor: Color,

    // Bottom Sheet
    val ChiliBottomSheetBackgroundColor: Color,
    val ChiliBottomSheetGrayBackgroundColor: Color,

    // Card Cell View
    val ChiliCardErrorTextColor: Color,

    // Action Bottom Sheet
    val ChiliActionBottomSheetButtonTextColor: Color,
    val ChiliActionBottomSheetAccentButtonTextColor: Color,

    // In App Push
    val ChiliInAppPushBackgroundColor: Color,

    // Bottom Sheet Drag Handle line color
    val ChiliThickBottomSheetDragHandleColor: Color,
    val ChiliBottomSheetDragHandleColor: Color,

    // ChiliQuickActionButton
    val ChiliQuickActionButtonTitleEnabledColor: Color,
    val ChiliQuickActionButtonTitleDisabledColor: Color
) {

    companion object {
        @Composable
        fun defaultDarkColors(): ChiliColors = ChiliColors(
            ChiliPrimaryTextColor = colorResource(id = R.color.white_1),
            ChiliSecondaryTextColor = colorResource(id = R.color.gray_3),
            ChiliMarkedTextColor = colorResource(id = R.color.white_1),
            ChiliErrorTextColor = colorResource(id = R.color.red_1),
            ChiliValueTextColor = colorResource(id = R.color.gray_1),
            ChiliLinkTextColor = colorResource(id = R.color.magenta_1),
            СhiliScreenBackground = colorResource(id = R.color.black_2),
            ChiliSurfaceBackground = colorResource(id = R.color.black_1),
            СhiliRippleForegroundColor = colorResource(id = R.color.gray_1_alpha_50),
            ChiliDividerColor = colorResource(id = R.color.black_4),
            СhiliChevronColor = colorResource(id = R.color.white_1),
            ChiliSnackbarTextColor = colorResource(id = R.color.gray_3),
            ChiliSnackbarBackground = colorResource(id = R.color.c_4a4a4a),
            СhiliSegmentedPickerBackgroundColor = colorResource(id = R.color.black_4),
            СhiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.black_3),
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
            ChiliSecondaryButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            ChiliSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBackgroundActive = colorResource(id = R.color.black_5),
            ChiliAdditionalButtonBackgroundDisabled = colorResource(id = R.color.black_5),
            ChiliAdditionalButtonTextColorActive = colorResource(id = R.color.white_1),
            ChiliAdditionalButtonTextColorDisabled = colorResource(id = R.color.gray_1_alpha_50),
            ChiliAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBorderColor = colorResource(id = R.color.black_5),
            ChiliCellBackground = colorResource(id = R.color.black_3),
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
            ChiliStartIconTopAppBarBackground = colorResource(R.color.black_1),
            ChiliToggleCellViewTrackColor = colorResource(id = R.color.black_4),
            ChiliToggleCellViewThumbNormalColor = colorResource(id = R.color.black_5),
            ChiliToggleCellViewTextOnOffCheckedEnabledColor = colorResource(id = R.color.white_1),
            ChiliToggleCellViewTextOnOffCheckedDisabledColor = colorResource(id = R.color.black_1),
            ChiliCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            ChiliCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            ChiliCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            ChiliCodeInputItemBackgroundColor = colorResource(id = R.color.black_4),
            ChiliCodeInputItemBorderColor = colorResource(id = R.color.white_1),
            ChiliCardErrorTextColor = colorResource(id = R.color.custom_red_3),
            ChiliCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_2),
            ChiliBottomSheetBackgroundColor = colorResource(id = R.color.black_3),
            ChiliBottomSheetGrayBackgroundColor = colorResource(id = R.color.black_2),
            ChiliActionBottomSheetButtonTextColor = colorResource(id = R.color.gray_3),
            ChiliActionBottomSheetAccentButtonTextColor = colorResource(id = R.color.blue_1),
            ChiliInAppPushBackgroundColor = colorResource(id = R.color.black_3),
            ChiliThickBottomSheetDragHandleColor = colorResource(id = R.color.black_5),
            ChiliBottomSheetDragHandleColor = colorResource(id = R.color.gray_3),
            ChiliNavBarSelectedItemColor = colorResource(id = R.color.folly_1),
            ChiliNavBarUnSelectedItemColor = colorResource(id = R.color.gray_1),
            ChiliNavBarItemBackgroundColor = colorResource(id = R.color.black_4),
            ChiliNavBarItemStrokeColor = colorResource(id = R.color.black_4),
            ChiliNavBarBackgroundColor = colorResource(id = R.color.black_4),
            ChiliQuickActionButtonTitleEnabledColor = colorResource(id = R.color.white_1),
            ChiliQuickActionButtonTitleDisabledColor = colorResource(id = R.color.gray_1),
            ChiliNavBarAlternativeSelectedItemColor = colorResource(id = R.color.white_1),
            ChiliNavBarAlternativeUnSelectedItemColor = colorResource(id = R.color.gray_1)
        )

        @Composable
        fun defaultLightColors(): ChiliColors = ChiliColors(
            ChiliPrimaryTextColor = colorResource(id = R.color.black_1),
            ChiliSecondaryTextColor = colorResource(id = R.color.black_4),
            ChiliMarkedTextColor = colorResource(id = R.color.black_1),
            ChiliErrorTextColor = colorResource(id = R.color.red_1),
            ChiliValueTextColor = colorResource(id = R.color.gray_1),
            ChiliLinkTextColor = colorResource(id = R.color.magenta_1),
            СhiliScreenBackground = colorResource(id = R.color.gray_4),
            ChiliSurfaceBackground = colorResource(id = R.color.white_1),
            СhiliRippleForegroundColor = colorResource(id = R.color.black_1_alpha_20),
            ChiliDividerColor = colorResource(id = R.color.gray_6),
            СhiliChevronColor = colorResource(id = R.color.gray_2),
            ChiliSnackbarBackground = colorResource(id = R.color.c_4a4a4a),
            ChiliSnackbarTextColor = colorResource(id = R.color.gray_3),
            СhiliSegmentedPickerBackgroundColor = colorResource(id = R.color.gray_6),
            СhiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.white_1),
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
            ChiliSecondaryButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            ChiliSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            ChiliSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonBackgroundActive = colorResource(id = R.color.gray_5),
            ChiliAdditionalButtonBackgroundDisabled = colorResource(id = R.color.gray_5),
            ChiliAdditionalButtonTextColorActive = colorResource(id = R.color.black_1),
            ChiliAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            ChiliAdditionalButtonTextColorDisabled = colorResource(id = R.color.gray_1_alpha_50),
            ChiliAdditionalButtonBorderColor = colorResource(id = R.color.gray_5),
            ChilicellSquircleIconBackground = colorResource(id = R.color.gray_3),
            ChiliCellBackground = colorResource(id = R.color.white_1),
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
            ChiliStartIconTopAppBarBackground = colorResource(R.color.white_1),
            ChiliToggleCellViewTrackColor = colorResource(id = R.color.gray_2),
            ChiliToggleCellViewThumbNormalColor = colorResource(id = R.color.white_1),
            ChiliToggleCellViewTextOnOffCheckedEnabledColor = colorResource(id = R.color.white_1),
            ChiliToggleCellViewTextOnOffCheckedDisabledColor = colorResource(id = R.color.black_1),
            ChiliCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            ChiliCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            ChiliCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            ChiliCodeInputItemBackgroundColor = colorResource(id = R.color.gray_5),
            ChiliCodeInputItemBorderColor = colorResource(id = R.color.magenta_1),
            ChiliCardErrorTextColor = colorResource(id = R.color.custom_red_3),
            ChiliCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_3),
            ChiliBottomSheetBackgroundColor = colorResource(id = R.color.white_1),
            ChiliBottomSheetGrayBackgroundColor = colorResource(id = R.color.gray_4),
            ChiliActionBottomSheetButtonTextColor = colorResource(id = R.color.black_4),
            ChiliActionBottomSheetAccentButtonTextColor = colorResource(id = R.color.blue_1),
            ChiliInAppPushBackgroundColor = colorResource(id = R.color.white_1),
            ChiliThickBottomSheetDragHandleColor = colorResource(id = R.color.gray_1),
            ChiliNavBarSelectedItemColor = colorResource(id = R.color.magenta_1),
            ChiliNavBarUnSelectedItemColor = colorResource(id = R.color.gray_1),
            ChiliBottomSheetDragHandleColor = colorResource(id = R.color.black_5),
            ChiliNavBarItemBackgroundColor = colorResource(id = R.color.white_1),
            ChiliNavBarItemStrokeColor = colorResource(id = R.color.c_ececec_alpha_30),
            ChiliNavBarBackgroundColor = colorResource(id = R.color.gray_9),
            ChiliQuickActionButtonTitleEnabledColor = colorResource(id = R.color.black_1),
            ChiliQuickActionButtonTitleDisabledColor = colorResource(id = R.color.gray_2),
            ChiliNavBarAlternativeSelectedItemColor = colorResource(id = R.color.magenta_1),
            ChiliNavBarAlternativeUnSelectedItemColor = colorResource(id = R.color.gray_1)
        )
    }
}