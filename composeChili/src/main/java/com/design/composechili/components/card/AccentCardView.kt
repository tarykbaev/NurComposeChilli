package com.design.composechili.components.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A customizable accent card view that displays a title, description, and optional icons.
 * The card can be clicked to trigger an action. It supports setting start and end icons
 * with custom colors and styles.
 *
 * @param [title] The main title text displayed on the card.
 * @param [description] The descriptive text displayed below the title.
 * @param [startIcon] Optional drawable resource ID for the icon displayed at the start of the card.
 * @param [endIcon] Optional drawable resource ID for the icon displayed at the end of the card.
 * @param [cardParams] The colors used for the card, provided by the [AccentCardViewParams].
 * @param [onClick] Callback triggered when the card is clicked.
 *
 * @sample AccentCardView_Preview
 */

@Composable
fun AccentCardView(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null,
    cardParams: AccentCardViewParams,
    onClick: () -> Unit
) {
    Card(
        colors = cardParams.colors,
        onClick = onClick
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
                .padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
        ) {
            Column(modifier = Modifier.weight(3f)) {
                Row {
                    if (startIcon != null)
                        Image(
                            modifier = Modifier.padding(end = dimensionResource(id = R.dimen.padding_4dp)),
                            imageVector = ImageVector.vectorResource(id = startIcon),
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
                    imageVector = ImageVector.vectorResource(id = endIcon),
                    contentDescription = null
                )
        }
    }
}

@Preview
@Composable
fun AccentCardView_Preview() {
    ChiliTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            AccentCardView(
                title = "Сканнер штрих кодов и QR",
                description = "Для удобной оплаты\nбез ввода реквизитов",
                endIcon = R.drawable.pay,
                cardParams = AccentCardViewParams.accentCardViewFucsia,
                startIcon = null
            ) {

            }
            AccentCardView(
                title = "Цифровая карта",
                description = "Для бесконтактных платежей",
                endIcon = null,
                startIcon = R.drawable.icon_k,
                cardParams = AccentCardViewParams.accentCardViewBlack,
            ) {

            }
            AccentCardView(
                title = "Цифровая карта",
                description = "Для бесконтактных платежей",
                endIcon = R.drawable.ic_scaner_48,
                startIcon = null,
                cardParams = AccentCardViewParams.accentCardViewWhite,
            ) {

            }
        }
    }
}

data class AccentCardViewParams(
    val colors: CardColors,
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
) {
    companion object {
        val accentCardViewFucsia
            @Composable get() = AccentCardViewParams(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.folly_1),
                    contentColor = colorResource(id = R.color.white_1)
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                )
            )
        val accentCardViewBlack
            @Composable get() = AccentCardViewParams(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.black_4),
                    contentColor = colorResource(id = R.color.white_1)
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                )
            )
        val accentCardViewWhite
            @Composable get() = AccentCardViewParams(
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.white_1),
                    contentColor = colorResource(id = R.color.black_1)
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    font = ChiliTheme.Attribute.ChiliRegularTextFont
                )
            )
    }
}