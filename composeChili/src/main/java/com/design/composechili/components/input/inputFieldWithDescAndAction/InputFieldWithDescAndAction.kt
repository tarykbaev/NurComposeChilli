package com.design.composechili.components.input.inputFieldWithDescAndAction

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.input.baseInput.BaseInput
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

/**
 * A composable function that displays an input field with an optional description and an optional action button.
 * The description appears above the input field, and the action button (if provided) is displayed next to the field.
 *
 * @param modifier A [Modifier] to configure the layout or decoration of this composable. Can be used to
 * adjust size, padding, or other layout behavior. Defaults to [Modifier] with no modifications.
 *
 * @param descriptionModifier A [Modifier] for customizing the layout or style of the description text.
 * Defaults to [Modifier] with no modifications.
 *
 * @param description A [String] that represents the description text displayed above the input field.
 * Defaults to an empty string.
 *
 * @param descriptionTextStyle A [TextStyle] defining the appearance of the description text, such as font size
 * and color. The default style uses:
 *  - Text size from [ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8].
 *  - Primary text color from [ChiliTheme.Colors.ChiliPrimaryTextColor].
 *
 * @param actionTitle A [String] that represents the label for the action button. If empty, the action button
 * will not be displayed. Defaults to an empty string.
 *
 * @param onActionClick An optional lambda function that is invoked when the action button is clicked.
 * If `null`, no action button will be shown. Defaults to `null`.
 *
 * @param inputField A composable lambda that defines the input field, receiving a [Modifier] as a parameter.
 * The input field is fully customizable and must be provided by the caller.
 */
@Composable
fun InputFieldWithDescAndAction(
    modifier: Modifier = Modifier,
    descriptionModifier: Modifier = Modifier,
    description: String = String(),
    descriptionTextStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
        ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
    actionTitle: String = String(),
    onActionClick: (() -> Unit)? = null,
    inputField: @Composable (Modifier) -> Unit,
) {
    val localDensity = LocalDensity.current
    var calculateTextHeight by remember{ mutableStateOf(0.dp) }

    Column(
        modifier = modifier
            .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp))
            .wrapContentHeight()
    ) {
        inputField(Modifier.fillMaxWidth())
        Row(modifier = Modifier.padding(8.dp)) {
            if (description.isNotBlank()) {
                Text(
                    modifier = descriptionModifier
                        .onGloballyPositioned { coordinates ->
                            calculateTextHeight = with(localDensity) { coordinates.size.height.toDp() }
                        }
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterVertically),
                    text = description,
                    style = descriptionTextStyle.copy(textAlign = TextAlign.Start)
                )
            }
            if (actionTitle.isNotBlank()) {
                Button(
                    modifier = Modifier.sizeIn(maxHeight = calculateTextHeight),
                    shape = RoundedCornerShape(12.dp),
                    contentPadding = PaddingValues(0.dp),
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

@Preview(showBackground = true)
@Composable
fun InputFieldWithDescAndActionPreview() {
    ChiliTheme {
        var inputFieldText by rememberSaveable { mutableStateOf("TestTextFieldValue") }

        InputFieldWithDescAndAction(
            description = "Description",
            actionTitle = "Action",
        ) {
            BaseInput(textFieldValue = inputFieldText, onValueChange = {
                inputFieldText = it
            }, params = BaseInputParams.Default.copy(textFieldPadding = PaddingValues(0.dp))
                )
        }
    }
}