package com.design.composechili.components.buttons.quickActionButton

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

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
 * @param chiliQuickActionButtonParams An instance of [ChiliQuickActionButtonParams] to configure additional
 * parameters for the button, such as icon size and text style. Defaults to [ChiliQuickActionButtonParams.Default].
 *
 * @param onClick An optional lambda function that is invoked when the button is clicked. If `null`,
 * no click action will be performed.
 */
@Composable
fun QuickActionButton(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int? = null,
    @DrawableRes rippleIcon: Int? = null,
    @DrawableRes disabledIcon: Int? = null,
    enabled: Boolean = true,
    chiliQuickActionButtonParams: ChiliQuickActionButtonParams = ChiliQuickActionButtonParams.Default,
    onClick: (() -> Unit)? = null
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val currentIcon = when {
        !enabled -> disabledIcon ?: icon
        isPressed -> rippleIcon ?: icon
        else -> icon
    }

    ChiliTheme {
        Column(
            modifier = modifier
                .wrapContentSize()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    enabled = enabled,
                    onClick = { onClick?.invoke() }
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(chiliQuickActionButtonParams.iconSize),
                painter = painterResource(currentIcon ?: R.drawable.transparent_placeholder),
                contentDescription = "icon"
            )

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_8dp)))

            Text(
                modifier = Modifier.wrapContentSize(),
                text = title,
                style = if (enabled) {
                    chiliQuickActionButtonParams.titleEnabledTextStyle
                } else {
                    chiliQuickActionButtonParams.titleDisabledTextStyle
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickActionButtonPreview() {
    ChiliTheme {
        Row {
            QuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = R.drawable.ic_favourite,
                rippleIcon = R.drawable.ic_ripple_favourite,
                disabledIcon = R.drawable.ic_favourite_disabled
            ) {

            }

            Spacer(modifier = Modifier.size(12.dp))
            QuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                enabled = false,
                icon = R.drawable.ic_favourite,
                rippleIcon = R.drawable.ic_ripple_favourite,
                disabledIcon = R.drawable.ic_favourite_disabled
            ) {

            }
        }
    }
}