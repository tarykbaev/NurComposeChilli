package com.design.composechili.components.card

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    @DrawableRes icon: Int,
    categoryCardParams: CategoryCardParams,
    onClick: () -> Unit,
) {
    val iconPadding = if (categoryCardParams == CategoryCardParams.LeftAligned8Dp) 8.dp else 12.dp
    Column(
        modifier = modifier
            .background(
                color = ChiliTheme.Colors.ChiliSurfaceBackground, shape = RoundedCornerShape(
                    dimensionResource(id = R.dimen.radius_12dp)
                )
            )
            .clickable { onClick() }
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
            .padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
        horizontalAlignment = categoryCardParams.alignment
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = iconPadding),
            text = title,
            style = categoryCardParams.style
        )
    }
}

@Preview
@Composable

fun CardScreen_Preview() {
    ChiliTheme {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CategoryCard(
                    modifier = Modifier.weight(1f),
                    title = "Transfers",
                    icon = R.drawable.ic_payment,
                    categoryCardParams = CategoryCardParams.LeftAligned
                ) {}
                CategoryCard(
                    title = "Centered",
                    icon = R.drawable.ic_payment,
                    categoryCardParams = CategoryCardParams.Centered
                ) {}
            }
            CategoryCard(
                title = "Centered",
                icon = R.drawable.ic_payment,
                categoryCardParams = CategoryCardParams.LeftAligned8Dp
            ) {}
        }
    }
}