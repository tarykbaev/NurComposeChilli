package com.design.composeNur.components.bottomSheet.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

@Stable
data class NurInfoBottomSheetButton(
    val onClick: () -> Unit,
    val title: String,
    val buttonStyle: NurButtonStyle
)

@Stable
data class InfoBottomSheetsParams(
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
    val maxChars: Int
) {
    companion object {
        private const val MAX_CHARS = 120
        val Default
            @Composable get() = InfoBottomSheetsParams(
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor
                ),
                descriptionStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH4,
                    color = NurTheme.Colors.NurErrorTextColor
                ),
                maxChars = MAX_CHARS
            )
    }
}