package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.R
import com.design.composechili.components.navBar.navBarWithFab.ChiliNavBarWithFab
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavWithFab
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChiliTheme {
                Scaffold(
                    bottomBar = {
                        ChiliNavBarWithFab(
                            navItems = listOf(
                                ChiliNavWithFab.ChiliNavButton(
                                    icon = R.drawable.ic_home,
                                    label = "Главная"
                                ),
                                ChiliNavWithFab.ChiliNavButton(
                                    icon = R.drawable.ic_payment,
                                    label = "Платежи"
                                ),
                                ChiliNavWithFab.ChiliNavFloatActionButton(
                                    icon = R.drawable.ic_scaner_48
                                ),
                                ChiliNavWithFab.ChiliNavButton(
                                    icon = R.drawable.ic_history,
                                    label = "История"
                                ),
                                ChiliNavWithFab.ChiliNavButton(
                                    icon = R.drawable.ic_menu,
                                    label = "Ещё"
                                ),
                            ),
                            onNavigateItemClicked = { }
                        )
                    }
                ) { paddingValues ->
                    Box(modifier = Modifier.background(color = Color.Black)) {
                        Image(
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize(),
                            painter = painterResource(id = R.drawable.ic_cat),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}