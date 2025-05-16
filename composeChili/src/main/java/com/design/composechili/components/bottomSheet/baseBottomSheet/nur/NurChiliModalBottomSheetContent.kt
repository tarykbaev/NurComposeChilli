package com.design.composechili.components.bottomSheet.baseBottomSheet.nur

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.ripple
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheetParams
import com.design.composechili.theme.ChiliTheme

@Composable
fun NurChiliModalBottomSheetContent(
    modifier: Modifier = Modifier,
    hasCloseIcon: Boolean = true,
    params: BaseBottomSheetParams,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .windowInsetsPadding(WindowInsets.systemBars)
            .fillMaxWidth(),
        color = params.bottomSheetContentBackgroundColor,
        contentColor = Color.Unspecified
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (hasCloseIcon) {
                Image(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(params.closeIconPadding)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = ripple(
                                color = ChiliTheme.Colors.СhiliRippleForegroundColor
                            )
                        ) {
                            onDismissRequest()
                        },
                    painter = params.closeIcon,
                    contentDescription = "ModalBottomSheet close icon"
                )
            }
            content()
        }
    }
}