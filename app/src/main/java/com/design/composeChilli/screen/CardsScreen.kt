package com.design.composeChilli.screen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.card.AccentCard
import com.design.composechili.components.card.AccentCardParams
import com.design.composechili.components.card.CardContainer
import com.design.composechili.components.card.CardContainerParams
import com.design.composechili.components.card.CategoryCard
import com.design.composechili.components.card.CategoryCardParams
import com.design.composechili.components.card.PromoBannerCard
import com.design.composechili.components.card.PromoBannerCardParams
import com.design.composechili.components.card.base.NurChiliBaseCard
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.utils.softLayerShadow

@Composable
fun CardsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChiliTheme.Colors.ChiliSurfaceBackground)
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
                isContentExpandedInitValue = true,
                expandableContent = {
                    AccentCardList()
                }
            )
            CardContainer(
                title = "PromoBannerCard",
                cardContainerParams = CardContainerParams.Transparent,
                isContentExpandedInitValue = true,
                expandableContent = {
                    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(1) {
                            PromoBannerCard(
                                title = "Виртуальная карта",
                                subtitle = "Открой бесплатно в приложении!",
                                startIcon = painterResource(id = R.drawable.ic_visa_banner_logo),
                                rightImage = painterResource(id = R.drawable.bg_virtual_cards_3),
                                promoBannerCardParams = PromoBannerCardParams.Regular
                            ) {}
                            Spacer(modifier = Modifier.padding(8.dp))
                            PromoBannerCard(
                                title = "Карта ЭЛКАРТ",
                                subtitle = "Откройте карту в О!Store",
                                startIcon = painterResource(id = R.drawable.ic_elcart_title_logo),
                                rightImage = painterResource(id = R.drawable.bg_virtual_cards_2),
                                promoBannerCardParams = PromoBannerCardParams.Small
                            ) {}
                        }
                    }
                }
            )
            CardContainer(
                title = "CategoryCard",
                cardContainerParams = CardContainerParams.Transparent,
                isContentExpandedInitValue = true,
                expandableContent = {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        CategoryCard(
                            modifier = Modifier
                                .weight(1f)
                                .softLayerShadow()
                                .padding(vertical = 16.dp),
                            title = "Переводы",
                            painter = painterResource(id = R.drawable.ic_payment),
                            categoryCardParams = CategoryCardParams.LeftAligned
                        ) {}
                        CategoryCard(
                            modifier = Modifier
                                .softLayerShadow()
                                .padding(vertical = 16.dp),
                            title = "Centered",
                            painter = painterResource(id = R.drawable.ic_payment),
                            categoryCardParams = CategoryCardParams.Centered
                        ) {}
                    }
                }
            )
            CardContainer(
                title = "CategoryCard(8 dp icon offset)",
                endIcon = null,
                cardContainerParams = CardContainerParams.Transparent,
                isContentExpandedInitValue = true,
                expandableContent = {
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        CategoryCard(
                            modifier = Modifier
                                .softLayerShadow()
                                .padding(vertical = 16.dp),
                            title = "Кофейня.\nБонусная.",
                            painter = painterResource(id = R.drawable.ic_payment),
                            categoryCardParams = CategoryCardParams.LeftAligned8Dp,
                            rootPadding = PaddingValues(
                                top = 8.dp,
                                bottom = 8.dp,
                                end = 64.dp,
                                start = 8.dp
                            )
                        ) {}
                        CategoryCard(
                            modifier = Modifier
                                .softLayerShadow()
                                .padding(vertical = 16.dp),
                            title = "Народный\nБонусная",
                            painter = painterResource(id = R.drawable.ic_payment),
                            categoryCardParams = CategoryCardParams.LeftAligned8Dp,
                            rootPadding = PaddingValues(
                                top = 8.dp,
                                bottom = 8.dp,
                                end = 64.dp,
                                start = 8.dp
                            )
                        ) {}
                    }
                })
            NurChiliBaseCard(
                modifier = Modifier
                    .softLayerShadow()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Title",
                        style = ChiliTextStyle.get(
                            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                            font = ChiliTheme.Attribute.ChiliBoldTextFont,
                            color = ChiliTheme.Colors.ChiliPrimaryTextColor
                        )
                    )
                    Text(
                        text = "SubTitle",
                        style = ChiliTextStyle.get(
                            font = ChiliTheme.Attribute.ChiliRegularTextFont,
                            color = ChiliTheme.Colors.ChiliSecondaryTextColor
                        )
                    )
                    Text(
                        text = "SubTitle",
                        style = ChiliTextStyle.get(
                            font = ChiliTheme.Attribute.ChiliRegularTextFont,
                            color = ChiliTheme.Colors.ChiliSecondaryTextColor
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun AccentCardList() {
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

@Preview()
@Composable
fun CardsScreen_Preview() {
    ChiliTheme {
        CardsScreen()
    }
}

