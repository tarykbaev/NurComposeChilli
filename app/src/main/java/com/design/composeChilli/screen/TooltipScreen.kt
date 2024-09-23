package com.design.composeChilli.screen

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
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.input.maskedTextField.MaskedTextField
import com.design.composechili.components.tooltip.ChiliTooltip
import com.design.composechili.theme.ChiliTheme

@Composable
fun TooltipScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ChiliTheme.Colors.СhiliScreenBackground)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Box {
            ChiliTooltip(
                title = "Получи бонус 10 ГБ! (22)",
                subtitle = "При пополнении баланса на 120 с (32)",
                requesterView = { clickListenerModifier ->
                    InputFieldWithDescAndAction(
                        modifier = clickListenerModifier,
                        description = "Введите номер",
                        actionTitle = "Из контактов"
                    ) {
                        MaskedTextField(
                            rootContainerPadding = PaddingValues(0.dp),
                            initialText = "+996XXX XXX XXX",
                            onValueChange = {}
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
    ChiliTheme {
        TooltipScreen()
    }
}