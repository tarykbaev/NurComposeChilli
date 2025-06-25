package com.design.composeNur.components.cell.expandableCell

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * @param [title] accepts [String] and shown on the start of the cell
 * @param [description] accepts [String] and shown at the bottom of the cell below divider
 * @param [isInitiallyExpanded] sets if initially cell expanded/collapsed
 * @param [animationDuration] sets cell collapse/expand animation duration
 * @param [expandableCellParams] cells visual transformation params and paddings
 * @sample ExpandableCellParams.Default
 */

@Composable
fun ExpandableCell(
    modifier: Modifier = Modifier,
    title: String = String(),
    description: String = String(),
    isInitiallyExpanded: Boolean = false,
    animationDuration: Int = 100,
    expandableCellParams: ExpandableCellParams = ExpandableCellParams.Default,
) {

    val baseCellParams = expandableCellParams.nurBaseCellParams
    var isExpanded by remember { mutableStateOf(isInitiallyExpanded) }
    val mutableInteractionSource = remember { MutableInteractionSource() }
    val rotationState by animateFloatAsState(
        targetValue = if (isExpanded) -90f else 90f, label = String()
    )

    Box(
        modifier
            .clip(CellCornerMode.Single.toRoundedShape())
            .background(baseCellParams.background)
    ) {
        Column(
            Modifier
                .wrapContentHeight()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = animationDuration,
                        easing = LinearOutSlowInEasing
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isExpanded = !isExpanded
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            baseCellParams.titlePadding.toPaddingValues()
                        ),
                    textAlign = TextAlign.Start,
                    style = baseCellParams.titleTextStyle,
                )
                Image(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(
                            baseCellParams.chevronIconPadding.toPaddingValues()
                        )
                        .rotate(rotationState),
                    painter = painterResource(id = R.drawable.nur_ic_chevron),
                    contentDescription = "Navigation icon",
                    colorFilter = ColorFilter.tint(
                        baseCellParams.chevronIconTint, BlendMode.SrcIn
                    )
                )
            }
            if (isExpanded) {
                HorizontalDivider(
                    color = NurTheme.Colors.NurDividerColor,
                    thickness = NurTheme.Attribute.NurDividerHeightSize
                )
                Text(
                    text = description,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(
                            expandableCellParams.descriptionPadding.toPaddingValues()
                        ),
                    style = expandableCellParams.descriptionTextStyle
                )
            }
        }
    }
}

@Preview
@Composable
fun ExpandableCellViewPreview() {
    NurTheme {
        ExpandableCell(
            title = "Title"
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ExpandableCellViewNight() {
    NurTheme {
        ExpandableCell(
            title = "Title"
        )
    }
}