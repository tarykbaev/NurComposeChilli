package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.components.cell.baseCell.BaseCell
import com.design.composechili.theme.ChiliTheme

@Composable
fun CellsScreen() {

    val scrollState = rememberScrollState()

    ChiliTheme {
        Column(
            Modifier
                .background(ChiliTheme.Colors.ChiliSurfaceBackground)
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.size(12.dp))
            BaseCell(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                title = "BaseCell",
                subtitle = "ChevronVisible",
                isChevronVisible = true,
                isDividerVisible = false,
            )
        }
    }
}