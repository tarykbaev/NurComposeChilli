package com.design.composeNur.components.common.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun NurPagerIndicator(
    modifier: Modifier,
    items: List<Any>,
    currentIndex: Int,
    params: NurPagerDotIndicatorParams = NurPagerDotIndicatorParams.Default
) {
    Row(
        modifier = modifier.wrapContentWidth(),
        horizontalArrangement = Arrangement.spacedBy(params.spacing),
        verticalAlignment = Alignment.CenterVertically
    ) {

        items.forEachIndexed { index, _ ->
            val isSelected = index == currentIndex

            Box(
                modifier = Modifier
                    .size(if (isSelected) params.selectedSize else params.unselectedSize)
                    .background(if (isSelected) params.selectedColor else params.unselectedColor, params.shape)
            )
        }
    }
}