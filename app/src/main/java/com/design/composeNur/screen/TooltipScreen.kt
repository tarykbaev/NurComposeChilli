package com.design.composeNur.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.input.inputFieldWithDescAndAction.NurInputFieldWithDescAndAction
import com.design.composeNur.components.input.maskedTextField.NurMaskedTextField
import com.design.composeNur.components.input.maskedTextField.MaskedTextFieldParams
import com.design.composeNur.components.tooltip.NurTooltip
import com.design.composeNur.theme.NurTheme

@Composable
fun TooltipScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(NurTheme.Colors.NurSurfaceBackground)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Box {
            NurTooltip(
                title = "Получи бонус 10 ГБ! (22)",
                subtitle = "При пополнении баланса на 120 с (32)",
                requesterView = { clickListenerModifier ->
                    NurInputFieldWithDescAndAction(
                        modifier = clickListenerModifier,
                        description = "Введите номер",
                        actionTitle = "Из контактов"
                    ) {
                        NurMaskedTextField(
                            rootContainerPadding = PaddingValues(0.dp),
                            initialText = "+996 XXX XXX XXX",
                            onValueChange = {},
                            maskInputParams = MaskedTextFieldParams.Default.copy(allowedInputSymbols = "1234567890")
                        )
                    }
                },
            )
        }
    }
}

@Composable
@Preview
fun TooltipScreenPreview() {
    NurTheme {
        TooltipScreen()
    }
}