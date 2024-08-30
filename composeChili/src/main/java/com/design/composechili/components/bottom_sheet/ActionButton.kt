package com.design.composechili.components.bottom_sheet

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.extensions.collapse
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

data class ActionBottomSheetButton(
    val title: String?,
    val type: ActionBottomSheetButtonType,
    val hideBottomSheetOnClick: Boolean = true,
    val onClick: (() -> Unit)? = null
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionButton(
    button: ActionBottomSheetButton,
    sheetState: BottomSheetScaffoldState
) {
    val scope = rememberCoroutineScope()

    ChiliTheme {
        val buttonTextColor = when (button.type) {
            ActionBottomSheetButtonType.SIMPLE -> ChiliTheme.Colors.chiliSecondaryTextColor
            ActionBottomSheetButtonType.ACCENT -> ChiliTheme.Colors.ChiliComponentButtonTextColorActive
        }

        BaseButton(
            onClick = {
                button.onClick?.invoke()
                if (button.hideBottomSheetOnClick) scope.launch {
                    sheetState.collapse()
                }
            },
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