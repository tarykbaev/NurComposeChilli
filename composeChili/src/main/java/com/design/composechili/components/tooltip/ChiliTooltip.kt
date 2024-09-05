package com.design.composechili.components.tooltip

import android.util.Log
import android.view.View
import android.widget.TextView
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
import androidx.compose.ui.unit.dp
import androidx.core.view.allViews
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

/**
 * tooltipContent - Content to display in tooltip.
 */
@Composable
fun ChiliTooltip(
    modifier: Modifier = Modifier,
    requesterView: @Composable (Modifier) -> Unit,
    params: ChiliTooltipParams = ChiliTooltipParams.Default,
    title: String = String(),
    subtitle: String = String(),
    @DrawableRes endIcon: Int = R.drawable.chili_ic_clear_24
) {

    ChiliTheme {
        var isShowTooltip by remember { mutableStateOf(false) }
        var position by remember { mutableStateOf(TooltipPopupPosition()) }

        val view = LocalView.current.rootView

        if (isShowTooltip) {
            Log.e("TAG", "ChiliTooltip: ${LocalView.current.rootView}", )
            ChiliTooltipPopup(
                backgroundColor = ChiliTheme.Colors.ChiliTooltipBackground,
                backgroundShape = RoundedCornerShape(params.tooltipCornerSize),
                arrowHeight = params.arrowHeight,
                onDismissRequest = {
                    isShowTooltip = isShowTooltip.not()
                },
                position = position,
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
}


enum class TooltipAlignment {
    BottomCenter,
}
