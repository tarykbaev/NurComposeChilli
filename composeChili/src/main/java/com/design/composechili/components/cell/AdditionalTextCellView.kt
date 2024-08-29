package com.design.composechili.components.cell

import androidx.annotation.IntegerRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Composable
fun AdditionalTextCellView(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    chevronEnabled: Boolean,
    @IntegerRes icon: Int,
    ) {
    Row(
        modifier
            .background(
                color = ChiliTheme.Colors.chiliSurfaceBackground,
                shape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius4Dp)
            )
            .padding(horizontal = 8.dp)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_darkmode_false_),
            contentDescription = null
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Left
        )
        Text(
            modifier = Modifier.weight(1f),
            text = description,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Right
        )
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null
        )
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
                icon = R.drawable.chili_ic_chevron,
                chevronEnabled = true,
            )
            AdditionalTextCellView()
            AdditionalTextCellView()
        }
    }
}