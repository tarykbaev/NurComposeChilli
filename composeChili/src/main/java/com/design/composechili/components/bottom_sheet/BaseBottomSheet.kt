package com.design.composechili.components.bottom_sheet

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
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
    peekHeight: Dp = BottomSheetDefaults.SheetPeekHeight,
    hasCloseIcon: Boolean = false,
    collapseOnBackPressed: Boolean = true,
    baseBottomSheetParams: BaseBottomSheetParams = BaseBottomSheetParams.Default,
    isBackgroundDimmingEnabled: Boolean = true,
    bottomSheetSwipeEnabled: Boolean = true,
    isDragHandleContentEnabled: Boolean = false,
    dragHandle: @Composable () -> Unit = { BottomSheetDefaults.DragHandle() },
    bottomSheetContent: @Composable () -> Unit,
    screenContent: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()

    ChiliTheme {

        var backgroundBoxVisibility by rememberSaveable { mutableStateOf(false) }

        BottomSheetScaffold(
            sheetContent = {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(baseBottomSheetParams.bottomSheetContentBackgroundColor)
                        .padding(bottom = baseBottomSheetParams.bottomSheetBottomPadding)
                ) {

                    if (hasCloseIcon) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                .clickable {
                                    scope.launch { sheetState.bottomSheetState.hide() }
                                },
                            colorFilter = ColorFilter.tint(ChiliTheme.Colors.ChiliBottomSheetTopDrawableColor),
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
                topStart = baseBottomSheetParams.topCornerRadius,
                topEnd = baseBottomSheetParams.topCornerRadius,
                bottomEnd = baseBottomSheetParams.bottomCornerRadius,
                bottomStart = baseBottomSheetParams.bottomCornerRadius
            ),
            sheetSwipeEnabled = bottomSheetSwipeEnabled,
            sheetShadowElevation = baseBottomSheetParams.bottomSheetShadowElevation,
            sheetContentColor = ChiliTheme.Colors.chiliCheckBoxCheckedColor,
            sheetDragHandle = if (isDragHandleContentEnabled) {
                dragHandle
            } else null,
            sheetPeekHeight = peekHeight,
        ) {
            screenContent()

            backgroundBoxVisibility = sheetState.isExpanding()

            AnimatedVisibility(
                visible = backgroundBoxVisibility,
                enter = fadeIn(animationSpec = tween(500)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(baseBottomSheetParams.backgroundColor.copy(alpha = 0.5f))
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }) {
                            scope.launch { sheetState.bottomSheetState.hide() }
                        })
            }
        }
    }
}

@Stable
data class BaseBottomSheetParams(
    val bottomSheetContentBackgroundColor: Color,
    val topCornerRadius: Dp,
    val bottomCornerRadius: Dp,
    val bottomSheetBottomPadding: Dp,
    val backgroundColor: Color,
    val bottomSheetShadowElevation: Dp
) {

    companion object {

        val Default
            @Composable
            get() = BaseBottomSheetParams(
                bottomSheetContentBackgroundColor = ChiliTheme.Colors.ChiliBottomSheetBackgroundColor,
                topCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetTopCornerRadius,
                bottomCornerRadius = ChiliTheme.Attribute.ChiliBottomSheetBottomCornerRadius,
                backgroundColor = Color.Black,
                bottomSheetBottomPadding = ChiliTheme.Attribute.ChiliBottomSheetContainerBottomMargin,
                bottomSheetShadowElevation = dimensionResource(id = R.dimen.elevation_8dp)
            )
    }

}