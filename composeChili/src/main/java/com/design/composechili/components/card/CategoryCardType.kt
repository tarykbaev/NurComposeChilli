package com.design.composechili.components.card

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
sealed class CategoryCardType(
    open val title: String,
    @DrawableRes open val icon: Int,
    open val style: TextStyle,
) {

    companion object {
        val boldTextStyle
            @Composable get() = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                font = ChiliTheme.Attribute.ChiliBoldTextFont
            )
        val regularTextStyle
            @Composable get() = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                font = ChiliTheme.Attribute.ChiliRegularTextFont
            )
    }

    @Stable
    data class LeftAligned(
        override val title: String,
        @DrawableRes override val icon: Int,
        override val style: TextStyle
    ) : CategoryCardType(title = title, icon = icon, style = style)

    @Stable
    data class Centered(
        override val title: String,
        @DrawableRes override val icon: Int,
        override val style: TextStyle
    ) : CategoryCardType(title = title, icon = icon, style = style)
}