package com.design.composechili.components.topAppBar

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
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
    containerColor: Color = ChiliTheme.Colors.ChiliTopAppBarBackground,
    dividerColor: Color = ChiliTheme.Colors.ChiliTopAppBarDividerColor,
    dividerThickness: Dp = ChiliTheme.Attribute.ChiliTopAppBarThicknessSize,
    isCenteredTitle: Boolean = false,
    onNavigationClick: (() -> Unit)? = null,
    onEndIconClick: (() -> Unit)? = null
) {
    ChiliTheme {
        Column {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(ChiliTheme.Attribute.ChiliTopAppBarHeightSize)
                    .background(containerColor),
                contentAlignment = Alignment.CenterStart
            ) {
                var navigationIconWidth by remember { mutableStateOf(0) }
                navigationIcon?.let { icon ->
                    IconButton(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(horizontal = dimensionResource(R.dimen.padding_4dp))
                            .onGloballyPositioned { coordinates ->
                                navigationIconWidth = coordinates.size.width
                            },
                        onClick = onNavigationClick ?: {}
                    ) {
                        Image(
                            modifier = Modifier
                                .size(
                                    navigationIconSize ?: dimensionResource(R.dimen.view_24dp)
                                ),
                            painter = painterResource(icon),
                            contentDescription = "back"
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
                                .wrapContentSize()
                                .padding(end = dimensionResource(R.dimen.padding_16dp)),
                            text = additionalText,
                            style = additionalTextStyle
                        )
                    }

                    endIcon?.let { icon ->
                        IconButton(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(horizontal = 4.dp),
                            onClick = onEndIconClick ?: {}
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(
                                        endIconSize ?: dimensionResource(R.dimen.view_24dp)
                                    )
                                    .padding(0.dp),
                                painter = painterResource(icon),
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
                        style = titleStyle,
                    )
                }
            }

            when {
                isDividerVisible -> {
                    HorizontalDivider(
                        color = dividerColor,
                        thickness = dividerThickness
                    )
                }
            }
        }
    }
}