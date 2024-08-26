package com.design.composechili.components.input

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun InputFieldWithDescAndAction(
    modifier: Modifier = Modifier,
    description: String = String(),
    descriptionTextStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
        ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
    actionTitle: String = String(),
    onActionClick: (() -> Unit)? = null,
    inputField: @Composable (Modifier) -> Unit,
) {
    Column(modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))) {
        inputField(Modifier.fillMaxWidth())
        Row() {
            if (description.isNotBlank()) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp)
                        .align(Alignment.CenterVertically),
                    text = description,
                    style = descriptionTextStyle.copy(textAlign = TextAlign.Start)
                )
            }
            if (actionTitle.isNotBlank()) {
                Button(
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(top = 10.dp, start = 12.dp, bottom = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    onClick = {
                        onActionClick?.invoke()
                    },
                    content = {
                        Text(
                            text = actionTitle,
                            style = ChiliTextStyle.get(
                                color = ChiliTheme.Colors.ChiliComponentButtonTextColorPressed,
                                font = ChiliTheme.Attribute.ChiliComponentButtonTextFont,
                            ).copy(textAlign = TextAlign.End)
                        )
                    },
                )
            }
        }
    }

}