package com.design.composeNur.components.bottomSheet.action

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.theme.NurTheme

/**
 * Used for [NurActionBottomSheet], displayed on BottomSheet with LazyColumn
 * @param [actionBottomSheetParams] ActionBottomSheetButton visual transformation params and click listener
 * @see [NurActionBottomSheet]
 */

@Composable
fun NurActionBottomSheetButton(
    title: String,
    nurButtonStyle: NurButtonStyle,
    onClick: (() -> Unit)
) {
    NurButton(
        onClick = { onClick.invoke() },
        title = title,
        buttonStyle = nurButtonStyle,
        buttonPadding = PaddingValues()
    )
}

@Composable
@Preview(showBackground = true)
fun ActionBottomSheetButtonPreview() {
    NurTheme {
        NurActionBottomSheetButton(
            title = "TestTitle",
            nurButtonStyle = NurButtonStyle.Secondary,
        ) {
        }
    }
}
