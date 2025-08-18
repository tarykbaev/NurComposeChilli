package com.design.composeNur.components.cell.additionalText

import androidx.annotation.DrawableRes
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
import androidx.compose.material.ripple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.components.shimmer.ShimmerOrContent
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.utils.softLayerShadow
import com.design.composenur.R

/**
 * @param [title] accept [String] and showing on the start in cell
 * @param [subtitle] accept [String] and showing on the start and below [title] in cell
 * @param [additionalTitle] accept [String] and showing below [subtitle] in cell
 * @param [additionalSubTitle] accept [String] and showing below [additionalTitle] in cell
 * @param [isChevronVisible] u can set visibility state of chevron which will show on the end in cell
 * @param [isDividerVisible] u can set visibility state of divider which will show on the bottom in cell
 * @param [startIcon] accept [DrawableRes] and set [Image] on the start in cell
 * @param [params] cell visual transformation params and paddings
 * @param [cellCornerMode] defines the corner shape of the cell, with options for rounded corners or straight edges.
 * @param [isShimmering] if true, the cell will show a shimmer effect instead of content.
 * @param [onClick] optional click event handler that gets triggered when the cell is clicked.
 * @sample AdditionalTextCellParams.Default
 */

@Composable
fun AdditionalTextCell(
    modifier: Modifier = Modifier,
    title: String = String(),
    subtitle: String = String(),
    additionalTitle: String = String(),
    additionalSubTitle: String = String(),
    isChevronVisible: Boolean = false,
    isDividerVisible: Boolean = false,
    startIcon: Painter? = null,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    isShimmering: Boolean = false,
    params: AdditionalTextCellParams = AdditionalTextCellParams.Default,
    onClick: (() -> Unit)? = null
) {

    val baseCellParams = params.nurBaseCellParams
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(baseCellParams.background)
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
                            vertical = baseCellParams.iconSize.verticalPadding,
                            horizontal = baseCellParams.iconSize.horizontalPadding
                        ),
                    shimmerHeight = baseCellParams.iconSize.size,
                    shimmerWidth = baseCellParams.iconSize.size,
                    isShimmering = isShimmering
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(
                                vertical = baseCellParams.iconSize.verticalPadding,
                                horizontal = baseCellParams.iconSize.horizontalPadding
                            )
                            .size(baseCellParams.iconSize.size),
                        painter = startIcon,
                        contentDescription = "Base cell start icon"
                    )
                }
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {
                        val adjustedTitlePadding = baseCellParams.titlePadding.copy(
                            start = if (startIcon != null) 0.dp else baseCellParams.titlePadding.start,
                            bottom = if (subtitle.isBlank()) {
                                dimensionResource(id = R.dimen.padding_12dp)
                            } else {
                                dimensionResource(id = R.dimen.padding_4dp)
                            }
                        )

                        ShimmerOrContent(
                            modifier = Modifier
                                .padding(adjustedTitlePadding.toPaddingValues()),
                            shimmerWidth = dimensionResource(R.dimen.view_120dp),
                            shimmerHeight = dimensionResource(R.dimen.view_8dp),
                            isShimmering = isShimmering
                        ) {
                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(adjustedTitlePadding.toPaddingValues()),
                                text = title,
                                style = baseCellParams.titleTextStyle,
                                maxLines = baseCellParams.textMaxLines,
                                overflow = TextOverflow.Ellipsis
                            )
                        }

                        val subTitlePadding = baseCellParams.subtitlePadding.copy(
                            start = if (startIcon != null) 0.dp else baseCellParams.subtitlePadding.start
                        )

                        if (subtitle.isNotBlank()) {
                            ShimmerOrContent(
                                modifier = Modifier
                                    .padding(subTitlePadding.toPaddingValues()),
                                shimmerWidth = dimensionResource(R.dimen.view_60dp),
                                shimmerHeight = dimensionResource(R.dimen.view_8dp),
                                isShimmering = isShimmering
                            ) {
                                Text(
                                    modifier = Modifier
                                        .wrapContentSize()
                                        .padding(subTitlePadding.toPaddingValues()),
                                    text = subtitle,
                                    style = baseCellParams.subTitleTextStyle,
                                    maxLines = baseCellParams.textMaxLines,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f),
                        verticalArrangement = Arrangement.Center
                    ) {

                        val adjustedAdditionalTitlePadding = params.additionalTitlePadding.copy(
                            bottom = if (additionalSubTitle.isNotBlank()) dimensionResource(id = R.dimen.padding_4dp)
                            else dimensionResource(id = R.dimen.padding_12dp),
                            end = if (isChevronVisible) params.additionalTitlePadding.end
                            else dimensionResource(R.dimen.padding_12dp)
                        )

                        ShimmerOrContent(
                            modifier = Modifier
                                .padding(adjustedAdditionalTitlePadding.toPaddingValues()),
                            shimmerWidth = dimensionResource(R.dimen.view_120dp),
                            shimmerHeight = dimensionResource(R.dimen.view_8dp),
                            isShimmering = isShimmering
                        ) {
                            Text(
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .wrapContentSize()
                                    .padding(adjustedAdditionalTitlePadding.toPaddingValues()),
                                text = additionalTitle,
                                style = params.additionalTitleStyle,
                                maxLines = baseCellParams.textMaxLines,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.End
                            )
                        }

                        if (additionalSubTitle.isNotBlank()) {
                            val additionalSubTitlePadding = params.additionalSubTitlePadding.copy(
                                end = if (isChevronVisible) params.additionalSubTitlePadding.end
                                else dimensionResource(R.dimen.padding_12dp)
                            )

                            ShimmerOrContent(
                                modifier = Modifier
                                    .padding(additionalSubTitlePadding.toPaddingValues()),
                                shimmerWidth = dimensionResource(R.dimen.view_60dp),
                                shimmerHeight = dimensionResource(R.dimen.view_8dp),
                                isShimmering = isShimmering
                            ) {
                                Text(
                                    modifier = Modifier
                                        .align(Alignment.End)
                                        .wrapContentSize()
                                        .padding(
                                            additionalSubTitlePadding.toPaddingValues()
                                        ),
                                    text = additionalSubTitle,
                                    style = params.additionalSubTitleStyle,
                                    maxLines = baseCellParams.textMaxLines,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                        }
                    }
                }
            }

            if (isChevronVisible) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = baseCellParams.chevronIconPadding.end),
                    painter = painterResource(id = R.drawable.nur_ic_chevron),
                    contentDescription = "Navigation icon",
                    colorFilter = ColorFilter.tint(
                        baseCellParams.chevronIconTint, BlendMode.SrcIn
                    )
                )
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
fun AdditionalTextCell_Preview() {
    NurTheme {
        Column {
            AdditionalTextCell(
                modifier = Modifier
                    .softLayerShadow(),
                title = "Заголовок",
                subtitle = "Подзаголовок",
                isShimmering = true,
                additionalTitle = "Additional",
                additionalSubTitle = "Additional Sub",
                isChevronVisible = true,
                cellCornerMode = CellCornerMode.Single,
            )
        }
    }
}