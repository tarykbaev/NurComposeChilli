package com.design.composechili.components.bottomSheet.detailedInfoBottomSheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A composable function that displays a detailed bottom sheet with an icon, descriptive text,
 * and customizable primary and secondary buttons. The bottom sheet can be styled and customized
 * through the provided parameters.
 *
 * @param [onPrimaryClick] The action to perform when the primary button is clicked.
 * @param [onSecondaryClick] The action to perform when the secondary button is clicked (optional).
 * @param [infoText] The descriptive text to display in the bottom sheet.
 * @param [buttonTitle] The title for the primary button.
 * @param [secondaryButtonTitle] Optional title for the secondary button.
 * @param [detailedInfoBottomSheetParams] Parameters for customizing the appearance, such as icon size and text style.
 * @sample [DetailedInfoBottomSheet_Preview]
 */

@Composable
fun DetailedInfoBottomSheetContent(
    modifier: Modifier = Modifier,
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: () -> Unit = {},
    infoText: String,
    buttonTitle: String,
    secondaryButtonTitle: String? = null,
    detailedInfoBottomSheetParams: DetailedInfoBottomSheetParams,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(detailedInfoBottomSheetParams.iconSize),
            painter = painterResource(id = detailedInfoBottomSheetParams.icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16dp)),
            text = infoText,
            style = detailedInfoBottomSheetParams.textStyle
        )
        if (secondaryButtonTitle != null)
            BaseButton(
                buttonPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
                onClick = onSecondaryClick,
                title = secondaryButtonTitle,
                buttonStyle = ChiliButtonStyle.Additional
            )
        BaseButton(onClick = onPrimaryClick, title = buttonTitle)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DetailedInfoBottomSheetCustom_Preview() {
    ChiliTheme {
        DetailedInfoBottomSheetContent(
            onPrimaryClick = {},
            infoText = "Я согласен с условиями <a href=\"https://o\n" +
                    ".kg\">пользовательского соглашения</a> и \n" +
                    "условиями\n" +
                    "<a href=\"https://o.kg\">оферты сервиса «О!Деньги»</a>",
            buttonTitle = "Start",
            secondaryButtonTitle = "Later",
            detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.SmallIconWithTwoButtons
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DetailedInfoBottomSheet_Preview() {
    ChiliTheme {
        DetailedInfoBottomSheetContent(
            onPrimaryClick = {},
            infoText = "Текстовый блок, который содержит много текста и не может уместиться в четыре строки (как в маленьком Bottom-sheet).\n\n" +
                    "Возможно имеет какую-то инструкцию или подробное описание функционал. Плюс тут есть картиночка. \n\n" +
                    "Высота зависит от контента.",
            buttonTitle = "Понятно",
            detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.BigIconWithSingleButton
        )
    }
}