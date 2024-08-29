package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.containers.highlight.HighlightContainer
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.tooltip.ChiliTooltip
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember {
                SnackbarHostState()
            }

            var maskedValueState by remember {
                mutableStateOf(String())
            }
            val linearGradient = remember {
                Brush.linearGradient(listOf(Color.Red, Color.Blue))
            }

            ChiliTheme {
                Column {
                    Spacer(modifier = Modifier.height(80.dp))
                    ChiliTooltip(
                        title = "Услуга Где Дети",
                        subtitle = "Услуга Где Дети Описание ",
                        requesterView = { clickListenerModifier ->
                            InputFieldWithDescAndAction(
                                descriptionModifier = clickListenerModifier,
                                description = "Test description",
                                actionTitle = "Test Action"
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    value = "Test Message",
                                    onValueChange = {})
                            }
                        },
                    )

                    HighlightContainer(
                        modifier = Modifier
                            .padding(start = 12.dp, top = 12.dp),
                        borderGradient = linearGradient,
                        cornerRadius = 60.dp
                    ) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(50.dp))
                        ) {
                            Image(
                                modifier = Modifier.fillMaxSize(),
                                contentDescription = "Gay",
                                painter = painterResource(com.design.composechili.R.drawable.test_image),
                                contentScale = ContentScale.Crop,
                            )
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