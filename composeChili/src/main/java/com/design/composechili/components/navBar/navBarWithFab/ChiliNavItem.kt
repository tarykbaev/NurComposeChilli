package com.design.composechili.components.navBar.navBarWithFab

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavItemParams
import com.design.composechili.theme.ChiliTextDimensions
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

/**
 *
 * Chili Navigation item to to display inside [NavBarWithFab]
 *
 * @param [label] accepts [String] adds text below the icon
 * @param [icon] accepts [DrawableRes] displays it at the center top of the component
 * @param [iconTint] accepts [Color] adds tint to the icon if not null
 * @param [isAnimated] accepts [Boolean] adds Bounce animation if true
 * @param [navItemParams] accepts [ChiliNavItemParams] adds visual transformation to component
 * @param [onClick] called when component is clicked
 */

@Composable
fun ChiliNavItem(
    label: String = String(),
    @DrawableRes icon: Int,
    iconTint: Color? = null,
    isAnimated: Boolean = false,
    onClick: () -> Unit = {},
    navItemParams: ChiliNavItemParams = ChiliNavItemParams.Default
) {

    var bounceState by remember { mutableStateOf(NavItemBounceState.NORMAL) }
    val sizeScale by animateFloatAsState(
        targetValue = if (bounceState == NavItemBounceState.BOUNCED) navItemParams.animationScaleSize else 1f,
        label = "Button Animation",
        animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = navItemParams.animationStiffness)
    ) {
        if (bounceState == NavItemBounceState.BOUNCED) bounceState = NavItemBounceState.NORMAL
    }

    ChiliTheme {
        Column(
            modifier = Modifier
                .graphicsLayer(
                    scaleX = sizeScale,
                    scaleY = sizeScale
                )
                .offset(y = (-navItemParams.verticalOffset))
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        if (isAnimated) bounceState = NavItemBounceState.BOUNCED
                        onClick.invoke()
                    }
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier
                    .background(
                        color = navItemParams.iconBackgroundColor,
                        shape = navItemParams.iconBackgroundShape
                    )
                    .padding(dimensionResource(id = R.dimen.padding_8dp)),
                painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
                colorFilter = if (iconTint != null) ColorFilter.tint(color = iconTint) else null,
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = label,
                style = navItemParams.labelTextStyle
            )
        }
    }
}

enum class NavItemBounceState { BOUNCED, NORMAL }