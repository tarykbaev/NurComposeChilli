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
 * @param [bottomSheetCellParams] BottomSheetCell's visual transformation params and click listener
 * @see [CellBottomSheet]
 */

@Composable
fun BottomSheetCell(
    bottomSheetCellParams: BottomSheetCellParams
) {
    ChiliTheme {
        BaseCell(
            modifier = Modifier.clickable { bottomSheetCellParams.onClick?.invoke() },
            title = bottomSheetCellParams.title,
            startIcon = bottomSheetCellParams.icon,
            isChevronVisible = true,
            isDividerVisible = true
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BottomSheetCellPreview() {
    ChiliTheme {
        BottomSheetCell(
            bottomSheetCellParams = BottomSheetCellParams(
                title = "TestTitle",
                icon = "https://minio.o.kg/catalog/icons/light/gov_fines.png"
            )
        )
    }
}

@Stable
data class BottomSheetCellParams(
    val title: String,
    val icon: Any? = null,
    val onClick: (() -> Unit)? = null
)
