package com.design.composechili.components.slider

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import java.util.Locale
import kotlin.math.roundToInt

@Composable
fun ChiliSliderM2(
    description: String = "Slider value",
    stepsSize: Int = 0,
    range: ClosedFloatingPointRange<Float> = 0f..4f,
    onValueChanged: (Float) -> Unit = {}
) {
    var sliderPosition by remember { mutableFloatStateOf(0.0f) }
    ChiliTheme {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(
                text = "$description ${
                    String.format(
                        Locale.ROOT,
                        "%.1f",
                        sliderPosition
                    )
                }",
                color = ChiliTheme.Colors.chiliValueTextColor
            )
            SliderM2(
                value = sliderPosition,
                valueRange = range,
                onValueChange = {
                    sliderPosition = it
                    onValueChanged(it.roundToInt().toFloat())
                },
                colors = SliderDefaultsM2.colors(
                    thumbColor = ChiliTheme.Colors.chiliLinkTextColor,
                    disabledThumbColor = ChiliTheme.Colors.chiliLinkTextColor,
                    activeTrackColor = ChiliTheme.Colors.chiliLinkTextColor,
                    inactiveTrackColor = ChiliTheme.Colors.chiliCheckBoxDisabledColor,
                    disabledInactiveTrackColor = ChiliTheme.Colors.chiliCheckBoxDisabledColor,
                    inactiveTickColor = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    activeTickColor = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                steps = stepsSize,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliSliderM2_Preview() {
    Column {
        ChiliSliderM2(stepsSize = 40, range = 0f..20f)
        ChiliSliderM2(range = 0f..4f)
    }
}