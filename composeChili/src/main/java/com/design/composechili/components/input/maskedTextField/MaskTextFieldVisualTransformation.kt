
package com.design.composechili.components.input.maskedTextField

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration

class MaskTextFieldVisualTransformation(private val hintTextColor: Color) : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            text = buildAnnotatedStringWithUrlHighlighting(text.text, hintTextColor),
            offsetMapping = OffsetMapping.Identity
        )
    }

    private fun buildAnnotatedStringWithUrlHighlighting(
        text: String,
        color: Color = Color.Gray
    ): AnnotatedString {
        return buildAnnotatedString {
            append(text)
            text.toList().forEachIndexed { index, char ->
                if (char.toString() == "X") {
                    addStyle(
                        style = SpanStyle(
                            color = color,
                            textDecoration = TextDecoration.None
                        ),
                        start = index, end = index + 1
                    )
                }
            }
        }
    }
}