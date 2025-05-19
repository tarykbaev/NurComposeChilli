package com.design.composeChilli.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getDrawable
import com.design.composechili.R
import com.design.composechili.components.containers.HighlightContainer
import com.design.composechili.components.containers.HighlightState
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HighlighterContainersScreen() {
    var showModalBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(ChiliTheme.Colors.СhiliScreenBackground)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            HighlightContainer(
                modifier = Modifier
                    .clickable(onClick = {
                        showModalBottomSheet = true
                    }),
                highlighterColorStart = Color.Red,
                highlighterIcon = getDrawable(LocalContext.current, R.drawable.lighting),
                highlightState = HighlightState.WITH_CIRCLE_AND_ICON
            ) {
                HighlighterView(
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            HighlightContainer(
                modifier = Modifier,
                highlighterColorStart = Color.Red,
                highlighterColorEnd = Color.Blue,
                highlightState = HighlightState.WITH_LINE_ONLY
            ) {
                HighlighterView(
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            HighlightContainer(
                modifier = Modifier,
                highlighterColorStart = Color.Red,
                highlighterColorEnd = Color.Blue,
                highlightState = HighlightState.WITHOUT_HIGHLIGHT
            ) {
                HighlighterView(
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            HighlightContainer(
                modifier = Modifier,
                highlighterColorStart = Color.Red,
                highlighterColorEnd = Color.Blue,
                highlightState = HighlightState.WITHOUT_HIGHLIGHT
            ) {
                HighlighterView(
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            HighlightContainer(
                modifier = Modifier,
                highlighterColorStart = Color.Red,
                highlighterColorEnd = Color.Blue,
                highlightState = HighlightState.WITHOUT_HIGHLIGHT
            ) {
                HighlighterView(
                    modifier = Modifier.size(86.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))
        HighlightContainer(
            modifier = Modifier.padding(horizontal = 16.dp),
            highlighterIcon = getDrawable(LocalContext.current, R.drawable.lighting),
            highlighterColorStart = Color.Red,
            highlightState = HighlightState.WITH_CIRCLE_AND_ICON
        ) {
            HighlighterView(
                modifier = Modifier.height(86.dp),
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
        HighlightContainer(
            modifier = Modifier.padding(horizontal = 16.dp),
            highlighterIcon = getDrawable(LocalContext.current, R.drawable.lighting),
            highlighterColorStart = Color.Red,
            highlightState = HighlightState.WITH_CIRCLE_AND_ICON
        ) {
            HighlighterView(
                modifier = Modifier.height(186.dp),
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH3
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        HighlightContainer(
            modifier = Modifier.padding(horizontal = 16.dp),
            highlighterColorStart = Color.Red,
            highlighterColorEnd = Color.Blue,
            highlightState = HighlightState.WITH_LINE_ONLY
        ) {
            HighlighterView(
                modifier = Modifier.height(286.dp),
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH3
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Spacer(modifier = Modifier.width(16.dp))
            CircularHighlighterView()
            Spacer(modifier = Modifier.width(16.dp))
            CircularHighlighterView(highlighterColorEnd = Color.Blue)
            Spacer(modifier = Modifier.width(16.dp))
            CircularHighlighterView(
                highlighterColorStart = Color.Green,
                highlighterColorEnd = Color.Yellow
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun HighlighterView(
    modifier: Modifier = Modifier,
    textSize: TextUnit = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH10
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {
        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.test_image),
            contentDescription = "PreviewImage"
        )
        Text(
            modifier = Modifier
                .padding(start = 8.dp, bottom = 8.dp)
                .align(Alignment.BottomStart),
            text = "Повышенный кэшбэк",
            style = ChiliTextStyle.get(
                textSize,
                ChiliTheme.Colors.ChiliPrimaryButtonTextColorActive,
                Font(R.font.roboto_medium)
            )
        )
    }
}

@Composable
fun CircularHighlighterView(
    highlighterColorStart: Color = Color.Red,
    highlighterColorEnd: Color = Color.Red
) {
    HighlightContainer(
        modifier = Modifier,
        cornerRadius = 50.dp,
        highlighterColorStart = highlighterColorStart,
        highlighterColorEnd = highlighterColorEnd,
        highlightState = HighlightState.WITH_LINE_ONLY
    ) {
        Box(
            modifier = Modifier
                .size(86.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(50.dp))
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.test_image),
                contentDescription = "PreviewImage"
            )
        }
    }
}

@Composable
@Preview
fun HighlighterContainersScreenPreview() {
    ChiliTheme {
        HighlighterContainersScreen()
    }
}