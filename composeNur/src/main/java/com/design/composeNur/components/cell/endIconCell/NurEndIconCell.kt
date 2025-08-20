package com.design.composeNur.components.cell.endIconCell

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.ripple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.components.shimmer.ShimmerOrContent
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

@Composable
fun NurEndIconCell(
    modifier: Modifier = Modifier,
    title: String = String(),
    subtitle: String = String(),
    endIcon: Painter? = null,
    startIcon: Painter? = null,
    isDividerVisible: Boolean = false,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    isShimmering: Boolean = false,
    params: NurEndIconCellParams = NurEndIconCellParams.Default,
    onEndIconClick: (() -> Unit)? = null,
    onStartIconClick: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(params.background)
            .clickable(
                onClick = { onClick?.invoke() },
                interactionSource = interactionSource,
                indication = ripple(
                    color = NurTheme.Colors.СhiliRippleForegroundColor
                )
            )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(min = dimensionResource(R.dimen.view_48dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (startIcon != null) {
                ShimmerOrContent(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            vertical = params.startIconSize.verticalPadding,
                            horizontal = params.startIconSize.horizontalPadding
                        )
                        .size(params.startIconSize.size),
                    isShimmering = isShimmering,
                    shimmerWidth = params.startIconSize.size,
                    shimmerHeight = params.endIconSize.size
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(
                                vertical = params.startIconSize.verticalPadding,
                                horizontal = params.startIconSize.horizontalPadding
                            )
                            .size(params.startIconSize.size)
                            .clickable(
                                onClick = { if (onStartIconClick != null) onStartIconClick() else onClick?.invoke() },
                                interactionSource = interactionSource,
                                indication = ripple(
                                    color = NurTheme.Colors.СhiliRippleForegroundColor
                                )
                            ),
                        painter = startIcon,
                        contentDescription = "Base cell start icon"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(end = dimensionResource(R.dimen.padding_16dp)),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    val adjustedTitlePadding = params.titlePadding.copy(
                        start = if (startIcon != null) 0.dp else params.titlePadding.start,
                        bottom = if (subtitle.isBlank()) {
                            dimensionResource(id = R.dimen.padding_12dp)
                        } else {
                            dimensionResource(id = R.dimen.padding_4dp)
                        }
                    )

                    ShimmerOrContent(
                        modifier = Modifier
                            .padding(adjustedTitlePadding.toPaddingValues()),
                        shimmerWidth = 200.dp,
                        shimmerHeight = 8.dp,
                        isShimmering = isShimmering
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(
                                    adjustedTitlePadding.toPaddingValues()
                                ),
                            style = params.titleTextStyle,
                            maxLines = params.textMaxLines,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    val subTitlePadding = params.subtitlePadding.copy(
                        start = if (startIcon != null) 0.dp else params.subtitlePadding.start
                    )

                    if (subtitle.isNotBlank()) {
                        ShimmerOrContent(
                            modifier = Modifier
                                .padding(subTitlePadding.toPaddingValues()),
                            shimmerWidth = 82.dp,
                            shimmerHeight = 8.dp,
                            isShimmering = isShimmering
                        ) {
                            Text(
                                text = subtitle,
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(subTitlePadding.toPaddingValues()),
                                style = params.subTitleTextStyle,
                                maxLines = params.textMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }

            if (endIcon != null) {
                ShimmerOrContent(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            vertical = params.endIconSize.verticalPadding,
                            horizontal = params.endIconSize.horizontalPadding
                        )
                        .size(params.endIconSize.size),
                    shimmerWidth = params.endIconSize.size,
                    shimmerHeight = params.endIconSize.size,
                    isShimmering = isShimmering
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(
                                vertical = params.endIconSize.verticalPadding,
                                horizontal = params.endIconSize.horizontalPadding
                            )
                            .size(params.endIconSize.size)
                            .clickable(
                                onClick = { if (onEndIconClick != null) onEndIconClick() else onClick?.invoke() },
                                interactionSource = interactionSource,
                                indication = ripple(
                                    color = NurTheme.Colors.СhiliRippleForegroundColor
                                )
                            ),
                        painter = endIcon,
                        contentDescription = "end navigation icon",
                        colorFilter = ColorFilter.tint(
                            params.endIconTint, BlendMode.SrcIn
                        )
                    )
                }
            }
        }
        if (isDividerVisible) {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = NurTheme.Colors.NurDividerColor,
                thickness = NurTheme.Attribute.NurDividerHeightSize
            )
        }
    }
}

@Preview
@Composable
fun NurEndIconCell_Preview() {
    NurTheme {
        NurEndIconCell(
            title = "Nur Nur End Icon Cell Title",
            startIcon = rememberVectorPainter(Icons.Filled.AccountCircle),
            endIcon = rememberVectorPainter(Icons.Filled.CheckCircle),
            params = NurEndIconCellParams.Default.copy(endIconTint = Color.Green),
            subtitle = "Nur Nur End Icon Subtitle",
        )
    }
}