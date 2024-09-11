package com.design.composechili.components.bottomSheet.detailedInfoBottomSheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffoldState
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
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedInfoBottomSheet(
    sheetState: BottomSheetScaffoldState,
    peekHeight: Dp = 0.dp,
    onPrimaryClick: () -> Unit = {},
    onSecondaryClick: () -> Unit = {},
    infoText: String,
    buttonTitle: String,
    secondaryButtonTitle: String? = null,
    detailedInfoBottomSheetParams: DetailedInfoBottomSheetParams,
    screenContent: @Composable () -> Unit
) {
    val iconSize =
        if (secondaryButtonTitle != null) 72.dp else dimensionResource(id = R.dimen.view_125dp)
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            bottomSheetContent = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(iconSize),
                        painter = painterResource(id = R.drawable.ic_cat),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_16dp)),
                        text = infoText,
                        style = detailedInfoBottomSheetParams.textStyle
                    )
                }
                if (secondaryButtonTitle != null)
                    BaseButton(
                        modifier = Modifier.padding(8.dp),
                        onClick = onSecondaryClick,
                        title = secondaryButtonTitle,
                        buttonStyle = ChiliButtonStyle.Additional
                    )
                BaseButton(onClick = onPrimaryClick, title = buttonTitle)
            },
            hasCloseIcon = true,
            screenContent = screenContent,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailedInfoBottomSheet_Preview() {
    val sheetState = getBottomSheetState()
    ChiliTheme {
        DetailedInfoBottomSheet(
            sheetState = sheetState,
            onPrimaryClick = {},
            infoText = "Я согласен с условиями <a href=\"https://o\n.kg\">пользовательского соглашения</a> и \nусловиями\n<a href=\"https://o.kg\">оферты сервиса «О!Деньги»</a>",
            buttonTitle = "Start",
            secondaryButtonTitle = "Later",
            peekHeight = 350.dp,
            detailedInfoBottomSheetParams = DetailedInfoBottomSheetParams.Default
        )
        { }
    }
}