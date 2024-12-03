package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composeChilli.screen.ScreenEnum.ACTION_BOTTOM_SHEET
import com.design.composeChilli.screen.ScreenEnum.BOTTOM_SHEET_WITH_RECYCLE
import com.design.composeChilli.screen.ScreenEnum.DESCRIPTION_BOTTOM_SHEET
import com.design.composeChilli.screen.ScreenEnum.DETAILED_INFO_BOTTOM_SHEET
import com.design.composeChilli.screen.ScreenEnum.DETAILED_INFO_BOTTOM_SHEET_CUSTOM
import com.design.composeChilli.screen.ScreenEnum.INFO_BOTTOM_SHEET
import com.design.composeChilli.screen.ScreenEnum.SEARCH_SELECT_BOTTOM_SHEET
import com.design.composeChilli.screen.ScreenEnum.UNKNOWN
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetContent
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetContent
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetParams
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetButton
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetContent
import com.design.composechili.components.bottomSheet.recycleBottomSheet.RecycleBottomSheetContent
import com.design.composechili.components.bottomSheet.recycleBottomSheet.SampleRadioItem
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorBottomSheetContent
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorOptionItem
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.cell.radioButtonCell.RadioButtonCell
import com.design.composechili.components.inAppPush.InfoInAppPush
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.expand
import com.design.composechili.utils.hide
import kotlinx.coroutines.launch

private enum class ScreenEnum {
    UNKNOWN,
    ACTION_BOTTOM_SHEET,
    INFO_BOTTOM_SHEET,
    DETAILED_INFO_BOTTOM_SHEET,
    DETAILED_INFO_BOTTOM_SHEET_CUSTOM,
    DESCRIPTION_BOTTOM_SHEET,
    BOTTOM_SHEET_WITH_RECYCLE,
    SEARCH_SELECT_BOTTOM_SHEET
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen() {
    val scrollState = rememberScrollState()

    val coScope = rememberCoroutineScope()
    val sheetState = getBottomSheetState().apply {
        coScope.launch { bottomSheetState.hide() }
    }

    var isInAppPushVisible by rememberSaveable { mutableStateOf(false) }
    var isInAppPushWithBannerVisible by rememberSaveable { mutableStateOf(false) }

    var bottomSheetScreen by rememberSaveable { mutableStateOf(UNKNOWN) }

    BaseBottomSheet(
        sheetState = sheetState,
        peekHeight = 100.dp,
        hasCloseIcon = true,
        bottomSheetContent = {
            when (bottomSheetScreen) {
                ACTION_BOTTOM_SHEET -> ActionBottomSheet()
                INFO_BOTTOM_SHEET -> InfoBottomSheet {
                    coScope.launch { sheetState.hide() }
                }

                DETAILED_INFO_BOTTOM_SHEET -> DetailedInfoBottomSheet {
                    coScope.launch { sheetState.hide() }
                }

                DETAILED_INFO_BOTTOM_SHEET_CUSTOM -> DetailedInfoBottomSheetCustom {
                    coScope.launch { sheetState.hide() }
                }

                DESCRIPTION_BOTTOM_SHEET -> DescriptionBottomSheet {
                    coScope.launch { sheetState.hide() }
                }

                UNKNOWN -> return@BaseBottomSheet
                BOTTOM_SHEET_WITH_RECYCLE -> RecycleBottomSheet {
                    coScope.launch { sheetState.hide() }
                }

                SEARCH_SELECT_BOTTOM_SHEET -> {
                    SearchSelectorBottomSheet{
                        coScope.launch { sheetState.hide() }
                    }
                }
            }
        },
        screenContent = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor)
            ) {

                if (isInAppPushVisible) {
                    InfoInAppPushScreen {
                        isInAppPushVisible = isInAppPushVisible.not()
                    }
                }

                if (isInAppPushWithBannerVisible) {
                    InfoInAppPushScreenWithBanner {
                        isInAppPushWithBannerVisible = isInAppPushWithBannerVisible.not()
                    }
                }


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    BaseButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        onClick = {
                            bottomSheetScreen = ACTION_BOTTOM_SHEET
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Action bottom sheet",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = INFO_BOTTOM_SHEET
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Info bottom sheet",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = DETAILED_INFO_BOTTOM_SHEET
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Detailed info bottom sheet",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = DETAILED_INFO_BOTTOM_SHEET_CUSTOM
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Detailed info bottom sheet custom",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = DESCRIPTION_BOTTOM_SHEET
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Description bottom sheet",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = BOTTOM_SHEET_WITH_RECYCLE
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Bottom sheet with recycle",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            isInAppPushVisible = isInAppPushVisible.not()
                        },
                        title = "In App push",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            isInAppPushWithBannerVisible = isInAppPushWithBannerVisible.not()
                        },
                        title = "In App push with banner",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                    BaseButton(
                        onClick = {
                            bottomSheetScreen = SEARCH_SELECT_BOTTOM_SHEET
                            coScope.launch { sheetState.expand() }
                        },
                        title = "Search selector bottom sheet",
                        buttonStyle = ChiliButtonStyle.Primary
                    )
                }
            }
        }
    )
}

@Composable
fun InfoInAppPushScreen(onDismiss: () -> Unit) {
    InfoInAppPush(
        title = "Максимальная длина заголовка равна 60 символов, а если не по",
        description = "Описание описания,Описание описания, которое описывает описанное описание описанного описания, максимум из 190 символов," +
                "но если ничего \n \nне помещается, не проблема, потому что у нас всегда fasdf",
        buttonText = "ПОДРОБНЕЕ",
        onClickListener = onDismiss,
        onDismissRequest = onDismiss
    )
}

@Composable
fun InfoInAppPushScreenWithBanner(onDismiss: () -> Unit) {
    InfoInAppPush(
        title = "Максимальная длина заголовка равна 60 символов, а если не по",
        description = "Описание описания,Описание описания, которое описывает описанное описание описанного описания, максимум из 190 символов," +
                "но если ничего \n \nне помещается, не проблема, потому что у нас всегда fasdf",
        buttonText = "ПОДРОБНЕЕ",
        banner = "https://static.vecteezy.com/system/resources/thumbnails/024/669/489/small_2x/mountain-countryside-landscape-at-sunset-dramatic-sky-over-a-distant-valley-green-fields-and-trees-on-hill-beautiful-natural-landscapes-of-the-carpathians-generative-ai-variation-5-photo.jpeg",
        onClickListener = onDismiss,
        onDismissRequest = onDismiss
    )
}

@Composable
fun SearchSelectorBottomSheet(
    onClick: () -> Unit
) {
    SearchSelectorBottomSheetContent(
        list = listOf(
            SearchSelectorOptionItem("1", "Option 1", false),
            SearchSelectorOptionItem("2", "Example 2", false),
            SearchSelectorOptionItem("3", "Test 3", false),
            SearchSelectorOptionItem("4", "Random 4", false),
        ),
        onOptionClick = { onClick() }
    )
}

@Composable
fun RecycleBottomSheet(onClick: () -> Unit) {
    val listOfItems = listOf(
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("ELCART ЭЛКАП", "···· 1234"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("ELCART ЭЛКАП", "···· 1234"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
        SampleRadioItem("Банковский счет", "···· 2341"),
        SampleRadioItem("Visa", "···· 1234"),
        SampleRadioItem("Visa o!Dengi", "···· 12421"),
    )
    RecycleBottomSheetContent(
        title = "Это боттомщит где вы можете засетить свой адаптер к ресайклу",
        subtitle = "Тут можно задать стиль тексту",
        listOfItems = listOfItems,
        onItemClick = { onClick() },
        composableItem = { item: SampleRadioItem, click: (SampleRadioItem) -> Unit ->
            RadioButtonCell(
                title = item.title,
                subtitle = item.subtitle,
                onItemClick = { click(item) }
            )
        }
    )
}

@Composable
fun DescriptionBottomSheet(onClick: () -> Unit) {
    DescriptionBottomSheetContent(
        icon = R.drawable.ic_cat,
        title = "Title",
        description = "Description",
        secondaryDescription = "SecondaryDescription",
        buttonText = "Button",
        onButtonClick = onClick,
    )
}

@Composable
fun DetailedInfoBottomSheet(onClick: () -> Unit) {
    DetailedInfoBottomSheetContent(
        onPrimaryClick = onClick,
        infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                "Высота зависит от контента.",
        buttonTitle = "Понятно",
        detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.BigIconWithSingleButton
    )
}

@Composable
fun DetailedInfoBottomSheetCustom(onClick: () -> Unit) {
    DetailedInfoBottomSheetContent(
        onPrimaryClick = onClick,
        infoText = "Я согласен с условиями <a href=\"https://o\n" +
                ".kg\">пользовательского соглашения</a> и \n" +
                "условиями\n" +
                "<a href=\"https://o.kg\">оферты сервиса «О!Деньги»</a>",
        buttonTitle = "Start",
        secondaryButtonTitle = "Later",
        detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.SmallIconWithTwoButtons
    )
}

@Composable
fun ActionBottomSheet() {
    val buttons = listOf(
        ActionBottomSheetParams("First", ChiliButtonStyle.Secondary) { },
        ActionBottomSheetParams("Second", ChiliButtonStyle.Secondary) { },
        ActionBottomSheetParams("Cancel", ChiliButtonStyle.Additional) { },
    )
    ActionBottomSheetContent(buttons = buttons)
}

@Composable
fun InfoBottomSheet(onClick: () -> Unit) {
    val buttons = listOf(
        InfoBottomSheetButton(
            title = "First",
            onClick = onClick,
            buttonStyle = ChiliButtonStyle.Primary
        ),
        InfoBottomSheetButton(
            title = "Cancel",
            onClick = onClick,
            buttonStyle = ChiliButtonStyle.Additional
        ),
    )

    InfoBottomSheetContent(
        title = "Заголовок окна",
        description = "LALALLA Текстовый блок, который содержит 120 символов, и этого количества должно хватить для информации ...",
        buttons = buttons,
        icon = R.drawable.ic_cat
    )
}