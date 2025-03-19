package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBar
import com.design.composechili.components.topAppBar.ChiliBaseTopAppBarParams
import com.design.composechili.theme.ChiliTheme

@Composable
fun ToolbarsScreen(onBackPressed: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(ChiliTheme.Colors.СhiliScreenBackground)
    ) {
        ChiliBaseTopAppBar(
            title = "Transparent Toolbar",
            isCenteredTitle = true,
            navigationIcon = painterResource(id = R.drawable.chili_ic_nav_back),
            params = ChiliBaseTopAppBarParams.Default.copy(containerColor = Color.Transparent),
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(title = "Default toolbar")
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(
            title = "Custom navigation  icon toolbar",
            navigationIcon = painterResource(id = R.drawable.chili_ic_chevron_left)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(title = "Additional text", additionalText = "5 из 10")
        ChiliBaseTopAppBar(
            title = "Additional text",
            additionalText = "Save",
            onAdditionalTextClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(title = "End icon", endIcon = painterResource(id = R.drawable.ic_cat))
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(
            title = "+996 700 123 456",
            isCenteredTitle = true,
            endIcon = painterResource(id = R.drawable.ic_cat),
            params = ChiliBaseTopAppBarParams.Default.copy(endIconSize = 54.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(
            title = "Menu toolbar",
            navigationIcon = painterResource(id = R.drawable.chili_ic_nav_back)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(
            title = "Start icon toolbar \nStart icon toolbar",
            navigationIcon = painterResource(id = R.drawable.chili_ic_nav_back),
            isDividerVisible = false
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        ChiliBaseTopAppBar(
            title = "TailedToolbarView",
            navigationIcon = painterResource(id = R.drawable.chili_ic_chevron_left),
            params = ChiliBaseTopAppBarParams.Default.copy(containerColor = Color.Transparent)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@Preview
fun ToolbarsScreenPreview() {
    ChiliTheme {
        ToolbarsScreen()
    }
}