package com.design.composeNur.components.input.code

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle
import com.design.composenur.R

@Composable
fun NurCodeInputItem(
    modifier: Modifier = Modifier,
    state: CodeInputItemState,
    text: String = ""
) {
    val backgroundColor = when (state) {
        CodeInputItemState.INACTIVE -> NurTheme.Colors.NurCodeInputItemBackgroundColor
        CodeInputItemState.ACTIVE -> NurTheme.Colors.NurCodeInputItemBackgroundColor
        CodeInputItemState.ERROR -> NurTheme.Colors.NurCodeInputItemErrorBackgroundColor
        CodeInputItemState.ACTIVE_ERROR -> NurTheme.Colors.NurCodeInputItemErrorBackgroundColor
    }

    val borderColor = when (state) {
        CodeInputItemState.ACTIVE, CodeInputItemState.ACTIVE_ERROR -> NurTheme.Colors.NurCodeInputItemBorderColor
        CodeInputItemState.INACTIVE, CodeInputItemState.ERROR -> Color.Transparent
    }

    NurTheme {
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
                .padding(vertical = dimensionResource(id = R.dimen.padding_14dp)),
            text = text,
            textAlign = TextAlign.Center,
            style = NurTextStyle.get(
                textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                color = NurTheme.Colors.NurPrimaryTextColor,
                font = NurTheme.Attribute.NurBoldTextFont
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
    NurTheme {
        NurCodeInputItem(state = CodeInputItemState.INACTIVE, text = "1")
    }
}