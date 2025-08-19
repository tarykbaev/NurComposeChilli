package com.design.composeNur.components.topAppBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.utils.pxToDp
import com.design.composenur.R

/**
 * A composable function that creates a customizable top app bar, featuring a title, optional navigation and end icons,
 * additional text, and a configurable divider. Supports various configurations including title alignment and
 * click actions for the icons.
 *
 * @param modifier A [Modifier] to configure the layout or decoration of this composable. Can be used to adjust size,
 * padding, or other layout behavior. Defaults to [Modifier] with no modifications.
 *
 * @param title A [String] representing the main title displayed on the app bar. This parameter is required and
 * must be provided by the caller.
 *
 * @param params An instance of [NurBaseTopAppBarParams] to configure additional parameters for the app bar
 * (e.g., colors, iconSize). Defaults to [NurBaseTopAppBarParams.Default].
 *
 * @param isDividerVisible A [Boolean] indicating whether a divider line should be displayed below the app bar.
 * Defaults to `true`.
 *
 * @param additionalText An optional [String] for displaying additional text below the main title. If `null`,
 * no additional text will be shown.
 *
 * @param navigationIcon An optional drawable resource ID for the navigation icon (e.g., a back button) on the left side
 * of the app bar. If `null`, no navigation icon will be displayed.
 *
 * @param endIcon An optional drawable resource ID for the end icon (e.g., a settings or more options button) on the right
 * side of the app bar. If `null`, no end icon will be displayed.
 *
 * @param isCenteredTitle A [Boolean] indicating whether the title should be centered within the app bar.
 * Defaults to `false`, meaning the title will be aligned to the start of the app bar.
 *
 * @param onNavigationClick An optional lambda function that is invoked when the navigation icon is clicked. If `null`,
 * no click action will be assigned to the navigation icon.
 *
 * @param onEndIconClick An optional lambda function that is invoked when the end icon is clicked. If `null`,
 * no click action will be assigned to the end icon.
 *
 * @sample [NurBaseTopAppBarParams.Default]
 */
@Composable
fun NurBaseTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    params: NurBaseTopAppBarParams = NurBaseTopAppBarParams.Default,
    isDividerVisible: Boolean = true,
    additionalText: String? = null,
    navigationIcon: Painter = painterResource(R.drawable.nur_ic_nav_back),
    endIcon: Painter? = null,
    isCenteredTitle: Boolean = false,
    isNavigationButtonEnabled: Boolean = true,
    onAdditionalTextClick: (() -> Unit)? = null,
    onEndIconClick: (() -> Unit)? = null,
    onNavigationClick: (() -> Unit)? = null
) {
    Column {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(NurTheme.Attribute.NurTopAppBarHeightSize)
                .background(params.containerColor), contentAlignment = Alignment.CenterStart
        ) {
            var navigationIconWidth by remember { mutableStateOf(0) }

            if (isNavigationButtonEnabled) {
                IconButton(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = dimensionResource(R.dimen.padding_4dp))
                        .onGloballyPositioned { coordinates ->
                            navigationIconWidth = coordinates.size.width
                        }, onClick = { onNavigationClick?.invoke() }) {
                    Image(
                        modifier = Modifier.size(params.navigationIconSize),
                        painter = navigationIcon,
                        contentDescription = "back",
                        colorFilter = params.startIconFilter
                    )
                }
            }


            Row(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = dimensionResource(R.dimen.padding_16dp)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                additionalText?.let { text ->
                    Surface(
                        modifier = Modifier
                            .wrapContentSize()
                            .clip(RoundedCornerShape(dimensionResource(R.dimen.radius_12dp)))
                            .then(
                                if (onAdditionalTextClick != null) {
                                    Modifier.clickable(
                                        onClick = { onAdditionalTextClick.invoke() },
                                        indication = ripple(),
                                        interactionSource = remember { MutableInteractionSource() }
                                    )
                                } else {
                                    Modifier
                                }
                            ),
                        color = Color.Transparent
                    ) {
                        Text(
                            modifier = Modifier.padding(all = dimensionResource(R.dimen.padding_4dp)),
                            text = text,
                            style = params.additionalTextStyle
                        )
                    }
                }

                endIcon?.let { icon ->
                    IconButton(
                        modifier = Modifier.size(params.endIconSize),
                        onClick = { onEndIconClick?.invoke() }
                    ) {
                        Image(
                            colorFilter = params.endIconColorFilter,
                            painter = icon,
                            contentDescription = "endIcon"
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .align(if (isCenteredTitle) Alignment.Center else Alignment.CenterStart)
                    .offset(
                        x = when {
                            isCenteredTitle -> dimensionResource(R.dimen.padding_0dp)

                            !isCenteredTitle && navigationIcon != null -> {
                                navigationIconWidth.pxToDp() + dimensionResource(R.dimen.padding_24dp)
                            }

                            else -> dimensionResource(R.dimen.padding_16dp)
                        }
                    )
                    .wrapContentSize()
            ) {
                Text(
                    modifier = Modifier,
                    text = title,
                    style = params.titleTextStyle,
                )
            }
        }

        when {
            isDividerVisible -> {
                HorizontalDivider(
                    color = params.dividerColor, thickness = params.dividerThickness
                )
            }
        }
    }
}

@Preview
@Composable
fun NurBaseTopAppBarPreview() {
    NurTheme {
        NurBaseTopAppBar(
            title = "TopAppBar",
            isCenteredTitle = true,
            navigationIcon = painterResource(id = R.drawable.nur_ic_nav_back),
            endIcon = painterResource(id = R.drawable.ic_cat),
            onNavigationClick = {

            },
            onEndIconClick = {

            }
        )
    }
}