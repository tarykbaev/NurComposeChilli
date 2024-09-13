package com.design.composechili.components.common.chiliMaterialDesignSlider

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
fun ChiliMaterialDesignSlider(
    initialValue: Float = 0.0f,
    description: String = "Slider value",
    stepsSize: Int = 0,
    range: ClosedFloatingPointRange<Float> = 0f..4f,
    onValueChanged: (Float) -> Unit = {}
) {
    var sliderPosition by remember { mutableFloatStateOf(initialValue) }
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
                color = ChiliTheme.Colors.ChiliValueTextColor
            )
            MaterialDesignSlider(
                value = sliderPosition,
                valueRange = range,
                onValueChange = {
                    sliderPosition = it
                    onValueChanged(it.roundToInt().toFloat())
                },
                colors = SliderDefaultsM2.colors(
                    thumbColor = ChiliTheme.Colors.ChiliLinkTextColor,
                    disabledThumbColor = ChiliTheme.Colors.ChiliLinkTextColor,
                    activeTrackColor = ChiliTheme.Colors.ChiliLinkTextColor,
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
        ChiliMaterialDesignSlider(stepsSize = 40, range = 0f..20f)
        ChiliMaterialDesignSlider(range = 0f..4f)
    }
}