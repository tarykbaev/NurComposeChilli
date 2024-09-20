package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.bottomSheet.cellBottomSheet.BottomSheetCellParams
import com.design.composechili.components.bottomSheet.cellBottomSheet.CellBottomSheetContent
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetContent
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetParams
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetContent
import com.design.composechili.components.bottomSheet.detailedInfoBottomSheet.DetailedInfoBottomSheetParams
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetButton
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetContent
import com.design.composechili.components.bottomSheet.infoBottomSheet.InfoBottomSheetsParams
import com.design.composechili.components.bottomSheet.recycleBottomSheet.RecycleBottomSheetContent
import com.design.composechili.components.bottomSheet.recycleBottomSheet.RecycleBottomSheetParams
import com.design.composechili.components.bottomSheet.recycleBottomSheet.SampleRadioItem
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorBottomSheetContent
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorBottomSheetParams
import com.design.composechili.components.bottomSheet.searchSelectorBottomSheet.SearchSelectorOptionItem
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.cell.radioButtonCell.RadioButtonCell
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsScreen() {
    val scope = rememberCoroutineScope()
    val density = LocalDensity.current
    val sheetState by remember { mutableStateOf(
        BottomSheetScaffoldState(
            bottomSheetState = SheetState(
                skipPartiallyExpanded = true,
                density = density
            ), snackbarHostState = SnackbarHostState()
        ))
    }

    var sheetType by remember { mutableStateOf<BottomSheetType?>(null) }
    val buttons = listOf(
        ActionBottomSheetParams(
            title = "Primary Button",
            buttonStyle = ChiliButtonStyle.Primary,
            onClick = {
                scope.launch { sheetState.bottomSheetState.hide() }
            }),
        ActionBottomSheetParams(
            title = "Secondary Button",
            buttonStyle = ChiliButtonStyle.Secondary,
            onClick = {
                scope.launch { sheetState.bottomSheetState.hide() }
            }),
        ActionBottomSheetParams(
            title = "Component Button",
            buttonStyle = ChiliButtonStyle.ComponentButton,
            onClick = {
                scope.launch { sheetState.bottomSheetState.hide() }
            }),
    )
    val cellButtons = listOf(
        BottomSheetCellParams("Кошелёк О!Деньги", "https://minio.o.kg/catalog/logos/odengi.png"),
        BottomSheetCellParams("Пополнение О!Деньги", "https://minio.o.kg/catalog/logos/elcart.png"),
        BottomSheetCellParams(
            "Перевод О!Деньги",
            "https://valuta.kg/uploads/b/baitushum/avat_bai_1cbf8.png"
        ),
        BottomSheetCellParams("Заголовок", "https://minio.o.kg/catalog/icons/light/gov_fines.png"),
        BottomSheetCellParams(
            "Народный.Бонусная карта",
            "https://minio.o.kg/catalog/logos/vostokelectro.png"
        ),
        BottomSheetCellParams(
            "Перевод О!Деньги",
            "https://img2.freepng.ru/20180429/bzq/kisspng-advertising-publicity-marketing-computer-icons-bra-5ae5c4fa63ff38.1177983315250076104096.jpg"
        ) {
            scope.launch { sheetState.bottomSheetState.hide() }
        },
        BottomSheetCellParams(
            "Пополнение О!Деньги",
            "https://minio.o.kg/catalog/logos/optimabank.png"
        ),
        BottomSheetCellParams("Перевод О!Деньги", "https://minio.o.kg/catalog/logos/mbank_new.png"),
        BottomSheetCellParams("Пополнение О!Деньги", "https://minio.o.kg/catalog/logos/odengi.png")
    )
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

    BaseBottomSheet(
        sheetState = sheetState,
        isDragHandleContentEnabled = sheetType?.isDragHandleEnabled ?: false,
        hasCloseIcon = sheetType?.hasCloseIcon ?: false,
        dragHandle = sheetType?.dragHandle ?: {},
        bottomSheetContent = {
            when (sheetType) {
                is BottomSheetType.ActionBottomSheet -> ActionBottomSheetContent(
                    modifier = Modifier,
                    buttons = buttons
                )

                is BottomSheetType.CellBottomSheet -> CellBottomSheetContent(
                    modifier = Modifier,
                    cells = cellButtons
                )

                is BottomSheetType.DescriptionBottomSheet -> DescriptionBottomSheetContent(
                    modifier = Modifier,
                    icon = R.drawable.ic_cat,
                    params = DescriptionBottomSheetParams.Default,
                    title = "Title",
                    description = "Description",
                    secondaryDescription = "SecondaryDescription",
                    buttonText = "Button",
                    onButtonClick = { scope.launch { sheetState.bottomSheetState.hide() } },
                )

                is BottomSheetType.DetailedBottomSheetDoubleButton -> DetailedInfoBottomSheetContent(
                    modifier = Modifier,
                    detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.SmallIconWithTwoButtons,
                    infoText = "Я согласен с условиями <a href=\"https://o\n" +
                            ".kg\">пользовательского соглашения</a> и \n" +
                            "условиями\n" +
                            "<a href=\"https://o.kg\">оферты сервиса «О!Деньги»</a>",
                    buttonTitle = "Start",
                    secondaryButtonTitle = "Later",
                    onPrimaryClick = { scope.launch { sheetState.bottomSheetState.hide() } },
                    onSecondaryClick = { scope.launch { sheetState.bottomSheetState.hide() } }
                )

                is BottomSheetType.DetailedBottomSheetSingleButton -> DetailedInfoBottomSheetContent(
                    modifier = Modifier,
                    infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                            "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                            "Высота зависит от контента.",
                    buttonTitle = "Понятно",
                    detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.BigIconWithSingleButton,
                    onPrimaryClick = {}
                )

                is BottomSheetType.InfoBottomSheet -> InfoBottomSheetContent(
                    modifier = Modifier,
                    title = "Заголовок окна",
                    description = "LALALLA Текстовый блок, который содержит 120 символов, и этого количества должно хватить для информации ...",
                    buttons = listOf(
                        InfoBottomSheetButton(
                            title = "First",
                            onClick = {},
                            buttonStyle = ChiliButtonStyle.Primary
                        ),
                        InfoBottomSheetButton(
                            title = "Cancel",
                            onClick = {
                                scope.launch { sheetState.bottomSheetState.hide() }
                            },
                            buttonStyle = ChiliButtonStyle.Additional
                        ),
                    ),
                    icon = R.drawable.ic_cat,
                    infoBottomSheetsParams = InfoBottomSheetsParams.Default
                )

                is BottomSheetType.RecycleBottomSheet -> RecycleBottomSheetContent(
                    modifier = Modifier,
                    title = "Это боттомщит где вы можете засетить свой адаптер к ресайклу",
                    subtitle = "Тут можно задать стиль тексту",
                    listOfItems = listOfItems,
                    onItemClick = {},
                    recycleBottomSheetParams = RecycleBottomSheetParams.Default,
                    composableItem = { item: SampleRadioItem, onClick: (SampleRadioItem) -> Unit ->
                        RadioButtonCell(
                            title = item.title,
                            subtitle = item.subtitle,
                            onItemClick = { onClick(item) }
                        )
                    }
                )

                is BottomSheetType.SearchBottomSheet -> SearchSelectorBottomSheetContent(
                    modifier = Modifier,
                    params = SearchSelectorBottomSheetParams.Default,
                    list = listOf(
                        SearchSelectorOptionItem("1", "Option 1", true),
                        SearchSelectorOptionItem("1", "Option 1", true),
                        SearchSelectorOptionItem("1", "Option 1", true),
                        SearchSelectorOptionItem("1", "Option 1", true),
                    )
                ) {

                }

                null -> {}
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor)
        ) {
            Column {
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.ActionBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Action Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.CellBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Cell Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.DescriptionBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Description Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.DetailedBottomSheetDoubleButton()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Detailed Bottom Sheet Small",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.DetailedBottomSheetSingleButton()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Detailed Bottom Sheet Big",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.InfoBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Info Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.RecycleBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Recycle Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType = BottomSheetType.SearchBottomSheet()
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Search Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
            }
        }
    }
}

@Stable
sealed class BottomSheetType(
    open val isDragHandleEnabled: Boolean,
    open val hasCloseIcon: Boolean,
    open val dragHandle: @Composable () -> Unit = {},
) {
    @Stable
    data class ActionBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @Stable
    data class CellBottomSheet(
        override val isDragHandleEnabled: Boolean = true,
        override val hasCloseIcon: Boolean = true,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @OptIn(ExperimentalMaterial3Api::class)
    @Stable
    data class DescriptionBottomSheet(
        override val isDragHandleEnabled: Boolean = true,
        override val hasCloseIcon: Boolean = false,
    ) : BottomSheetType(
        isDragHandleEnabled,
        hasCloseIcon,
        dragHandle = { BottomSheetDefaults.DragHandle() })

    @Stable
    data class DetailedBottomSheetSingleButton(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = true,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @Stable
    data class DetailedBottomSheetDoubleButton(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = true,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @Stable
    data class InfoBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = true,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @Stable
    data class RecycleBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)

    @Stable
    data class SearchBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon)
}


@Preview(name = "BottomSheetsScreen_Preview")
@Composable
fun BottomSheetsScreen_Preview() {
    ChiliTheme {
        BottomSheetsScreen()
    }
}