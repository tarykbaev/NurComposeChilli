package com.design.composechili.components.cell.toggle

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

@Composable
fun ToggleCellView(
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
    toggleCellParams: ToggleCellParams = ToggleCellParams.Default,
    onCheckedChangeListener: (isChecked: Boolean) -> Unit = {}
) {
    ChiliTheme {
        Box(
            modifier
                .clip(toggleCellParams.cornerMode.toRoundedShape())
                .background(ChiliTheme.Colors.ChiliCellViewBackground)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (startIcon != null) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(dimensionResource(id = R.dimen.view_32dp)),
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

                    val cellBottomPadding = if (subtitle.isBlank()) {
                        dimensionResource(id = R.dimen.padding_12dp)
                    } else {
                        dimensionResource(id = R.dimen.padding_4dp)
                    }

                    Text(
                        text = title,
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(
                                toggleCellParams.titlePadding
                                    .copy(bottom = cellBottomPadding)
                                    .toPaddingValues()
                            ),
                        style = toggleCellParams.titleTextStyle,
                    )

                    if (subtitle.isNotBlank()) {
                        Text(
                            text = subtitle,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(toggleCellParams.subtitlePadding.toPaddingValues()),
                            style = toggleCellParams.subTitleTextStyle
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
                            style = toggleCellParams.switchTextStyle
                        )
                    }
                    Switch(
                        modifier = Modifier.padding(toggleCellParams.switchPadding.toPaddingValues()),
                        checked = isChecked,
                        enabled = isSwitchEnabled,
                        onCheckedChange = onCheckedChangeListener,
                        colors = toggleCellParams.toggleColors,
                        thumbContent = {
                            if (switchTextOnOff != null) {
                                Text(
                                    text = switchTextOnOff,
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    style = toggleCellParams.switchOnOffTextStyle.copy(
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
}


data class ToggleCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val switchTextStyle: TextStyle,
    val switchOnOffTextStyle: TextStyle,
    val titlePadding: ChiliPadding,
    val subtitlePadding: ChiliPadding,
    val cornerMode: CellCornerMode,
    val startIconPadding: ChiliPadding,
    val switchPadding: ChiliPadding,
    val toggleColors: SwitchColors
) {
    companion object {
        val Default
            @Composable get() = ToggleCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ), subTitleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.chiliSecondaryTextColor,
                ), switchTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ), switchOnOffTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ), titlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ), subtitlePadding = ChiliPadding(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ), cornerMode = CellCornerMode.Single, startIconPadding = ChiliPadding(
                    vertical = dimensionResource(id = R.dimen.padding_8dp),
                    horizontal = dimensionResource(id = R.dimen.padding_12dp)
                ), switchPadding = ChiliPadding(
                    end = dimensionResource(id = R.dimen.padding_12dp)
                ), toggleColors = SwitchDefaults.colors(
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent,
                    disabledUncheckedBorderColor = Color.Transparent,
                    disabledCheckedBorderColor = Color.Transparent,
                    uncheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    checkedTrackColor = colorResource(id = R.color.magenta_1_alpha_40),
                    disabledCheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    disabledUncheckedTrackColor = ChiliTheme.Colors.ChiliToggleCellViewTrackColor,
                    checkedThumbColor = colorResource(id = R.color.magenta_1),
                    uncheckedThumbColor = ChiliTheme.Colors.ChiliToggleCellViewThumbNormalColor
                )
            )
    }

}

@Preview
@Composable
fun ToggleCellViewPreviewLight() {
    ChiliTheme {
        ToggleCellView(
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
        ToggleCellView(
            title = "Title",
            isChecked = false,
            isSwitchEnabled = true,
            subtitle = "Subtitle"
        )
    }
}