package com.design.composechili.components.buttons.loaderButton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.theme.ChiliTheme

@Composable
fun LoaderButton(
    isLoading: Boolean,
    onClick: () -> Unit,
    buttonTitle: String,
    progressColor: Color = colorResource(id = R.color.magenta_1),
    strokeWidth: Dp = 4.dp
) {
    ChiliTheme {
        val animatedAlpha by animateFloatAsState(
            targetValue = if (isLoading) 1.0f else 0f,
            label = "alpha"
        )

        AnimatedVisibility(visible = true) {
            Box(modifier = Modifier
                .wrapContentSize()
                .fillMaxWidth()) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .width(48.dp)
                            .graphicsLayer { alpha = animatedAlpha }
                            .align(Alignment.Center),
                        color = progressColor,
                        strokeWidth = strokeWidth
                    )
                } else {
                    BaseButton(onClick = onClick, title = buttonTitle)
                }
            }
        }
        }
    }