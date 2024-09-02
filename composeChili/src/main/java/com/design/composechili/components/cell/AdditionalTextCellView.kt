package com.design.composechili.components.cell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.cell.model.AdditionalTextCellViewItems
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTheme

@Composable
fun AdditionalTextCellView(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    subTitle: String? = null,
    subDescription: String? = null,
    chevronEnabled: Boolean = false,
    @DrawableRes icon: Int? = null,
    shape: CellCornerMode = CellCornerMode.Single
) {
    val hasSubtext = subDescription != null || subTitle != null
    Column(
        modifier
            .sizeIn(minHeight = 48.dp)
            .background(
                color = ChiliTheme.Colors.chiliSurfaceBackground,
                shape = shape.toRoundedShape()
            ),
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (icon != null)
                Image(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(if (hasSubtext) 8.dp else 0.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Left,
                    style = AdditionalTextCellViewParams.AdditionalText.titleTextAppearance
                )
                if (subTitle != null)
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = subTitle,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Left,
                        style = AdditionalTextCellViewParams.AdditionalText.titleTextAppearance
                    )
            }
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = description,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Right,
                    style = AdditionalTextCellViewParams.AdditionalText.additionalTextAppearance
                )
                if (subDescription != null)
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = subDescription,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Right,
                        style = AdditionalTextCellViewParams.AdditionalText.additionalSubTextAppearance
                    )
            }
            if (chevronEnabled)
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.chili_ic_chevron),
                    contentDescription = null
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdditionalTextCellView_Preview() {
    ChiliTheme {
        Column(
            Modifier.background(Color.Black),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AdditionalTextCellView(
                title = "Длинный текст ",
                description = "Текст значения выходящий за свои рамки своей вместимости",
                chevronEnabled = true,
            )
            AdditionalTextCellView(
                title = "Заголовок",
                description = "Additional text no chevron",
                chevronEnabled = false
            )
            AdditionalTextCellView(
                title = "Заголовок",
                description = "Additional text icon",
                icon = R.drawable.ic_darkmode_false_,
                chevronEnabled = true,
            )
            AdditionalTextCellViewList(
                itemsList = listOf(
                    AdditionalTextCellViewItems(
                        text = "simple",
                        description = "Value"
                    ),
                    AdditionalTextCellViewItems(
                        text = "simple",
                        description = "Value"
                    ),
                    AdditionalTextCellViewItems(
                        text = "simple",
                        description = "Value"
                    ),
                )
            )
            AdditionalTextCellView(
                title = "simple",
                description = "Value",
                subTitle = "123123",
                subDescription = "Sub text 123",
                icon = R.drawable.ic_bonus_new,
                chevronEnabled = false,
            )
        }
    }
}