package com.design.composechili.components.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H6

@Composable
fun NurChiliLoader(
    isVisible: Boolean,
    onDismissRequest: () -> Unit = { }
) {
    if (isVisible) {
        Dialog(
            onDismissRequest,
            DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            )
        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(containerColor = ChiliTheme.Colors.ChiliSurfaceBackground),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp, horizontal = 48.dp)
                        .defaultMinSize(minHeight = 100.dp, minWidth = 150.dp)
                        .wrapContentSize()
                        .background(ChiliTheme.Background.color),
                    verticalArrangement = Arrangement.Center
                ) {
                    AnimatedVisibility(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        visible = true,
                        enter = fadeIn()
                    ) {
                        CircularProgressIndicator(
                            color = ChiliTheme.Colors.ChiliLoaderColor,
                            strokeWidth = 4.dp
                        )
                    }
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        text = "Loading...",
                        textAlign = TextAlign.Center,
                        style = H6.Primary.Medium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun NurChiliLoader_Preview() {
    ChiliTheme {
        NurChiliLoader(isVisible = true)
    }
}