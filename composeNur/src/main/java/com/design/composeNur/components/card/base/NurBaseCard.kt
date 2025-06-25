package com.design.composeNur.components.card.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A customizable card component with clickable functionality and configurable corner shapes.
 *
 * @param [modifier] Modifier to be applied to the card for additional customization.
 * @param [cellCornerMode] Defines the corner shape of the card, with options for rounded corners or straight edges.
 * @param [backgroundColor] Sets the background color of the card. Defaults to [com.design.composeNur.theme.NurColors.NurCellBackground].
 * @param [contentPadding] Padding applied to the content inside the card. Defaults to 12dp on all sides.
 * @param [onClick] Optional click event handler that gets triggered when the card is clicked.
 * @param [content] Composable lambda that defines the content to be displayed inside the card.
 */

@Composable
fun NurBaseCard(
    modifier: Modifier = Modifier,
    cellCornerMode: CellCornerMode = CellCornerMode.Single,
    backgroundColor: Color = NurTheme.Colors.NurCellBackground,
    contentPadding: PaddingValues = PaddingValues(all = dimensionResource(R.dimen.padding_12dp)),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .clip(cellCornerMode.toRoundedShape())
            .background(backgroundColor)
            .clickable(
                onClick = { onClick?.invoke() },
                interactionSource = interactionSource,
                indication = ripple(
                    color = NurTheme.Colors.СhiliRippleForegroundColor
                )
            )
            .padding(contentPadding)
    ) {
        content()
    }
}