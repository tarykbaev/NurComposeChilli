package com.design.composeNur.components.buttons.quickActionButton

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.utils.pressEffect
import com.design.composeNur.utils.rememberPressState
import com.design.composenur.R

/**
 * A composable function that creates a customizable quick action button with an icon and title.
 * Supports normal, pressed, and disabled states with corresponding icons for each state.
 *
 * @param title A [String] representing the text label displayed below the button icon. This parameter is required.
 *
 * @param icon An optional drawable resource ID for the default icon of the button. If `null`, no icon will be shown
 * unless `disabledIcon` or `rippleIcon` is provided for specific states.
 *
 * @param rippleIcon An optional drawable resource ID for the icon shown when the button is pressed. If `null`,
 * the default `icon` will be used when pressed.
 *
 * @param disabledIcon An optional drawable resource ID for the icon shown when the button is disabled. If `null`,
 * the default `icon` will be used when the button is disabled.
 *
 * @param enabled A [Boolean] indicating whether the button is enabled or disabled. Defaults to `true`.
 * When `false`, the `disabledIcon` is used, and the button is not clickable.
 *
 *  @param visible Controls the visibility of the QuickActionButton.
 *  If false, the button will not be rendered.
 *
 * @param params An instance of [NurQuickActionButtonParams] to configure additional
 * parameters for the button, such as icon size and text style. Defaults to [NurQuickActionButtonParams.Default].
 *
 * @param onClick An optional lambda function that is invoked when the button is clicked. If `null`,
 * no click action will be performed.
 */
@Composable
fun NurQuickActionButton(
    modifier: Modifier = Modifier
        .wrapContentSize(),
    title: String,
    @DrawableRes icon: Int = R.drawable.transparent_placeholder,
    @DrawableRes rippleIcon: Int? = null,
    @DrawableRes disabledIcon: Int? = null,
    enabled: Boolean = true,
    visible: Boolean = true,
    params: NurQuickActionButtonParams = NurQuickActionButtonParams.Default,
    onClick: (() -> Unit)? = null
) {

    if (!visible) return

    val isPressed = rememberPressState()

    val currentIcon = when {
        !enabled -> disabledIcon ?: icon
        isPressed.value -> rippleIcon ?: icon
        else -> icon
    }

    Column(
        modifier = modifier
            .then(
                if (enabled) {
                    Modifier.pressEffect(
                        pointerInputKey = "quickActionButton",
                        isPressedState = isPressed
                    ) {
                        onClick?.invoke()
                    }
                } else {
                    Modifier
                }
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(params.iconSize),
            painter = painterResource(currentIcon),
            contentDescription = "icon"
        )

        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_8dp)))

        Text(
            modifier = Modifier.wrapContentSize(),
            text = title,
            style = if (enabled) {
                params.titleEnabledTextStyle
            } else {
                params.titleDisabledTextStyle
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun QuickActionButtonPreview() {
    NurTheme {
        Row {
            NurQuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = R.drawable.ic_favourite,
                rippleIcon = R.drawable.ic_ripple_favourite,
                disabledIcon = R.drawable.ic_favourite_disabled
            ) {}
            Spacer(modifier = Modifier.size(12.dp))
            NurQuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                enabled = false,
                icon = R.drawable.ic_favourite,
                rippleIcon = R.drawable.ic_ripple_favourite,
                disabledIcon = R.drawable.ic_favourite_disabled
            ) {}
        }
    }
}