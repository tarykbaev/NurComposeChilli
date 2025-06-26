package com.design.composeChilli.screen

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.design.composechili.components.common.leftOver.LeftOverCard_Preview
import com.design.composechili.components.common.leftOver.Preview_Arc
import com.design.composechili.components.common.leftOver.TariffLeftOverCard_Preview
import com.design.composechili.theme.ChiliTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LeftOverScreen() {
    val context = LocalContext.current

    val internetPermissionState = rememberPermissionState(android.Manifest.permission.INTERNET) {
        val intent = Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
            Uri.fromParts("package", context.applicationContext.packageName, null)
        )
        if (!it) {
            context.startActivity(intent)
        } else {
            Toast.makeText(context, "Internet access granted", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        internetPermissionState.launchPermissionRequest()
    }
    Column(
        Modifier
            .background(ChiliTheme.Colors.СhiliScreenBackground)
            .scrollable(rememberScrollState(), orientation = Orientation.Vertical)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Preview_Arc()
        TariffLeftOverCard_Preview()
        LeftOverCard_Preview()
    }
}