package com.design.composechili.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Composable
fun CategoryCard(
    modifier: Modifier = Modifier,
    type: CategoryCardType,
) {
    val horizontalAlignment = when (type) {
        is CategoryCardType.Centered -> Alignment.CenterHorizontally
        is CategoryCardType.LeftAligned -> Alignment.Start
    }
    Column(
        modifier = modifier
            .background(
                color = ChiliTheme.Colors.ChiliSurfaceBackground, shape = RoundedCornerShape(
                    dimensionResource(id = R.dimen.radius_12dp)
                )
            )
            .clickable(interactionSource = remember {
                MutableInteractionSource()
            }, indication = LocalIndication.current, onClick = {})
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
            .padding(vertical = dimensionResource(id = R.dimen.padding_8dp)),
        horizontalAlignment = horizontalAlignment
    ) {
        Image(
            painter = painterResource(id = type.icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            text = type.title,
            style = type.style
        )
    }
}

@Preview
@Composable
fun CategoryCard_Preview() {
    ChiliTheme {
        CategoryCard(
            type = CategoryCardType.Centered(
                title = "Something",
                icon = R.drawable.chili_ic_airpods,
                style = CategoryCardType.regularTextStyle
            )
        )
    }
}