package com.design.composechili.components.cell

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.values.ChiliPadding

/*
  TODO(Add shimmer effect)
 */

@Composable
fun BaseCell(
    modifier: Modifier = Modifier,
    title: String = "Test",
    subtitle: String = String(),
    isChevronVisible: Boolean = false,
    isDividerVisible: Boolean = false,
    @DrawableRes startIcon: Int? = null,
    baseCellParams: BaseCellParams = BaseCellParams.Default,
) {
    ChiliTheme {
        Box(
            modifier
                .clip(baseCellParams.cornerMode.toRoundedShape())
                .background(Color.White)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
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
                        .padding(end = 16.dp)
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
                                baseCellParams.titlePadding
                                    .copy(bottom = cellBottomPadding)
                                    .toPaddingValues()
                            ),
                        style = baseCellParams.titleTextStyle,
                    )

                    if (subtitle.isNotBlank()) {
                        Text(
                            text = subtitle,
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(baseCellParams.subtitlePadding.toPaddingValues()),
                            style = baseCellParams.subTitleTextStyle
                        )
                    }
                }

                if (isChevronVisible) {
                    Image(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        painter = painterResource(id = R.drawable.chili_ic_chevron),
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
                    color = ChiliTheme.Colors.ChiliDividerColor,
                    thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                )
            }
        }
    }
}


data class BaseCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val titlePadding: ChiliPadding,
    val subtitlePadding: ChiliPadding,
    val cornerMode: CellCornerMode,
    val startIconPadding: ChiliPadding,
    val chevronIconTint: Color
) {
    companion object {
        val Default
            @Composable get() = BaseCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ), subTitleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.chiliSecondaryTextColor,
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
                ), chevronIconTint = ChiliTheme.Colors.chiliChevronColor
            )
    }

}

@Preview(showBackground = true)
@Composable
fun BaseCell_Preview() {
    ChiliTheme {
        Column {
            BaseCell(
                title = "Hello im a base cell",
                subtitle = "Im a subtitle",
                isChevronVisible = true,
                isDividerVisible = true
            )
            BaseCell(
                title = "Hello im a base cell",
                isChevronVisible = true,
                isDividerVisible = true
            )
            BaseCell(
                title = "Hello im a base cell",
                isChevronVisible = false,
                isDividerVisible = false
            )
        }
    }
}
