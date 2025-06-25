package com.design.composeNur.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.design.composeNur.components.buttons.baseButton.NurButton
import com.design.composeNur.components.dialog.NurLoader
import com.design.composeNur.components.dialog.NurWarningDialog
import kotlinx.coroutines.delay

@Composable
fun DialogScreen() {

    var isLoaderVisible by rememberSaveable { mutableStateOf(false) }
    var isWarningDialogVisible by rememberSaveable { mutableStateOf(false) }
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        NurButton(title = "Show progress dialog", modifier = Modifier.fillMaxWidth()) {
            isLoaderVisible = isLoaderVisible.not()
        }

        NurButton(title = "Show warning dialog", modifier = Modifier.fillMaxWidth()) {
            isWarningDialogVisible = isWarningDialogVisible.not()
        }
    }

    if (isWarningDialogVisible) {
        NurWarningDialog(
            title = "Ой! Что-то пошло не так",
            message = "Попробуйте позже",
            positiveButton = "Понятно" to {
                Toast.makeText(context, "Positive button clicked", Toast.LENGTH_LONG).show()
            },
            negativeButton = "Отмена" to {
                Toast.makeText(context, "Negativef button clicked", Toast.LENGTH_LONG).show()
            },
            onDismissRequest = { isWarningDialogVisible = isWarningDialogVisible.not() }
        )
    }

    NurLoader(isLoaderVisible)

    if (isLoaderVisible){
        LaunchedEffect(true) {
            delay(3_000)
            isLoaderVisible = isLoaderVisible.not()
        }
    }

}