package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.BaseSnackBar
import com.design.composechili.components.cell.BaseCell
import com.design.composechili.components.cell.BaseCellParams
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.components.navBar.NavBarWithFab
import com.design.composechili.components.navBar.model.ChiliNavItems
import com.design.composechili.components.slider.ChiliSlider
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
            var stiffnessValue by remember { mutableFloatStateOf(0f) }
            var animationValue by remember { mutableFloatStateOf(0f) }

            ChiliTheme {
                Scaffold(
                    bottomBar = {
                        NavBarWithFab(
                            animationSize = animationValue,
                            stiffness = stiffnessValue,
                            items = listOf(
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_home_filled,
                                    unselectedIcon = R.drawable.ic_home,
                                    text = "Главная"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_payment_filled,
                                    unselectedIcon = R.drawable.ic_payment,
                                    text = "Платежи"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_scaner_48,
                                    unselectedIcon = R.drawable.ic_scaner_48,
                                    isFab = true
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_history_filled,
                                    unselectedIcon = R.drawable.ic_history,
                                    text = "История"
                                ),
                                ChiliNavItems(
                                    selectedIcon = R.drawable.ic_menu_filled,
                                    unselectedIcon = R.drawable.ic_menu,
                                    text = "Ещё"
                                ),
                            ),
                            navigate = { }
                        )
                    },
                    snackbarHost = {
                        SnackbarHost(
                            hostState = snackbarHostState,
                            modifier = Modifier,
                            snackbar = {
                                BaseSnackBar(
                                    text = it.visuals.message,
                                    actionText = it.visuals.actionLabel.orEmpty(),
                                    startIcon = R.drawable.ic_cat,
                                    actionListener = {
                                        it.dismiss()
                                    })
                            })
                    }
                ) { contentPadding ->
                    Box(
                        modifier = Modifier
                            .background(Color.Black)
                            .padding(contentPadding)
                            .fillMaxSize()
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
                            Column(
                                Modifier
                                    .padding(16.dp)
                                    .background(Color.White)
                            ) {
                                ChiliSlider(description = "Animation size $animationValue") { animationValue = it }
                                ChiliSlider(
                                    description = "Stiffness value $stiffnessValue",
                                    stepsSize = 9,
                                    range = 0f..1000f
                                ) { stiffnessValue = it }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    ChiliTheme {
        Scaffold(
            bottomBar = {
                NavBarWithFab(
                    items = listOf(
                        ChiliNavItems(
                            selectedIcon = R.drawable.ic_home_filled,
                            unselectedIcon = R.drawable.ic_home,
                            text = "Главная"
                        ),
                        ChiliNavItems(
                            selectedIcon = R.drawable.ic_payment_filled,
                            unselectedIcon = R.drawable.ic_payment,
                            text = "Платежи"
                        ),
                        ChiliNavItems(
                            selectedIcon = R.drawable.ic_scaner_48,
                            unselectedIcon = R.drawable.ic_scaner_48,
                            isFab = true
                        ),
                        ChiliNavItems(
                            selectedIcon = R.drawable.ic_history_filled,
                            unselectedIcon = R.drawable.ic_history,
                            text = "История"
                        ),
                        ChiliNavItems(
                            selectedIcon = R.drawable.ic_menu_filled,
                            unselectedIcon = R.drawable.ic_menu,
                            text = "Ещё"
                        ),
                    ),
                    navigate = { }
                )
            },
            snackbarHost = {
                SnackbarHost(
                    hostState = snackbarHostState,
                    modifier = Modifier,
                    snackbar = {
                        BaseSnackBar(
                            text = it.visuals.message,
                            actionText = it.visuals.actionLabel.orEmpty(),
                            startIcon = R.drawable.ic_cat,
                            actionListener = {
                                it.dismiss()
                            })
                    })
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(contentPadding)
                    .fillMaxSize()
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
                    ChiliSlider(description = "Animation size") {}
                    ChiliSlider(
                        description = "Stiffness value",
                        stepsSize = 9,
                        range = 0f..1000f
                    ) {}
                }
            }
        }
    }
}