package com.design.composechili.components.input.code

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun CodeInputItemView(
    modifier: Modifier = Modifier,
    state: CodeInputItemState,
    text: String = ""
) {
    val backgroundColor = when (state) {
        CodeInputItemState.INACTIVE -> ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor
        CodeInputItemState.ACTIVE -> ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor
        CodeInputItemState.ERROR -> colorResource(id = R.color.red_3)
        CodeInputItemState.ACTIVE_ERROR -> colorResource(id = R.color.red_3)
    }

    val borderColor = when (state) {
        CodeInputItemState.ACTIVE, CodeInputItemState.ACTIVE_ERROR -> ChiliTheme.Colors.ChiliCodeInputItemBorderColor
        CodeInputItemState.INACTIVE, CodeInputItemState.ERROR -> Color.Transparent
    }

    ChiliTheme {
        Text(
            modifier = modifier
                .width(dimensionResource(id = R.dimen.view_44dp))
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp))
                )
                .border(
                    width = dimensionResource(id = R.dimen.view_1dp),
                    color = borderColor,
                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_12dp))
                )
                .padding(vertical = dimensionResource(id = R.dimen.padding_18dp)),
            text = text,
            textAlign = TextAlign.Center,
            style = ChiliTextStyle.get(
                textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                font = ChiliTheme.Attribute.ChiliBoldTextFont
            )
        )
    }
}

enum class CodeInputItemState {
    INACTIVE, ACTIVE, ERROR, ACTIVE_ERROR
}

@Preview
@Composable
fun CodeInputItemViewPreview() {
    ChiliTheme {
        CodeInputItemView(state = CodeInputItemState.INACTIVE, text = "1")
    }
}