package com.design.composeNur.components.cell.toggle

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
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

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
 * @param [startIcon] accepts [DrawableRes] and sets [Image] to the start of the cell
 * @param [cellCornerMode] defines the visual corner mode of the cell (e.g. single, top, middle, bottom)
 * @param [params] cell's visual transformation params and paddings
 * @param [onClick] called when the cell is clicked
 * @param [onCheckedChangeListener] called when [Switch] checked value changes
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


    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(NurTheme.Colors.NurCellBackground)
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
                        .padding(params.startIconPadding.toPaddingValues())
                        .size(48.dp),
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
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            if (isSwitchVisible) {
                val switchTextOnOff = if (isChecked) switchTextOn else switchTextOff
                val switchTextOnOffColor = when {
                    !isChecked -> NurTheme.Colors.NurPrimaryTextColor
                    isSwitchEnabled -> NurTheme.Colors.NurToggleCellViewTextOnOffCheckedEnabledColor
                    !isSwitchEnabled -> NurTheme.Colors.NurToggleCellViewTextOnOffCheckedDisabledColor
                    else -> NurTheme.Colors.NurPrimaryTextColor
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
                color = NurTheme.Colors.NurDividerColor,
                thickness = NurTheme.Attribute.NurDividerHeightSize
            )
        }
    }
}

@Preview
@Composable
fun ToggleCellViewPreviewLight() {
    NurTheme {
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
    NurTheme {
        ToggleCell(
            title = "Title",
            isChecked = false,
            isSwitchEnabled = true,
            subtitle = "Subtitle"
        )
    }
}