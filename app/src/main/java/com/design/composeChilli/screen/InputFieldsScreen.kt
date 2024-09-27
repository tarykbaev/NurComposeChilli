package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import com.design.composechili.components.input.baseInput.BaseInput
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.components.input.code.CodeInput
import com.design.composechili.components.input.code.CodeLength
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.input.maskedTextField.MaskedTextField
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun InputFieldsScreen() {

    var baseInputText by remember { mutableStateOf("") }
    var baseInputWithIconsText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var commentText by remember { mutableStateOf("") }
    var isFieldError by remember { mutableStateOf(false) }
    var descriptionText by remember { mutableStateOf("") }
    var isCodeInputError by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChiliTheme.Colors.ChiliSurfaceBackground)
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        BaseInput(
            textFieldValue = baseInputText,
            onValueChange = { baseInputText = it },
            params = BaseInputParams.Default.copy(
                textStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    ChiliTheme.Colors.ChiliPrimaryTextColor,
                    ChiliTheme.Attribute.ChiliBoldTextFont
                ),
            ),
            containerStartIcon = painterResource(id = R.drawable.ic_cat),
        )
        InputFieldWithDescAndAction(
            description = "Simple",
            actionTitle = "Сканер",
        ) {
            MaskedTextField(
                initialText = "+996 XXX XXX XXX",
                onValueChange = {},
                rootContainerPadding = PaddingValues(0.dp)
            )
        }
        InputFieldWithDescAndAction(
            description = "Simple",
        ) {
            BaseInput(
                textFieldValue = descriptionText,
                onValueChange = { descriptionText = it },
                hint = "Hint",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyle.get(
                        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                        ChiliTheme.Colors.ChiliPrimaryTextColor,
                        ChiliTheme.Attribute.ChiliBoldTextFont
                    ).copy(textAlign = TextAlign.Center)
                )
            )
        }

        InputFieldWithDescAndAction(
            description = "Simple with start icon"
        ) {
            BaseInput(
                textFieldValue = baseInputWithIconsText,
                onValueChange = { baseInputWithIconsText = it },
                hint = "Search Service",
                params = BaseInputParams.Default.copy(
                    textStyle = ChiliTextStyle.get(
                        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                        ChiliTheme.Colors.ChiliPrimaryTextColor,
                        ChiliTheme.Attribute.ChiliRegularTextFont
                    )
                ),
                fieldEndIcon = painterResource(id = R.drawable.chili_ic_clear_24),
                fieldStartIcon = painterResource(id = R.drawable.chili_ic_search)
            )
        }


        InputFieldWithDescAndAction(
            description = "Simple with start icon",
            descriptionTextStyle = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                if (isFieldError) colorResource(id = R.color.red_1) else colorResource(id = R.color.black_5)
            )
        ) {
            BaseInput(
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

        InputFieldWithDescAndAction(
            description = "mask"
        ) {
            MaskedTextField(
                initialText = "123123123123XXXXXXXXX",
                onValueChange = { },
                rootContainerPadding = PaddingValues(0.dp)
            )
        }

        BaseInput(
            hint = "Введите комментарий",
            params = BaseInputParams.Default.copy(maxLines = 4),
            textFieldValue = commentText,
            onValueChange = {
                commentText = it
            }
        )

        CodeInput(
            errorMessage = "Неверный пароль",
            actionText = "Сбросить пароль",
            isError = isCodeInputError,
            onCodeComplete = {
                isCodeInputError = true
            },
            onCodeChange = {
                isCodeInputError = false
            }
        )

        CodeInput(
            codeLength = CodeLength.FOUR,
            isError = false,
            onCodeComplete = {

            }
        )

        Spacer(modifier = Modifier.size(54.dp))

        /*
                CodeInput(
                    codeLength = CodeLength.FOUR,
                    state = codeInputState,
                    isActionTextEnabled = false,
                    clearCode = codeInputClear,
                    onActionTextClick = {},
                    codeCompleteListener = object : OnCodeChangeListener {
                        override fun onCodeComplete(otp: String) {
                            codeInputState = CodeInputItemState.ERROR
                            codeInputClear = true
                        }

                        override fun onCodeChange(text: String?) {
                            codeInputState = CodeInputItemState.INACTIVE
                            codeInputClear = false
                        }
                    })*/
    }
}


@Composable
@Preview
fun InputFieldsScreenPreview() {
    ChiliTheme {
        InputFieldsScreen()
    }
}