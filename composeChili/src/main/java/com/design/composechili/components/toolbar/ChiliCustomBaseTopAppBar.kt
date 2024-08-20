package com.design.composechili.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.pxToDp

@Composable
fun ChiliCustomBaseTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        ChiliTheme.Colors.chiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    isDividerVisible: Boolean = true,
    additionalText: String? = null,
    additionalTextStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
        ChiliTheme.Colors.chiliSecondaryTextColor
    ),
    @DrawableRes navigationIcon: Int? = null,
    navigationIconSize: Dp? = null,
    @DrawableRes endIcon: Int? = null,
    endIconSize: Dp? = null,
    containerColor: Color = ChiliTheme.Colors.ChiliToolbarBackground,
    dividerColor: Color = ChiliTheme.Colors.ChiliToolbarDividerColor,
    dividerThickness: Dp = ChiliTheme.Attribute.ChiliToolbarThicknessSize,
    isCenteredTitle: Boolean = false,
    onNavigationClick: (() -> Unit)? = null
) {
    ChiliTheme {
        Column {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(ChiliTheme.Attribute.ChiliToolbarHeightSize)
                    .background(containerColor)
            ) {
                var navigationIconWidth by remember { mutableStateOf(0) }
                var endIconWidth by remember { mutableStateOf(0) }

                navigationIcon?.let { icon ->
                    IconButton(
                        modifier = Modifier
                            .padding(4.dp)
                            .onGloballyPositioned { coordinates ->
                                navigationIconWidth = coordinates.size.width
                            },
                        onClick = onNavigationClick ?: {}
                    ) {
                        Icon(
                            modifier = Modifier.size(
                                navigationIconSize ?: dimensionResource(R.dimen.view_24dp)
                            ),
                            painter = painterResource(icon),
                            contentDescription = "back",
                            tint = ChiliTheme.Colors.ChiliToolbarIconsTint
                        )
                    }
                }

                Row(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    additionalText?.let {
                        Text(
                            modifier = Modifier
                                .padding(end = dimensionResource(R.dimen.padding_16dp)),
                            text = additionalText,
                            style = additionalTextStyle
                        )
                    }

                    endIcon?.let { icon ->
                        IconButton(
                            modifier = Modifier
                                .padding(4.dp)
                                .onGloballyPositioned { coordinates ->
                                    endIconWidth = coordinates.size.width
                                },
                            onClick = {}
                        ) {
                            Image(
                                modifier = Modifier.size(
                                    endIconSize ?: dimensionResource(R.dimen.view_24dp)
                                ),
                                painter = painterResource(icon),
                                contentDescription = "endIcon"
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier
                        .align(if (isCenteredTitle) Alignment.Center else Alignment.CenterStart)
                        .offset(
                            x = if (isCenteredTitle) {
                                (navigationIconWidth.pxToDp() - endIconWidth.pxToDp()) / 2
                            } else {
                                navigationIconWidth.pxToDp() + 8.dp
                            }
                        )
                        .padding(start = if (!isCenteredTitle) 0.dp else 0.dp),
                    text = title,
                    style = titleStyle,
                )
            }

            if (isDividerVisible) {
                HorizontalDivider(
                    color = dividerColor,
                    thickness = dividerThickness
                )
            }
        }
    }
}

