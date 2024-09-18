package com.design.composechili.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.card.models.CategoryCardItem
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    description: String,
    discount: String,
    image: Int,
    productCardParams: ProductCardParams = ProductCardParams.Default,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(
                color = ChiliTheme.Colors.ChiliSurfaceBackground,
                shape = productCardParams.cornerShape
            )
            .sizeIn(maxWidth = 168.dp)
            .clip(productCardParams.cornerShape)
            .clickable(interactionSource = remember {
                MutableInteractionSource()
            }, indication = LocalIndication.current, onClick = onClick),
    ) {
        Box {
            Image(
                modifier = Modifier.size(height = 210.dp, width = 168.dp),
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.BottomStart)
                    .background(
                        brush = Brush.linearGradient(colors = productCardParams.discountGradientColors),
                        RoundedCornerShape(dimensionResource(id = R.dimen.radius_6dp))
                    ),
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = discount,
                    style = productCardParams.discountStyle
                )
            }
        }
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = productCardParams.titleStyle
            )
            Row(
                modifier = Modifier
                    .background(
                        color = Color(0x1AFF9500),
                        RoundedCornerShape(
                            dimensionResource(id = R.dimen.radius_6dp)
                        )
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(
                        vertical = 4.dp,
                        horizontal = 8.dp
                    ),
                    text = subtitle,
                    style = productCardParams.subtitleStyle
                )
            }
            Text(
                modifier = Modifier.padding(vertical = dimensionResource(id = R.dimen.padding_4dp)),
                text = description,
                maxLines = productCardParams.descriptionMaxLines,
                overflow = TextOverflow.Ellipsis,
                style = productCardParams.descriptionStyle
            )
        }
    }
}

@Preview
@Composable
fun ProductCard_Preview() {
    val item = CategoryCardItem(
        title = "98 000,00 с",
        subtitle = "833,3 с x 12мес",
        description = "Помпа для воды AQUA Automatic Water Dispenser белый",
        discount = "-20%",
        image = R.drawable.test_image,
    )
    ChiliTheme {
        ProductCard(
            title = item.title,
            subtitle = item.subtitle,
            description = item.description,
            discount = item.discount,
            image = item.image
        )
    }
}

data class ProductCardParams(
    val titleStyle: TextStyle,
    val subtitleStyle: TextStyle,
    val descriptionStyle: TextStyle,
    val descriptionMaxLines: Int,
    val discountStyle: TextStyle,
    val discountGradientColors: List<Color>,
    val cornerShape: RoundedCornerShape,
) {
    companion object {
        val Default
            @Composable get() = ProductCardParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                ),
                subtitleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH10,
                    color = Color(0xFFFF9500),
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                ),
                descriptionMaxLines = 2,
                discountStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                    color = Color.White
                ),
                discountGradientColors = listOf(
                    Color(0xFFFF6491), Color(0xFFF91155)
                ),
                cornerShape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp))
            )
    }
}