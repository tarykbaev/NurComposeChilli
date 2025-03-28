package com.design.composeChilli.screen

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
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.buttons.loaderButton.LoaderButton
import com.design.composechili.components.buttons.quickActionButton.QuickActionButton
import com.design.composechili.theme.ChiliTheme

@Composable
fun ButtonsScreen() {
    val scrollState = rememberScrollState()
    var isButtonLoading by rememberSaveable { mutableStateOf(false) }

    ChiliTheme {

    }

    Column(
        Modifier
            .background(ChiliTheme.Colors.ChiliSurfaceBackground)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        LoaderButton(isLoading = isButtonLoading) {
            NurChiliButton(
                onClick = { isButtonLoading = isButtonLoading.not() },
                title = "Loader Button",
                buttonStyle = ChiliButtonStyle.Primary
            )
        }
        NurChiliButton(
            modifier = Modifier
                .align(Alignment.End)
                .wrapContentSize(),
            onClick = { isButtonLoading = isButtonLoading.not() },
            title = "stop loader",
            buttonStyle = ChiliButtonStyle.ComponentButton
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurChiliButton(onClick = { }, title = "Primary button", buttonStyle = ChiliButtonStyle.Primary)
        Spacer(modifier = Modifier.size(16.dp))
        NurChiliButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = ChiliButtonStyle.Primary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        NurChiliButton(
            onClick = { },
            title = "Secondary button",
            buttonStyle = ChiliButtonStyle.Secondary
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurChiliButton(
            onClick = { },
            title = "Secondary button disabled",
            buttonStyle = ChiliButtonStyle.Secondary,
            isEnabled = false
        )
        Spacer(modifier = Modifier.size(32.dp))
        NurChiliButton(
            onClick = { },
            title = "Additional Button",
            buttonStyle = ChiliButtonStyle.Additional
        )
        Spacer(modifier = Modifier.size(16.dp))
        NurChiliButton(
            onClick = { },
            title = "Additional Button disabled",
            buttonStyle = ChiliButtonStyle.Additional,
            isEnabled = false,
        )
        Spacer(modifier = Modifier.size(12.dp))
        NurChiliButton(
            modifier = Modifier
                .align(Alignment.Start)
                .wrapContentSize(),
            onClick = { },
            buttonPadding = PaddingValues(0.dp),
            title = "Component button",
            buttonStyle = ChiliButtonStyle.ComponentButton
        )
        NurChiliButton(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Start),
            onClick = { },
            buttonPadding = PaddingValues(0.dp),
            isEnabled = false,
            title = "Component button disabled",
            buttonStyle = ChiliButtonStyle.ComponentButton
        )
        Spacer(modifier = Modifier.size(12.dp))
        NurChiliButton(
            onClick = {},
            endIcon = painterResource(id = com.design.composechili.R.drawable.ic_market),
            title = "Iconed button",
            buttonStyle = ChiliButtonStyle.Additional
        )

        Spacer(modifier = Modifier.size(12.dp))
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            QuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = com.design.composechili.R.drawable.ic_favourite,
                rippleIcon = com.design.composechili.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composechili.R.drawable.ic_favourite_disabled
            ) {}

            Spacer(modifier = Modifier.size(12.dp))
            QuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                enabled = false,
                visible = false,
                icon = com.design.composechili.R.drawable.ic_favourite,
                rippleIcon = com.design.composechili.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composechili.R.drawable.ic_favourite_disabled
            ) {}

            Spacer(modifier = Modifier.size(12.dp))
            QuickActionButton(
                modifier = Modifier,
                title = "To favorites",
                icon = com.design.composechili.R.drawable.ic_favourite,
                rippleIcon = com.design.composechili.R.drawable.ic_ripple_favourite,
                disabledIcon = com.design.composechili.R.drawable.ic_favourite_disabled
            ) {}
        }
    }
}