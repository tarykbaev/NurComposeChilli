package com.design.composechili.components.bottomSheet.actionBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * Used for [ActionBottomSheet], displayed on BottomSheet with LazyColumn
 * @param [actionBottomSheetParams] ActionBottomSheetButton visual transformation params and click listener
 * @see [ActionBottomSheet]
 */

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
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ActionBottomSheetButtonPreview() {
    ChiliTheme {
        ActionBottomSheetButton(
            actionBottomSheetParams = ActionBottomSheetParams(
                title = "TestTitle",
                buttonTextColor = ChiliTheme.Colors.ChiliComponentButtonTextColorActive,
            )
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
