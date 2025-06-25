package com.design.composeNur.components.bottomSheet.lazy

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H5
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder.Companion.H9

data class NurLazyBottomSheetContentParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle
) {
    companion object {

        val Default
            @Composable get() = NurLazyBottomSheetContentParams(
                titleStyle = H5.Primary.Bold,
                subtitleStyle = H9.Error.Default
            )
    }
}