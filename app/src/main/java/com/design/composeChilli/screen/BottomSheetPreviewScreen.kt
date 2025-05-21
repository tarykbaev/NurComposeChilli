package com.design.composeChilli.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.NurChiliModalBottomSheet
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetContent
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetContent
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetParams
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetButton
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetContent
import com.design.composechili.components.bottomSheet.recycleBottomSheet.LazyBottomSheetContent
import com.design.composechili.components.bottomSheet.recycleBottomSheet.SampleRadioItem
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorBottomSheetContent
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.optionItem.SearchSelectorOptionItem
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.components.cell.radioButtonCell.RadioButtonCell
import com.design.composechili.components.inAppPush.InfoInAppPush

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetPreviewScreen() {

    val scrollState = rememberScrollState()

    var showActionModalBottomSheet by remember { mutableStateOf(false) }
    var showInfoModalBottomSheet by remember { mutableStateOf(false) }
    var showDetailedInfoModalBottomSheet by remember { mutableStateOf(false) }
    var showDescriptionModalBottomSheet by remember { mutableStateOf(false) }
    var showLazyModalBottomSheet by remember { mutableStateOf(false) }
    var showSearchSelectorModalBottomSheet by remember { mutableStateOf(false) }

    var isInAppPushVisible by rememberSaveable { mutableStateOf(false) }
    var isInAppPushWithBannerVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NurChiliButton(
            onClick = {
                showActionModalBottomSheet = true
            },
            title = "Action bottom sheet",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                showInfoModalBottomSheet = true
            },
            title = "Info bottom sheet",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                showDetailedInfoModalBottomSheet = true
            },
            title = "Detailed info bottom sheet",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
            },
            title = "Detailed info bottom sheet custom",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                showDescriptionModalBottomSheet = true
            },
            title = "Description bottom sheet",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                showLazyModalBottomSheet = true
            },
            title = "Bottom sheet with LazyColumn",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                isInAppPushVisible = isInAppPushVisible.not()
            },
            title = "In App push",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                isInAppPushWithBannerVisible = isInAppPushWithBannerVisible.not()
            },
            title = "In App push with banner",
            buttonStyle = ChiliButtonStyle.Primary
        )
        NurChiliButton(
            onClick = {
                showSearchSelectorModalBottomSheet = true
            },
            title = "Search selector bottom sheet",
            buttonStyle = ChiliButtonStyle.Primary
        )
    }

    NurChiliModalBottomSheet(
        isVisible = showActionModalBottomSheet,
        hasCloseIcon = false,
        onDismissRequest = {
            showActionModalBottomSheet = false
        }
    ) {
        ActionBottomSheetContent()
    }

    NurChiliModalBottomSheet(
        isVisible = showInfoModalBottomSheet,
        onDismissRequest = { showInfoModalBottomSheet = false }
    ) {
        InfoBottomSheetContent {
            showInfoModalBottomSheet = false
        }
    }

    NurChiliModalBottomSheet(
        isVisible = showDetailedInfoModalBottomSheet,
        onDismissRequest = { showDetailedInfoModalBottomSheet = false }
    ) {
        DetailedInfoBottomSheetContent(
            onPrimaryClick = { showDetailedInfoModalBottomSheet = false },
            infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                    "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                    "Высота зависит от контента.",
            buttonTitle = "Понятно",
            detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.BigIconWithSingleButton
        )
    }

    NurChiliModalBottomSheet(
        isVisible = showDescriptionModalBottomSheet,
        onDismissRequest = {
            showDescriptionModalBottomSheet = false
        }
    ) {
        DescriptionBottomSheetContent(
            icon = R.drawable.ic_cat,
            title = "Title",
            description = "Description",
            secondaryDescription = "SecondaryDescription",
            buttonText = "Button",
            onButtonClick = {
                showDescriptionModalBottomSheet = false
            },
        )
    }

    NurChiliModalBottomSheet(
        isVisible = showLazyModalBottomSheet,
        swipeToDismissEnabled = false,
        onDismissRequest = { showLazyModalBottomSheet = false }
    ) {
        LazyBottomSheetContent(
            modifier = Modifier
                .fillMaxSize(),
            title = "Это боттомщит с LazyColumn",
            subtitle = "Тут можно задать стиль тексту",
            listOfItems = List(50) {
                SampleRadioItem("Банковский счет", "···· 2341")
            },
            onItemClick = {
                showLazyModalBottomSheet = false
            },
            composableItem = { item: SampleRadioItem, onClick: (SampleRadioItem) -> Unit ->
                RadioButtonCell(
                    title = item.title,
                    subtitle = item.subtitle,
                    onItemClick = { onClick(item) }
                )
            }
        )
    }

    NurChiliModalBottomSheet(
        isVisible = showSearchSelectorModalBottomSheet,
        onDismissRequest = {
            showSearchSelectorModalBottomSheet = false
        }
    ) {
        SearchSelectorBottomSheetContent {
            showSearchSelectorModalBottomSheet = false
        }
    }

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
}

@Composable
fun InfoBottomSheetContent(onClick: () -> Unit) {
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

@Composable
fun SearchSelectorBottomSheetContent(
    onClick: (SearchSelectorOptionItem) -> Unit
) {
    SearchSelectorBottomSheetContent(
        list = listOf(
            SearchSelectorOptionItem("1", "Option 1", false),
            SearchSelectorOptionItem("2", "Example 2", false),
            SearchSelectorOptionItem("3", "Test 3", true),
            SearchSelectorOptionItem("4", "Random 4", false),
        ),
        onOptionClick = { onClick(it) }
    )
}

@Composable
fun ActionBottomSheetContent() {
    val buttons = listOf(
        ActionBottomSheetParams("First", ChiliButtonStyle.Secondary) { },
        ActionBottomSheetParams("Second", ChiliButtonStyle.Secondary) { },
        ActionBottomSheetParams("Cancel", ChiliButtonStyle.Additional) { },
    )
    ActionBottomSheetContent(buttons = buttons)
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