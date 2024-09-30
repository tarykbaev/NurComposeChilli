package com.design.composechili.components.cell.toggle

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ripple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTheme

/**
 * Cell view component containing [Switch] at the end of the cell
 * @param [title] accepts [String] and shown at the start of the cell
 * @param [subtitle] accepts [String] and shown at the start of the cell and below [title]
 * @param [isDividerVisible] sets visibility to divider which will be shown at the bottom of the cell
 * @param [isSwitchVisible] sets visibility to [Switch] at the end of the cell
 * @param [isChecked] sets if [Switch] is checked on/off
 * @param [isSwitchEnabled] sets if [Switch] is enabled/disabled
 * @param [switchTextOn] sets [String] value to the thumb on [Switch] when it is checked
 * @param [switchTextOff] sets [String] value to the thumb on [Switch] when it is not checked
 * @param [switchText] accepts [String] and shown at the start of [Switch]
 * @param [startIcon] accepts [DrawableRes] and sets [Image] to the start of cell
 * @param [onCheckedChangeListener] called when [Switch] checked value changes
 * @param [params] cell's visual transformation params and paddings
 * @sample ToggleCellParams.Default
 */

@Composable
fun ToggleCell(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String = String(),
    isDividerVisible: Boolean = false,
    isSwitchVisible: Boolean = true,
    isChecked: Boolean,
    isSwitchEnabled: Boolean = true,
    switchTextOn: String? = null,
    switchTextOff: String? = null,
    switchText: String? = null,
    @DrawableRes startIcon: Int? = null,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    params: ToggleCellParams = ToggleCellParams.Default,
    onClick: (() -> Unit)? = null,
    onCheckedChangeListener: (isChecked: Boolean) -> Unit = {}
) {

    val baseCellParams = params.baseCellParams
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(ChiliTheme.Colors.ChiliCellBackground)
            .clickable(
                onClick = { onClick?.invoke() },
                interactionSource = interactionSource,
                indication = ripple(
                    color = ChiliTheme.Colors.СhiliRippleForegroundColor
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
                            vertical = baseCellParams.iconSize.verticalPadding,
                            horizontal = baseCellParams.iconSize.horizontalPadding
                        )
                        .size(baseCellParams.iconSize.size),
                    painter = painterResource(id = startIcon),
                    contentDescription = "Base cell start icon"
                )
            }
            Column(
                Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .padding(end = dimensionResource(id = R.dimen.padding_16dp))
            ) {

                val adjustedTitlePadding = baseCellParams.titlePadding.copy(
                    start = if (startIcon != null) 0.dp else baseCellParams.titlePadding.start,
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
                    style = baseCellParams.titleTextStyle,
                    maxLines = baseCellParams.textMaxLines,
                    overflow = TextOverflow.Ellipsis
                )

                val subTitlePadding = baseCellParams.subtitlePadding.copy(
                    start = if (startIcon != null) 0.dp else baseCellParams.subtitlePadding.start
                )

                if (subtitle.isNotBlank()) {
                    Text(
                        text = subtitle,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(subTitlePadding.toPaddingValues()),
                        style = baseCellParams.subTitleTextStyle,
                        maxLines = baseCellParams.textMaxLines,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if (isSwitchVisible) {
                val switchTextOnOff = if (isChecked) switchTextOn else switchTextOff
                val switchTextOnOffColor = when {
                    !isChecked -> ChiliTheme.Colors.ChiliPrimaryTextColor
                    isSwitchEnabled -> ChiliTheme.Colors.ChiliToggleCellViewTextOnOffCheckedEnabledColor
                    !isSwitchEnabled -> ChiliTheme.Colors.ChiliToggleCellViewTextOnOffCheckedDisabledColor
                    else -> ChiliTheme.Colors.ChiliPrimaryTextColor
                }
                if (switchText != null) {
                    Text(
                        modifier = Modifier
                            .padding(end = dimensionResource(id = R.dimen.padding_2dp)),
                        text = switchText,
                        textAlign = TextAlign.End,
                        style = params.switchTextStyle
                    )
                }
                Switch(
                    modifier = Modifier.padding(params.switchPadding.toPaddingValues()),
                    checked = isChecked,
                    enabled = isSwitchEnabled,
                    onCheckedChange = onCheckedChangeListener,
                    colors = params.toggleColors,
                    thumbContent = {
                        if (switchTextOnOff != null) {
                            Text(
                                text = switchTextOnOff,
                                textAlign = TextAlign.Center,
                                maxLines = 1,
                                style = params.switchOnOffTextStyle.copy(
                                    color = switchTextOnOffColor
                                )
                            )
                        }
                    }
                )
            }
        }
        if (isDividerVisible) {
            HorizontalDivider(
                modifier = Modifier.align(Alignment.BottomCenter),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
        }
    }
}

@Preview
@Composable
fun ToggleCellViewPreviewLight() {
    ChiliTheme {
        ToggleCell(
            title = "Title",
            isChecked = false,
            isSwitchEnabled = true,
            subtitle = "Subtitle"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ToggleCellViewPreview() {
    ChiliTheme {
        ToggleCell(
            title = "Title",
            isChecked = false,
            isSwitchEnabled = true,
            subtitle = "Subtitle"
        )
    }
}