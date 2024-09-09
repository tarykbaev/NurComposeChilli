package com.design.composechili.components.navBar.simpleNavBar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import com.design.composechili.R
import com.design.composechili.components.navBar.simpleNavBar.model.ChiliNavSimpleItemParams
import com.design.composechili.theme.ChiliTheme

/**
 *
 * Chili Navigation item to to display inside [ChiliNavBar]
 *
 * @param [label] accepts [String] adds text below the icon
 * @param [icon] accepts [DrawableRes] displays it at the center top of the component
 * @param [iconTint] accepts [Color] adds tint to the icon if not null
 * @param [navItemParams] accepts [ChiliNavSimpleItemParams] adds visual transformation to component
 * @param [onClick] called when component is clicked
 */

@Composable
fun ChiliNavSimpleItem(
    label: String = String(),
    @DrawableRes icon: Int,
    iconTint: Color? = null,
    navItemParams: ChiliNavSimpleItemParams = ChiliNavSimpleItemParams.Default,
    onClick: () -> Unit = {},
) {

    ChiliTheme {
        Column(
            modifier = Modifier
                .padding(vertical = navItemParams.verticalPadding)
                .clickable(
                    onClick = onClick
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier,
                painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
                colorFilter = if (iconTint != null) ColorFilter.tint(color = iconTint) else null,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_4dp)),
                text = label,
                style = navItemParams.labelTextStyle
            )
        }
    }
}