package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.toolbar.ChiliBaseToolbar
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChiliTheme {
                val composableScope = rememberCoroutineScope()

                var isVisible by remember { mutableStateOf(false) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "Transparent Toolbar",
                        containerColor = Color.Transparent,
                        navigationIcon = com.design.composechili.R.drawable.chili_ic_nav_back,
                    ) {}

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "Toolbar with NavIcon"
                    ) {}

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "Custom Navigation Toolbar",
                        startIcon = com.design.composechili.R.drawable.chili_ic_card_oil
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "Additional Text",
                        additionalText = "5 из 10"
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "End Icon",
                        endIcon = com.design.composechili.R.drawable.chili_ic_card_oil
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliBaseToolbar(
                        modifier = Modifier,
                        title = "Menu Toolbar",
                        navigationIcon = com.design.composechili.R.drawable.chili_ic_nav_back
                    ) {}
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1,
        color = ChiliTheme.colors.chiliErrorTextColor
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}