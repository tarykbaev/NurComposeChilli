package com.design.composechili.components.bottomSheet.descriptionBottomSheet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.BottomSheetDragHandle
import com.design.composechili.components.bottomSheet.actionBottomSheet.ActionBottomSheetButton
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme

/**
 * @param [modifier] Will be applied to bottomSheetContent root composable content. In this is case root is [LazyColumn]
 * @param [peekHeight] The default peek height used by BottomSheetScaffold.
 * @param [buttonText] [String] that will show on the [BaseButton]
 * @param [title] [String] that will show up below icon
 * @param [hasCloseIcon] The icon which will show up on the top right corner of the sheet
 * @param [icon] Icon which will show up on the top of the sheet
 * @param [description] [String] which will show up below [title]
 * @param [secondaryDescription] [String] which will show up below [description]
 * @param [sheetState] Bottom sheet state, hosting state like expanded or not
 * @see [BottomSheetScaffoldState]
 * @param [onButtonClick] Will be called when [BaseButton] clicked
 * @param [content] Screen content, which should be covered by the [BaseBottomSheet]. Bottom Sheet will show over this content
 *
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionBottomSheet(
    modifier: Modifier = Modifier,
    peekHeight: Dp = 0.dp,
    buttonText: String,
    title: String,
    hasCloseIcon: Boolean = false,
    @DrawableRes icon: Int? = null,
    description: String? = null,
    secondaryDescription: String? = null,
    sheetState: BottomSheetScaffoldState,
    onButtonClick: () -> Unit,
    params: DescriptionBottomSheetParams = DescriptionBottomSheetParams.Default,
    content: @Composable () -> Unit
) {
    BaseBottomSheet(
        sheetState = sheetState,
        peekHeight = peekHeight,
        hasCloseIcon = hasCloseIcon,
        isDragHandleContentEnabled = true,
        dragHandle = { BottomSheetDragHandle() },
        bottomSheetContent = {
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
                BaseButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                        .padding(top = dimensionResource(id = R.dimen.padding_16dp)),
                    onClick = onButtonClick,
                    buttonStyle = ChiliButtonStyle.Secondary,
                    title = buttonText
                )
            }
        },
        screenContent = { content() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DescriptionBottomSheetPreview() {
    ChiliTheme {
        val sheetState = getBottomSheetState()

        DescriptionBottomSheet(
            icon = R.drawable.ic_cat,
            sheetState = sheetState,
            title = "Title",
            description = "Description",
            secondaryDescription = "SecondaryDescription",
            buttonText = "Button",
            onButtonClick = {},
            peekHeight = 272.dp
        ) {

        }
    }
}
