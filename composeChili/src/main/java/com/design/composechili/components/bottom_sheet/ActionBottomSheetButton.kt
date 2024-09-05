package com.design.composechili.components.bottom_sheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun ActionBottomSheetButton(
    actionBottomSheetParams: ActionBottomSheetParams
) {

    ChiliTheme {

        val titleStyle = actionBottomSheetParams.titleStyle ?: ChiliTextStyle.get(
            textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
            font = ChiliTheme.Attribute.ChiliBoldTextFont
        )

        BaseButton(
            onClick = { actionBottomSheetParams.onClick?.invoke() },
            title = actionBottomSheetParams.title,
            buttonStyle = ChiliButtonStyle.Secondary,
            titleStyle = titleStyle.copy(actionBottomSheetParams.buttonTextColor)
        )
    }
}

@Stable
data class ActionBottomSheetParams(
    val title: String,
    val buttonTextColor: Color,
    val onClick: (() -> Unit)? = null,
    val titleStyle: TextStyle? = null
)
