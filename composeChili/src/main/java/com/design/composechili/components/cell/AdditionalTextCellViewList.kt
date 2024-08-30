package com.design.composechili.components.cell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.theme.ChiliTheme

@Composable
fun AdditionalTextCellViewList(
    modifier: Modifier = Modifier,
    itemsList: List<AdditionalTextCellViewItems>,
) {
    LazyColumn(modifier = modifier.background(Color.Transparent)){
        itemsIndexed(itemsList) { index, item ->
            when {
                (index == itemsList.indexOf(item)) -> {
                    AdditionalTextCellView(
                        title = item.text,
                        description = item.description,
                        shape = AdditionalTextCellViewParams.roundedShapeTop,
                    )
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = ChiliTheme.Colors.ChiliDividerColor,
                        thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                    )
                }

                (index == itemsList.lastIndexOf(item)) -> {
                    AdditionalTextCellView(
                        title = item.text,
                        description = item.description,
                        shape = AdditionalTextCellViewParams.roundedShapeBottom
                    )
                }

                else -> {
                    AdditionalTextCellView(
                        title = item.text,
                        description = item.description,
                        shape = AdditionalTextCellViewParams.roundedShapeCenter
                    )
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = ChiliTheme.Colors.ChiliDividerColor,
                        thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AdditionalTextCellViewList_Preview() {
    ChiliTheme {
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
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                ),
                AdditionalTextCellViewItems(
                    text = "simple",
                    description = "Value"
                )
            )
        )
    }
}

data class AdditionalTextCellViewItems(
    val text: String,
    val description: String,
    val chevronEnabled: Boolean = false,
    @DrawableRes val icon: Int? = null,
)