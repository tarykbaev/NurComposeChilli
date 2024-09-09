package com.design.composechili.components.inAppPush

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Composable
fun BaseInAppPush(
    modifier: Modifier = Modifier,
    params: BaseInAppPushParams = BaseInAppPushParams.Default,
    inAppPushPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 24.dp),
    rootContentPadding: PaddingValues = PaddingValues(8.dp),
    onDismissRequest: () -> Unit,
    isCloseButtonEnable: Boolean = true,
    closeButtonSize:Dp = 24.dp,
    cornerRadius: Dp = ChiliTheme.Attribute.ChiliInAppPushCornerRadius,
    content: @Composable () -> Unit,
) {

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(Gravity.BOTTOM)
        ChiliTheme {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(inAppPushPadding,),
                colors = CardDefaults.cardColors(containerColor = params.contentColor),
                shape = RoundedCornerShape(cornerRadius),
            ) {
                Column(Modifier.padding(rootContentPadding)) {
                    if (isCloseButtonEnable) {
                        IconButton(
                            modifier = Modifier.align(Alignment.End).size(closeButtonSize),
                            onClick = onDismissRequest
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.chili_ic_clear_24),
                                contentDescription = String()
                            )
                        }
                    }
                    content()
                }
            }
        }
    }
}

@Stable
data class BaseInAppPushParams(
    val bottomSheetShadowElevation: Dp,
    val backgroundDimmingColor: Color,
    val contentColor: Color
) {

    companion object {
        val Default
            @Composable
            get() = BaseInAppPushParams(
                bottomSheetShadowElevation = 12.dp,
                backgroundDimmingColor = colorResource(id = R.color.black_1),
                contentColor = ChiliTheme.Colors.ChiliInAppPushBackgroundColor
            )
    }

}