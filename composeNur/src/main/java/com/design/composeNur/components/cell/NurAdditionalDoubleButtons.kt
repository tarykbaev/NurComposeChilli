package com.design.composeNur.components.cell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.components.cell.model.CellCornerMode
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

/**
 * A composable function that displays a header with an optional icon and title, followed by two buttons
 * positioned at the bottom of the cell. The buttons can be customized with different titles and click actions.
 *
 * @param modifier Modifier to be applied to the composable.
 * @param title The main title text displayed in the header section of the cell.
 * @param icon Drawable resource ID for the icon displayed in the header section. Defaults to a phone icon.
 * @param negativeTitle Title text for the left (negative) button.
 * @param positiveTitle Title text for the right (positive) button.
 * @param onTitleClick Callback invoked when the user clicks on the header part of the cell.
 * @param onPositiveButtonClick Callback invoked when the user clicks on the right (positive) button.
 * @param onNegativeButtonClick Callback invoked when the user clicks on the left (negative) button.
 *
 * Example usage:
 * @sample NurAdditionalDoubleButtons(
 *     title = "Example Title",
 *     icon = R.drawable.ic_example_icon,
 *     negativeTitle = "Cancel",
 *     positiveTitle = "Confirm",
 *     onTitleClick = { /* Handle title click */ },
 *     onPositiveButtonClick = { /* Handle positive button click */ },
 *     onNegativeButtonClick = { /* Handle negative button click */ }
 * )
 */

@Composable
fun NurAdditionalDoubleButtons(
    modifier: Modifier = Modifier,
    title: String = String(),
    @DrawableRes icon: Int = R.drawable.ic_squircle_phone,
    negativeTitle: String = String(),
    positiveTitle: String = String(),
    onTitleClick: () -> Unit = {},
    onPositiveButtonClick: () -> Unit = {},
    onNegativeButtonClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = NurTheme.Colors.NurCellBackground,
                shape = CellCornerMode.Single.toRoundedShape()
            )
    ) {
        Row(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(), onClick = onTitleClick
                )
                .background(Color.Transparent)
                .padding(vertical = 16.dp)
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = icon),
                modifier = Modifier.size(48.dp),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left,
                style = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    NurTheme.Colors.NurPrimaryTextColor,
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.nur_ic_chevron),
                contentDescription = null
            )
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = NurTheme.Colors.NurDividerColor,
            thickness = NurTheme.Attribute.NurDividerHeightSize
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            NurButton(
                modifier = Modifier.weight(1f),
                onClick = { onNegativeButtonClick() },
                title = negativeTitle,
                buttonPadding = PaddingValues(0.dp),
                buttonStyle = NurButtonStyle.Additional.copy(
                    backgroundActiveColor = Color.Transparent,
                    borderColor = Color.Transparent
                ),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurSecondaryButtonTextColorActive
                )
            )
            VerticalDivider(
                modifier = Modifier.fillMaxHeight(),
                color = NurTheme.Colors.NurDividerColor,
                thickness = NurTheme.Attribute.NurDividerHeightSize
            )
            NurButton(
                modifier = Modifier.weight(1f),
                onClick = { onPositiveButtonClick() },
                title = positiveTitle,
                buttonPadding = PaddingValues(0.dp),
                buttonStyle = NurButtonStyle.Additional.copy(
                    backgroundActiveColor = Color.Transparent,
                    borderColor = Color.Transparent
                ),
                titleStyle = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurSecondaryButtonTextColorActive,
                    font = NurTheme.Attribute.NurBoldTextFont
                )
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AdditionalButtons_Preview() {
    NurTheme {
        NurAdditionalDoubleButtons(
            title = "Заголовок",
            positiveTitle = "ОПЛАТИТЬ",
            negativeTitle = "ОТМЕНИТЬ"
        )
    }
}