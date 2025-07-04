package com.design.composeNur.screen

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
import com.design.composenur.R
import com.design.composeNur.components.bottomSheet.action.NurActionBottomSheet
import com.design.composeNur.components.bottomSheet.action.NurActionBottomSheetParams
import com.design.composeNur.components.bottomSheet.description.NurDescriptionBottomSheet
import com.design.composeNur.components.bottomSheet.detailedInfo.NurDetailedInfoBottomSheet
import com.design.composeNur.components.bottomSheet.detailedInfo.NurDetailedInfoBottomSheetParams
import com.design.composeNur.components.bottomSheet.info.NurInfoBottomSheet
import com.design.composeNur.components.bottomSheet.info.NurInfoBottomSheetButton
import com.design.composeNur.components.bottomSheet.lazy.NurLazyBottomSheet
import com.design.composeNur.components.bottomSheet.lazy.model.SampleRadioItem
import com.design.composeNur.components.bottomSheet.searchSelector.NurSearchSelectorBottomSheet
import com.design.composeNur.components.bottomSheet.searchSelector.optionItem.SearchSelectorOptionItem
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.cell.radioButtonCell.RadioButtonCell
import com.design.composeNur.components.inAppPush.InfoInAppPush

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
        NurButton(
            onClick = {
                showActionModalBottomSheet = true
            },
            title = "Action bottom sheet",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                showInfoModalBottomSheet = true
            },
            title = "Info bottom sheet",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                showDetailedInfoModalBottomSheet = true
            },
            title = "Detailed info bottom sheet",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
            },
            title = "Detailed info bottom sheet custom",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                showDescriptionModalBottomSheet = true
            },
            title = "Description bottom sheet",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                showLazyModalBottomSheet = true
            },
            title = "Bottom sheet with LazyColumn",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                isInAppPushVisible = isInAppPushVisible.not()
            },
            title = "In App push",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                isInAppPushWithBannerVisible = isInAppPushWithBannerVisible.not()
            },
            title = "In App push with banner",
            buttonStyle = NurButtonStyle.Primary
        )
        NurButton(
            onClick = {
                showSearchSelectorModalBottomSheet = true
            },
            title = "Search selector bottom sheet",
            buttonStyle = NurButtonStyle.Primary
        )
    }

    ActionBottomSheetWithContent(
        isVisible = showActionModalBottomSheet,
        onDismissRequest = {
            showActionModalBottomSheet = false
        }
    )

    InfoBottomSheetWithContent(
        isVisible = showInfoModalBottomSheet,
        onClick = {
            showInfoModalBottomSheet = false
        },
        onDismissRequest = {
            showInfoModalBottomSheet = false
        }
    )

    NurDetailedInfoBottomSheet(
        isVisible = showDetailedInfoModalBottomSheet,
        onPrimaryClick = { showDetailedInfoModalBottomSheet = false },
        infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                "Высота зависит от контента.",
        buttonTitle = "Ясно",
        secondaryButtonTitle = "Понятно",
        nurDetailedInfoBottomSheetParams = NurDetailedInfoBottomSheetParams.BigIconWithSingleButton,
        onDismissRequest = {
            showDetailedInfoModalBottomSheet = false
        }
    )

    NurDescriptionBottomSheet(
        isVisible = showDescriptionModalBottomSheet,
        icon = R.drawable.ic_cat,
        title = "Title",
        description = "Description",
        secondaryDescription = "SecondaryDescription",
        buttonText = "Button",
        onButtonClick = {
            showDescriptionModalBottomSheet = false
        },
        onDismissRequest = {
            showDescriptionModalBottomSheet = false
        }
    )

    NurLazyBottomSheet(
        isVisible = showLazyModalBottomSheet,
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
        },
        onDismissRequest = {
            showLazyModalBottomSheet = false
        }
    )

    NurSearchSelectorBottomSheet(
        isVisible = showSearchSelectorModalBottomSheet,
        list = listOf(
            SearchSelectorOptionItem("1", "Option 1", false),
            SearchSelectorOptionItem("2", "Example 2", false),
            SearchSelectorOptionItem("3", "Test 3", true),
            SearchSelectorOptionItem("4", "Random 4", false),
        ),
        onOptionClick = {
            showSearchSelectorModalBottomSheet = false
        },
        onDismissRequest = {
            showSearchSelectorModalBottomSheet = false
        }
    )

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
fun InfoBottomSheetWithContent(
    isVisible: Boolean,
    onClick: () -> Unit,
    onDismissRequest: () -> Unit
) {
    val buttons = listOf(
        NurInfoBottomSheetButton(
            title = "First",
            onClick = onClick,
            buttonStyle = NurButtonStyle.Primary
        ),
        NurInfoBottomSheetButton(
            title = "Cancel",
            onClick = onClick,
            buttonStyle = NurButtonStyle.Additional
        ),
    )

    NurInfoBottomSheet(
        isVisible = isVisible,
        title = "Заголовок окна",
        description = "LALALLA Текстовый блок, который содержит 120 символов, и этого количества должно хватить для информации ...",
        buttons = buttons,
        icon = R.drawable.ic_cat,
        onDismissRequest = onDismissRequest
    )
}

@Composable
fun ActionBottomSheetWithContent(
    isVisible: Boolean,
    onDismissRequest: () -> Unit,
) {
    val buttons = listOf(
        NurActionBottomSheetParams("First", NurButtonStyle.Secondary) {
            onDismissRequest()
        },
        NurActionBottomSheetParams("Second", NurButtonStyle.Secondary) { },
        NurActionBottomSheetParams("Cancel", NurButtonStyle.Additional) { },
    )
    NurActionBottomSheet(
        isVisible = isVisible,
        buttons = buttons,
        onDismissRequest = onDismissRequest
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