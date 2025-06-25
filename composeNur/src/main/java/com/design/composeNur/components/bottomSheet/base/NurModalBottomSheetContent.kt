package com.design.composeNur.components.bottomSheet.base

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NurModalBottomSheetContent(
    modifier: Modifier = Modifier,
    hasCloseIcon: Boolean = true,
    params: NurModalBottomSheetParams,
    onDismissRequest: () -> Unit,
    content: @Composable ColumnScope.() -> Unit,
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(),
        shape = params.topRoundedCornerShape,
        color = params.backgroundColor,
        contentColor = Color.Unspecified
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            if (hasCloseIcon) {
                IconButton(
                    onClick = onDismissRequest,
                    modifier = Modifier
                        .align(Alignment.End)
                ) {
                    Icon(
                        tint = Color.Unspecified,
                        painter = params.closeIcon,
                        contentDescription = "ModalBottomSheet close icon"
                    )
                }
            } else Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
}