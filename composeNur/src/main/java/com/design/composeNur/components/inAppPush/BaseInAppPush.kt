package com.design.composeNur.components.inAppPush

import android.view.Gravity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A base component for displaying an in-app push notification or message. It provides customizable
 * padding, corner radius, and optional close button functionality.
 *
 * @param modifier Modifier to be applied to the in-app push container, allowing layout customizations such as size, alignment, and padding.
 * Default is `Modifier`.
 *
 * @param params [BaseInAppPush] visual transformation params and elevations. Default is `BaseInAppPushParams.Default`
 *
 * @param inAppPushPadding Padding to be applied around the entire in-app push component.
 * This defines the spacing between the content and the boundaries of the push notification.
 * Default is `PaddingValues(horizontal = 8.dp, vertical = 24.dp)`.
 *
 * @param rootContentPadding Padding values applied inside the root content of the in-app push notification,
 * defining the space around the actual content. Default is `PaddingValues(8.dp)`.
 *
 * @param onDismissRequest A lambda function that is invoked when the user requests to dismiss the in-app push.
 * This can be triggered by the close button or other gestures, enabling dismissal logic such as hiding the notification.
 *
 * @param isCloseButtonEnable A Boolean flag that controls whether a close button is displayed on the in-app push.
 * If `true`, a close button will be visible and clickable. Default is `true`.
 *
 * @param closeButtonSize A `Dp` value representing the size of the close button.
 * Default is `24.dp`.
 *
 * @param cornerRadius A `Dp` value representing the corner radius of the in-app push notification.
 * This defines how rounded the corners of the notification will be. Default is `NurTheme.Attribute.NurInAppPushCornerRadius`.
 *
 * @param content A composable lambda function representing the main content to be displayed inside the in-app push notification.
 * This allows any custom content, such as text, images, or buttons, to be passed.
 *
 * Example Usage:
 * ```
 * BaseInAppPush(
 *     onDismissRequest = { /* Handle dismiss */ },
 *     content = {
 *         Text("This is an in-app push message")
 *     }
 * )
 * ```
 *
 * @see [BaseInAppPushParams.Default]
 */

@Composable
fun BaseInAppPush(
    modifier: Modifier = Modifier,
    params: BaseInAppPushParams = BaseInAppPushParams.Default,
    inAppPushPadding: PaddingValues = PaddingValues(horizontal = 8.dp, vertical = 24.dp),
    rootContentPadding: PaddingValues = PaddingValues(8.dp),
    onDismissRequest: () -> Unit,
    isCloseButtonEnable: Boolean = true,
    closeButtonSize: Dp = 24.dp,
    cornerRadius: Dp = NurTheme.Attribute.NurInAppPushCornerRadius,
    content: @Composable () -> Unit,
) {

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        dialogWindowProvider.window.setGravity(Gravity.BOTTOM)
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(inAppPushPadding),
            colors = CardDefaults.cardColors(containerColor = params.contentColor),
            shape = RoundedCornerShape(cornerRadius),
        ) {
            Column(
                Modifier
                    .padding(rootContentPadding)
                    .align(Alignment.CenterHorizontally)
            ) {
                if (isCloseButtonEnable) {
                    IconButton(
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(closeButtonSize),
                        onClick = onDismissRequest
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.nur_ic_clear_24),
                            contentDescription = String()
                        )
                    }
                }
                content()
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
                contentColor = NurTheme.Colors.NurInAppPushBackgroundColor
            )
    }
}

@Preview(device = Devices.PIXEL_5, showBackground = true)
@Composable
fun BaseInAppPushPreview() {
    NurTheme {
        Column(Modifier.fillMaxSize()) {
            BaseInAppPush(
                isCloseButtonEnable = true,
                onDismissRequest = { /* Handle dismiss */ },
                content = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        text = "This is an in-app push message"
                    )
                }
            )
        }
    }
}