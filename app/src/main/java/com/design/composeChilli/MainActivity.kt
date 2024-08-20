package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.R
import com.design.composechili.components.toolbar.ChiliCustomBaseTopAppBar
import com.design.composechili.theme.ChiliTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
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
                    ChiliCustomBaseTopAppBar(
                        modifier = Modifier,
                        title = "Android Developer",
                        additionalText = "4 from 9",
                        isCenteredTitle = false,
                    ) {}

                    ChiliCustomBaseTopAppBar(
                        modifier = Modifier,
                        title = "Android Developer",
                        navigationIcon = R.drawable.chili_ic_nav_back,
                        isCenteredTitle = true,
                    ) {}

                    ChiliCustomBaseTopAppBar(
                        modifier = Modifier,
                        title = "Android Developer",
                        navigationIcon = R.drawable.chili_ic_nav_back,
                        isCenteredTitle = false,
                        endIcon = R.drawable.chili_ic_test_trash
                    ) {}

                    CenterAlignedTopAppBar(
                        modifier = Modifier,
                        title = {
                            Text(
                                modifier = Modifier,
                                text = "Android Developer",
                                style = get(
                                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                                    ChiliTheme.Colors.chiliPrimaryTextColor,
                                    ChiliTheme.Attribute.ChiliBoldTextFont
                                )
                            )
                        },
                        navigationIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.view_24dp)),
                                    painter = painterResource(R.drawable.chili_ic_nav_back),
                                    contentDescription = "back",
                                    tint = ChiliTheme.Colors.ChiliToolbarIconsTint
                                )
                            }
                        },
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(
                                    modifier = Modifier
                                        .size(dimensionResource(R.dimen.view_24dp)),
                                    painter = painterResource(R.drawable.chili_ic_airpods),
                                    contentDescription = "back",
                                    tint = ChiliTheme.Colors.ChiliToolbarIconsTint
                                )
                            }
                        }
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