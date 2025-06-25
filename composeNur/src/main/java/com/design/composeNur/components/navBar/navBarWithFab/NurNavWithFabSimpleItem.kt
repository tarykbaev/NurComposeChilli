package com.design.composeNur.components.navBar.navBarWithFab

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.navBar.navBarWithFab.model.NurNavWithFabSimpleItemParams
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.dimensions.NurPaddingDimensions
import com.design.composeNur.utils.pressEffect
import com.design.composeNur.utils.rememberPressState
import com.design.composenur.R

/**
 * A composable function that represents a navigation item with a floating action button (FAB).
 * This item can have an icon, a label, and scale animation effects when selected.
 *
 * @param modifier Modifier applied to the root composable. Defaults to `Modifier`.
 * @param label The text label associated with the navigation item. Defaults to an empty string.
 * @param icon The resource ID for the drawable icon to display. This is a mandatory parameter.
 * @param selected A boolean flag that indicates whether the navigation item is currently selected.
 * @param scaleSize The scaling factor applied to the navigation item when it is selected.
 *                  Defaults to 1.3f (30% larger when selected).
 * @param scaleAnimationDuration The duration of the scale animation when the item is selected, in milliseconds.
 *                               Defaults to `DefaultDurationMillis`.
 * @param isScaleAnimationEnabled A boolean flag that controls whether the scale animation is enabled.
 *                                Defaults to `true`.
 * @param verticalOffset A vertical offset applied to the item to adjust its position.
 *                       Defaults to `NurPaddingDimensions.fromResources().padding20Dp`.
 * @param params Additional parameters for customizing the appearance and behavior of the item.
 *               Defaults to `NurNavSimpleItemParams.Default`.
 * @param onNavClicked A lambda function triggered when the navigation item is clicked.
 *                     Defaults to an empty lambda.
 * @sample NurNavSimpleItemParams.Default
 */

@Composable
fun NurNavWithFabSimpleItem(
    modifier: Modifier = Modifier,
    label: String = String(),
    @DrawableRes icon: Int,
    selected: Boolean,
    scaleSize: Float = 1.3f,
    scaleAnimationDuration: Int = DefaultDurationMillis,
    isScaleAnimationEnabled: Boolean = true,
    verticalOffset: Dp = NurPaddingDimensions.fromResources().padding20Dp,
    params: NurNavWithFabSimpleItemParams = NurNavWithFabSimpleItemParams.Default,
    onNavClicked: () -> Unit = {},
) {

    val navItemColor by animateColorAsState(
        targetValue = if (selected) params.selectedColorTint else params.unselectedColorTint,
        label = "nav item color for enable state",
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    val isPressedState = rememberPressState()

    val scale by animateFloatAsState(
        targetValue = if (isPressedState.value) scaleSize else 1f,
        label = String(),
        animationSpec = tween(scaleAnimationDuration)
    )

    Column(
        modifier = modifier
            .padding(vertical = params.verticalPadding)
            .offset(y = (-verticalOffset))
            .scale(if (isScaleAnimationEnabled) scale else 1f)
            .pressEffect("NurNavSimpleItem$label", isPressedState) {
                onNavClicked()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = NurTheme.Colors.NurNavBarItemBackgroundColor),
            border = BorderStroke(
                1.dp, NurTheme.Colors.NurNavBarItemStrokeColor
            )
        ) {
            Image(
                modifier = Modifier.padding(8.dp),
                painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
                colorFilter = ColorFilter.tint(navItemColor),
                contentDescription = null,
            )
        }
        Text(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_4dp)),
            text = label,
            color = navItemColor,
            style = params.labelTextStyle
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NurNavSimpleItemPreview() {
    NurTheme {
        var isSelected by remember {
            mutableStateOf(false)
        }
        NurNavWithFabSimpleItem(
            modifier = Modifier.padding(24.dp), icon = R.drawable.ic_home, selected = isSelected
        ) {
            isSelected = !isSelected
        }
    }
}