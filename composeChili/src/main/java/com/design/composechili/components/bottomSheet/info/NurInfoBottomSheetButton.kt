package com.design.composechili.components.bottomSheet.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class NurInfoBottomSheetButton(
    val onClick: () -> Unit,
    val title: String,
    val buttonStyle: ChiliButtonStyle
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
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4,
                    color = ChiliTheme.Colors.ChiliErrorTextColor
                ),
                maxChars = MAX_CHARS
            )
    }
}