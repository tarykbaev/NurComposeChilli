package com.design.composechili.components.cell

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
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
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.components.cell.model.CellCornerMode
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
/**
 * @param [onTitleClick] callback will invoke when user will click cell upper header part
 * @param [onPositiveButtonClick] callback will invoke when user will click right positive button
 * @param [onNegativeButtonClick] callback will invoke when user will click left negative button
 * @param [title] button main title value
 * @param [titleStyle] button main title style
 * @param [buttonStyle] button visual style
 * @param [isEnabled] is button enabled state
 * @sample ChiliButtonStyle.Primary
 */

@Composable
fun AdditionalDoubleButtons(
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
                color = ChiliTheme.Colors.ChiliCellViewBackground,
                shape = CellCornerMode.Single.toRoundedShape()
            )
    ) {
        Row(
            modifier = Modifier
                .clickable { onTitleClick() }
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
                style = AdditionalTextCellViewParams.AdditionalText.titleTextAppearance
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.chili_ic_chevron),
                contentDescription = null
            )
        }
        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = ChiliTheme.Colors.ChiliDividerColor,
            thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
        )
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BaseButton(
                modifier = Modifier.weight(1f),
                onClick = { onNegativeButtonClick() },
                title = negativeTitle,
                buttonPadding = PaddingValues(0.dp),
                buttonStyle = ChiliButtonStyle.Additional.copy(
                    backgroundActiveColor = Color.Transparent,
                    borderColor = Color.Transparent
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliSecondaryButtonTextColorActive
                )
            )
            VerticalDivider(
                modifier = Modifier.fillMaxHeight(),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
            BaseButton(
                modifier = Modifier.weight(1f),
                onClick = { onPositiveButtonClick() },
                title = positiveTitle,
                buttonPadding = PaddingValues(0.dp),
                buttonStyle = ChiliButtonStyle.Additional.copy(
                    backgroundActiveColor = Color.Transparent,
                    borderColor = Color.Transparent
                ),
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliSecondaryButtonTextColorActive,
                    font = ChiliTheme.Attribute.ChiliBoldTextFont
                )
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
fun AdditionalButtons_Preview() {
    ChiliTheme {
        AdditionalDoubleButtons(
            title = "Заголовок",
            positiveTitle = "ОПЛАТИТЬ",
            negativeTitle = "ОТМЕНИТЬ"
        )
    }
}