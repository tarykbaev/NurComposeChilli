package com.design.composeNur.components.cell.baseCell

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * TODO (add shimmer effect)
 * @param [title] accept [String] and showing on the start in cell
 * @param [subtitle] accept [String] and showing on the start and below [title] in cell
 * @param [isChevronVisible] u can set visibility state of chevron which will show on the end in cell
 * @param [isDividerVisible] u can set visibility state of divider which will show on the bottom in cell
 * @param [startIcon] accept [DrawableRes] and set [Image] on the start in cell
 * @param [cellCornerMode] defines the corner shape of the cell, with options for rounded corners or straight edges.
 * @param [params] cell visual transformation params and paddings
 * @param [onClick] optional click event handler that gets triggered when the cell is clicked.
 * @sample NurBaseCellParams.Default
 */

@Composable
fun NurBaseCell(
    modifier: Modifier = Modifier,
    title: String = String(),
    subtitle: String = String(),
    isChevronVisible: Boolean = true,
    isDividerVisible: Boolean = false,
    startIcon: Painter? = null,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    params: NurBaseCellParams = NurBaseCellParams.Default,
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
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            vertical = params.iconSize.verticalPadding,
                            horizontal = params.iconSize.horizontalPadding
                        )
                        .size(params.iconSize.size),
                    painter = startIcon,
                    contentDescription = "Base cell start icon"
                )
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

                    val subTitlePadding = params.subtitlePadding.copy(
                        start = if (startIcon != null) 0.dp else params.subtitlePadding.start
                    )

                    if (subtitle.isNotBlank()) {
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

            if (isChevronVisible) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = params.chevronIconPadding.end),
                    painter = painterResource(id = R.drawable.nur_ic_chevron),
                    contentDescription = "Navigation icon",
                    colorFilter = ColorFilter.tint(
                        params.chevronIconTint, BlendMode.SrcIn
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
fun NurBaseCellPreview() {
    NurTheme {
        NurBaseCell(
            title = "Test",
            subtitle = "Test",
            isChevronVisible = true,
            isDividerVisible = false,
        )
    }
}
