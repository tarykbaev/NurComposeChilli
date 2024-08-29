package com.design.composechili.components.navBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun ChiliNavSimpleItem(
    text: String = String(),
    @DrawableRes selectedIcon: Int,
    @DrawableRes unselectedIcon: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit = {},
) {

    val icon = if (isSelected) selectedIcon else unselectedIcon
    val textColor =
        if (isSelected) ChiliTheme.Colors.chiliLinkTextColor else ChiliTheme.Colors.chiliValueTextColor

    ChiliTheme {
        Column(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onClick
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier,
                painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = text,
                style = ChiliTextStyle.get(
                    textSize = ChiliTextDimensions.fromResources().TextSizeH10,
                    color = ChiliTheme.Colors.chiliSegmentedPickerTabTextColor,
                    font = Font(R.font.roboto_medium)
                ),
                color = textColor
            )
        }
    }
}