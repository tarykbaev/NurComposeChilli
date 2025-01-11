package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.input.baseInput.NurChiliBaseInput
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.components.input.code.NurChiliCodeInput
import com.design.composechili.components.input.code.CodeLength
import com.design.composechili.components.input.inputFieldWithDescAndAction.NurChiliInputFieldWithDescAndAction
import com.design.composechili.components.input.maskedTextField.NurChiliMaskedTextField
import com.design.composechili.components.input.maskedTextField.MaskedTextFieldParams
import com.design.composechili.components.input.password.NurChiliPasswordInput
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder

@Composable
fun InputFieldsScreen() {

    var baseInputText by remember { mutableStateOf("") }
    var baseInputWithIconsText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var commentText by remember { mutableStateOf("") }
    var isFieldError by remember { mutableStateOf(false) }
    var descriptionText by remember { mutableStateOf("") }
    var isCodeInputError by remember { mutableStateOf(true) }
    var simpleWithClearText by remember {
        mutableStateOf(String())
    }
    var passwordInputText by remember { mutableStateOf("") }
    var isPasswordInputError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChiliTheme.Colors.ChiliSurfaceBackground)
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        NurChiliBaseInput(
            textFieldValue = baseInputText,
            onValueChange = { baseInputText = it },
            params = BaseInputParams.Default.copy(
                textStyle = ChiliTextStyleBuilder.H7.Primary.Bold,
            ),
            containerStartIcon = painterResource(id = R.drawable.ic_cat),
        )
        NurChiliInputFieldWithDescAndAction(
            description = "Simple",
            actionTitle = "Сканер",
        ) {
            NurChiliMaskedTextField(
                initialText = "+996 XXX XXX XXX",
                onValueChange = {},
                rootContainerPadding = PaddingValues(0.dp),
                maskInputParams = MaskedTextFieldParams.Default.copy(allowedInputSymbols = "1234567890")
            )
        }
        NurChiliInputFieldWithDescAndAction(
            description = "Simple",
        ) {
            NurChiliBaseInput(
                textFieldValue = descriptionText,
                onValueChange = { descriptionText = it },
                hint = "Hint",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyleBuilder.H5.Primary.Bold.copy(textAlign = TextAlign.Center)
                )
            )
        }

        NurChiliInputFieldWithDescAndAction(
            description = "Simple with start icon"
        ) {
            NurChiliBaseInput(
                textFieldValue = baseInputWithIconsText,
                onValueChange = { baseInputWithIconsText = it },
                hint = "Search Service",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyleBuilder.H7.Primary.Regular
                ),
                fieldEndIcon = painterResource(id = R.drawable.chili_ic_clear_24),
                fieldStartIcon = painterResource(id = R.drawable.chili_ic_search)
            )
        }

        NurChiliInputFieldWithDescAndAction(
            description = "Simple with clear"
        ) {
            NurChiliBaseInput(textFieldValue = simpleWithClearText,
                onValueChange = { simpleWithClearText = it },
                hint = "Hint",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyle.get(
                        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                        ChiliTheme.Colors.ChiliPrimaryTextColor,
                        ChiliTheme.Attribute.ChiliBoldTextFont
                    ).copy(textAlign = TextAlign.Center)
                ),
                fieldEndIcon = if (simpleWithClearText.isNotBlank()) painterResource(id = R.drawable.chili_ic_clear_24) else null,
                endIconClicked = {
                    simpleWithClearText = String()
                })
        }


        NurChiliInputFieldWithDescAndAction(
            description = "Simple with start icon", descriptionTextStyle = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                if (isFieldError) colorResource(id = R.color.red_1) else colorResource(id = R.color.black_5)
            )
        ) {
            NurChiliBaseInput(
                textFieldValue = passwordText,
                hint = "Password",
                isError = isFieldError,
                onValueChange = { passwordText = it },
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyle.get(
                        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                        ChiliTheme.Colors.ChiliPrimaryTextColor,
                        ChiliTheme.Attribute.ChiliBoldTextFont
                    ).copy(textAlign = TextAlign.Center),
                )
            )
        }
        NurChiliPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = passwordInputText,
            hint = "Password",
            isError = isPasswordInputError,
            onImeAction = {
                isPasswordInputError = isPasswordInputError.not()
            },
            onValueChange = { passwordInputText = it },
        )

        NurChiliInputFieldWithDescAndAction(
            description = "mask"
        ) {
            NurChiliMaskedTextField(
                initialText = "123123123123XXXXXXXXX",
                onValueChange = { },
                rootContainerPadding = PaddingValues(0.dp)
            )
        }

        NurChiliBaseInput(hint = "Введите комментарий",
            params = BaseInputParams.Default.copy(maxLines = 4),
            textFieldValue = commentText,
            onValueChange = {
                commentText = it
            })

        NurChiliCodeInput(errorMessage = "Неверный пароль",
            actionText = "Сбросить пароль",
            isError = isCodeInputError,
            onCodeComplete = {
                isCodeInputError = true
            },
            onCodeChange = {
                isCodeInputError = false
            })

        NurChiliCodeInput(codeLength = CodeLength.FOUR, isError = false, onCodeComplete = {

        })

        Spacer(modifier = Modifier.size(54.dp))
    }
}


@Composable
@Preview
fun InputFieldsScreenPreview() {
    ChiliTheme {
        InputFieldsScreen()
    }
}