package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.R
import com.design.composechili.components.topAppBar.ChiliCustomBaseTopAppBar
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChiliTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    ChiliCustomBaseTopAppBar(
                        title = "Transparent TopAppBar",
                        containerColor = Color.Transparent,
                        navigationIcon = R.drawable.chili_ic_nav_back,
                        isCenteredTitle = true,
                        isDividerVisible = false
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "Default TopAppBar"
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "Custom navigation icon TopAppBar",
                        navigationIcon = R.drawable.ic_cat
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "Additional Text",
                        additionalText = "5 из 10"
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "End Icon",
                        endIcon = R.drawable.ic_cat
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "+996 704 055 063",
                        endIcon = R.drawable.ic_cat,
                        isCenteredTitle = true,
                        endIconSize = 52.dp
                    )

                    Spacer(modifier = Modifier.size(16.dp))
                    ChiliCustomBaseTopAppBar(
                        title = "Menu TopAppBar",
                        navigationIcon = R.drawable.chili_ic_nav_back
                    )
                }
            }
        }
    }
}

fun get(
    textSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.Unspecified,
    font: Font = Font(R.font.roboto_regular)
): TextStyle {
    return TextStyle(fontSize = textSize, color = color, fontFamily = font.toFontFamily())
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1,
        color = ChiliTheme.Colors.chiliErrorTextColor
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}