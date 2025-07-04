package com.design.composeNur.components.cell.actionCell

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.ripple
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
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

@Composable
fun NurActionCell(
    modifier: Modifier = Modifier,
    title: String,
    actionTitle: String,
    isChevronVisible: Boolean = false,
    startIcon: Painter? = null,
    params: NurActionCellParams = NurActionCellParams.Default,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    isActionEnabled: Boolean = true,
    onActionClick: (() -> Unit)? = null,
    onClick: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(params.background)
            .clickable(
                onClick = { onClick.invoke() },
                interactionSource = interactionSource,
                indication = ripple(
                    color = NurTheme.Colors.СhiliRippleForegroundColor
                )
            )
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .heightIn(min = dimensionResource(R.dimen.view_48dp))
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (startIcon != null) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            vertical = params.startIconSize.verticalPadding,
                            horizontal = params.startIconSize.horizontalPadding
                        )
                        .size(params.startIconSize.size),
                    painter = startIcon,
                    contentDescription = "action cell start icon"
                )
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .wrapContentSize(),
                        style = params.titleStyle,
                        maxLines = params.textMaxLines,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }

            NurButton(
                modifier = Modifier
                    .wrapContentSize(),
                buttonPadding = PaddingValues(0.dp),
                title = actionTitle,
                isEnabled = isActionEnabled,
                buttonStyle = NurButtonStyle.ComponentButton.copy(
                    contentPaddingValues = PaddingValues(0.dp)
                ),
                onClick = { if (onActionClick != null) onActionClick() else onClick() }
            )

            if (isChevronVisible) {
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically),
                    painter = painterResource(id = R.drawable.nur_ic_chevron),
                    contentDescription = "Navigation icon",
                    colorFilter = ColorFilter.tint(
                        params.chevronIconTint, BlendMode.SrcIn
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun NurActionCell_Preview() {
    NurTheme {
        NurActionCell(
            title = "Nur Action Cell shfsjahfka ahkasdhfkasajshfkasd",
            actionTitle = "Action",
            onClick = { },
            params = NurActionCellParams.Default.copy(textMaxLines = 3),
            onActionClick = { },
            isChevronVisible = true,
        )
    }
}