package com.design.composechili.components.cell

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

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
    baseCellParams: BaseCellParams = BaseCellParams.Default
) {
    ChiliTheme {
        Box(modifier = modifier
            .fillMaxWidth()
            .clip(baseCellParams.cornerMode.toRoundedShape())) {
            Log.e("TAG", "BaseCell: ${baseCellParams.cornerMode.toRoundedShape()}", )
            Row (modifier.wrapContentWidth()){
                if (startIcon != null) {
                    Image(
                        modifier = modifier.size(dimensionResource(id = R.dimen.view_32dp)),
                        painter = painterResource(id = startIcon),
                        contentDescription = "Base cell start icon"
                    )
                }
                Column(modifier.fillMaxWidth().padding(end = 16.dp)) {
                    Text(
                        text = title,
                        modifier = modifier
                            .wrapContentSize()
                            .fillMaxWidth()
                            .padding(baseCellParams.titlePadding),
                        style = baseCellParams.titleTextStyle,
                    )
                    Text(
                        text = subtitle,
                        modifier = modifier
                            .wrapContentSize()
                            .fillMaxWidth()
                            .padding(baseCellParams.subtitlePadding),
                        style = baseCellParams.subTitleTextStyle
                    )
                }

                if (isChevronVisible) {
                    Image(
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
                    modifier = modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    ChiliTheme.Attribute.ChiliDividerHeightSize,
                    ChiliTheme.Colors.chiliDividerColor
                )
            }
        }
    }
}

data class BaseCellParams(
    val titleTextStyle: TextStyle,
    val subTitleTextStyle: TextStyle,
    val titlePadding: PaddingValues,
    val subtitlePadding: PaddingValues,
    val cornerMode: CellCornerMode,
    val startIconPadding: PaddingValues,
    val chevronIconTint: Color
) {
    companion object {
        val Default
            @Composable get() = BaseCellParams(
                titleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                ), subTitleTextStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.chiliSecondaryTextColor
                ), titlePadding = PaddingValues(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    top = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_4dp)
                ), subtitlePadding = PaddingValues(
                    start = dimensionResource(id = R.dimen.padding_12dp),
                    end = dimensionResource(id = R.dimen.padding_4dp),
                    bottom = dimensionResource(id = R.dimen.padding_12dp)
                ), cornerMode = CellCornerMode.Single, startIconPadding = PaddingValues(
                    vertical = dimensionResource(id = R.dimen.padding_8dp),
                    horizontal = dimensionResource(id = R.dimen.padding_12dp)
                ), chevronIconTint = ChiliTheme.Colors.chiliChevronColor
            )
    }

}
