package com.design.composechili.components.navBar.navBarWithFab

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliPaddingDimensions
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions
import com.design.composechili.theme.dimensions.ChiliViewDimensions

/**
 * A floating action button (FAB) component for a navigation bar. It supports customization of icon,
 * background color, shape, size, and animations.
 *
 * @param modifier Modifier to be applied to the FAB, allowing for layout customizations such as padding, alignment, and size.
 * Default is `Modifier`.
 *
 * @param icon A drawable resource ID that specifies the icon displayed like FAB.
 * The icon should be passed as an integer representing a valid drawable resource (`@DrawableRes`).
 *
 * @param isAnimateScale A Boolean that determines if the FAB should animate its scale when interacted with.
 * If `true`, the button will grow and shrink slightly when pressed. Default is `true`.
 *
 * @param iconBackgroundColor The background color of the FAB icon. You can pass any `Color` to set this.
 * Default is `Color.Transparent`, making the background invisible.
 *
 * @param iconBackgroundShape The shape of the icon's background. You can provide any shape,
 * such as `CircleShape`, `RoundedCornerShape`, etc.
 * Default is `RoundedCornerShape` with a corner radius of 12dp.
 *
 * @param iconSize The size of the icon displayed inside the FAB.
 * Default size is 48dp. You can provide any `Dp` value to customize this.
 *
 * @param verticalOffset The vertical distance of the FAB from the bottom or surrounding content.
 * This allows positioning adjustments. Default is 24dp.
 *
 * @param onClick A lambda function invoked when the FAB is clicked. Default is an empty lambda (`{}`).
 *
 * Example Usage:
 * ```
 * ChiliNavFabItem(
 *     icon = R.drawable.ic_example,
 *     isAnimateScale = true,
 *     iconBackgroundColor = Color.Red,
 *     iconBackgroundShape = CircleShape,
 *     onClick = { /* Handle click */ }
 * )
 * ```
 */

@Composable
fun ChiliNavFabItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    isAnimateScale: Boolean = true,
    iconBackgroundColor: Color = Color.Transparent,
    iconBackgroundShape: Shape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius12Dp),
    iconSize: Dp = ChiliViewDimensions.fromResources().view48Dp,
    verticalOffset: Dp = ChiliPaddingDimensions.fromResources().padding24Dp,
    onClick: () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val scale by animateFloatAsState(
        targetValue = if (interactionSource.collectIsPressedAsState().value) 0.8f else 1f,
        label = String()
    )

    ChiliTheme {
        Column(
            modifier = modifier
                .offset(y = (-verticalOffset))
                .scale(if (isAnimateScale) scale else 1f)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = {
                        onClick.invoke()
                    }
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Image(
                modifier = Modifier
                    .size(iconSize)
                    .background(
                        color = iconBackgroundColor,
                        shape = iconBackgroundShape
                    ),
                painter = painterResource(id = icon),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun ChiliNavFabItemPreview() {
    ChiliTheme {
        ChiliNavFabItem(
            modifier = Modifier.padding(24.dp),
            icon = R.drawable.ic_scaner_48,
            isAnimateScale = true,
        )
    }
}