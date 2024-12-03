package com.design.composeChilli.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder

@Composable
fun CommonsScreen() {

    val context = LocalContext.current
    var isFirstSwitchChecked by rememberSaveable {
        mutableStateOf(false)
    }
    var isSecondSwitchChecked by rememberSaveable {
        mutableStateOf(true)
    }
    var isFirstCheckBoxChecked by rememberSaveable {
        mutableStateOf(false)
    }
    var isSecondCheckBoxChecked by rememberSaveable {
        mutableStateOf(true)
    }
    var isAgreementChecked by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Material Design slider",
            style = ChiliTextStyleBuilder.H6.Primary.Medium
        )
        ChiliMaterialDesignSlider(
            initialValue = 20f,
            range = 0f..100f,
        )
        ChiliMaterialDesignSlider(
            initialValue = 20f,
            description = "Slider with steps",
            range = 0f..100f,
            stepsSize = 4
        )
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "CheckBox",
            style = ChiliTextStyleBuilder.H7.Primary.Regular
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(isChecked = isFirstCheckBoxChecked) {
                isFirstCheckBoxChecked = isFirstCheckBoxChecked.not()
            }
            Text(
                text = "Checkbox enabled & not checked",
                style =  ChiliTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(isChecked = isSecondCheckBoxChecked) {
                isSecondCheckBoxChecked = isSecondCheckBoxChecked.not()
            }
            Text(
                text = "Checkbox enabled & checked",
                style =ChiliTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(enabled = false, isChecked = false)
            Text(
                text = "Checkbox disabled & not checked",
                style = ChiliTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            ChiliCheckbox(enabled = false, isChecked = true)
            Text(
                text = "Checkbox disabled & checked",
                style = ChiliTextStyleBuilder.H8.Primary.Regular
            )
        }
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "AgreementView",
            style = ChiliTextStyleBuilder.H8.Primary.Regular
        )
        ChiliAgreementItem(
            isChecked = isAgreementChecked,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            },
            onCheckedChange = {
                isAgreementChecked = it
            }
        )
        ChiliAgreementItem(
            isChecked = true,
            displayMode = DisplayMode.ICON,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        ChiliAgreementItem(
            modifier = Modifier.padding(horizontal = 8.dp),
            isChecked = true,
            displayMode = DisplayMode.TEXT_ONLY,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        HorizontalDivider(
            color = ChiliTheme.Colors.ChiliDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Switch",
            style = ChiliTextStyleBuilder.H8.Primary.Regular
        )
        ChiliSwitch(
            description = "ChiliSwitch",
            checkedState = isFirstSwitchChecked
        ) {
            isFirstSwitchChecked = it
        }
        ChiliSwitch(
            description = "ChiliSwitch",
            checkedState = isSecondSwitchChecked
        ) {
            isSecondSwitchChecked = it
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CommonsScreenPreview() {
    ChiliTheme {
        CommonsScreen()
    }
}