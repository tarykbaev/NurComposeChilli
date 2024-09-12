package com.design.composechili.components.bottomSheet.cellBottomSheet

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.components.bottomSheet.BottomSheetDragHandle
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

/**
 * @param [modifier] Will be applied to bottomSheetContent root composable content. In this is case root is [LazyColumn]
 * @param [sheetState] Bottom sheet state, hosting state like expanded or not
 * @see [BottomSheetScaffoldState]
 * @param [buttons] List of BottomSheetCellParams. Which will convert to composable [BottomSheetCell].
 * @param [peekHeight] The default peek height used by BottomSheetScaffold.
 * @param [content] Screen content, which should be covered by the [BaseBottomSheet]. Bottom Sheet will show over this content
 * @sample [BottomSheetCell]
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    buttons: List<BottomSheetCellParams>,
    peekHeight: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            isDragHandleContentEnabled = true,
            dragHandle = {
                BottomSheetDragHandle(
                    modifier = Modifier.padding(top = 8.dp),
                    width = 40.dp,
                    height = 5.dp,
                    color = ChiliTheme.Colors.ChiliThickBottomSheetDragHandleColor
                )
                         },
            hasCloseIcon = true,
            bottomSheetContent = {
                LazyColumn(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    items(buttons) { item ->
                        BottomSheetCell(item)
                    }
                }
            },
            screenContent = { content() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CellBottomSheetPreview() {
    ChiliTheme {
        val scope = rememberCoroutineScope()
        val sheetState = getBottomSheetState()

        val buttons = listOf(
            BottomSheetCellParams("Кошелёк О!Деньги", "https://minio.o.kg/catalog/logos/odengi.png"),
            BottomSheetCellParams("Пополнение О!Деньги", "https://minio.o.kg/catalog/logos/elcart.png"),
            BottomSheetCellParams("Перевод О!Деньги", "https://valuta.kg/uploads/b/baitushum/avat_bai_1cbf8.png"),
            BottomSheetCellParams("Заголовок", "https://minio.o.kg/catalog/icons/light/gov_fines.png"),
            BottomSheetCellParams("Народный.Бонусная карта", "https://minio.o.kg/catalog/logos/vostokelectro.png"),
            BottomSheetCellParams(
                "Перевод О!Деньги",
                "https://img2.freepng.ru/20180429/bzq/kisspng-advertising-publicity-marketing-computer-icons-bra-5ae5c4fa63ff38.1177983315250076104096.jpg"
            ) {
                scope.launch { sheetState.bottomSheetState.hide() }
            },
            BottomSheetCellParams("Пополнение О!Деньги", "https://minio.o.kg/catalog/logos/optimabank.png"),
            BottomSheetCellParams("Перевод О!Деньги", "https://minio.o.kg/catalog/logos/mbank_new.png"),
            BottomSheetCellParams("Пополнение О!Деньги", "https://minio.o.kg/catalog/logos/odengi.png")
        )

        CellBottomSheet(sheetState = sheetState, buttons = buttons, peekHeight = 400.dp) {

        }
    }
}
