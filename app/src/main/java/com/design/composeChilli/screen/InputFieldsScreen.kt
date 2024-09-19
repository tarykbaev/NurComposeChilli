package com.design.composeChilli.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.trace
import com.design.composeChilli.R
import com.design.composechili.components.input.baseInput.BaseInput
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.components.input.code.CodeInput
import com.design.composechili.components.input.code.CodeInputItemState
import com.design.composechili.components.input.code.OnCodeChangeListener
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.input.maskedTextField.MaskedTextField
import com.design.composechili.theme.ChiliTheme

@Composable
fun InputFieldsScreen() {

    var baseInputText by remember { mutableStateOf("") }
    var baseInputWithIconsText by remember { mutableStateOf("") }
    var baseInputWithErrorText by remember { mutableStateOf("") }
    var descriptionText by remember { mutableStateOf("") }
    var codeInputState by remember { mutableStateOf(CodeInputItemState.INACTIVE) }
    var codeInputClear by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.verticalScroll(state = rememberScrollState())
    ) {
        BaseInput(
            textFieldValue = baseInputText ,
            onValueChange = { baseInputText = it },
            hint = "BaseInput"
        )
        Spacer(modifier = Modifier.height(16.dp))
        BaseInput(
            textFieldValue = baseInputWithIconsText ,
            onValueChange = { baseInputWithIconsText = it },
            hint = "BaseInput with icons",
            startIcon = com.design.composechili.R.drawable.ic_scaner_48,
            endIcon = com.design.composechili.R.drawable.chili_ic_card_oil
        )
        Spacer(modifier = Modifier.height(16.dp))
        BaseInput(
            textFieldValue = baseInputWithErrorText ,
            onValueChange = { baseInputWithErrorText = it },
            isError = true,
            hint = "BaseInput with error",
            startIcon = com.design.composechili.R.drawable.ic_scaner_48,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(modifier = Modifier.padding(horizontal = 16.dp), text = "CodeInputField")
        Spacer(modifier = Modifier.height(8.dp))
        CodeInput(
            modifier = Modifier.padding(horizontal = 16.dp),
            message = "Message",
            actionText = "Action",
            state = codeInputState,
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
        })
        Spacer(modifier = Modifier.height(16.dp))
        InputFieldWithDescAndAction(
            description = "Description",
            actionTitle = "Action"
        ) {
            BaseInput(
                textFieldValue = descriptionText,
                onValueChange = { descriptionText = it },
                hint = "Description InputField",
                params = BaseInputParams.Default.copy(textFieldPadding = PaddingValues(0.dp))
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        MaskedTextField(initialText = "+996XXX XXX XXX", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@Preview
fun InputFieldsScreenPreview() {
    ChiliTheme {
        InputFieldsScreen()
    }
}