package com.design.composechili.components.slider

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme
import java.util.Locale
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiliSliderCustom(
    description: String = String(),
    stepsSize: Int = 0,
    range: ClosedFloatingPointRange<Float> = 0f..4f,
    onValueChanged: (Float) -> Unit = {},
) {

    var sliderValueState by remember { mutableFloatStateOf(0.0f) }
    val interactionSource = remember { MutableInteractionSource() }
    val text = description.ifBlank {
        "Spring animation float value ${
            String.format(
                Locale.ROOT,
                "%.1f",
                sliderValueState
            )
        }"
    }
    val onPress by interactionSource.collectIsDraggedAsState()
    val sizeScale by animateFloatAsState(
        targetValue = if (onPress) 1.2f else 1f,
        label = "Button Animation",
        animationSpec = tween(300)
    )

    ChiliTheme {
        Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)) {
            Text(
                text = text,
                color = ChiliTheme.Colors.chiliValueTextColor
            )
            Slider(
                value = sliderValueState,
                onValueChange = {
                    sliderValueState = it
                    onValueChanged((sliderValueState.roundToInt().toFloat()))
                },

                interactionSource = interactionSource,
                steps = stepsSize,
                onValueChangeFinished = {},
                valueRange = range,
                thumb = {
                    Spacer(
                        Modifier
                            .graphicsLayer {
                                scaleX = sizeScale
                                scaleY = sizeScale
                            }
                            .size(10.dp)
                            .offset(x = 4.dp, y = 5.dp)
                            .indication(
                                interactionSource = interactionSource,
                                indication = rememberRipple(bounded = false, radius = 15.dp)
                            )
                            .background(
                                ChiliTheme.Colors.chiliLinkTextColor,
                                RoundedCornerShape(20.dp)
                            )
                    )
                },
                track = { sliderState ->
                    SliderDefaults.Track(
                        sliderState = sliderState,
                        colors = SliderDefaults.colors(
                            activeTrackColor = ChiliTheme.Colors.chiliLinkTextColor,
                            inactiveTickColor = ChiliTheme.Colors.chiliValueTextColor,
                            disabledInactiveTickColor = Color.Black,
                            activeTickColor = Color.Black,
                            disabledActiveTickColor = Color.Black
                        )
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChiliSlider_Preview() {
    Column {
        ChiliSliderCustom(stepsSize = 9)
        ChiliSliderCustom()
    }
}