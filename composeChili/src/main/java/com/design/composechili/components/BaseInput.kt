package com.design.composechili.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun BaseInput(
    modifier: Modifier = Modifier,
    textFieldValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isEnabled: Boolean = true,
    textStyle: TextStyle = ChiliTextStyle.get(ChiliTheme.attribute.chiliTextSizeH8, ChiliTheme.),
    @DrawableRes startIcon: Int? = null,
    @DrawableRes endIcon: Int? = null
) {
    ChiliTheme {
        Row() {
            if (startIcon != null) {
                Image(
                    painter = painterResource(id = startIcon),
                    contentDescription = "Input field start description icon",
                    modifier = modifier
                        .wrapContentSize()
                        .padding(
                            start = dimensionResource(id = R.dimen.padding_8dp),
                            top = dimensionResource(id = R.dimen.padding_8dp),
                        )
                )
            }
            TextField(
                modifier = modifier
                    .padding(dimensionResource(id = R.dimen.padding_12dp)),
                value = textFieldValue,
                onValueChange = onValueChange,
                textStyle = textStyle,
                maxLines = 1,
                enabled = isEnabled,
                shape = CircleShape.copy()
            )
            if (endIcon != null) {
                Image(
                    painter = painterResource(id = endIcon),
                    contentDescription = "Input field end description icon",
                    modifier = modifier
                        .wrapContentSize()
                        .padding(
                            end = dimensionResource(id = R.dimen.padding_8dp),
                            top = dimensionResource(id = R.dimen.padding_8dp),
                            bottom = dimensionResource(id = R.dimen.padding_8dp)
                        )
                )
            }
        }
    }
}