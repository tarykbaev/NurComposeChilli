package com.design.composeChilli.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetContent
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.bottomSheet.cellBottomSheet.BottomSheetCellParams
import com.design.composechili.components.bottomSheet.cellBottomSheet.CellBottomSheetContent
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetContent
import com.design.composechili.components.bottomSheet.descriptionBottomSheet.DescriptionBottomSheetParams
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetsScreen() {
    val scope = rememberCoroutineScope()
    val sheetState = getBottomSheetState()

    val sheetType = remember {
        mutableStateOf(
            listOf(
                BottomSheetType.ActionBottomSheet(showSheet = false),
                BottomSheetType.CellBottomSheet(showSheet = false),
                BottomSheetType.DescriptionBottomSheet(showSheet = false),
                BottomSheetType.DetailedBottomSheet(showSheet = false),
                BottomSheetType.InfoBottomSheet(showSheet = false),
                BottomSheetType.RecycleBottomSheet(showSheet = false),
                BottomSheetType.SearchBottomSheet(showSheet = false),
            )
        )
    }
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
    val selectedSheet = sheetType.value.find { it.showSheet }

    BaseBottomSheet(
        sheetState = sheetState,
        isDragHandleContentEnabled = selectedSheet?.isDragHandleEnabled ?: false,
        hasCloseIcon = selectedSheet?.hasCloseIcon ?: false,
        dragHandle = selectedSheet?.dragHandle ?: {},
        bottomSheetContent = {
            val visibleSheet = sheetType.value.find { it.showSheet }
            when (visibleSheet) {
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
                    icon = com.design.composechili.R.drawable.ic_cat,
                    params = DescriptionBottomSheetParams.Default,
                    title = "Title",
                    description = "Description",
                    secondaryDescription = "SecondaryDescription",
                    buttonText = "Button",
                    onButtonClick = {},
                )

                is BottomSheetType.DetailedBottomSheet -> CellBottomSheetContent(
                    modifier = Modifier,
                    cells = cellButtons
                )

                is BottomSheetType.InfoBottomSheet -> CellBottomSheetContent(
                    modifier = Modifier,
                    cells = cellButtons
                )

                is BottomSheetType.RecycleBottomSheet -> CellBottomSheetContent(
                    modifier = Modifier,
                    cells = cellButtons
                )

                is BottomSheetType.SearchBottomSheet -> CellBottomSheetContent(
                    modifier = Modifier,
                    cells = cellButtons
                )

                null -> {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = com.design.composechili.R.drawable.ic_cat),
                        contentDescription = null
                    )
                }
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
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.ActionBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Action Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.CellBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Cell Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.DescriptionBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Description Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.DetailedBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Detailed Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.InfoBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Info Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.RecycleBottomSheet()
                            )
                            sheetState.bottomSheetState.expand()
                        }
                    },
                    title = "Recycle Bottom Sheet",
                    buttonPadding = PaddingValues(16.dp)
                )
                BaseButton(
                    onClick = {
                        scope.launch {
                            sheetType.value = selectBottomSheetToShow(
                                sheetType.value,
                                BottomSheetType.SearchBottomSheet()
                            )
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

private fun selectBottomSheetToShow(
    sheetType: List<BottomSheetType>,
    selected: BottomSheetType
): List<BottomSheetType> {
    return sheetType.map { bottomSheet ->
        when (bottomSheet) {
            is BottomSheetType.ActionBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.CellBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.DescriptionBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.DetailedBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.InfoBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.RecycleBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
            is BottomSheetType.SearchBottomSheet -> bottomSheet.copy(showSheet = bottomSheet == selected)
        }
    }
}

@Stable
sealed class BottomSheetType(
    open val isDragHandleEnabled: Boolean,
    open val hasCloseIcon: Boolean,
    open val showSheet: Boolean,
    open val dragHandle: @Composable () -> Unit = {},
) {
    @Stable
    data class ActionBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false,
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)

    @Stable
    data class CellBottomSheet(
        override val isDragHandleEnabled: Boolean = true,
        override val hasCloseIcon: Boolean = true,
        override val showSheet: Boolean = false
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)

    @OptIn(ExperimentalMaterial3Api::class)
    @Stable
    data class DescriptionBottomSheet(
        override val isDragHandleEnabled: Boolean = true,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false
    ) : BottomSheetType(
        isDragHandleEnabled,
        hasCloseIcon,
        showSheet,
        dragHandle = { BottomSheetDefaults.DragHandle() })

    @Stable
    data class DetailedBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)

    @Stable
    data class InfoBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)

    @Stable
    data class RecycleBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)

    @Stable
    data class SearchBottomSheet(
        override val isDragHandleEnabled: Boolean = false,
        override val hasCloseIcon: Boolean = false,
        override val showSheet: Boolean = false
    ) : BottomSheetType(isDragHandleEnabled, hasCloseIcon, showSheet)
}


@Preview(name = "BottomSheetsScreen_Preview")
@Composable
fun BottomSheetsScreen_Preview() {
    ChiliTheme {
        BottomSheetsScreen()
    }
}