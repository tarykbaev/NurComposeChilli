package com.design.composeNur.components.cell.radioButtonCell

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composeNur.theme.NurTheme
import com.design.composeNur.theme.textStyle.NurTextStyle

@Composable
fun RadioButtonCell(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onItemClick: () -> Unit
) {

    var selected by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                style = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH7,
                    color = NurTheme.Colors.NurPrimaryTextColor,
                    font = NurTheme.Attribute.NurBoldTextFont
                )
            )
            Text(
                text = subtitle,
                style = NurTextStyle.get(
                    textSize = NurTheme.Attribute.NurTextDimensions.TextSizeH8,
                    color = NurTheme.Colors.NurPrimaryTextColor
                )
            )
        }

        Spacer(modifier = modifier.weight(1f))
        RadioButton(selected = selected, onClick = {
            selected = !selected
            onItemClick()
        })
    }
}

@Preview
@Composable
fun RadioButtonCellPreview() {
    NurTheme {
        RadioButtonCell(
            title = "Radio Button Title",
            subtitle = "This is a subtitle for the radio button cell",
            onItemClick = {}
        )
    }
}