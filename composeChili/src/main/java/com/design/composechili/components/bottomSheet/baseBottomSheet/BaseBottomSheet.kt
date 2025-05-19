package com.design.composechili.components.bottomSheet.baseBottomSheet

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.extensions.isExpanded
import com.design.composechili.extensions.isExpanding
import kotlinx.coroutines.launch

/**
 * @param [modifier] Will be applied to sheetContent root composable
 * @param [sheetState] Bottom sheet state, hosting state like expanded or not
 ** @see [BottomSheetScaffoldState]
 * @param [peekHeight] The default peek height used by BottomSheetScaffold.
 * @param [hasCloseIcon] The icon which will show up on the top right corner of the sheet
 * @param [collapseOnBackPressed] System back button handler enable/disable flag. Button will hide bottomSheet
 * @param [nurChiliModalBottomSheetParams] BottomSheet visual transformation params
 * @param [isBackgroundDimmingEnabled] Background dimming enable/disable flag
 * @param [bottomSheetSwipeEnabled] Bottom sheet swipe(drag) enable/disable flag
 * @param [isDragHandleContentEnabled] Drag handle enable/disable flag
 * @param [dragHandle] Drag handle composable content, by default is [BottomSheetDefaults.DragHandle].Will show on the top of the sheet
 * @param [bottomSheetContent] BottomSheet content, which will show in the bottomSheet
 * @param [screenContent] Screen content, which should be covered by the [BaseBottomSheet]. Bottom Sheet will show over this content
 * @sample [NurChiliModalBottomSheetParams]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    peekHeight: Dp = BottomSheetDefaults.SheetPeekHeight,
    hasCloseIcon: Boolean = false,
    collapseOnBackPressed: Boolean = true,
    nurChiliModalBottomSheetParams: NurChiliModalBottomSheetParams = NurChiliModalBottomSheetParams.Default,
    isBackgroundDimmingEnabled: Boolean = true,
    bottomSheetSwipeEnabled: Boolean = true,
    isDragHandleContentEnabled: Boolean = false,
    dragHandle: @Composable () -> Unit = { BottomSheetDefaults.DragHandle() },
    bottomSheetContent: @Composable () -> Unit,
    screenContent: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()

    var backgroundBoxVisibility by rememberSaveable { mutableStateOf(false) }

    BottomSheetScaffold(
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .background(nurChiliModalBottomSheetParams.backgroundColor)
                    .padding(bottom = nurChiliModalBottomSheetParams.bottomPadding)
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .animateContentSize()
            ) {
                if (hasCloseIcon) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(nurChiliModalBottomSheetParams.closeIconPadding)
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
        sheetShape = RoundedCornerShape(
            topStart = nurChiliModalBottomSheetParams.topCornerRadius,
            topEnd = nurChiliModalBottomSheetParams.topCornerRadius,
            bottomEnd = nurChiliModalBottomSheetParams.bottomCornerRadius,
            bottomStart = nurChiliModalBottomSheetParams.bottomCornerRadius
        ),
        sheetContainerColor = nurChiliModalBottomSheetParams.backgroundColor,
        sheetSwipeEnabled = bottomSheetSwipeEnabled,
        sheetShadowElevation = nurChiliModalBottomSheetParams.shadowElevation,
        sheetContentColor = nurChiliModalBottomSheetParams.backgroundColor,
        sheetDragHandle = if (isDragHandleContentEnabled) {
            dragHandle
        } else null,
        sheetPeekHeight = peekHeight,
    ) {
        screenContent()

        backgroundBoxVisibility = sheetState.isExpanding() && isBackgroundDimmingEnabled

        AnimatedVisibility(
            visible = backgroundBoxVisibility,
            enter = fadeIn(animationSpec = tween(500)),
            exit = fadeOut(animationSpec = tween(500))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(nurChiliModalBottomSheetParams.backgroundDimmingColor.copy(alpha = 0.5f))
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }) {
                        scope.launch { sheetState.bottomSheetState.hide() }
                    })
        }
    }
}