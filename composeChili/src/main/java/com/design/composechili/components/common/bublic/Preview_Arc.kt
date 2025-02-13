package com.design.composechili.components.common.bublic

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun Preview_Arc() {
    var limit by remember { mutableLongStateOf(51200L) }
    var left by remember { mutableLongStateOf(24000L) }
    val listOfSmallIcons = listOf(
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
    )

    ChiliTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = limit.toString(),
                onValueChange = { limit = it.toLong() },
                label = { Text("Type total limit") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
            OutlinedTextField(
                left.toString(),
                onValueChange = { left = it.toLong() },
                label = { Text("Type limit left") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

            ProgressCircleBar(
                limit = limit,
                left = left,
                isUnlimited = false,
                bottomUrlImageList = listOfSmallIcons
            )
        }
    }
}

@Composable
fun ProgressCircleBar(
    modifier: Modifier = Modifier,
    size: Dp = 70.dp,
    @DrawableRes centeredImage: Int = R.drawable.ic_internet_32_dp,
    bottomUrlImageList: List<String> = listOf(),
    limit: Long = 51200L,
    left: Long = 39219L,
    isUnlimited: Boolean,
) {
    val centeredImagePainter = getPainter(centeredImage)

    val imageIndex = remember { mutableIntStateOf(0) }

    val absoluteProgressAngle = 300f
    val startDegreeAngle = 120f

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
        delay(500)
        val countLimitInPercents = (left * 100) / limit
        val arcRangePercent = absoluteProgressAngle / 100f
        progress =
            if (isUnlimited) absoluteProgressAngle
            else (countLimitInPercents * arcRangePercent).coerceIn(
                0f..absoluteProgressAngle
            )
    }

    LaunchedEffect(Unit) {
        while (true) {
            animate.value = true
            delay(1000)
            animate.value = false
            delay(1000)
            imageIndex.intValue = (imageIndex.intValue + 1) % bottomUrlImageList.size
            Log.d("ProgressCircleBar", "imageIndex updated to: $imageIndex")
        }
    }

    Box(modifier = modifier) {
        Canvas(modifier = modifier.size(size),
            onDraw = {
                drawArc(
                    color = Color.LightGray,
                    startAngle = startDegreeAngle,
                    sweepAngle = absoluteProgressAngle,
                    style = Stroke(cap = StrokeCap.Round, width = size.value / 5f),
                    useCenter = false,
                )

                translate(
                    left = (this.size.width / 2) - (centeredImagePainter.intrinsicSize.width / 2),
                    top = (this.size.height / 2) - (centeredImagePainter.intrinsicSize.height / 2)
                ) {
                    with(centeredImagePainter) {
                        draw(
                            size = centeredImagePainter.intrinsicSize
                        )
                    }
                }
                drawArc(
                    color = Color(0xFF5AC8FA),
                    startAngle = startDegreeAngle,
                    sweepAngle = progressAnimation.coerceIn(0f..absoluteProgressAngle),
                    style = Stroke(cap = StrokeCap.Round, width = size.value / 5f),
                    useCenter = false,
                )
            })
        AnimatedVisibility(
            visible = animate.value,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .size(size / 4, size / 4),
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = bottomUrlImageList.getOrNull(imageIndex.intValue),
                    onSuccess = { it.painter },
                ),
                contentDescription = "",
            )
        }
    }
}

@Composable
private fun getPainter(image: Int): Painter {
    val vector = ImageVector.vectorResource(id = image)
    val painter = rememberVectorPainter(image = vector)
    return painter
}