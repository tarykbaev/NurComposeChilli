package com.design.composechili.components.bottomSheet.actionBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme

/**
 * Used for [ActionBottomSheetContent], displayed on BottomSheet with LazyColumn
 * @param [actionBottomSheetParams] ActionBottomSheetButton visual transformation params and click listener
 * @see [ActionBottomSheetContent]
 */

@Composable
fun ActionBottomSheetButton(
    title: String,
    chiliButtonStyle: ChiliButtonStyle,
    onClick: (() -> Unit)
) {
    NurChiliButton(
        onClick = { onClick.invoke() },
        title = title,
        buttonStyle = ChiliButtonStyle.Secondary,
    )
}

@Composable
@Preview(showBackground = true)
fun ActionBottomSheetButtonPreview() {
    ChiliTheme {
        ActionBottomSheetButton(
            title = "TestTitle",
            chiliButtonStyle = ChiliButtonStyle.Secondary,
        ) {
        }
    }
}
