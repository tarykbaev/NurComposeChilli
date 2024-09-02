package com.design.composechili.components.picker.chiliWheelDatePicker

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

@Composable
fun ChiliWheelTextPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    size: DpSize = DpSize(128.dp, 128.dp),
    texts: List<String>,
    rowCount: Int,
    style: TextStyle,
    chiliSelectorProperties: ChiliWheelPickerSelectorProperties = ChiliWheelPickerSelectorProperties.Default,
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
) {
    ChiliWheelPicker(
        modifier = modifier,
        startIndex = startIndex,
        wheeSize = size,
        count = texts.size,
        rowCount = rowCount,
        chiliWheelPickerSelectorProperties = chiliSelectorProperties,
        onScrollFinished = onScrollFinished
    ){ index ->
        Text(
            text = texts[index],
            style = style,
            color = style.color,
            maxLines = 1
        )
    }
}