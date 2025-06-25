package com.design.composeNur.components.tooltip

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * Tooltip view, which is displayed under any view, defined in [requesterView].
 * @param [requesterView] The view on clicking which the tooltip will be displayed.
 * @param [params] Tooltip visual transformation params.
 * @param [title] The main title text displayed on the card.
 * @param [subtitle] The descriptive text displayed below the title.
 * @param [endIcon] Optional drawable resource ID for the icon displayed at the end of the tooltip.
 */

@Composable
fun NurTooltip(
    modifier: Modifier = Modifier,
    requesterView: @Composable (Modifier) -> Unit,
    params: NurTooltipParams = NurTooltipParams.Default,
    title: String = String(),
    subtitle: String = String(),
    @DrawableRes endIcon: Int = R.drawable.nur_ic_clear_24
) {

    var isShowTooltip by remember { mutableStateOf(false) }
    var position by remember { mutableStateOf(IntOffset(0, 0)) }

    val view = LocalView.current.rootView

    if (isShowTooltip) {
        NurTooltipPopup(
            backgroundColor = NurTheme.Colors.NurTooltipBackground,
            backgroundShape = RoundedCornerShape(params.tooltipCornerSize),
            arrowHeight = params.arrowHeight,
            onDismissRequest = {
                isShowTooltip = isShowTooltip.not()
            },
            offset = position
        ) {
            Row(modifier = modifier.padding(start = 12.dp, top = 8.dp, bottom = 8.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    if (title.isNotBlank()) {
                        Text(
                            modifier = Modifier.padding(end = 4.dp),
                            text = title,
                            color = Color.White,
                            style = params.titleTextStyle
                        )
                        Text(
                            modifier = Modifier.padding(top = 4.dp, end = 4.dp),
                            text = subtitle,
                            color = Color.White,
                            style = params.subtitleTextStyle
                        )
                    }
                }
                Image(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            isShowTooltip = isShowTooltip.not()
                        },
                    painter = painterResource(id = endIcon),
                    contentDescription = String()
                )
            }
        }
    }
    requesterView(
        modifier
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                isShowTooltip = isShowTooltip.not()
            }
            .onGloballyPositioned { coordinates ->
                position = calculateTooltipPopupPosition(view, coordinates)
            }
    )
}
