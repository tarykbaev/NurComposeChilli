package com.design.composechili.components.bottomSheet.action

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.theme.ChiliTheme

/**
 * Used for [NurActionBottomSheet], displayed on BottomSheet with LazyColumn
 * @param [actionBottomSheetParams] ActionBottomSheetButton visual transformation params and click listener
 * @see [NurActionBottomSheet]
 */

@Composable
fun NurActionBottomSheetButton(
    title: String,
    chiliButtonStyle: ChiliButtonStyle,
    onClick: (() -> Unit)
) {
    NurChiliButton(
        onClick = { onClick.invoke() },
        title = title,
        buttonStyle = chiliButtonStyle,
        buttonPadding = PaddingValues()
    )
}

@Composable
@Preview(showBackground = true)
fun ActionBottomSheetButtonPreview() {
    ChiliTheme {
        NurActionBottomSheetButton(
            title = "TestTitle",
            chiliButtonStyle = ChiliButtonStyle.Secondary,
        ) {
        }
    }
}
