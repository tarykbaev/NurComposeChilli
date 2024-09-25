package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.snackbar.BaseSnackBar
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.spacerVerticalDefaultPadding
import kotlinx.coroutines.launch

@Composable
fun SnackbarScreen() {
    val loadingSnackbarHostState = remember { SnackbarHostState() }
    val imageSnackbarHostState = remember { SnackbarHostState() }
    val simpleSnackbarHostState = remember { SnackbarHostState() }
    val topGravitySnackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Scaffold(
            containerColor = ChiliTheme.Colors.ChiliSurfaceBackground,
            snackbarHost = {
                SnackbarHost(hostState = simpleSnackbarHostState) {
                    BaseSnackBar(
                        modifier = Modifier,
                        title = it.visuals.message,
                        isLoading = false
                    )
                }

                SnackbarHost(hostState = loadingSnackbarHostState) {
                    BaseSnackBar(
                        modifier = Modifier,
                        title = it.visuals.message,
                        isLoading = true
                    )
                }

                SnackbarHost(hostState = imageSnackbarHostState) {
                    BaseSnackBar(
                        modifier = Modifier,
                        title = it.visuals.message,
                        startIcon = com.design.composechili.R.drawable.ic_cat
                    )
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                Spacer(modifier = Modifier.spacerVerticalDefaultPadding(16.dp))
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            simpleSnackbarHostState.showSnackbar(message = "Hello")
                        }
                    },
                    title = "Simple Snackbar"
                )

                Spacer(modifier = Modifier.spacerVerticalDefaultPadding(16.dp))
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            loadingSnackbarHostState.showSnackbar(
                                message = "Snackbar message"
                            )
                        }
                    },
                    title = "Loading Snackbar"
                )

                Spacer(modifier = Modifier.spacerVerticalDefaultPadding(16.dp))
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            imageSnackbarHostState.showSnackbar(
                                message = "Warning snackbar"
                            )
                        }
                    },
                    title = "Custom warning snackbar"
                )

                Spacer(modifier = Modifier.spacerVerticalDefaultPadding(16.dp))
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        scope.launch {
                            topGravitySnackbarHostState.showSnackbar(
                                message = "Top Snackbar",
                                actionLabel = "OK",
                            )
                        }
                    },
                    title = "Top snackbar"
                )
            }
        }
        SnackbarHost(
            modifier = Modifier.align(Alignment.TopCenter),
            hostState = topGravitySnackbarHostState
        ) {
            BaseSnackBar(
                modifier = Modifier,
                title = it.visuals.message,
                actionText = it.visuals.actionLabel ?: "",
                actionListener = {
                    scope.launch {
                        simpleSnackbarHostState.showSnackbar(
                            message = "Action"
                        )
                    }
                }
            )
        }
    }
}
