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
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.design.composechili.components.navBar.navBarWithFab.model.ChiliNavFabItemParams
import com.design.composechili.theme.ChiliTheme

/**
 *
 * Chili Navigation FAB item to show Floating Action Button
 * @param [icon] accepts [DrawableRes] displays it at the center of FAB
 * @param [isAnimated] accepts [Boolean] adds Bounce animation if true
 * @param [navItemParams] accepts [ChiliNavFabItemParams] adds visual transformation to FAB
 * @param [onClick] called when FAB is clicked
 */

@Composable
fun ChiliNavFabItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    isAnimated: Boolean = false,
    navItemParams: ChiliNavFabItemParams = ChiliNavFabItemParams.Default,
    onClick: () -> Unit = {}
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
            modifier = modifier
                .offset(y = (-navItemParams.verticalOffset))
                .graphicsLayer(
                    scaleX = sizeScale,
                    scaleY = sizeScale
                )
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
                    .size(54.dp)
                    .background(
                        color = navItemParams.iconBackgroundColor,
                        shape = navItemParams.iconBackgroundShape
                    ),
                painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
                contentDescription = null
            )
        }
    }
}