package com.design.composechili.components.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme
import kotlin.math.roundToInt

@Composable
fun ChiliSliderM2() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    ChiliTheme {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "Slider value ${sliderPosition.roundToInt()}",
                color = ChiliTheme.Colors.chiliValueTextColor
            )
            Slider(
                value = sliderPosition,
                valueRange = 0f..100f,
                onValueChange = { sliderPosition = it },
                colors = SliderDefaults.colors(
                    thumbColor = ChiliTheme.Colors.chiliLinkTextColor,
                    disabledThumbColor = ChiliTheme.Colors.chiliLinkTextColor,
                    activeTrackColor = ChiliTheme.Colors.chiliLinkTextColor,
                    inactiveTrackColor = ChiliTheme.Colors.chiliCheckBoxDisabledColor,
                    disabledInactiveTrackColor = ChiliTheme.Colors.chiliCheckBoxDisabledColor,
                    inactiveTickColor = ChiliTheme.Colors.chiliLinkTextColor
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliSliderM2_Preview() {
    ChiliSliderM2()
}