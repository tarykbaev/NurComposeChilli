package com.design.composeNur.components.common.nurAgreement

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

data class NurAgreementItemParams(
    @DrawableRes val startIcon: Int,
    val startIconSize: Dp,
    val agreementHtmlTextStyle: TextStyle,
    val linkColor: Color,
) {

    companion object {

        val Default
            @Composable
            get() = NurAgreementItemParams(
                startIcon = R.drawable.nur_ic_checkmark,
                startIconSize = dimensionResource(R.dimen.view_24dp),
                agreementHtmlTextStyle = NurTextStyle.get(
                    NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    NurTheme.Colors.NurPrimaryTextColor
                ),
                linkColor = colorResource(R.color.magenta_1),
            )
    }
}