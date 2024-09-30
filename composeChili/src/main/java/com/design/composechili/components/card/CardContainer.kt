package com.design.composechili.components.card

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

/**
 * A container that represents a card view with an optional expandable content section.
 * The card features a title, an end icon, and an expandable section that can be toggled
 * by tapping on the card or a dedicated icon. The expansion state can be saved across
 * recompositions if needed.
 *
 * @param [modifier] Modifier to be applied to the card container.
 * @param [title] The title text displayed on the card.
 * @param [endIcon] Nullable drawable resource ID for the icon displayed at the end of the card if not null.
 * @param [isContentExpandedInitValue] If true, the expanded state is saved across recompositions,
 * meaning the card will remember its expanded/collapsed state.
 * @param [cardContainerParams] Contains the default properties for the card, such as shape, colors, and text style.
 * @param [expandableContent] The composable content that will be shown when the card is expanded.
 *
 * @sample CardContainer_Preview
 */

@Composable
fun CardContainer(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes endIcon: Int? = null,
    isContentExpandedInitValue: Boolean,
    cardContainerParams: CardContainerParams,
    expandableContent: @Composable () -> Unit,
) {

    var isContentExpandedState by rememberSaveable {
        mutableStateOf(isContentExpandedInitValue)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (isContentExpandedState) 90f else 0f, label = ""
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = cardContainerParams.shape,
        colors = cardContainerParams.colors,
        onClick = {
            isContentExpandedState = isContentExpandedState.not()
        }) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_8dp))
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier,
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = cardContainerParams.titleStyle
                )
                IconButton(
                    modifier = Modifier.rotate(rotationState),
                    onClick = {
                        isContentExpandedState = isContentExpandedState.not()
                    }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.chili_ic_chevron),
                        contentDescription = "Drop-Down Arrow"
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                if (endIcon != null)
                    Image(
                        modifier = Modifier.size(dimensionResource(id = R.dimen.view_32dp)),
                        imageVector = ImageVector.vectorResource(id = endIcon),
                        contentDescription = null
                    )
            }
            if (isContentExpandedState) {
                expandableContent()
            }
        }
    }
}

@Preview
@Composable
fun CardContainer_Preview() {
    ChiliTheme {
        CardContainer(
            title = "AccentCardView",
            endIcon = R.drawable.ic_visa_banner_logo,
            cardContainerParams = CardContainerParams.Filled,
            isContentExpandedInitValue = false,
            expandableContent = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    AccentCard(
                        title = "Сканнер штрих кодов и QR",
                        description = "Для удобной оплаты\nбез ввода реквизитов",
                        endIcon = painterResource(id = R.drawable.pay),
                        cardParams = AccentCardParams.accentCardFucsia,
                        startIcon = null
                    ) {

                    }
                    AccentCard(
                        title = "Цифровая карта",
                        description = "Для бесконтактных платежей",
                        endIcon = null,
                        startIcon = painterResource(id = R.drawable.icon_k),
                        cardParams = AccentCardParams.accentCardBlack,
                    ) {

                    }
                    AccentCard(
                        title = "Цифровая карта",
                        description = "Для бесконтактных платежей",
                        endIcon = painterResource(id = R.drawable.ic_scaner_48),
                        startIcon = null,
                        cardParams = AccentCardParams.accentCardWhite,
                    ) {

                    }
                }
            }
        )
    }
}