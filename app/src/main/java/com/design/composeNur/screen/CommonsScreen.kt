package com.design.composeNur.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.design.composeNur.R
import com.design.composeNur.components.checkbox.NurCheckbox
import com.design.composeNur.components.common.carousel.CarouselItem
import com.design.composeNur.components.common.carousel.ImageCarousel
import com.design.composeNur.components.common.nurAgreement.DisplayMode
import com.design.composeNur.components.common.nurAgreement.NurAgreementItem
import com.design.composeNur.components.common.nurMaterialDesignSlider.NurMaterialDesignSlider
import com.design.composeNur.components.common.switch.NurSwitch
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyleBuilder

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
            style = NurTextStyleBuilder.H6.Primary.Medium
        )
        NurMaterialDesignSlider(
            initialValue = 20f,
            range = 0f..100f,
        )
        NurMaterialDesignSlider(
            initialValue = 20f,
            description = "Slider with steps",
            range = 0f..100f,
            stepsSize = 4
        )
        HorizontalDivider(
            color = NurTheme.Colors.NurDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "CheckBox",
            style = NurTextStyleBuilder.H7.Primary.Regular
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            NurCheckbox(isChecked = isFirstCheckBoxChecked) {
                isFirstCheckBoxChecked = isFirstCheckBoxChecked.not()
            }
            Text(
                text = "Checkbox enabled & not checked",
                style =  NurTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NurCheckbox(isChecked = isSecondCheckBoxChecked) {
                isSecondCheckBoxChecked = isSecondCheckBoxChecked.not()
            }
            Text(
                text = "Checkbox enabled & checked",
                style =NurTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NurCheckbox(enabled = false, isChecked = false)
            Text(
                text = "Checkbox disabled & not checked",
                style = NurTextStyleBuilder.H8.Primary.Regular
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            NurCheckbox(enabled = false, isChecked = true)
            Text(
                text = "Checkbox disabled & checked",
                style = NurTextStyleBuilder.H8.Primary.Regular
            )
        }
        HorizontalDivider(
            color = NurTheme.Colors.NurDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "AgreementView",
            style = NurTextStyleBuilder.H8.Primary.Regular
        )
        NurAgreementItem(
            isChecked = isAgreementChecked,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            },
            onCheckedChange = {
                isAgreementChecked = it
            }
        )
        NurAgreementItem(
            isChecked = true,
            displayMode = DisplayMode.ICON,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        NurAgreementItem(
            modifier = Modifier.padding(horizontal = 8.dp),
            isChecked = true,
            displayMode = DisplayMode.TEXT_ONLY,
            agreementHtmlText = stringResource(id = R.string.agree_terms),
            onLinkClick = {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        )
        HorizontalDivider(
            color = NurTheme.Colors.NurDividerColor
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Switch",
            style = NurTextStyleBuilder.H8.Primary.Regular
        )
        NurSwitch(
            description = "NurSwitch",
            checkedState = isFirstSwitchChecked
        ) {
            isFirstSwitchChecked = it
        }
        NurSwitch(
            description = "NurSwitch",
            checkedState = isSecondSwitchChecked
        ) {
            isSecondSwitchChecked = it
        }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "ImageCarousel",
            style = NurTextStyleBuilder.H8.Primary.Regular
        )
        ImageCarousel(
            modifier = Modifier
                .height(210.dp)
                .padding(16.dp),
            items = listOf(
                CarouselItem(
                    imageDrawable = R.drawable.cover,
                    item = R.drawable.cover
                ), CarouselItem(
                    imageDrawable = com.design.composenur.R.drawable.ic_cat,
                    item = com.design.composenur.R.drawable.ic_cat
                ), CarouselItem(
                    imageDrawable = com.design.composenur.R.drawable.test_image,
                    item = com.design.composenur.R.drawable.test_image
                )
            )
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CommonsScreenPreview() {
    NurTheme {
        CommonsScreen()
    }
}