package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.BaseInput
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChiliTheme {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
                    var text by remember { mutableStateOf(String()) }
                    BaseInput(
                        textFieldValue = text,
                        onValueChange = {
                            text = it
                        },
                        hint = "Test Hint Test Hint"
                    )
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
        fontSize = ChiliTheme.attribute.chiliTextSizeH1,
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