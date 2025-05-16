package com.design.composechili.components.bottomSheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.theme.ChiliTheme

@Composable
fun BottomSheetDragHandle(
    modifier: Modifier = Modifier,
    width: Dp = 40.dp,
    height: Dp = 3.dp,
    verticalPadding: Dp = 6.dp,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    color: Color = ChiliTheme.Colors.ChiliBottomSheetDragHandleColor,
) {
    Surface(
        modifier = modifier
            .padding(vertical = verticalPadding),
        color = color,
        shape = shape
    ) {
        Box(
            Modifier
                .size(
                    width = width,
                    height = height
                )
        )
    }
}

@Composable
@Preview
fun BottomSheetDragHandlePreview() {
    ChiliTheme {
        BottomSheetDragHandle()
    }
}