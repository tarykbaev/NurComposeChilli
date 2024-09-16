package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Stable
data class TextAppearanceScreenModel(
    val text: String,
    val style: TextStyle
)

@Composable
fun TextAppearanceScreen() {

    val textStyleList = listOf(
        TextAppearanceScreenModel(
            text = "Headline1",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline2",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH2,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline3",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH3,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline4",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline5",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline6",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline7",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline8",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline9",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline10",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH10,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Color",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Secondary Color",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliSecondaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Value Color",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliValueTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Error Color",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliErrorTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Marked Color",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliMarkedTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Italic",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor,
                Font(R.font.roboto_italic)
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Bold",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor,
                Font(R.font.roboto_medium)
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary 700",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor,
                Font(R.font.roboto_700)
            )
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(ChiliTheme.Colors.ChiliSurfaceBackground)
    ) {
        items(textStyleList){
            Text(modifier = Modifier.padding(horizontal = 16.dp), text = it.text, style = it.style)
            Spacer(modifier = Modifier.padding(16.dp))
        }
    }
}