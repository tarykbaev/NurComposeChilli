package com.design.composeNur.screen

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
import com.design.composenur.R
import com.design.composeNur.components.topAppBar.NurBaseTopAppBar
import com.design.composeNur.components.topAppBar.NurBaseTopAppBarParams
import com.design.composeNur.theme.NurTheme

@Composable
fun ToolbarsScreen(onBackPressed: (() -> Unit)? = null) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(NurTheme.Colors.СhiliScreenBackground)
    ) {
        NurBaseTopAppBar(
            title = "Transparent Toolbar",
            isCenteredTitle = true,
            navigationIcon = painterResource(id = R.drawable.nur_ic_nav_back),
            params = NurBaseTopAppBarParams.Default.copy(containerColor = Color.Transparent),
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(title = "Default toolbar")
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(
            title = "Custom navigation  icon toolbar",
            navigationIcon = painterResource(id = R.drawable.nur_ic_chevron_left)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(title = "Additional text", additionalText = "5 из 10")
        NurBaseTopAppBar(
            title = "Additional text",
            additionalText = "Save",
            onAdditionalTextClick = {}
        )
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(title = "End icon", endIcon = painterResource(id = R.drawable.ic_cat))
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(
            title = "+996 700 123 456",
            isCenteredTitle = true,
            endIcon = painterResource(id = R.drawable.ic_cat),
            params = NurBaseTopAppBarParams.Default.copy(endIconSize = 54.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(
            title = "Menu toolbar",
            navigationIcon = painterResource(id = R.drawable.nur_ic_nav_back)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(
            title = "Start icon toolbar \nStart icon toolbar",
            navigationIcon = painterResource(id = R.drawable.nur_ic_nav_back),
            isDividerVisible = false
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
        NurBaseTopAppBar(
            title = "TailedToolbarView",
            navigationIcon = painterResource(id = R.drawable.nur_ic_chevron_left),
            params = NurBaseTopAppBarParams.Default.copy(containerColor = Color.Transparent)
        ) {
            onBackPressed?.invoke()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@Preview
fun ToolbarsScreenPreview() {
    NurTheme {
        ToolbarsScreen()
    }
}