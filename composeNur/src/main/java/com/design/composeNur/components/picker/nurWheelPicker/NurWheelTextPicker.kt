package com.design.composeNur.components.picker.nurWheelPicker

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

/**
 * A custom composable function that displays a wheel-style text picker, allowing the user to scroll
 * through and select from a list of text options.
 *
 * @param modifier A [Modifier] to configure the layout or decoration of the composable. Can be used for
 * padding, size, or other styling. Defaults to [Modifier] with no modifications. And applying to root @Composable function
 *
 * @param startIndex An integer representing the initial index of the selected text in the list when the
 * picker is first displayed. Defaults to `0`, which corresponds to the first item in the list.
 *
 * @param size A [DpSize] specifying the width and height of the text picker. Defaults to 128.dp in both
 * width and height.
 *
 * @param texts A list of [String] values representing the options available for selection in the wheel.
 * This list must be provided by the caller and contains the text items displayed in the picker.
 *
 * @param rowCount An integer indicating the number of visible rows in the wheel picker, controlling how
 * many text items are visible at one time. This parameter must be provided by the caller.
 *
 * @param style A [TextStyle] to define the appearance of the text inside the picker, including properties
 * like font size, color, and font family. Must be provided by the caller for custom text styling.
 *
 * @param onScrollFinished A callback function that is triggered when the user finishes scrolling the wheel
 * and a text item is snapped into place. The callback provides the snapped index of the selected text item
 * and returns an optional [Int?]. The default is a no-op that returns `null`.
 */

@Composable
fun NurWheelTextPicker(
    modifier: Modifier = Modifier,
    startIndex: Int = 0,
    size: DpSize = DpSize(128.dp, 128.dp),
    texts: List<String>,
    rowCount: Int,
    style: TextStyle,
    onScrollFinished: (snappedIndex: Int) -> Int? = { null },
) {
    NurWheelPicker(
        modifier = modifier,
        startIndex = startIndex,
        wheeSize = size,
        count = texts.size,
        rowCount = rowCount,
        onScrollFinished = onScrollFinished
    ) { index ->
        Text(
            text = texts[index],
            style = style,
            color = style.color,
            maxLines = 1
        )
    }
}