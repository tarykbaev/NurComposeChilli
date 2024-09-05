package com.design.composechili.components.bottomSheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.extensions.isExpanding
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BaseInAppPush(
    modifier: Modifier = Modifier,
    bottomSheetState: BottomSheetScaffoldState,
    params: BaseInAppPushParams = BaseInAppPushParams.Default,
    boxPadding:PaddingValues = PaddingValues(16.dp),
    cornerRadius: Dp = ChiliTheme.Attribute.ChiliInAppPushCornerRadius,
    isBackgroundDimmingEnabled:Boolean = true,
    screenContent: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()

    ChiliTheme {


    }
}

@Stable
data class BaseInAppPushParams(
    val bottomSheetShadowElevation:Dp,
    val backgroundDimmingColor:Color,
    val contentColor:Color
){

    companion object{
        val Default
        @Composable
        get() = BaseInAppPushParams(
            bottomSheetShadowElevation = 12.dp,
            backgroundDimmingColor = colorResource(id = R.color.black_1),
            contentColor = ChiliTheme.Colors.ChiliInAppPushBackgroundColor
        )
    }

}