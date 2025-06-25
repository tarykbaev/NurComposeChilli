package com.design.composeNur.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.extensions.gradientBackground
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A customizable banner card component for promotional content in Jetpack Compose.
 *
 * This component displays a title, subtitle, an optional start icon, and an optional
 * right-side image. Additionally, you can control the visibility of a chevron icon and
 * provide a click action. It is also styled with a gradient background that supports
 * customizable colors, an angle, and rounded corners.
 *
 * @param modifier The modifier to be applied to the card layout.
 * @param title The primary text to display on the card.
 * @param subtitle The secondary text to display below the title.
 * @param startIcon An optional resource ID for the icon displayed at the start of the card.
 * @param rightImage An optional resource ID for the image displayed at the right side of the card.
 * @param chevronVisible Determines whether the chevron icon at the end of the card is visible.
 * @param promoBannerCardParams An instance of [PromoBannerCardParams] to configure styles like
 * title, subtitle, icon sizes, and background colors.
 * @param onClick A lambda function that is invoked when the card is clicked.
 *
 * Example usage:
 * ```
 * PromoBannerCard(
 *   title = "Virtual Card",
 *   subtitle = "Open for free in the app!",
 *   startIcon = R.drawable.ic_card_logo,
 *   rightImage = R.drawable.bg_virtual_card,
 *   promoBannerCardParams = PromoBannerCardParams.Regular,
 *   onClick = { /* Handle click */ }
 * )
 */

@Composable
fun PromoBannerCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    startIcon: Painter? = null,
    rightImage: Painter? = null,
    chevronVisible: Boolean = true,
    promoBannerCardParams: PromoBannerCardParams,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .gradientBackground(
                colors = promoBannerCardParams.backgroundColors,
                angle = 135f,
                cornerRadius = dimensionResource(id = R.dimen.radius_12dp)
            )
            .clip(RoundedCornerShape(corner = CornerSize(12.dp)))
            .clickable(interactionSource = remember {
                MutableInteractionSource()
            }, indication = LocalIndication.current, onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(start = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (startIcon != null) {
                    Image(
                        painter = startIcon,
                        contentDescription = null,
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 8.dp),
                    text = title,
                    style = promoBannerCardParams.titleStyle,
                )
            }
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = subtitle,
                style = promoBannerCardParams.subtitleStyle
            )
        }
        Box {
            if (rightImage != null) {
                Image(
                    painter = rightImage,
                    contentDescription = null,
                )
            }
            if (chevronVisible) {
                Image(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    painter = painterResource(id = R.drawable.nur_ic_chevron),
                    contentDescription = "Chevron",
                )
            }
        }
    }
}

@Preview
@Composable
fun PromoCardPreview() {
    NurTheme {
        PromoBannerCard(
            title = "Виртуальная карта",
            subtitle = "Открой бесплатно в приложении!",
            startIcon = painterResource(id = R.drawable.ic_visa_banner_logo),
            rightImage = painterResource(id = R.drawable.bg_virtual_cards_3),
            promoBannerCardParams = PromoBannerCardParams.Regular
        ) {}
    }
}

@Preview
@Composable
fun PromoCardPreview2() {
    NurTheme {
        PromoBannerCard(
            title = "Карта ЭЛКАРТ",
            subtitle = "Откройте карту в О!Store",
            startIcon = painterResource(id = R.drawable.ic_elcart_title_logo),
            rightImage = painterResource(id = R.drawable.bg_virtual_cards_2),
            promoBannerCardParams = PromoBannerCardParams.Small
        ) {}
    }
}