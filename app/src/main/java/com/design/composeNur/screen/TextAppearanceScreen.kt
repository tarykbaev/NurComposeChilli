package com.design.composeNur.screen

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
import com.design.composenur.R
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composeNur.theme.NurTheme

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
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH1,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H2",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH2,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H3",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH3,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H4",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH4,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H5",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH5,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H6",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H7",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H8",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H9",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH9,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Headline H10",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH10,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Color",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurPrimaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Secondary Color",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurSecondaryTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Value Color",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurValueTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Error Color",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurErrorTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Marked Color",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurMarkedTextColor
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Italic",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurPrimaryTextColor,
                Font(R.font.roboto_italic)
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary Bold",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurPrimaryTextColor,
                Font(R.font.roboto_medium)
            )
        ),
        TextAppearanceScreenModel(
            text = "Primary 700",
            style = NurTextStyle.get(
                NurTheme.Attribute.NurTextDimensions.TextSizeH6,
                NurTheme.Colors.NurPrimaryTextColor,
                Font(R.font.roboto_700)
            )
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(NurTheme.Colors.NurSurfaceBackground)
    ) {
        items(textStyleList) {
            Text(modifier = Modifier.padding(horizontal = 16.dp), text = it.text, style = it.style)
            HorizontalDivider(
                modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_16dp)),
                color = NurTheme.Colors.NurDividerColor,
                thickness = NurTheme.Attribute.NurDividerHeightSize
            )
            Spacer(modifier = Modifier.padding(12.dp))
        }
    }
}

@Preview
@Composable
fun TextAppearanceScreen_Preview() {
    NurTheme {
        TextAppearanceScreen()
    }
}