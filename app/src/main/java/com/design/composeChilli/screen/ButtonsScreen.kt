package com.design.composeChilli.screen

import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle

@Composable
fun ButtonsScreen() {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        BaseButton(onClick = { }, title = "Primary button", buttonStyle = ChiliButtonStyle.Primary)
        Spacer(modifier = Modifier.size(16.dp))
        BaseButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = ChiliButtonStyle.Primary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        BaseButton(
            onClick = { },
            title = "Secondary button",
            buttonStyle = ChiliButtonStyle.Secondary
        )
        Spacer(modifier = Modifier.size(16.dp))
        BaseButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = ChiliButtonStyle.Secondary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        BaseButton(
            onClick = { },
            title = "Additional Button",
            buttonStyle = ChiliButtonStyle.Additional
        )
        Spacer(modifier = Modifier.size(16.dp))
        BaseButton(
            onClick = { },
            title = "Additional Button disabled",
            buttonStyle = ChiliButtonStyle.Additional,
            isEnabled = false,
        )
    }
}