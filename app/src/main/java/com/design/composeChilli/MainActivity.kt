package com.design.composeChilli

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.BaseSnackBar
import com.design.composechili.components.cell.BaseCell
import com.design.composechili.components.cell.BaseCellParams
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember {
                SnackbarHostState()
            }


            ChiliTheme {
                Scaffold(
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState,
                            modifier = Modifier,
                            snackbar = {
                                BaseSnackBar(
                                    text = it.visuals.message,
                                    actionText = it.visuals.actionLabel.orEmpty(),
                                    isLoading = true,
                                    actionListener = {
                                        it.dismiss()
                                    })
                            })
                    }
                ) { contentPadding ->
                    Box(
                        modifier = Modifier
                            .padding(contentPadding)
                            .fillMaxSize()
                            .background(Color.Black)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Spacer(modifier = Modifier.size(54.dp))
                            Row() {
                                Spacer(modifier = Modifier.size(24.dp))
                                BaseCell(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            scope.launch {
                                                snackbarHostState.showSnackbar(
                                                    message = "testMessage",
                                                    actionLabel = "Action",
                                                    duration = SnackbarDuration.Short
                                                )
                                            }
                                        },
                                    title = "TestTitle",
                                    subtitle = "TestSubtitle",
                                    isChevronVisible = true,
                                    isDividerVisible = true,
                                    baseCellParams = BaseCellParams.Default.copy(cornerMode = CellCornerMode.Top)
                                )
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                            Row() {
                                Spacer(modifier = Modifier.size(24.dp))
                                BaseCell(
                                    modifier = Modifier.weight(1f),
                                    title = "SecondTestTitle",
                                    isChevronVisible = true,
                                    isDividerVisible = true,
                                    baseCellParams = BaseCellParams.Default.copy(cornerMode = CellCornerMode.Middle)
                                )
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                            Row() {
                                Spacer(modifier = Modifier.size(24.dp))
                                BaseCell(
                                    modifier = Modifier.weight(1f),
                                    title = "ThirdTestTitle",
                                    subtitle = "ThirdTestSubtitle",
                                    isChevronVisible = true,
                                    isDividerVisible = true,
                                    baseCellParams = BaseCellParams.Default.copy(cornerMode = CellCornerMode.Bottom)
                                )
                                Spacer(modifier = Modifier.size(24.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}