package com.design.composeChilli.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeChilli.R
import com.design.composechili.components.checkbox.ChiliCheckbox
import com.design.composechili.components.common.chiliAgreement.ChiliAgreementItem
import com.design.composechili.components.common.chiliAgreement.DisplayMode
import com.design.composechili.components.common.chiliMaterialDesignSlider.ChiliMaterialDesignSlider
import com.design.composechili.components.common.switch.ChiliSwitch
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun CommonsScreen() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ChiliMaterialDesignSlider(
            initialValue = 20f,
            range = 0f..100f,
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliMaterialDesignSlider(
            initialValue = 20f,
            description = "Slider with steps",
            range = 0f..100f,
            stepsSize = 4
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(isChecked = false)
            Text(
                text = "Checkbox enabled & not checked",
                style = ChiliTextStyle.get(color = ChiliTheme.Colors.ChiliPrimaryTextColor)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(isChecked = true)
            Text(
                text = "Checkbox enabled & checked",
                style = ChiliTextStyle.get(color = ChiliTheme.Colors.ChiliPrimaryTextColor)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(enabled = false, isChecked = false)
            Text(
                text = "Checkbox disabled & not checked",
                style = ChiliTextStyle.get(color = ChiliTheme.Colors.ChiliPrimaryTextColor)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(enabled = false, isChecked = true)
            Text(
                text = "Checkbox disabled & checked",
                style = ChiliTextStyle.get(color = ChiliTheme.Colors.ChiliPrimaryTextColor)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliAgreementItem(
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliAgreementItem(
            isChecked = true,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliAgreementItem(
            modifier = Modifier.padding(horizontal = 16.dp),
            isChecked = true,
            displayMode = DisplayMode.ICON,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliAgreementItem(
            modifier = Modifier.padding(horizontal = 8.dp),
            isChecked = true,
            displayMode = DisplayMode.TEXT_ONLY,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        ChiliSwitch(description = "ChiliSwitch", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@Preview
fun CommonsScreenPreview() {
    ChiliTheme {
        CommonsScreen()
    }
}