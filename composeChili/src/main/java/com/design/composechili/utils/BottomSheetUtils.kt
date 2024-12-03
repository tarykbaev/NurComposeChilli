package com.design.composechili.utils

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api


@OptIn(ExperimentalMaterial3Api::class)
suspend fun BottomSheetScaffoldState.hide(){
    bottomSheetState.hide()
}

@OptIn(ExperimentalMaterial3Api::class)
suspend fun BottomSheetScaffoldState.expand(){
    bottomSheetState.expand()
}
