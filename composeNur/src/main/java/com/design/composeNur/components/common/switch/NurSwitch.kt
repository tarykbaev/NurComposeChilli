package com.design.composeNur.components.common.switch

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme

@Composable
fun NurSwitch(
    modifier: Modifier = Modifier,
    checkedState: Boolean,
    paddingValues: PaddingValues = PaddingValues(horizontal = 16.dp),
    description: String = "",
    onValueChange: (Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = description,
            color = NurTheme.Colors.NurValueTextColor
        )
        Switch(
            checked = checkedState,
            onCheckedChange = {
                onValueChange(it)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = NurTheme.Colors.NurSwitchBoxCheckedToggleColor,
                uncheckedThumbColor = NurTheme.Colors.NurSwitchBoxUncheckedToggleColor,
                checkedTrackColor = NurTheme.Colors.NurSwitchBoxCheckedBackground,
                uncheckedTrackColor = NurTheme.Colors.NurSwitchBoxUncheckedBackground
            )
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Switch_Preview() {
    NurTheme {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Row(Modifier.background(NurTheme.Colors.NurSurfaceBackground)) {
            NurSwitch(checkedState = checkedState) {
                checkedState = it
            }
        }
    }
}