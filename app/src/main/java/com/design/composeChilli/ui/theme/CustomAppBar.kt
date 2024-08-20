package com.design.composeChilli.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
    title: String,
    isTitleCentered: Boolean,
    navIcon: @Composable (() -> Unit)? = null,
    endIcon: @Composable (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    (if (!isTitleCentered) navIcon else null)?.let {
        TopAppBar(
        modifier = modifier,
        title = {
            if (isTitleCentered) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = title)
                }
            } else {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (navIcon != null) {
                        Box(Modifier.padding(end = 8.dp)) {
                            navIcon()
                        }
                    }
                    Text(text = title, modifier = Modifier.weight(1f))
                    if (endIcon != null) {
                        Box(Modifier.padding(start = 8.dp)) {
                            endIcon()
                        }
                    }
                }
            }
        },
        navigationIcon = it,
        actions = {
            if (!isTitleCentered && endIcon != null) {
                endIcon()
            }
        }
    )
    }
}
