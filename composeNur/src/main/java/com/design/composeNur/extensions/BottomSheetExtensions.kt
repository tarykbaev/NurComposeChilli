package com.design.composeNur.extensions

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isExpanding(): Boolean =
    bottomSheetState.targetValue == SheetValue.Expanded

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isExpanded(): Boolean =
    bottomSheetState.currentValue == SheetValue.Expanded

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isNotHidden(): Boolean =
    bottomSheetState.currentValue != SheetValue.Hidden