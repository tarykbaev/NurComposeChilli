package com.design.composeNur.components.buttons.loaderButton

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A composable function that displays a button with a loading spinner. The button can show a loading indicator
 * while performing a task and allows for custom button content. The content is provided via a composable lambda
 * and is displayed when the button is not loading.
 *
 * @param isLoading A [Boolean] indicating whether the button is in a loading state. If `true`, a loading spinner
 * is shown. If `false`, the button content is displayed. This parameter is required and must be provided by the
 * caller.
 *
 * @param progressColor A [Color] used for the color of the loading spinner. Defaults to a color resource identified
 * by `R.color.magenta_1`.
 *
 * @param strokeWidth A [Dp] representing the thickness of the loading spinner's stroke. Defaults to 4.dp.
 *
 * @param buttonContent A composable lambda function that defines the content of the button, which is displayed
 * when the button is not in the loading state. This parameter is required and must be provided by the caller.
 */

@Composable
fun NurLoaderButton(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    progressColor: Color = colorResource(id = R.color.magenta_1),
    strokeWidth: Dp = 4.dp,
    buttonContent: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .wrapContentSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = isLoading, enter = fadeIn()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center),
                color = progressColor,
                strokeWidth = strokeWidth
            )
        }

        AnimatedVisibility(visible = !isLoading, exit = fadeOut()) {
            buttonContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoaderButtonPreview() {
    NurTheme {
        var isLoadingState by remember { mutableStateOf(false) }
        Column {
            Spacer(modifier = Modifier.size(40.dp))
            NurLoaderButton(isLoading = isLoadingState) {
                NurButton(
                    onClick = {
                        isLoadingState = !isLoadingState
                    },
                    title = "base Nur button"
                )
            }
        }
    }
}