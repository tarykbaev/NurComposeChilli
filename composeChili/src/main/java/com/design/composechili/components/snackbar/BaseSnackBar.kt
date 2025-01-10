package com.design.composechili.components.snackbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

/**
 * @param [title] main information title
 * @param [actionText] action button title
 * @param [isLoading]  u can set visibility state of progress in snackBar
 * @param [startIcon] accept [DrawableRes] set [Image] on the start in snackBar
 * @param [actionListener] will invoke when user will click [actionText]
 * @param [dismissAction] will invoke when snackBar will dismiss
 * @param [params] snackBar visual transformation params
 * @sample BaseSnackBarParams.Default
 */

@Composable
fun BaseSnackBar(
    title: String,
    modifier: Modifier = Modifier,
    actionText: String = String(),
    isLoading: Boolean = false,
    @DrawableRes startIcon: Int? = null,
    actionListener: (() -> Unit)? = null,
    dismissAction: (() -> Unit)? = null,
    params: BaseSnackBarParams = BaseSnackBarParams.Default
) {
    Snackbar(
        modifier = modifier
            .defaultMinSize(minHeight = 50.dp)
            .padding(
                horizontal = ChiliTheme.Attribute.ChiliSnackbarContentPaddingHorizontal,
                vertical = ChiliTheme.Attribute.ChiliSnackbarContentPaddingVertical
            ),
        shape = RoundedCornerShape(params.cornersSize),
        containerColor = params.containerColor,
        action = {
            Text(actionText, color = params.actionTextColor, modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.padding_16dp),
                    vertical = ChiliTheme.Attribute.ChiliSnackbarContentPaddingVertical
                )
                .clickable { actionListener?.invoke() })
        },
        dismissAction = { dismissAction?.invoke() },
        content = {
            Row(
                modifier = Modifier
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        strokeWidth = 2.dp,
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.view_32dp)),
                        color = params.textColor,
                    )
                }
                if (startIcon != null) {
                    Image(
                        modifier = Modifier
                            .size(
                                width = ChiliTheme.Attribute.ChiliSnackbarIconWidth,
                                height = ChiliTheme.Attribute.ChiliSnackbarIconHeight
                            ),
                        painter = painterResource(id = startIcon),
                        contentDescription = "Base SnackBar start icon"
                    )
                }

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(start = 12.dp),
                    style = params.textStyle,
                    text = title,
                    color = params.textColor
                )
            }
        },
    )
}

@Preview
@Composable
fun BaseSnackBarPreview() {
    ChiliTheme {
        val scope = rememberCoroutineScope()
        val snackBarHostState = remember { SnackbarHostState() }

        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackBarHostState) {
                    BaseSnackBar(modifier = Modifier, title = it.visuals.message, isLoading = true)
                }
            },
            content = { padding ->
                NurChiliButton(modifier = Modifier.padding(padding), onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar(message = "TestMessage")
                    }
                }, title = "BaseButton")
            }
        )
    }
}