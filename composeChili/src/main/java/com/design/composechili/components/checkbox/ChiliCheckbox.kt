package com.design.composechili.components.checkbox

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.theme.ChiliTheme

/**
 * @param [isChecked] indicates the current state of the checkbox.
 * @param [chiliCheckboxParams] accepts [ChiliCheckboxParams] to customize the colors.
 * @param [onCheckedChange] sets the handler for checkbox state changes, called whenever the state changes.
 */
@Composable
fun ChiliCheckbox(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    chiliCheckboxParams: ChiliCheckboxParams = ChiliCheckboxParams.Default,
    onCheckedChange: (Boolean) -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val scale by animateFloatAsState(
        targetValue = if (interactionSource.collectIsPressedAsState().value) 0.9f else 1f,
        label = "M2CheckBoxAnim"
    )

    Box(
        modifier = modifier
            .scale(scale)
            .animateContentSize()
            .wrapContentSize()
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            interactionSource = interactionSource,
            colors = CheckboxDefaults.colors(
                checkedColor = chiliCheckboxParams.checkedColor,
                uncheckedColor = chiliCheckboxParams.uncheckedColor,
                disabledCheckedColor = chiliCheckboxParams.disabledColor
            )
        )
    }
}

@Preview
@Composable
fun ChiliCheckboxPreview() {
    ChiliTheme {
        ChiliCheckbox(
            isChecked = true
        )
    }
}