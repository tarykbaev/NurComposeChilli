package com.design.composechili.components.bottom_sheet

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.extensions.isExpanded
import com.design.composechili.extensions.isExpanding
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    isHidden: Boolean = true,
    hasCloseIcon: Boolean = false,
    collapseOnBackPressed: Boolean = true,
    cornerRadius: Dp = 8.dp,
    dragAreaColor: Color? = null,
    isBackgroundDimmingEnabled: Boolean = true,
    bottomSheetContent: @Composable () -> Unit,
    screenContent: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()

    ChiliTheme {
        val alpha = animateFloatAsState(
            targetValue = if (isBackgroundDimmingEnabled && sheetState.isExpanding()) 0.5f else 0f,
            animationSpec = tween(durationMillis = 500),
            label = "dimming animation"
        )

        BottomSheetScaffold(
            sheetContent = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(ChiliTheme.Colors.chiliSurfaceBackground)
                ) {

                    if (hasCloseIcon) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                .clickable {
                                    scope.launch { sheetState.bottomSheetState.hide() }
                                },
                            painter = painterResource(id = R.drawable.chili_ic_clear_24),
                            contentDescription = "Base Bottom Sheet close icon"
                        )
                    }

                    bottomSheetContent()
                }

                BackHandler(enabled = collapseOnBackPressed && sheetState.isExpanded()) {
                    scope.launch { sheetState.bottomSheetState.hide() }
                }
            },
            scaffoldState = sheetState,
            sheetShape = RoundedCornerShape(topEnd = cornerRadius, topStart = cornerRadius),
            sheetContainerColor = dragAreaColor ?: ChiliTheme.Colors.chiliScreenBackground,
            sheetContentColor = ChiliTheme.Colors.chiliCheckBoxCheckedColor,
            sheetDragHandle = { if (dragAreaColor != null) BottomSheetDefaults.DragHandle() },
            sheetPeekHeight = if (isHidden) 0.dp else BottomSheetDefaults.SheetPeekHeight
        ) {
            screenContent()

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = alpha.value))
            )
        }
    }
}