package com.design.composechili.components.bottomSheet.cellBottomSheet

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.components.cell.baseCell.BaseCell
import com.design.composechili.theme.ChiliTheme

/**
 * Used for [CellBottomSheet], displayed on BottomSheet with LazyColumn
 * @param [icon] accepts [Any] value of image and is displayed at the start of the cell
 * @param [title] accepts [String] and is displayed after the icon
 * @param [onClick] callback invokes when user clicks on the cell
 * @see [CellBottomSheet]
 */

@Composable
fun BottomSheetCell(
    title: String,
    icon: Any? = null,
    onClick: (() -> Unit)? = null
) {
    BaseCell(
        modifier = Modifier.clickable { onClick?.invoke() },
        title = title,
        isChevronVisible = true,
        isDividerVisible = true
    )
}

@Composable
@Preview(showBackground = true)
fun BottomSheetCellPreview() {
    ChiliTheme {
        BottomSheetCell(
            title = "TestTitle",
            icon = "https://minio.o.kg/catalog/icons/light/gov_fines.png"
        )
    }
}

@Stable
data class BottomSheetCellParams(
    val title: String,
    val icon: Any? = null,
    val onClick: (() -> Unit)? = null
)
