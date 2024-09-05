package com.design.composechili.extensions

import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isExpanding() : Boolean = bottomSheetState.targetValue == SheetValue.Expanded

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isExpanded() : Boolean = bottomSheetState.currentValue == SheetValue.Expanded

@OptIn(ExperimentalMaterial3Api::class)
fun BottomSheetScaffoldState.isNotHidden() : Boolean = bottomSheetState.currentValue != SheetValue.Hidden

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun getBottomSheetState() = rememberBottomSheetScaffoldState(
    bottomSheetState = rememberModalBottomSheetState()
)