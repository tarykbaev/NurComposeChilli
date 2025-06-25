package com.design.composeNur.components.common.nurMaterialDesignSlider

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
import com.design.composeNur.theme.NurTheme
import java.util.Locale

@Composable
fun NurMaterialDesignSlider(
    initialValue: Float = 0.0f,
    description: String = "Slider value",
    stepsSize: Int = 0,
    range: ClosedFloatingPointRange<Float> = 0f..4f,
    onValueChanged: (Float) -> Unit = {}
) {
    var sliderPosition by remember { mutableFloatStateOf(initialValue) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "$description ${
                String.format(
                    Locale.ROOT,
                    "%.1f",
                    sliderPosition
                )
            }",
            color = NurTheme.Colors.NurValueTextColor
        )
        MaterialDesignSlider(
            value = sliderPosition,
            valueRange = range,
            onValueChange = {
                sliderPosition = it
                onValueChanged(it)
            },
            colors = SliderDefaultsM2.colors(
                thumbColor = NurTheme.Colors.NurLinkTextColor,
                disabledThumbColor = NurTheme.Colors.NurLinkTextColor,
                activeTrackColor = NurTheme.Colors.NurLinkTextColor,
                inactiveTrackColor = NurTheme.Colors.NurCheckBoxDisabledColor,
                disabledInactiveTrackColor = NurTheme.Colors.NurCheckBoxDisabledColor,
                inactiveTickColor = NurTheme.Colors.NurPrimaryTextColor,
                activeTickColor = NurTheme.Colors.NurPrimaryTextColor
            ),
            steps = stepsSize,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NurSliderM2_Preview() {
    NurTheme {
        Column {
            NurMaterialDesignSlider(stepsSize = 40, range = 0f..20f)
            NurMaterialDesignSlider(range = 0f..4f)
        }
    }
}