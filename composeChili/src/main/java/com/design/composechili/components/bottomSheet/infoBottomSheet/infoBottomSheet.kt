package com.design.composechili.components.bottomSheet.infoBottomSheet

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetButton
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetParams
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    title: String,
    description: String,
    buttons: List<ActionBottomSheetParams>,
    peekHeight: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    BaseBottomSheet(sheetState = sheetState, peekHeight = peekHeight, bottomSheetContent = {
        Column(modifier = modifier) {
            Icon(
                modifier = Modifier.align(Alignment.End),
                imageVector = ImageVector.vectorResource(id = R.drawable.chili_ic_clear_24),
                contentDescription = null
            )
            Text(text = title)
            Text(text = description)
            buttons.forEach { ActionBottomSheetButton(actionBottomSheetParams = it) }
        }
    }) { content() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InfoBottomSheet_Preview() {
    ChiliTheme {
        val scope = rememberCoroutineScope()
        val sheetState = getBottomSheetState()
        InfoBottomSheet(
            sheetState = sheetState,
            title = "bla-bla-bla",
            description = "o-lal-a",
            buttons = listOf(
                ActionBottomSheetParams(
                    "First",
                    ChiliTheme.Colors.ChiliActionBottomSheetButtonTextColor
                ),
                ActionBottomSheetParams(
                    "Cancel",
                    ChiliTheme.Colors.ChiliActionBottomSheetAccentButtonTextColor,
                    onClick = {
                        scope.launch { sheetState.bottomSheetState.hide() }
                    }),
            )
        ) {

        }
    }
}