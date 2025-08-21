package com.design.composeNur.components.common

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R
import kotlin.math.abs

@Composable
fun AnimatedProgressLine(
    modifier: Modifier = Modifier,
    progressPercent: Int = 0,
    isProgressAnimated: Boolean = false,
    progressColor: Color = colorResource(R.color.green_1),
    progressBackgroundColor: Color = colorResource(R.color.gray_4),
    progressGradientStartColor: Color? = null,
    progressGradientCenterColor: Color? = null,
    progressGradientEndColor: Color? = null,
    backgroundHeight: Dp = 6.dp,
    trackHeight: Dp = 6.dp,
    animationDuration: Int = 1000
) {

    val animatedProgress = if (isProgressAnimated) {
        animateIntAsState(
            targetValue = progressPercent,
            animationSpec = tween(durationMillis = animationDuration)
        ).value
    } else {
        progressPercent
    }

    val maxHeight = maxOf(backgroundHeight, trackHeight)

    Canvas(modifier = modifier.height(maxHeight).fillMaxWidth()) {
        val widthPx = size.width
        val roundOffset = (backgroundHeight.toPx() / 2f) + abs(trackHeight.toPx() - backgroundHeight.toPx()) / 2

        // Draw background line
        drawLine(
            color = progressBackgroundColor,
            start = Offset(roundOffset, roundOffset),
            end = Offset(widthPx - roundOffset, roundOffset),
            strokeWidth = backgroundHeight.toPx(),
            cap = StrokeCap.Round
        )

        // Draw progress line
        if (animatedProgress > 0) {
            val progressPx = (widthPx / 100f * animatedProgress).coerceAtLeast(trackHeight.toPx())
            val gradientBrush = when {
                progressGradientStartColor != null && progressGradientEndColor != null && progressGradientCenterColor != null -> Brush.linearGradient(
                    colors = listOf(progressGradientStartColor, progressGradientCenterColor, progressGradientEndColor),
                    start = Offset(0f, 0f),
                    end = Offset(progressPx, trackHeight.toPx())
                )
                progressGradientStartColor != null && progressGradientEndColor != null -> Brush.linearGradient(
                    colors = listOf(progressGradientStartColor, progressGradientEndColor),
                    start = Offset(0f, 0f),
                    end = Offset(progressPx, trackHeight.toPx())
                )
                else -> null
            }

            drawLine(
                brush = gradientBrush ?: SolidColor(progressColor),
                start = Offset(roundOffset, roundOffset),
                end = Offset(progressPx - roundOffset, roundOffset),
                strokeWidth = trackHeight.toPx(),
                cap = StrokeCap.Round
            )
        }
    }
}

@Preview
@Composable
fun AnimatedProgressLinePreview() {
    NurTheme {
        AnimatedProgressLine(
            modifier = Modifier.fillMaxWidth(),
            progressPercent = 75,
            isProgressAnimated = true,
            progressColor = colorResource(R.color.green_1),
            progressBackgroundColor = colorResource(R.color.gray_4),
            backgroundHeight = 4.dp,
            trackHeight = 6.dp
        )
    }
}