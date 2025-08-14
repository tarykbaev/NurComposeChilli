package com.design.composeNur.components.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme

@Composable
fun Modifier.shimmerEffect(targetValue: Float = 1000f, colors: List<Color>? = null): Modifier {
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.6f),
        Color.LightGray.copy(alpha = 0.2f),
        Color.LightGray.copy(alpha = 0.6f)
    )

    val transition = rememberInfiniteTransition(label = "shimmerTransition")
    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = targetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = FastOutSlowInEasing)
        ),
        label = "shimmerOffset"
    )
    val brush = Brush.linearGradient(
        colors = colors ?: shimmerColors,
        start = Offset.Zero,
        end = Offset(x = translateAnimation.value, y = translateAnimation.value)
    )
    return this.background(brush)
}

@Composable
fun Shimmer(
    modifier: Modifier = Modifier,
    height: Dp = 16.dp,
    width: Dp = 200.dp,
    roundRadius: Dp = NurTheme.Attribute.NurCellCornerRadius
) {
    Box(modifier = modifier
        .height(height)
        .width(width)
        .clip(RoundedCornerShape(roundRadius))
        .shimmerEffect())
}

@Composable
fun ShimmerOrContent(
    modifier: Modifier = Modifier,
    shimmerHeight: Dp = 16.dp,
    shimmerWidth: Dp = 200.dp,
    shimmerRoundRadius: Dp = NurTheme.Attribute.NurCellCornerRadius,
    isShimmering: Boolean = false,
    content: @Composable (() -> Unit)
) {
    if (isShimmering) {
        Shimmer(
            modifier = modifier,
            height = shimmerHeight,
            width = shimmerWidth,
            roundRadius = shimmerRoundRadius
        )
    } else {
        content.invoke()
    }
}