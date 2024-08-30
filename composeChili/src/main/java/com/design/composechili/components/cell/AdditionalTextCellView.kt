package com.design.composechili.components.cell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Composable
fun AdditionalTextCellView(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    chevronEnabled: Boolean = false,
    @DrawableRes icon: Int? = null,
    shape: RoundedCornerShape = AdditionalTextCellViewParams.AdditionalText.roundedCornerShape
) {
    Column(
        modifier
            .sizeIn(minHeight = 48.dp)
            .background(
                color = ChiliTheme.Colors.chiliSurfaceBackground,
                shape = shape
            ),
        verticalArrangement = Arrangement.Center,
        ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null)
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null
                )
            Text(
                modifier = Modifier
                    .weight(1.2f)
                    .padding(start = 4.dp),
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left,
                style = AdditionalTextCellViewParams.AdditionalText.titleTextAppearance
            )
            Text(
                modifier = Modifier.weight(1f),
                text = description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Right,
                style = AdditionalTextCellViewParams.AdditionalText.additionalTextAppearance
            )
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
                title = "Длинный текст",
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
        }
    }
}

data class AdditionalTextCellViewParams(
    val titleTextAppearance: TextStyle,
    val additionalTextAppearance: TextStyle,
    val roundedCornerShape: RoundedCornerShape,
) {

    companion object {
        val roundedShapeTop
            @Composable
            get() = RoundedCornerShape(
                topStart = ChiliRadiusDimensions.fromResources().radius8Dp,
                topEnd = ChiliRadiusDimensions.fromResources().radius8Dp,
            )

        val roundedShapeCenter
            @Composable
            get() = RoundedCornerShape(dimensionResource(id = R.dimen.view_0dp))

        val roundedShapeBottom
            @Composable
            get() = RoundedCornerShape(
                bottomStart = ChiliRadiusDimensions.fromResources().radius8Dp,
                bottomEnd = ChiliRadiusDimensions.fromResources().radius8Dp,
            )

//        val AdditionalTextWithIcon
//            @Composable
//            get() = AdditionalTextCellViewParams(
//                titleTextAppearance = ChiliTextStyle.get(
//                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
//                    ChiliTheme.Colors.ChiliPrimaryTextColor,
//                ),
//                additionalTextAppearance = ChiliTextStyle.get(
//                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
//                    ChiliTheme.Colors.ChiliPrimaryTextColor,
//                ),
//                roundedCornerShape = RoundedCornerShape(
//                    ChiliRadiusDimensions.fromResources().radius8Dp
//                )
//            )

        val AdditionalText
            @Composable
            get() = AdditionalTextCellViewParams(
                titleTextAppearance = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                additionalTextAppearance = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                ),
                roundedCornerShape = RoundedCornerShape(
                    ChiliRadiusDimensions.fromResources().radius8Dp
                )
            )
    }

}