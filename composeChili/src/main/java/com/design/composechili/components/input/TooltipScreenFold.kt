package com.design.composechili.components.input

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun TooltipScreenFold(
    tooltipContent: @Composable () -> Unit,
    mainContent: @Composable (Modifier) -> Unit
) {

    var isShowTooltip by remember { mutableStateOf(false) }


    Column {
        mainContent(
            Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                isShowTooltip = !isShowTooltip
            }
        )
        if (isShowTooltip){

        }
    }

}

