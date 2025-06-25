package com.design.composeNur.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.components.buttons.loaderButton.NurLoaderButton
import com.design.composeNur.components.buttons.quickActionButton.NurQuickActionButton
import com.design.composeNur.theme.NurTheme

@Composable
fun ButtonsScreen() {
    val scrollState = rememberScrollState()
    var isButtonLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .background(NurTheme.Colors.NurSurfaceBackground)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        NurLoaderButton(isLoading = isButtonLoading) {
            NurButton(
                onClick = { isButtonLoading = isButtonLoading.not() },
                title = "Loader Button",
                buttonStyle = NurButtonStyle.Primary
            )
        }
        NurButton(
            modifier = Modifier
                .align(Alignment.End)
                .wrapContentSize(),
            onClick = { isButtonLoading = isButtonLoading.not() },
            title = "stop loader",
            buttonStyle = NurButtonStyle.ComponentButton
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurButton(onClick = { }, title = "Primary button", buttonStyle = NurButtonStyle.Primary)
        Spacer(modifier = Modifier.size(16.dp))
        NurButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = NurButtonStyle.Primary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        NurButton(
            onClick = { },
            title = "Secondary button",
            buttonStyle = NurButtonStyle.Secondary
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = NurButtonStyle.Secondary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        NurButton(
            onClick = { },
            title = "Additional Button",
            buttonStyle = NurButtonStyle.Additional
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurButton(
            onClick = { },
            title = "Additional Button disabled",
            buttonStyle = NurButtonStyle.Additional,
            isEnabled = false,
        )
        Spacer(modifier = Modifier.size(12.dp))
        NurButton(
            modifier = Modifier
                .align(Alignment.Start)
                .wrapContentSize(),
            onClick = { },
            buttonPadding = PaddingValues(0.dp),
            title = "Component button",
            buttonStyle = NurButtonStyle.ComponentButton
        )
        NurButton(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            onClick = { },
            buttonPadding = PaddingValues(0.dp),
            isEnabled = false,
            title = "Component button disabled",
            buttonStyle = NurButtonStyle.ComponentButton
        )
        Spacer(modifier = Modifier.size(12.dp))
        NurButton(
            onClick = {},
            endIcon = painterResource(id = com.design.composenur.R.drawable.ic_market),
            title = "Iconed button",
            buttonStyle = NurButtonStyle.Additional
        )

        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            NurQuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = com.design.composenur.R.drawable.ic_favourite,
                rippleIcon = com.design.composenur.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composenur.R.drawable.ic_favourite_disabled
            ) {}

            Spacer(modifier = Modifier.size(12.dp))
            NurQuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                enabled = false,
                visible = false,
                icon = com.design.composenur.R.drawable.ic_favourite,
                rippleIcon = com.design.composenur.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composenur.R.drawable.ic_favourite_disabled
            ) {}

            Spacer(modifier = Modifier.size(12.dp))
            NurQuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = com.design.composenur.R.drawable.ic_favourite,
                rippleIcon = com.design.composenur.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composenur.R.drawable.ic_favourite_disabled
            ) {}
        }
    }
}