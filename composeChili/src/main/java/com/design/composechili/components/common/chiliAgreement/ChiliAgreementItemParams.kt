package com.design.composechili.components.common.chiliAgreement

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

data class ChiliAgreementItemParams(
    @DrawableRes val startIcon: Int,
    val startIconSize: Dp,
    val agreementHtmlTextStyle: TextStyle,
    val linkColor: Color,
) {

    companion object {

        val Default
            @Composable
            get() = ChiliAgreementItemParams(
                startIcon = R.drawable.chili_ic_checkmark,
                startIconSize = dimensionResource(R.dimen.view_24dp),
                agreementHtmlTextStyle = ChiliTextStyle.get(
                    ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                linkColor = colorResource(R.color.magenta_1),
            )
    }
}