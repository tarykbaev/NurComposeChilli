package com.design.composechili.components.cell.cardCell

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

/**
 * Cell view component used for brief card information presentation.
 * Contains start icon, title, subtitle and value.
 * Has special states such as blocked, unique and main.
 * @param [icon] accepts [DrawableRes] and shown at the start of the cell
 * @param [title] accepts [String] and shown after [icon] at the start of the cell
 * @param [subtitle] accepts [String] and shown at the start of the cell and below [title]
 * @param [value] accepts [String] and shown at the end of the cell
 * @param [isBlocked] sets alpha value to [title] and [value], adds overlay and overlay icon on top of [icon], sets specific error color to [subtitle] text
 * @param [isMain] adds a star icon next to [title]
 * @param [isUniqueStated] sets specific error color to [subtitle] and [value] text
 * @param [isSurfaceClickable] sets clicking animation on surface enabled/disabled
 * @param [onClickListener] called when surface of cell is clicked
 * @param [cardCellParams] cell's visual transformation params and paddings
 * @sample CardCellParams.Default
 */

@Composable
fun CardCell(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    title: String,
    subtitle: String = String(),
    value: String? = null,
    isBlocked: Boolean = false,
    isMain: Boolean = false,
    isUniqueStated: Boolean = false,
    isSurfaceClickable: Boolean = true,
    cardCellParams: CardCellParams = CardCellParams.Default,
    onClickListener: () -> Unit = {}
) {
    Box(
        Modifier
            .clip(cardCellParams.cornerMode.toRoundedShape())
            .background(ChiliTheme.Colors.ChiliCellBackground)
            .clickable(isSurfaceClickable) { onClickListener() }
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val alpha = when (isBlocked) {
                true -> cardCellParams.overlayAlpha
                else -> 1f
            }

            Box(
                modifier = Modifier
                    .padding(cardCellParams.iconPadding.toPaddingValues())
                    .align(Alignment.CenterVertically)
                    .size(
                        width = cardCellParams.iconWidth,
                        height = cardCellParams.iconHeight
                    )
            ) {
                if (icon != null) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = "Card Cell Icon"
                    )
                }
                if (isBlocked) {
                    Image(
                        painter = painterResource(id = cardCellParams.overlayRes),
                        alpha = alpha,
                        contentDescription = "Card cell icon overlay"
                    )
                    Image(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(dimensionResource(id = R.dimen.view_18dp)),
                        painter = painterResource(id = cardCellParams.overlayIconRes),
                        contentDescription = "Overlay icon"
                    )
                }
            }
            Column(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .padding(end = dimensionResource(id = R.dimen.padding_16dp))
            ) {

                val cellBottomPadding = if (subtitle.isBlank()) {
                    dimensionResource(id = R.dimen.padding_12dp)
                } else {
                    dimensionResource(id = R.dimen.padding_4dp)
                }

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .alpha(alpha)
                        .padding(
                            cardCellParams.titlePadding
                                .copy(bottom = cellBottomPadding)
                                .toPaddingValues()
                        )
                ) {
                    Text(
                        text = title,
                        maxLines = cardCellParams.titleMaxLines,
                        style = cardCellParams.titleTextStyle,
                    )

                    if (isMain) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = dimensionResource(id = R.dimen.padding_4dp))
                                .size(dimensionResource(id = R.dimen.view_14dp)),
                            painter = painterResource(id = R.drawable.chili_ic_star),
                            contentDescription = "Icon for the main cell"
                        )
                    }
                }

                if (subtitle.isNotBlank()) {
                    val textColor = when {
                        isBlocked -> ChiliTheme.Colors.ChiliCardErrorTextColor
                        isUniqueStated -> ChiliTheme.Colors.ChiliCardErrorTextColor
                        else -> ChiliTheme.Colors.ChiliSecondaryTextColor
                    }

                    Text(
                        text = subtitle,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(cardCellParams.subtitlePadding.toPaddingValues()),
                        maxLines = cardCellParams.subtitleMaxLines,
                        color = textColor,
                        style = cardCellParams.subtitleTextStyle
                    )
                }
            }
            if (value != null) {
                val textColor = when {
                    isUniqueStated -> ChiliTheme.Colors.ChiliCardErrorTextColor
                    else -> ChiliTheme.Colors.ChiliSecondaryTextColor
                }

                Text(
                    modifier = Modifier
                        .alpha(alpha)
                        .padding(cardCellParams.valuePadding.toPaddingValues()),
                    text = value,
                    textAlign = TextAlign.End,
                    color = textColor,
                    maxLines = cardCellParams.valueMaxLines,
                    style = cardCellParams.valueTextStyle
                )
            }

            if (cardCellParams.isChevronVisible) {
                Icon(
                    modifier = Modifier
                        .alpha(alpha)
                        .padding(end = dimensionResource(R.dimen.padding_12dp)),
                    imageVector = ImageVector.vectorResource(id = R.drawable.chili_ic_chevron),
                    contentDescription = "Chevron"
                )
            }
        }
    }
}

@Preview
@Composable
fun CardCellViewPreviewLight() {
    ChiliTheme {
        CardCell(
            icon = R.drawable.ic_deposit,
            cardCellParams = CardCellParams.Default.copy(
                iconWidth = dimensionResource(id = R.dimen.view_32dp),
                iconHeight = dimensionResource(id = R.dimen.view_32dp)
            ),
            title = "Title",
            subtitle = "Subtitle",
            value = "Value"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CardCellViewPreview() {
    ChiliTheme {
        CardCell(
            icon = R.drawable.chili_ic_card_default,
            title = "Title",
            subtitle = "Subtitle",
            isBlocked = true,
            value = "Value"
        )
    }
}