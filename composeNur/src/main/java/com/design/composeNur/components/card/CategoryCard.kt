package com.design.composeNur.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.shimmer.ShimmerOrContent
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.utils.clickableWithSimpleRippleEffect
import com.design.composenur.R

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: Painter,
    isShimmering: Boolean = false,
    categoryCardParams: CategoryCardParams = CategoryCardParams.Default,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp)))
            .background(NurTheme.Colors.NurCardViewBackground)
            .clickableWithSimpleRippleEffect {
                onClick()
            }
            .padding(categoryCardParams.containerPadding),
        horizontalAlignment = categoryCardParams.iconAlignment
    ) {
        ShimmerOrContent(
            shimmerHeight = categoryCardParams.iconSize,
            shimmerWidth = categoryCardParams.iconSize,
            shimmerRoundRadius = dimensionResource(R.dimen.radius_8dp),
            isShimmering = isShimmering
        ) {
            Image(
                modifier = Modifier
                    .size(categoryCardParams.iconSize),
                painter = icon,
                contentDescription = null
            )
        }
        ShimmerOrContent(
            modifier = Modifier.padding(categoryCardParams.titlePadding),
            shimmerWidth = dimensionResource(R.dimen.view_64dp),
            isShimmering = isShimmering
        ) {
            Text(
                modifier = Modifier.padding(categoryCardParams.titlePadding),
                text = title,
                style = categoryCardParams.textStyle
            )
        }
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
                    icon = painterResource(id = R.drawable.ic_payment)
                ) {}
                CategoryCard(
                    title = "Centered",
                    icon = painterResource(id = R.drawable.ic_payment),
                    categoryCardParams = CategoryCardParams.Default.copy(
                        iconAlignment = Alignment.CenterHorizontally
                    )
                ) {}
            }
            CategoryCard(
                title = "Centered",
                icon = painterResource(id = R.drawable.ic_payment),
            ) {}
        }
    }
}