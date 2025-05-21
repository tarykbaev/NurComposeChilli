package com.design.composechili.components.bottomSheet.recycleBottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H5
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder.Companion.H9

data class LazyBottomSheetContentParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle
) {
    companion object {

        val Default
            @Composable get() = LazyBottomSheetContentParams(
                titleStyle = H5.Primary.Bold,
                subtitleStyle = H9.Error.Default
            )
    }
}