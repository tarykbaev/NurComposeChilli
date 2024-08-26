package com.design.composechili.components.navBar

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions

@Composable
fun ChiliNavFabItem(
    @DrawableRes icon: Int = R.drawable.ic_scaner_48,
    animationSize: Float = 1.4f,
    stiffness: Float = Spring.StiffnessLow,
    onClick: () -> Unit = {},
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val sizeScale by animateFloatAsState(
        targetValue = if (isPressed) animationSize else 1f,
        label = "Button Animation",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy,
            stiffness = stiffness
        )
    )

    Column(
        modifier = Modifier
            .offset(y = (-27).dp)
            .graphicsLayer(
                scaleX = sizeScale,
                scaleY = sizeScale
            )
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onClick
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            modifier = Modifier
                .size(54.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(
                        ChiliRadiusDimensions.fromResources().radius12Dp,
                    )
                ),
            painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
            contentDescription = null
        )
    }
}