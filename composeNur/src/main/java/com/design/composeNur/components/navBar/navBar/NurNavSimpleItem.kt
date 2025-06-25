package com.design.composeNur.components.navBar.navBar

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.navBar.navBar.model.NurNavSimpleItemParams
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A simple navigation item for a navigation bar. It includes an icon and an optional label,
 * with customizable or theme-based tints for selected and unselected states.
 *
 * @param modifier Modifier to be applied to the navigation item, allowing for layout customizations such as padding, alignment, and size.
 * Default is `Modifier`.
 *
 * @param label A string representing the label to display below or next to the icon.
 * The label is optional and defaults to an empty string.
 *
 * @param icon A drawable resource ID for the icon displayed in the navigation item.
 * The icon should be passed as an integer representing a valid drawable resource (`@DrawableRes`).
 *
 * @param selectedColorTint The color tint applied to the icon and label when the item is selected.
 * The default value is the `NurNavBarSelectedItemColor` from the app's theme (`NurTheme.Colors.NurNavBarSelectedItemColor`).
 *
 * @param unselectedColorTint The color tint applied to the icon and label when the item is not selected.
 * The default value is the `NurNavBarUnSelectedItemColor` from the app's theme (`NurTheme.Colors.NurNavBarUnSelectedItemColor`).
 *
 * @param selected A Boolean that determines if the navigation item is currently selected.
 * If `true`, the item will use the `selectedColorTint`, otherwise it will use the `unselectedColorTint`.
 *
 * @param navItemParams nav item visual transformation params and paddings. Default is `NurNavSimpleItemParams.Default`.
 *
 * @param onNavClicked A lambda function invoked when the navigation item is clicked.
 * This is used to handle navigation logic or any associated actions.
 * Default is an empty lambda (`{}`).
 *
 * Example Usage:
 * ```
 * NurNavSimpleItem(
 *     label = "Home",
 *     icon = R.drawable.ic_home,
 *     selected = true,
 *     onNavClicked = { /* Handle navigation */ }
 * )
 * ```
 *
 * @see [NurNavSimpleItemParams.Default]
 */

@Composable
fun NurNavSimpleItem(
    modifier: Modifier = Modifier,
    label: String = String(),
    @DrawableRes icon: Int,
    selectedColorTint: Color = NurTheme.Colors.NurNavBarSelectedItemColor,
    unselectedColorTint: Color = NurTheme.Colors.NurNavBarUnSelectedItemColor,
    selected: Boolean,
    navItemParams: NurNavSimpleItemParams = NurNavSimpleItemParams.Default,
    onNavClicked: () -> Unit = {},
) {

    val navItemColor by animateColorAsState(
        targetValue = if (selected) selectedColorTint else unselectedColorTint,
        label = "nav item color for enable state",
        animationSpec = spring(stiffness = Spring.StiffnessLow)
    )

    Column(
        modifier = modifier
            .padding(vertical = navItemParams.verticalPadding)
            .clickable(
                onClick = onNavClicked
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            modifier = Modifier,
            painter = rememberVectorPainter(ImageVector.vectorResource(id = icon)),
            colorFilter = ColorFilter.tint(navItemColor),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.padding_4dp)),
            text = label,
            color = navItemColor,
            style = navItemParams.labelTextStyle
        )
    }
}

@Preview
@Composable
fun NurNavSimpleItemPreview() {
    NurTheme {
        var isSelected by remember {
            mutableStateOf(false)
        }
        NurNavSimpleItem(
            modifier = Modifier.padding(24.dp),
            icon = R.drawable.ic_home,
            selected = isSelected
        ) {
            isSelected = !isSelected
        }
    }
}