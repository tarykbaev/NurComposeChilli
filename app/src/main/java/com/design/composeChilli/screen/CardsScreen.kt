package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.card.AccentCard
import com.design.composechili.components.card.AccentCardParams
import com.design.composechili.components.card.CardContainer
import com.design.composechili.components.card.CardContainerParams
import com.design.composechili.components.card.CategoryCard
import com.design.composechili.components.card.CategoryCardType
import com.design.composechili.theme.ChiliTheme

@Composable
fun CardsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            CardContainer(
                title = "AccentCardView",
                endIcon = R.drawable.ic_visa_banner_logo,
                cardContainerParams = CardContainerParams.Transparent,
                saveExpandedState = false,
                expandableContent = {
                    AccentCardList()
                }
            )
            CardContainer(
                title = "CategoryCardView",
                endIcon = null,
                cardContainerParams = CardContainerParams.Transparent,
                saveExpandedState = false,
                expandableContent = {
                    CardCategorySample()
                })
            CardContainer(
                title = "CategoryCardView(8 dp icon offset)",
                endIcon = null,
                cardContainerParams = CardContainerParams.Transparent,
                saveExpandedState = false,
                expandableContent = {
                    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        CategoryCard(
                            type = CategoryCardType.Centered(
                                title = "Кофейня.\nБонусная.",
                                icon = R.drawable.ic_payment,
                                style = CategoryCardType.regularTextStyle
                            )
                        )
                        CategoryCard(
                            type = CategoryCardType.Centered(
                                title = "Народный\nБонусная",
                                icon = R.drawable.ic_payment,
                                style = CategoryCardType.regularTextStyle
                            )
                        )

                    }
                })
        }
    }
}

@Composable
private fun CardCategorySample() {
    Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        CategoryCard(
            modifier = Modifier.weight(3f),
            type = CategoryCardType.LeftAligned(
                title = "Переводы",
                icon = R.drawable.ic_payment,
                style = CategoryCardType.boldTextStyle
            )
        )
        CategoryCard(
            type = CategoryCardType.Centered(
                title = "Centered",
                icon = R.drawable.ic_payment,
                style = CategoryCardType.boldTextStyle
            )
        )
    }
}

@Composable
private fun AccentCardList() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AccentCard(
            title = "Сканнер штрих кодов и QR",
            description = "Для удобной оплаты\nбез ввода реквизитов",
            endIcon = R.drawable.pay,
            cardParams = AccentCardParams.accentCardFucsia,
            startIcon = null
        ) {

        }
        AccentCard(
            title = "Цифровая карта",
            description = "Для бесконтактных платежей",
            endIcon = null,
            startIcon = R.drawable.icon_k,
            cardParams = AccentCardParams.accentCardBlack,
        ) {

        }
        AccentCard(
            title = "Цифровая карта",
            description = "Для бесконтактных платежей",
            endIcon = R.drawable.ic_scaner_48,
            startIcon = null,
            cardParams = AccentCardParams.accentCardWhite,
        ) {

        }
    }
}

@Preview
@Composable
fun CardsScreen_Preview() {
    ChiliTheme {
        CardsScreen()
    }
}