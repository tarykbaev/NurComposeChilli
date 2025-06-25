package com.design.composeNur.components.bottomSheet.detailedInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.bottomSheet.base.NurModalBottomSheet
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.buttons.baseButton.NurButtonStyle
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

/**
 * A composable function that displays a detailed bottom sheet with an icon, descriptive text,
 * and customizable primary and secondary buttons. The bottom sheet can be styled and customized
 * through the provided parameters.
 *
 * @param [modifier] Modifier to be applied to the root container of the bottom sheet content.
 * @param [isVisible] Controls the visibility of the bottom sheet.
 * @param [infoText] The descriptive text to display in the bottom sheet.
 * @param [infoTextAlign] Alignment for the descriptive text.
 * @param [buttonTitle] The title for the primary button.
 * @param [secondaryButtonTitle] Optional title for the secondary button.
 * @param [nurDetailedInfoBottomSheetParams] Parameters for customizing the appearance, such as icon, icon size, and text style.
 * @param [onPrimaryClick] The action to perform when the primary button is clicked.
 * @param [onSecondaryClick] The action to perform when the secondary button is clicked (optional).
 * @param [onDismissRequest] Callback triggered when the bottom sheet is requested to be dismissed.
 *
 * @see [NurModalBottomSheet]
 * @see [NurButton]
 * @see [NurDetailedInfoBottomSheetParams]
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NurDetailedInfoBottomSheet(
    modifier: Modifier = Modifier,
    isVisible: Boolean,
    infoText: String,
    infoTextAlign: TextAlign = TextAlign.Unspecified,
    buttonTitle: String,
    secondaryButtonTitle: String? = null,
    nurDetailedInfoBottomSheetParams: NurDetailedInfoBottomSheetParams,
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: () -> Unit = {},
    onDismissRequest: () -> Unit
) {
    NurModalBottomSheet(
        modifier = modifier,
        isVisible = isVisible,
        onDismissRequest = onDismissRequest
    ) {
        NurDetailedInfoBottomSheetContent(
            infoText = infoText,
            infoTextAlign = infoTextAlign,
            buttonTitle = buttonTitle,
            secondaryButtonTitle = secondaryButtonTitle,
            nurDetailedInfoBottomSheetParams = nurDetailedInfoBottomSheetParams,
            onPrimaryClick = onPrimaryClick,
            onSecondaryClick = onSecondaryClick
        )
    }
}

@Composable
private fun NurDetailedInfoBottomSheetContent(
    infoText: String,
    infoTextAlign: TextAlign,
    buttonTitle: String,
    secondaryButtonTitle: String? = null,
    nurDetailedInfoBottomSheetParams: NurDetailedInfoBottomSheetParams,
    onPrimaryClick: () -> Unit,
    onSecondaryClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(nurDetailedInfoBottomSheetParams.iconSize),
            painter = painterResource(id = nurDetailedInfoBottomSheetParams.icon),
            contentDescription = "icon"
        )
        Text(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_16dp)),
            text = infoText,
            textAlign = infoTextAlign,
            style = nurDetailedInfoBottomSheetParams.textStyle
        )
        Spacer(modifier = Modifier.height(16.dp))
        secondaryButtonTitle?.let {
            NurButton(
                onClick = onSecondaryClick,
                title = it,
                buttonStyle = NurButtonStyle.Additional
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        NurButton(
            onClick = onPrimaryClick,
            title = buttonTitle
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@Preview(showBackground = true)
private fun NurDetailedInfoBottomSheetContentPreview() {
    NurTheme {
        NurDetailedInfoBottomSheetContent(
            infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                    "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                    "Высота зависит от контента.",
            infoTextAlign = TextAlign.Center,
            buttonTitle = "Ясно",
            secondaryButtonTitle = "Понятно",
            nurDetailedInfoBottomSheetParams = NurDetailedInfoBottomSheetParams.BigIconWithSingleButton,
            onPrimaryClick = {},
            onSecondaryClick = {}
        )
    }
}