package com.design.composechili.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

fun Modifier.spacerVerticalDefaultPadding(
    topPadding: Dp = 0.dp,
    bottomPadding: Dp = 0.dp
): Modifier {
    return this
        .fillMaxWidth()
        .padding(top = topPadding, bottom = bottomPadding)
}

@Composable
fun Modifier.clickableWithSimpleRippleEffect(onClick: () -> Unit): Modifier {
    return this.clickable(
        indication = ripple(color = ChiliTheme.Colors.СhiliRippleForegroundColor),
        interactionSource = remember { MutableInteractionSource() },
        onClick = onClick
    )
}

@Composable
fun rememberPressState(): MutableState<Boolean> {
    return remember { mutableStateOf(false) }
}

fun Modifier.pressEffect(
    pointerInputKey: Any?,
    isPressedState: MutableState<Boolean>,
    onPress: (() -> Unit)? = null,
    onTap: (() -> Unit)? = null
): Modifier = then(
    Modifier.pointerInput(pointerInputKey) {
        detectTapGestures(
            onPress = {
                isPressedState.value = true
                onPress?.invoke()
                try {
                    tryAwaitRelease()
                } finally {
                    isPressedState.value = false
                }
            },
            onTap = { onTap?.invoke() }
        )
    }
)