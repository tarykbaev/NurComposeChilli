package com.design.composechili.components.bottom_sheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    bottomSheetContent: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    ChiliTheme {
        BottomSheetScaffold(
            sheetContent = {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(ChiliTheme.Colors.chiliSurfaceBackground)
                ) {
                    bottomSheetContent()
                }
            },
            scaffoldState = sheetState,
            sheetShape = RoundedCornerShape(
                topEnd = dimensionResource(R.dimen.padding_8dp),
                topStart = dimensionResource(R.dimen.padding_8dp)
            ),
            sheetDragHandle = {}, // hides slider
            sheetPeekHeight = 0.dp // hides slider
        ) {
            content()
        }
    }
}