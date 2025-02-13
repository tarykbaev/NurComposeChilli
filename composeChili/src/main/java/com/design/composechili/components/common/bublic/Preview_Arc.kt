package com.design.composechili.components.common.bublic

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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
        "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png",
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

            Row {
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

@Composable
fun AnimatedLeftOver(
    modifier: Modifier = Modifier,
    leftOverParams: AnimatedLeftOverParams,
    limit: Long = 0L,
    left: Long = 0L,
    isUnlimited: Boolean,
    bottomUrlImageList: List<String> = listOf(),
) {
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
        }
    }

    Box(modifier = modifier) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(leftOverParams.centeredImage),
            contentDescription = ""
        )
        Canvas(modifier = modifier.size(leftOverParams.size),
            onDraw = {
                drawArc(
                    color = leftOverParams.arcBackgroundColor,
                    startAngle = startDegreeAngle,
                    sweepAngle = absoluteProgressAngle,
                    style = Stroke(cap = StrokeCap.Round, width = leftOverParams.size.value / 4f),
                    useCenter = false,
                )
                drawArc(
                    color = leftOverParams.arcProgressColor,
                    startAngle = startDegreeAngle,
                    sweepAngle = progressAnimation.coerceIn(0f..absoluteProgressAngle),
                    style = Stroke(cap = StrokeCap.Round, width = leftOverParams.size.value / 4f),
                    useCenter = false,
                )
            })
        AnimatedVisibility(
            visible = animate.value,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .size(leftOverParams.size / 3, leftOverParams.size / 3)
                .offset(x = 0.dp, y = 8.dp),
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

data class AnimatedLeftOverParams(
    val size: Dp = 60.dp,
    val arcBackgroundColor: Color = Color.LightGray,
    val arcProgressColor: Color = Color(0xFF5AC8FA),
    @DrawableRes val centeredImage: Int = R.drawable.ic_internet_32_dp,
    ){
    companion object {
        val Internet @Composable get() = AnimatedLeftOverParams(
            size = 60.dp,
            arcBackgroundColor = ChiliTheme.Colors.ChiliLeftOverBackgroundColor,
            arcProgressColor = colorResource(R.color.cyan_1),
            centeredImage = R.drawable.ic_internet_32_dp,

        )
        val Call @Composable get() = AnimatedLeftOverParams(
            size = 60.dp,
            arcBackgroundColor = ChiliTheme.Colors.ChiliLeftOverBackgroundColor,
            arcProgressColor = colorResource(R.color.green_1),
            centeredImage = R.drawable.ic_calls_outer_32_dp
        )
    }
}