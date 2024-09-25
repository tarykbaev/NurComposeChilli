package com.design.composechili.components.navBar.navBarWithFab

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.dimensions.ChiliPaddingDimensions
import com.design.composechili.theme.dimensions.ChiliRadiusDimensions
import com.design.composechili.theme.dimensions.ChiliViewDimensions
import com.design.composechili.utils.pressEffect
import com.design.composechili.utils.rememberPressState

/**
 * A composable function that represents a navigation item with a floating action button (FAB).
 * The FAB displays an icon and can optionally have a background, scaling animation, and custom size.
 *
 * @param modifier Modifier applied to the root composable. Defaults to `Modifier`.
 * @param icon The resource ID for the drawable icon to display. This is a mandatory parameter.
 * @param isScaleAnimationEnabled A boolean flag that controls whether the scale animation is enabled.
 *                                Defaults to `true`.
 * @param iconBackgroundColor The background color for the icon's container.
 *                            Defaults to `Color.Transparent` (no background).
 * @param iconBackgroundShape The shape of the background container for the icon.
 *                            Defaults to `RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius12Dp)`.
 * @param iconSize The size of the icon displayed within the FAB.
 *                 Defaults to `ChiliViewDimensions.fromResources().view48Dp`.
 * @param animationDuration The duration of the scaling animation in milliseconds.
 *                          Defaults to `DefaultDurationMillis`.
 * @param verticalOffset A vertical offset applied to adjust the position of the FAB.
 *                       Defaults to `ChiliPaddingDimensions.fromResources().padding20Dp`.
 * @param scaleSize The scaling factor applied to the icon when clicked or selected.
 *                  Defaults to 1.3f (30% increase).
 * @param onClick A lambda function triggered when the FAB is clicked. Defaults to an empty lambda.
 */


@Composable
fun ChiliNavFabItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    isScaleAnimationEnabled: Boolean = true,
    iconBackgroundColor: Color = Color.Transparent,
    iconBackgroundShape: Shape = RoundedCornerShape(ChiliRadiusDimensions.fromResources().radius12Dp),
    iconSize: Dp = ChiliViewDimensions.fromResources().view48Dp,
    animationDuration: Int = DefaultDurationMillis,
    verticalOffset: Dp = ChiliPaddingDimensions.fromResources().padding20Dp,
    scaleSize: Float = 1.3f,
    onClick: () -> Unit = {}
) {

    val isPressedState = rememberPressState()

    val scale by animateFloatAsState(
        targetValue = if (isPressedState.value) scaleSize else 1f,
        label = String(),
        animationSpec = tween(animationDuration)
    )

    Column(
        modifier = modifier
            .offset(y = (-verticalOffset))
            .scale(if (isScaleAnimationEnabled) scale else 1f)
            .pressEffect("ChiliNavFabItem", isPressedState, onClick),
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

@Preview
@Composable
fun ChiliNavFabItemPreview() {
    ChiliTheme
    ChiliNavFabItem(
        modifier = Modifier.padding(24.dp),
        icon = R.drawable.ic_scaner_48,
        isScaleAnimationEnabled = true,
    )
}