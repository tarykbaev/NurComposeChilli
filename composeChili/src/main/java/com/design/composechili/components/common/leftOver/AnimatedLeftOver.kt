package com.design.composechili.components.common.leftOver

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.ABSOLUTE_PROGRESS_ANGLE
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.ARC_ANIMATION_DURATION
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.BACKGROUND_ARC_WIDTH_DIVIDER
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.PROGRESS_ARC_WIDTH_DIVIDER
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.START_PROGRESS_ANGLE
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams.Companion.TETHERING_ANIMATION_DURATION
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import kotlinx.coroutines.delay

/**
 * Displays an animated circular progress arc with an optional image overlay that cycles periodically.
 * Useful for visualizing usage like internet or call limits.
 *
 * @param modifier Modifier to be applied to the container.
 * @param leftOverParams UI parameters including arc size, colors, and image resource.
 * @param limit Total value for the limit (e.g., total data).
 * @param left Remaining value of the limit (e.g., data left).
 * @param isUnlimited If true, the progress arc shows as full.
 * @param isAnimationActive If true animate images from bottomUrlImageList.
 * @param bottomUrlImageList Optional list of image URLs that will rotate periodically at the bottom.
 *
 */

@Composable
fun AnimatedLeftOver(
    modifier: Modifier = Modifier,
    leftOverParams: AnimatedLeftOverParams,
    limit: Long = leftOverParams.limit,
    left: Long = leftOverParams.left,
    isUnlimited: Boolean,
    isAnimationActive: Boolean = true,
    bottomUrlImageList: List<String>? = listOf(),
) {
    val imageIndex = remember { mutableIntStateOf(0) }

    val absoluteProgressAngle = ABSOLUTE_PROGRESS_ANGLE
    val startDegreeAngle = START_PROGRESS_ANGLE

    var progress by remember { mutableFloatStateOf(0f) }
    val animate = remember { mutableStateOf(false) }
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = SpringSpec(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )

    LaunchedEffect(left, limit, isUnlimited) {
        progress = 0f
        delay(ARC_ANIMATION_DURATION)
        val countLimitInPercents = if (limit != 0L && left != 0L) (left * 100) / limit else 0L
        val arcRangePercent = absoluteProgressAngle / 100f
        progress =
            if (isUnlimited) absoluteProgressAngle
            else (countLimitInPercents * arcRangePercent).coerceIn(
                0f..absoluteProgressAngle
            )
    }

    LaunchedEffect(!bottomUrlImageList.isNullOrEmpty()) {
        while (isAnimationActive) {
            animate.value = true
            delay(TETHERING_ANIMATION_DURATION)
            animate.value = false
            delay(TETHERING_ANIMATION_DURATION)
            if (bottomUrlImageList != null) {
                imageIndex.intValue = (imageIndex.intValue + 1) % bottomUrlImageList.size
            }
        }
    }

    Box(modifier) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(leftOverParams.centeredImage),
            contentDescription = ""
        )
        Canvas(
            modifier = Modifier.size(leftOverParams.size),
            onDraw = {
                drawArc(
                    color = leftOverParams.arcBackgroundColor,
                    startAngle = startDegreeAngle,
                    sweepAngle = absoluteProgressAngle,
                    style = Stroke(
                        cap = StrokeCap.Round,
                        width = leftOverParams.size.value / BACKGROUND_ARC_WIDTH_DIVIDER
                    ),
                    useCenter = false,
                )
                drawArc(
                    color = leftOverParams.arcProgressColor,
                    startAngle = startDegreeAngle,
                    sweepAngle = progressAnimation.coerceIn(0f..absoluteProgressAngle),
                    style = Stroke(
                        cap = StrokeCap.Round,
                        width = leftOverParams.size.value / PROGRESS_ARC_WIDTH_DIVIDER
                    ),
                    useCenter = false,
                )
            })
        AnimatedVisibility(
            visible = animate.value,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(leftOverParams.size / 3, leftOverParams.size / 3)
                .offset(x = 0.dp, y = 8.dp),
        ) {
            AsyncImage(
                model = bottomUrlImageList?.getOrNull(imageIndex.intValue),
                contentDescription = "Tethering animated icons"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_Arc() {
    var limit by remember { mutableLongStateOf(51200L) }
    var left by remember { mutableLongStateOf(24000L) }
    val listOfSmallIcons = listOf(
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png",
    )

    ChiliTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(ChiliTheme.Colors.ChiliCardViewBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = limit.toString(),
                onValueChange = {
                    limit = if (it.isNotBlank()) it.filter { char -> !char.isWhitespace() && char.isDigit() }
                        .toLong() else 0L
                },
                label = { Text("Type total limit") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = ChiliTextStyleBuilder.H7.Primary.Default
            )
            OutlinedTextField(
                left.toString(),
                onValueChange = {
                    left = if (it.isNotBlank()) it.filter { char -> !char.isWhitespace() && char.isDigit() }
                        .toLong() else 0L
                },
                label = { Text("Type limit left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                textStyle = ChiliTextStyleBuilder.H7.Primary.Default
            )

            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .padding(vertical = 8.dp)
            ) {
                AnimatedLeftOver(
                    modifier = Modifier.padding(12.dp),
                    limit = limit,
                    left = left,
                    isUnlimited = false,
                    bottomUrlImageList = listOfSmallIcons,
                    leftOverParams = AnimatedLeftOverParams.Internet
                )

                VerticalDivider(modifier = Modifier.padding(horizontal = 8.dp))

                AnimatedLeftOver(
                    modifier = Modifier.padding(12.dp),
                    limit = limit,
                    left = left,
                    isUnlimited = false,
                    bottomUrlImageList = listOfSmallIcons,
                    leftOverParams = AnimatedLeftOverParams.Call
                )
            }
        }
    }
}