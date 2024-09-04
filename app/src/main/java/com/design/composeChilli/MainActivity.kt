package com.design.composeChilli

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.ui.theme.NurComposeChiliTheme
import com.design.composechili.components.bottom_sheet.ActionBottomSheet
import com.design.composechili.components.bottom_sheet.ActionBottomSheetButton
import com.design.composechili.components.bottom_sheet.ActionBottomSheetButtonType
import com.design.composechili.components.cell.BaseCell
import com.design.composechili.components.input.inputFieldWithDescAndAction.InputFieldWithDescAndAction
import com.design.composechili.components.tooltip.ChiliTooltip
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val sheetState = getBottomSheetState()
            val buttons = listOf(
                ActionBottomSheetButton("First", ActionBottomSheetButtonType.SIMPLE) {},
                ActionBottomSheetButton("Second", ActionBottomSheetButtonType.SIMPLE) {
                    scope.launch { sheetState.bottomSheetState.hide() }
                },
                ActionBottomSheetButton("Cancel", ActionBottomSheetButtonType.ACCENT) {
                    scope.launch { sheetState.bottomSheetState.hide() }
                },
            )


            ChiliTheme {
                ActionBottomSheet(sheetState = sheetState, buttons = buttons) {
                    Column {
                        Spacer(modifier = Modifier.height(80.dp))
                        ChiliTooltip(
                            title = "Услуга Где Дети",
                            subtitle = "Услуга Где Дети Описание ",
                            requesterView = { clickListenerModifier ->
                                InputFieldWithDescAndAction(
                                    descriptionModifier = clickListenerModifier,
                                    description = "Test description",
                                    actionTitle = "Test Action"
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight(),
                                        value = "Test Message",
                                        onValueChange = {})
                                }
                            },
                        )

                        BaseCell(
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {

                                    scope.launch { sheetState.bottomSheetState.expand() }
                                },
                            title = "Open BottomSheet"
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = name, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NurComposeChiliTheme {
        Greeting("Android")
    }
}