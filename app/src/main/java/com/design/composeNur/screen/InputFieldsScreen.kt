package com.design.composeNur.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composenur.R
import com.design.composeNur.components.input.autoComplete.NurAutoCompleteInput
import com.design.composeNur.components.input.baseInput.NurBaseInput
import com.design.composeNur.components.input.baseInput.BaseInputParams
import com.design.composeNur.components.input.code.NurCodeInput
import com.design.composeNur.components.input.code.CodeLength
import com.design.composeNur.components.input.inputFieldWithDescAndAction.NurInputFieldWithDescAndAction
import com.design.composeNur.components.input.maskedTextField.NurMaskedTextField
import com.design.composeNur.components.input.maskedTextField.MaskedTextFieldParams
import com.design.composeNur.components.input.password.NurPasswordInput
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder

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

    val autoCompleteList = listOf(
        AutoCompleteItem(1, "test"),
        AutoCompleteItem(2, "yesteday"),
        AutoCompleteItem(2, "test2")
    )

    var autoCompleteInputText by remember { mutableStateOf(String()) }
    var autoCompleteItemListState: List<AutoCompleteItem> by remember {
        mutableStateOf(listOf())
    }

    var errorMessage by remember { mutableStateOf(String()) }

    var context = LocalContext.current

    fun onErrorMessageClicked() {
        if (errorMessage.isBlank()){
            errorMessage = "test error message"
        }else{
            errorMessage = String()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = NurTheme.Colors.NurSurfaceBackground)
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        NurBaseInput(
            textFieldValue = baseInputText,
            onValueChange = { baseInputText = it },
            params = BaseInputParams.Default.copy(
                textStyle = NurTextStyleBuilder.H7.Primary.Bold,
            ),
            containerStartIcon = painterResource(id = R.drawable.ic_cat),
        )
        NurInputFieldWithDescAndAction(
            description = "Simple",
            actionTitle = "Сканер",
        ) {
            NurMaskedTextField(
                initialText = "+996 XXX XXX XXX",
                onValueChange = {},
                rootContainerPadding = PaddingValues(0.dp),
                maskInputParams = MaskedTextFieldParams.Default.copy(allowedInputSymbols = "1234567890")
            )
        }
        NurInputFieldWithDescAndAction(
            description = "Simple",
            actionTitle = "Error show",
            onActionClick = { onErrorMessageClicked() }
        ) {
            NurBaseInput(
                textFieldValue = descriptionText,
                onValueChange = { descriptionText = it },
                hint = "Hint",
                errorMessage = errorMessage,
                isError = errorMessage.isNotBlank(),
                params = BaseInputParams.Default.copy(
                    textStyle = NurTextStyleBuilder.H5.Primary.Bold.copy(textAlign = TextAlign.Center)
                )
            )
        }

        NurInputFieldWithDescAndAction(
            description = "Simple with start icon"
        ) {
            NurBaseInput(
                textFieldValue = baseInputWithIconsText,
                onValueChange = { baseInputWithIconsText = it },
                hint = "Search Service",
                params = BaseInputParams.Default.copy(
                    textStyle = NurTextStyleBuilder.H7.Primary.Regular
                ),
                fieldEndIcon = painterResource(id = R.drawable.nur_ic_clear_24),
                fieldStartIcon = painterResource(id = R.drawable.nur_ic_search)
            )
        }

        NurInputFieldWithDescAndAction(
            description = "Simple with clear"
        ) {
            NurBaseInput(textFieldValue = simpleWithClearText,
                onValueChange = { simpleWithClearText = it },
                hint = "Hint",
                params = BaseInputParams.Default.copy(
                    textStyle = NurTextStyle.get(
                        NurTheme.Attribute.NurTextDimensions.TextSizeH5,
                        NurTheme.Colors.NurPrimaryTextColor,
                        NurTheme.Attribute.NurBoldTextFont
                    ).copy(textAlign = TextAlign.Center)
                ),
                fieldEndIcon = if (simpleWithClearText.isNotBlank()) painterResource(id = R.drawable.nur_ic_clear_24) else null,
                endIconClicked = {
                    simpleWithClearText = String()
                })
        }


        NurInputFieldWithDescAndAction(
            description = "Simple with start icon", descriptionTextStyle = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                if (isFieldError) colorResource(id = R.color.red_1) else colorResource(id = R.color.black_5)
            )
        ) {
            NurBaseInput(
                textFieldValue = passwordText,
                hint = "Password",
                isError = isFieldError,
                onValueChange = { passwordText = it },
                params = BaseInputParams.Default.copy(
                    textStyle = NurTextStyle.get(
                        NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                        NurTheme.Colors.NurPrimaryTextColor,
                        NurTheme.Attribute.NurBoldTextFont
                    ).copy(textAlign = TextAlign.Center),
                )
            )
        }
        NurPasswordInput(
            modifier = Modifier.fillMaxWidth(),
            value = passwordInputText,
            hint = "Password",
            isError = isPasswordInputError,
            onImeAction = {
                isPasswordInputError = isPasswordInputError.not()
            },
            onValueChange = { passwordInputText = it },
        )

        NurInputFieldWithDescAndAction(
            description = "mask"
        ) {
            NurMaskedTextField(
                initialText = "123123123123XXXXXXXXX",
                onValueChange = { },
                rootContainerPadding = PaddingValues(0.dp)
            )
        }

        NurAutoCompleteInput<AutoCompleteItem>(
            modifier = Modifier.fillMaxWidth(),
            autoCompleteItems = autoCompleteItemListState,
            onDisplayData = { it.name },
            onItemClick = { Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show() },
            inputComponent = {
                NurBaseInput(
                    textFieldValue = autoCompleteInputText,
                    onValueChange = {
                        autoCompleteInputText = it
                        autoCompleteItemListState =
                            if (it.isBlank()) listOf() else autoCompleteList.filter {
                                it.name.contains(
                                    autoCompleteInputText.lowercase()
                                )
                            }
                    },
                    hint = "Auto Complete Input",
                    params = BaseInputParams.Default.copy(
                        textStyle = NurTextStyleBuilder.H6.Primary.Regular
                    ),
                    fieldStartIcon = painterResource(id = R.drawable.nur_ic_search)
                )
            }
        )



        NurBaseInput(hint = "Введите комментарий",
            params = BaseInputParams.Default.copy(maxLines = 4),
            textFieldValue = commentText,
            onValueChange = {
                commentText = it
            })

        NurCodeInput(errorMessage = "Неверный пароль",
            actionText = "Сбросить пароль",
            isError = isCodeInputError,
            onCodeComplete = {
                isCodeInputError = true
            },
            onCodeChange = {
                isCodeInputError = false
            })

        NurCodeInput(codeLength = CodeLength.FOUR, isError = false, onCodeComplete = {

        })

        Spacer(modifier = Modifier.size(54.dp))
    }
}

data class AutoCompleteItem(val id: Int, val name: String)


@Composable
@Preview
fun InputFieldsScreenPreview() {
    NurTheme {
        InputFieldsScreen()
    }
}