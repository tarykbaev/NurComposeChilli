package com.design.composeNur.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

/**
 * A customizable accent card that displays a title, description, and optional icons.
 * The card can be clicked to trigger an action. It supports setting start and end icons
 * with custom colors and styles.
 *
 * @param [title] The main title text displayed on the card.
 * @param [description] The descriptive text displayed below the title.
 * @param [startIcon] Optional drawable resource ID for the icon displayed at the start of the card.
 * @param [endIcon] Optional drawable resource ID for the icon displayed at the end of the card.
 * @param [cardParams] The colors used for the card, provided by the [AccentCardParams].
 * @param [onClick] Callback triggered when the card is clicked.
 *
 * @sample AccentCardPreview
 */

@Composable
fun AccentCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    startIcon: Painter? = null,
    endIcon: Painter? = null,
    cardParams: AccentCardParams,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    dimensionResource(id = R.dimen.radius_12dp)
                )
            )
            .background(
                color = cardParams.containerColor
            )
            .clickable(interactionSource = remember {
                MutableInteractionSource()
            }, indication = LocalIndication.current, onClick = onClick)
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
            .padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
    ) {
        Column(modifier = Modifier.weight(3f)) {
            Row {
                if (startIcon != null)
                    Image(
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_4dp)),
                        painter = startIcon,
                        contentDescription = null
                    )
                Text(
                    text = title,
                    style = cardParams.titleStyle
                )
            }
            Text(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
                text = description,
                style = cardParams.descriptionStyle
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        if (endIcon != null)
            Image(
                modifier = Modifier.size(dimensionResource(id = R.dimen.view_56dp)),
                painter = endIcon,
                contentDescription = null
            )
    }
}

@Preview
@Composable
fun AccentCardPreview() {
    NurTheme {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
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
}

data class AccentCardParams(
    val containerColor: Color,
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
) {
    companion object {
        val accentCardFucsia
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.folly_1),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                )
            )
        val accentCardBlack
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.black_4),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.white_1)
                )
            )
        val accentCardWhite
            @Composable get() = AccentCardParams(
                containerColor = colorResource(id = R.color.white_1),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.black_1)
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    font = NurTheme.Attribute.NurRegularTextFont,
                    color = colorResource(id = R.color.black_1)
                )
            )
    }
}