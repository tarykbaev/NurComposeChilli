package com.design.composeNur.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.utils.clickableWithSimpleRippleEffect
import com.design.composenur.R

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    painter: Painter,
    categoryCardParams: CategoryCardParams,
    rootPadding: PaddingValues = PaddingValues(
        horizontal = dimensionResource(id = R.dimen.padding_16dp),
        vertical = dimensionResource(id = R.dimen.padding_8dp)
    ),
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp)))
            .background(NurTheme.Colors.NurCardViewBackground)
            .clickableWithSimpleRippleEffect {
                onClick()
            }
            .padding(rootPadding),
        horizontalAlignment = categoryCardParams.alignment
    ) {
        Image(
            painter = painter,
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(categoryCardParams.iconPaddings),
            text = title,
            style = categoryCardParams.style
        )
    }
}

@Preview
@Composable

fun CardScreen_Preview() {
    NurTheme {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                CategoryCard(
                    modifier = Modifier.weight(1f),
                    title = "Transfers",
                    painterResource(id = R.drawable.ic_payment),
                    categoryCardParams = CategoryCardParams.LeftAligned
                ) {}
                CategoryCard(
                    title = "Centered",
                    painter = painterResource(id = R.drawable.ic_payment),
                    categoryCardParams = CategoryCardParams.Centered
                ) {}
            }
            CategoryCard(
                title = "Centered",
                painter = painterResource(id = R.drawable.ic_payment),
                categoryCardParams = CategoryCardParams.LeftAligned8Dp
            ) {}
        }
    }
}