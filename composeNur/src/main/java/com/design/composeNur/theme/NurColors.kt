package com.design.composeNur.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.design.composenur.R

@Immutable
data class NurColors(
    val NurPrimaryTextColor: Color,
    val NurSecondaryTextColor: Color,
    val NurMarkedTextColor: Color,
    val NurErrorTextColor: Color,
    val NurValueTextColor: Color,
    val NurLinkTextColor: Color,

    // Screen Background
    val СhiliScreenBackground: Color,
    val NurSurfaceBackground: Color,

    // Ripple
    val СhiliRippleForegroundColor: Color,

    // Divider
    val NurDividerColor: Color,

    // Chevron
    val СhiliChevronColor: Color,

    // Snackbar
    val NurSnackbarBackground: Color,
    val NurSnackbarTextColor: Color,

    // Segmented Picker
    val СhiliSegmentedPickerBackgroundColor: Color,
    val СhiliSegmentedPickerTabIndicatorColor: Color,
    val NurSegmentedPickerTabTextColor: Color,

    // CheckBox
    val NurCheckBoxCheckedColor: Color,
    val NurCheckedBoxUncheckedColor: Color,
    val NurCheckBoxDisabledColor: Color,

    //Switch
    val NurSwitchBoxCheckedBackground: Color,
    val NurSwitchBoxUncheckedBackground: Color,
    val NurSwitchBoxCheckedToggleColor: Color,
    val NurSwitchBoxUncheckedToggleColor: Color,

    // Primary Button
    val NurPrimaryButtonBackgroundActive: Color,
    val NurPrimaryButtonBackgroundDisabled: Color,
    val NurPrimaryButtonTextColorActive: Color,
    val NurPrimaryButtonTextColorPressed: Color,
    val NurPrimaryButtonTextColorDisabled: Color,

    val NurPrimaryButtonRippleColor: Color,
    val NurPrimaryButtonBorderColor: Color,

    // Secondary Button
    val NurSecondaryButtonBackgroundActive: Color,
    val NurSecondaryButtonBackgroundDisabled: Color,
    val NurSecondaryButtonTextColorActive: Color,
    val NurSecondaryButtonTextColorPressed: Color,
    val NurSecondaryButtonTextColorDisabled: Color,

    // Additional Button
    val NurAdditionalButtonBackgroundActive: Color,
    val NurAdditionalButtonBackgroundDisabled: Color,
    val NurAdditionalButtonTextColorActive: Color,
    val NurAdditionalButtonTextColorPressed: Color,
    val NurAdditionalButtonTextColorDisabled: Color,
    val NurAdditionalButtonBorderColor: Color,

    // Component Button Attributes
    val NurComponentButtonBackgroundActive: Color,
    val NurComponentButtonBackgroundDisabled: Color,
    val NurComponentButtonTextColorActive: Color,
    val NurComponentButtonTextColorPressed: Color,
    val NurComponentButtonTextColorDisabled: Color,

    // Nur Card View
    val NurCardViewBackground: Color,

    // Accent Button Attributes
    val NurAccentButtonBackgroundActive: Color,
    val NurAccentButtonBackgroundDisabled: Color,

    // Cell View
    val NurCellBackground: Color,
    val NurcellSquircleIconBackground: Color,

    // ToggleCellView
    val NurToggleCellViewTrackColor: Color,
    val NurToggleCellViewThumbNormalColor: Color,
    val NurToggleCellViewTextOnOffCheckedEnabledColor: Color,
    val NurToggleCellViewTextOnOffCheckedDisabledColor: Color,

    val NurTooltipBackground: Color,


    // TopAppBar
    val NurTopAppBarDividerColor: Color,
    val NurTopAppBarIconsTint: Color,
    val NurTopAppBarBackground: Color,
    val NurStartIconTopAppBarBackground: Color,

    val NurInputEndIconTint: Color,
    val NurInputHintTextColor: Color,
    val NurInputViewBackgroundColor: Color,
    val NurInputViewBackgroundErrorColor: Color,
    val NurInputViewCursorColor: Color,
    val NurInputViewErrorMessageTextColor: Color,

    // Code Input View
    val NurCodeInputViewMessageColor: Color,
    val NurCodeInputViewActionTextActiveColor: Color,
    val NurCodeInputViewActionTextInActiveColor: Color,
    val NurCodeInputItemBorderColor: Color,
    val NurCodeInputItemBackgroundColor: Color,
    val NurCodeInputItemErrorBackgroundColor: Color,

    // NavBar
    val NurNavBarSelectedItemColor: Color,
    val NurNavBarUnSelectedItemColor: Color,

    val NurNavBarAlternativeSelectedItemColor: Color,
    val NurNavBarAlternativeUnSelectedItemColor: Color,

    val NurNavBarItemBackgroundColor: Color,
    val NurNavBarItemStrokeColor: Color,
    val NurNavBarBackgroundColor: Color,

    // Bottom Sheet
    val NurBottomSheetBackgroundColor: Color,
    val NurBottomSheetGrayBackgroundColor: Color,

    // Card Cell View
    val NurCardErrorTextColor: Color,

    // Action Bottom Sheet
    val NurActionBottomSheetButtonTextColor: Color,
    val NurActionBottomSheetAccentButtonTextColor: Color,

    // In App Push
    val NurInAppPushBackgroundColor: Color,

    // Bottom Sheet Drag Handle line color
    val NurThickBottomSheetDragHandleColor: Color,
    val NurBottomSheetDragHandleColor: Color,

    // NurQuickActionButton
    val NurQuickActionButtonTitleEnabledColor: Color,
    val NurQuickActionButtonTitleDisabledColor: Color,

    val NurLoaderColor: Color
) {

    companion object {
        @Composable
        fun defaultDarkColors(): NurColors = NurColors(
            NurPrimaryTextColor = colorResource(id = R.color.white_1),
            NurSecondaryTextColor = colorResource(id = R.color.gray_3),
            NurMarkedTextColor = colorResource(id = R.color.white_1),
            NurErrorTextColor = colorResource(id = R.color.red_1),
            NurValueTextColor = colorResource(id = R.color.gray_1),
            NurLinkTextColor = colorResource(id = R.color.magenta_1),
            СhiliScreenBackground = colorResource(id = R.color.black_2),
            NurSurfaceBackground = colorResource(id = R.color.black_1),
            СhiliRippleForegroundColor = colorResource(id = R.color.gray_1_alpha_50),
            NurDividerColor = colorResource(id = R.color.black_4),
            СhiliChevronColor = colorResource(id = R.color.white_1),
            NurSnackbarTextColor = colorResource(id = R.color.gray_3),
            NurSnackbarBackground = colorResource(id = R.color.c_4a4a4a),
            СhiliSegmentedPickerBackgroundColor = colorResource(id = R.color.black_4),
            СhiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.black_3),
            NurSegmentedPickerTabTextColor = colorResource(id = R.color.gray_3),
            NurCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            NurCheckBoxDisabledColor = colorResource(id = R.color.gray_1_alpha_50),
            NurCheckedBoxUncheckedColor = colorResource(id = R.color.gray_3),
            NurSwitchBoxCheckedBackground = colorResource(id = R.color.magenta_1_alpha_40),
            NurSwitchBoxUncheckedBackground = colorResource(id = R.color.black_5),
            NurSwitchBoxCheckedToggleColor = colorResource(id = R.color.magenta_1),
            NurSwitchBoxUncheckedToggleColor = colorResource(id = R.color.black_3),
            NurPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            NurPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_2),
            NurPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            NurPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            NurPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            NurPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            NurPrimaryButtonBorderColor = Color.Transparent,
            NurSecondaryButtonBackgroundActive = Color.Transparent,
            NurSecondaryButtonBackgroundDisabled = Color.Transparent,
            NurSecondaryButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            NurSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            NurSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            NurAdditionalButtonBackgroundActive = colorResource(id = R.color.black_5),
            NurAdditionalButtonBackgroundDisabled = colorResource(id = R.color.black_5),
            NurAdditionalButtonTextColorActive = colorResource(id = R.color.white_1),
            NurAdditionalButtonTextColorDisabled = colorResource(id = R.color.gray_1_alpha_50),
            NurAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            NurAdditionalButtonBorderColor = colorResource(id = R.color.black_5),
            NurCellBackground = colorResource(id = R.color.black_3),
            NurcellSquircleIconBackground = colorResource(id = R.color.black_2),
            NurComponentButtonBackgroundActive = Color.Transparent,
            NurComponentButtonBackgroundDisabled = Color.Transparent,
            NurComponentButtonTextColorActive = colorResource(id = R.color.blue_1),
            NurComponentButtonTextColorPressed = colorResource(id = R.color.blue_1),
            NurComponentButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            NurAccentButtonBackgroundActive = colorResource(id = R.color.magenta_1),
            NurAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            NurTooltipBackground = colorResource(id = R.color.black_3),
            NurTopAppBarDividerColor = colorResource(id = R.color.black_4),
            NurTopAppBarIconsTint = colorResource(id = R.color.white_1),
            NurTopAppBarBackground = colorResource(id = R.color.black_3),
            NurStartIconTopAppBarBackground = colorResource(R.color.black_1),
            NurToggleCellViewTrackColor = colorResource(id = R.color.black_4),
            NurToggleCellViewThumbNormalColor = colorResource(id = R.color.black_5),
            NurToggleCellViewTextOnOffCheckedEnabledColor = colorResource(id = R.color.white_1),
            NurToggleCellViewTextOnOffCheckedDisabledColor = colorResource(id = R.color.black_1),
            NurCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            NurCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            NurCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            NurCodeInputItemBackgroundColor = colorResource(id = R.color.black_4),
            NurCodeInputItemBorderColor = colorResource(id = R.color.white_1),
            NurCardErrorTextColor = colorResource(id = R.color.custom_red_3),
            NurCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_2),
            NurBottomSheetBackgroundColor = colorResource(id = R.color.black_3),
            NurBottomSheetGrayBackgroundColor = colorResource(id = R.color.black_2),
            NurActionBottomSheetButtonTextColor = colorResource(id = R.color.gray_3),
            NurActionBottomSheetAccentButtonTextColor = colorResource(id = R.color.blue_1),
            NurInAppPushBackgroundColor = colorResource(id = R.color.black_3),
            NurThickBottomSheetDragHandleColor = colorResource(id = R.color.black_5),
            NurBottomSheetDragHandleColor = colorResource(id = R.color.gray_3),
            NurNavBarSelectedItemColor = colorResource(id = R.color.folly_1),
            NurNavBarUnSelectedItemColor = colorResource(id = R.color.gray_1),
            NurNavBarItemBackgroundColor = colorResource(id = R.color.black_4),
            NurNavBarItemStrokeColor = colorResource(id = R.color.black_4),
            NurNavBarBackgroundColor = colorResource(id = R.color.black_4),
            NurQuickActionButtonTitleEnabledColor = colorResource(id = R.color.white_1),
            NurQuickActionButtonTitleDisabledColor = colorResource(id = R.color.gray_1),
            NurNavBarAlternativeSelectedItemColor = colorResource(id = R.color.white_1),
            NurNavBarAlternativeUnSelectedItemColor = colorResource(id = R.color.gray_1),

            NurInputEndIconTint = colorResource(id = R.color.gray_1),
            NurInputHintTextColor = colorResource(id = R.color.gray_1_alpha_50),
            NurInputViewBackgroundColor = colorResource(id = R.color.black_3),
            NurInputViewBackgroundErrorColor = colorResource(id = R.color.red_2),
            NurInputViewCursorColor = colorResource(id = R.color.magenta_1),
            NurInputViewErrorMessageTextColor = colorResource(id = R.color.red_1),
            NurCardViewBackground = colorResource(id = R.color.black_3),
            NurLoaderColor = colorResource(id = R.color.magenta_1)
        )

        @Composable
        fun defaultLightColors(): NurColors = NurColors(
            NurPrimaryTextColor = colorResource(id = R.color.black_1),
            NurSecondaryTextColor = colorResource(id = R.color.black_4),
            NurMarkedTextColor = colorResource(id = R.color.black_1),
            NurErrorTextColor = colorResource(id = R.color.red_1),
            NurValueTextColor = colorResource(id = R.color.gray_1),
            NurLinkTextColor = colorResource(id = R.color.magenta_1),
            СhiliScreenBackground = colorResource(id = R.color.gray_4),
            NurSurfaceBackground = colorResource(id = R.color.white_1),
            СhiliRippleForegroundColor = colorResource(id = R.color.black_1_alpha_20),
            NurDividerColor = colorResource(id = R.color.gray_6),
            СhiliChevronColor = colorResource(id = R.color.gray_2),

            NurSnackbarBackground = colorResource(id = R.color.c_4a4a4a),
            NurSnackbarTextColor = colorResource(id = R.color.gray_3),

            СhiliSegmentedPickerBackgroundColor = colorResource(id = R.color.gray_6),
            СhiliSegmentedPickerTabIndicatorColor = colorResource(id = R.color.white_1),
            NurSegmentedPickerTabTextColor = colorResource(id = R.color.black_5),

            NurCheckBoxCheckedColor = colorResource(id = R.color.magenta_1),
            NurCheckedBoxUncheckedColor = colorResource(id = R.color.black_5),
            NurCheckBoxDisabledColor = colorResource(id = R.color.gray_2),

            NurSwitchBoxCheckedBackground = colorResource(id = R.color.magenta_1_alpha_40),
            NurSwitchBoxUncheckedBackground = colorResource(id = R.color.gray_2),
            NurSwitchBoxCheckedToggleColor = colorResource(id = R.color.magenta_1),
            NurSwitchBoxUncheckedToggleColor = colorResource(id = R.color.white_1),

            NurPrimaryButtonBackgroundActive = colorResource(id = R.color.green_1),
            NurPrimaryButtonBackgroundDisabled = colorResource(id = R.color.green_3),
            NurPrimaryButtonTextColorActive = colorResource(id = R.color.white_1),
            NurPrimaryButtonTextColorDisabled = colorResource(id = R.color.white_1),
            NurPrimaryButtonTextColorPressed = colorResource(id = R.color.white_1),
            NurPrimaryButtonRippleColor = colorResource(id = R.color.black_1_alpha_20),
            NurPrimaryButtonBorderColor = Color.Transparent,
            NurSecondaryButtonBackgroundActive = Color.Transparent,
            NurSecondaryButtonBackgroundDisabled = Color.Transparent,
            NurSecondaryButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            NurSecondaryButtonTextColorActive = colorResource(id = R.color.blue_1),
            NurSecondaryButtonTextColorPressed = colorResource(id = R.color.gray_1),
            NurAdditionalButtonBackgroundActive = colorResource(id = R.color.gray_5),
            NurAdditionalButtonBackgroundDisabled = colorResource(id = R.color.gray_5),
            NurAdditionalButtonTextColorActive = colorResource(id = R.color.black_1),
            NurAdditionalButtonTextColorPressed = colorResource(id = R.color.gray_1),
            NurAdditionalButtonTextColorDisabled = colorResource(id = R.color.gray_1_alpha_50),
            NurAdditionalButtonBorderColor = colorResource(id = R.color.gray_5),
            NurcellSquircleIconBackground = colorResource(id = R.color.gray_3),
            NurCellBackground = colorResource(id = R.color.white_1),
            NurComponentButtonBackgroundActive = Color.Transparent,
            NurComponentButtonBackgroundDisabled = Color.Transparent,
            NurComponentButtonTextColorActive = colorResource(id = R.color.blue_1),
            NurComponentButtonTextColorPressed = colorResource(id = R.color.blue_1),
            NurComponentButtonTextColorDisabled = colorResource(id = R.color.blue_1_alpha_50),
            NurAccentButtonBackgroundActive = colorResource(id = R.color.magenta_1),
            NurAccentButtonBackgroundDisabled = colorResource(id = R.color.magenta_3),
            NurTooltipBackground = colorResource(id = R.color.black_3),
            NurTopAppBarDividerColor = colorResource(id = R.color.gray_8),
            NurTopAppBarIconsTint = colorResource(id = R.color.black_1),
            NurTopAppBarBackground = colorResource(id = R.color.white_1),
            NurStartIconTopAppBarBackground = colorResource(R.color.white_1),

            NurToggleCellViewTrackColor = colorResource(id = R.color.gray_2),
            NurToggleCellViewThumbNormalColor = colorResource(id = R.color.white_1),
            NurToggleCellViewTextOnOffCheckedEnabledColor = colorResource(id = R.color.white_1),
            NurToggleCellViewTextOnOffCheckedDisabledColor = colorResource(id = R.color.black_1),

            NurCodeInputViewMessageColor = colorResource(id = R.color.red_1),
            NurCodeInputViewActionTextActiveColor = colorResource(id = R.color.blue_1),
            NurCodeInputViewActionTextInActiveColor = colorResource(id = R.color.gray_1),
            NurCodeInputItemBackgroundColor = colorResource(id = R.color.gray_5),
            NurCodeInputItemBorderColor = colorResource(id = R.color.magenta_1),
            NurCardErrorTextColor = colorResource(id = R.color.custom_red_3),
            NurCodeInputItemErrorBackgroundColor = colorResource(id = R.color.red_3),

            NurBottomSheetBackgroundColor = colorResource(id = R.color.white_1),
            NurBottomSheetGrayBackgroundColor = colorResource(id = R.color.gray_4),

            NurActionBottomSheetButtonTextColor = colorResource(id = R.color.black_4),
            NurActionBottomSheetAccentButtonTextColor = colorResource(id = R.color.blue_1),

            NurInAppPushBackgroundColor = colorResource(id = R.color.white_1),
            NurThickBottomSheetDragHandleColor = colorResource(id = R.color.gray_1),

            NurNavBarSelectedItemColor = colorResource(id = R.color.magenta_1),
            NurNavBarUnSelectedItemColor = colorResource(id = R.color.gray_1),
            NurBottomSheetDragHandleColor = colorResource(id = R.color.black_5),
            NurNavBarItemBackgroundColor = colorResource(id = R.color.white_1),
            NurNavBarItemStrokeColor = colorResource(id = R.color.c_ececec_alpha_30),
            NurNavBarBackgroundColor = colorResource(id = R.color.gray_9),

            NurNavBarAlternativeSelectedItemColor = colorResource(id = R.color.magenta_1),
            NurNavBarAlternativeUnSelectedItemColor = colorResource(id = R.color.gray_1),

            NurQuickActionButtonTitleEnabledColor = colorResource(id = R.color.black_1),
            NurQuickActionButtonTitleDisabledColor = colorResource(id = R.color.gray_2),

            NurInputEndIconTint = colorResource(id = R.color.gray_1),
            NurInputHintTextColor = colorResource(id = R.color.gray_1_alpha_50),
            NurInputViewBackgroundColor = colorResource(id = R.color.gray_5),
            NurInputViewBackgroundErrorColor = colorResource(id = R.color.red_3),
            NurInputViewCursorColor = colorResource(id = R.color.magenta_1),
            NurInputViewErrorMessageTextColor = colorResource(id = R.color.red_1),
            NurCardViewBackground = colorResource(id = R.color.white_1),
            NurLoaderColor = colorResource(id = R.color.magenta_1)
        )

    }
}