package com.design.composechili.components.bottom_sheet

import androidx.compose.runtime.Composable
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ActionBottomSheetButton(
    val title: String?,
    val type: ActionBottomSheetButtonType,
    val onClick: (() -> Unit)? = null
)

@Composable
fun ActionButton(
    button: ActionBottomSheetButton
) {
    ChiliTheme {
        val buttonTextColor = when (button.type) {
            ActionBottomSheetButtonType.SIMPLE -> ChiliTheme.Colors.chiliSecondaryTextColor
            ActionBottomSheetButtonType.ACCENT -> ChiliTheme.Colors.ChiliComponentButtonTextColorActive
        }

        BaseButton(
            onClick = { button.onClick?.invoke() },
            title = button.title ?: String(),
            buttonStyle = ChiliButtonStyle.Secondary,
            titleStyle = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                color = buttonTextColor,
                font = ChiliTheme.Attribute.ChiliBoldTextFont
            ),
        )
    }
}