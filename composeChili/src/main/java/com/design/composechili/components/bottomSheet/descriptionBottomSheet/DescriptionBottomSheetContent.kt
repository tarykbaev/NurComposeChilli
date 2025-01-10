package com.design.composechili.components.bottomSheet.descriptionBottomSheet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.NurChiliButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme

/**
 * @param [modifier] Will be applied to bottomSheetContent root composable content. In this is case root is [LazyColumn]
 * @param [buttonText] [String] that will show on the [NurChiliButton]
 * @param [title] [String] that will show up below icon
 * @param [icon] Icon which will show up on the top of the sheet
 * @param [description] [String] which will show up below [title]
 * @param [secondaryDescription] [String] which will show up below [description]
 * @param [onButtonClick] Will be called when [NurChiliButton] clicked
 *
 */

@Composable
fun DescriptionBottomSheetContent(
    modifier: Modifier = Modifier,
    buttonText: String,
    title: String,
    @DrawableRes icon: Int? = null,
    description: String? = null,
    secondaryDescription: String? = null,
    onButtonClick: () -> Unit,
    params: DescriptionBottomSheetParams = DescriptionBottomSheetParams.Default,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_16dp))
    ) {
        if (icon != null) {
            Image(
                modifier = Modifier
                    .width(params.iconWidth)
                    .height(params.iconHeight)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = icon),
                contentDescription = "Icon"
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = dimensionResource(id = R.dimen.padding_16dp)
                ),
            style = params.titleTextStyle,
            text = title
        )
        if (description != null) {
            Text(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_16dp)
                    ),
                style = params.descriptionTextStyle,
                text = description
            )
        }
        if (secondaryDescription != null) {
            Text(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(id = R.dimen.padding_4dp)
                    ),
                style = params.secondaryDescriptionTextStyle,
                text = secondaryDescription
            )
        }
        NurChiliButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            onClick = onButtonClick,
            buttonStyle = ChiliButtonStyle.Secondary,
            title = buttonText
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DescriptionBottomSheetPreview() {
    ChiliTheme {
        DescriptionBottomSheetContent(
            icon = R.drawable.ic_cat,
            title = "Title",
            description = "Description",
            secondaryDescription = "SecondaryDescription",
            buttonText = "Button",
            onButtonClick = {},
        )
    }
}
