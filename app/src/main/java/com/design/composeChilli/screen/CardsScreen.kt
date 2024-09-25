package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.card.AccentCard
import com.design.composechili.components.card.AccentCardParams
import com.design.composechili.components.card.CardContainer
import com.design.composechili.components.card.CardContainerParams
import com.design.composechili.components.card.PromoBannerCard
import com.design.composechili.components.card.PromoBannerCardParams
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.softLayerShadow

@Composable
fun CardsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
        ) {
            CardContainer(
                title = "AccentCard",
                endIcon = R.drawable.ic_visa_banner_logo,
                cardContainerParams = CardContainerParams.Transparent,
                saveExpandedState = false,
                expandableContent = {
                    AccentCardList()
                }
            )
            CardContainer(
                title = "PromoBannerCard",
                cardContainerParams = CardContainerParams.Transparent,
                saveExpandedState = false,
                expandableContent = {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(1){
                            PromoBannerCard(
                                title = "Виртуальная карта",
                                subtitle = "Открой бесплатно в приложении!",
                                startIcon = R.drawable.ic_visa_banner_logo,
                                rightImage = R.drawable.bg_virtual_cards_3,
                                promoBannerCardParams = PromoBannerCardParams.Regular
                            ) {}
                            Spacer(modifier = Modifier.padding(8.dp))
                            PromoBannerCard(
                                title = "Карта ЭЛКАРТ",
                                subtitle = "Откройте карту в О!Store",
                                startIcon = R.drawable.ic_elcart_title_logo,
                                rightImage = R.drawable.bg_virtual_cards_2,
                                promoBannerCardParams = PromoBannerCardParams.Small
                            ) {}
                        }
                    }
                }
            )
        }
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