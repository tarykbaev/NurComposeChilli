package com.design.composeChilli.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.textStyle.ChiliTextStyle
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
            text = "Headline H1",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH1,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H2",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH2,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H3",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH3,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H4",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H5",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH5,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H6",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H7",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H8",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H9",
            style = ChiliTextStyle.get(
                ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH9,
                ChiliTheme.Colors.ChiliPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H10",
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
        items(textStyleList) {
            Text(modifier = Modifier.padding(horizontal = 16.dp), text = it.text, style = it.style)
            HorizontalDivider(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_16dp)),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
            Spacer(modifier = Modifier.padding(12.dp))
        }
    }
}

@Preview
@Composable
fun TextAppearanceScreen_Preview() {
    ChiliTheme {
        TextAppearanceScreen()
    }
}