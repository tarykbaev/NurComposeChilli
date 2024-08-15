package com.design.composechili.components.toolbar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChiliBaseToolbar(
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
    @DrawableRes startIcon: Int? = null,
    startIconSize: Dp? = null,
    @DrawableRes endIcon: Int? = null,
    endIconSize: Dp? = null,
    containerColor: Color = ChiliTheme.Colors.ChiliToolbarBackground,
    dividerColor: Color = ChiliTheme.Colors.ChiliToolbarDividerColor,
    dividerThickness: Dp = ChiliTheme.Attribute.ChiliToolbarThicknessSize,
    onNavigationClick: (() -> Unit)? = null
) {
    ChiliTheme {
        Column {
            TopAppBar(
                modifier = modifier
                    .height(ChiliTheme.Attribute.ChiliToolbarHeightSize),
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        startIcon?.let { icon ->
                            IconButton({

                            }) {
                                Image(
                                    modifier = Modifier
                                        .size(
                                            startIconSize ?: dimensionResource(R.dimen.view_24dp)
                                        ),
                                    painter = painterResource(icon),
                                    contentDescription = "startIcon",
                                )
                            }
                        }
                        Text(
                            modifier = Modifier,
                            text = title,
                            style = titleStyle,
                        )
                    }
                },
                navigationIcon = {
                    navigationIcon?.let { icon ->
                        onNavigationClick?.let {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                IconButton(onClick = it) {
                                    Icon(
                                        modifier = Modifier
                                            .size(
                                                navigationIconSize
                                                    ?: dimensionResource(R.dimen.view_24dp)
                                            ),
                                        painter = painterResource(icon),
                                        contentDescription = "Back",
                                        tint = ChiliTheme.Colors.ChiliToolbarIconsTint
                                    )
                                }
                            }
                        }
                    }
                },
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        endIcon?.let { icon ->
                            IconButton({

                            }) {
                                Image(
                                    modifier = Modifier.size(
                                        endIconSize ?: dimensionResource(R.dimen.view_24dp)
                                    ),
                                    painter = painterResource(id = icon),
                                    contentDescription = "endIcon"
                                )
                            }
                        }

                        additionalText?.let {
                            Text(
                                modifier = Modifier
                                    .padding(end = dimensionResource(R.dimen.padding_16dp)),
                                text = additionalText,
                                style = additionalTextStyle
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = containerColor,
                )
            )
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