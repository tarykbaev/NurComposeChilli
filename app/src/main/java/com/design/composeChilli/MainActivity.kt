package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.inAppPush.BaseInAppPush
import com.design.composechili.components.inAppPush.InfoInAppPush
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ChiliTheme {
                var alertDialogState by rememberSaveable { mutableStateOf(true) }
                var banner by rememberSaveable { mutableStateOf(String()) }
                val scope = rememberCoroutineScope()

                if (alertDialogState) {
                    InfoInAppPush(
                        title = "Test Title",
                        description = "\"Описание описания, которое описывает описанное описание описанного описания,\\n\" +\n" +
                                "                        \"максимум из 190 символов, но если ничего \\n\\n\" +\n" +
                                "                        \"не помещается, не проблема, потому что у нас всегда есть спецсимвол такой как троеточиеef evremiv ervmeive ervnervn ervnervne enruvneuv eunrvuernv eurnvueirv eurnvuev eurnvuev ervneurv\"",
                        buttonText = "Детали",
                        banner = banner,
                        onDismissRequest = {
                            alertDialogState = !alertDialogState
                        },
                        onClickListener = {
                            scope.launch {
                                banner = "https://mir-s3-cdn-cf.behance.net/project_modules/1400/73d91461797801.5a7a3b14e7f04.png"
                            }
                        }
                    )
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