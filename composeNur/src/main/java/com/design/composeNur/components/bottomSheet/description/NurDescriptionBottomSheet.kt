package com.design.composeNur.components.bottomSheet.description

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.components.bottomSheet.base.NurModalBottomSheet
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A reusable bottom sheet that shows a centered icon, title, optional description and a single button.
 *
 * @param modifier Will be applied to bottomSheetContent root composable content. In this case root is [Column]
 * @param isVisible Controls visibility of bottom sheet
 * @param icon Optional icon shown at the top
 * @param title Title text shown below the icon
 * @param description Optional description below the title
 * @param secondaryDescription Optional secondary description below the description
 * @param buttonText Text for the bottom action button
 * @param params Styling params for the text and icon
 * @param onButtonClick Called when action button is clicked
 * @param onDismissRequest Called when bottom sheet is dismissed
 *
 * @see NurModalBottomSheet
 * @see com.design.composeNur.components.bottomSheet.description.NurDescriptionBottomSheetParams
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurDescriptionBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    @DrawableRes icon: Int? = null,
    title: String,
    description: String? = null,
    secondaryDescription: String? = null,
    buttonText: String,
    params: NurDescriptionBottomSheetParams = NurDescriptionBottomSheetParams.Companion.Default,
    onButtonClick: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        hasCloseIcon = false,
        onDismissRequest = onDismissRequest
    ) {
        NurDescriptionBottomSheetContent(
            icon = icon,
            title = title,
            description = description,
            secondaryDescription = secondaryDescription,
            buttonText = buttonText,
            params = params,
            onButtonClick = onButtonClick
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun NurDescriptionBottomSheetContentPreview() {
    NurTheme {
        NurDescriptionBottomSheetContent(
            icon = R.drawable.ic_cat,
            title = "Title",
            description = "This is a description",
            secondaryDescription = "This is secondary",
            buttonText = "OK",
            onButtonClick = {},
            params = NurDescriptionBottomSheetParams.Companion.Default
        )
    }
}

@Composable
private fun NurDescriptionBottomSheetContent(
    @DrawableRes icon: Int? = null,
    title: String,
    description: String? = null,
    secondaryDescription: String? = null,
    buttonText: String,
    params: NurDescriptionBottomSheetParams,
    onButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(dimensionResource(id = R.dimen.padding_16dp))
    ) {
        icon?.let {
            Image(
                modifier = Modifier
                    .width(params.iconWidth)
                    .height(params.iconHeight)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = it),
                contentDescription = "Icon"
            )
        }

        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            style = params.titleTextStyle,
            text = title
        )

        description?.let {
            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
                style = params.descriptionTextStyle,
                text = it
            )
        }

        secondaryDescription?.let {
            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.padding_4dp)),
                style = params.secondaryDescriptionTextStyle,
                text = it
            )
        }

        NurButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
            buttonPadding = PaddingValues(),
            onClick = onButtonClick,
            buttonStyle = NurButtonStyle.Secondary,
            title = buttonText
        )
    }
}
