package com.design.composechili.components.input

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

@Composable
fun MaskedTextField(
    modifier: Modifier = Modifier,
    titleTextStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
        ChiliTheme.Colors.ChiliPrimaryTextColor,
        ChiliTheme.Attribute.ChiliBoldTextFont
    ),
    hintTextColor: Color = colorResource(id = R.color.gray_2),
    representation: Char = 'X',
    mask: String = "*",
    maskSymbols: List<Char> = listOf('-', ' ', '/'),
    allowedInputSymbols: String = "*",
    initialText: String = "",
    fieldContainerColor: Color = colorResource(id = R.color.gray_5),
    onValueChange: (String) -> Unit
) {
    var text by remember { mutableStateOf(initialText) }
    var selectionPosition by remember { mutableIntStateOf(mask.indexOf(representation)) }
    var isEditing by remember { mutableStateOf(false) }
    var endIconVisibility by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(fieldContainerColor)
                .padding(horizontal = 16.dp)
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 16.dp),
                value = TextFieldValue(text, TextRange(selectionPosition)),
                visualTransformation = InputMaskVisualTransformation(hintTextColor),
                onValueChange = { newText ->
                    if (!isEditing) {
                        isEditing = true
                        val inputText = StringBuilder(newText.text)
                        val clearedText =
                            clearMaskSymbols(inputText.toString(), maskSymbols, representation)
                                .clearForbiddenSymbols(allowedInputSymbols)
                        val maskedText =
                            mergeStrings(clearedText, mask, representation, selectionPosition) {
                                selectionPosition++
                            }

                        val isMaskAdding = checkIsMaskAdding(text, maskedText, representation)

                        // Определение позиции для маски
                        val lastMaskSym =
                            maskedText.indexOfFirst { it == representation }.takeIf { it != -1 }
                                ?: maskedText.length


                        // Обновление текста и позиции курсора
                        text = maskedText
                        selectionPosition = if (isMaskAdding) {
                            lastMaskSym.coerceAtMost(newText.text.length)
                        } else {
                            if (maskedText.getOrNull(lastMaskSym - 1) == ' ') {
                                lastMaskSym - 1
                            } else lastMaskSym.coerceAtMost(newText.text.length)
                        }

                        // Вызов обработчика изменения текста
                        onValueChange(maskedText)
                        isEditing = false
                    }
                },
                textStyle = titleTextStyle.copy(textAlign = TextAlign.Center),
                cursorBrush = SolidColor(colorResource(id = R.color.magenta_1)),
            )
            endIconVisibility = text != mask
            AnimatedVisibility(
                visible = endIconVisibility,
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Image(
                    modifier = Modifier
                        .clickable {
                            text = mask
                        },
                    painter = painterResource(id = R.drawable.chili_ic_clear_24),
                    contentDescription = "Mask clear button"
                )
            }
        }
    }
}


fun checkIsMaskAdding(oldText: String, newText: String, representation: Char): Boolean {
    return newText.count { it == representation } > oldText.count { it == representation }
}

fun clearMaskSymbols(text: String, maskSymbols: List<Char>, representation: Char): String {
    return text.filter { !maskSymbols.contains(it) && it != representation }
}

fun String.clearForbiddenSymbols(allowedInputSymbols: String): String {
    if (allowedInputSymbols == "*") return this
    return this.filter { allowedInputSymbols.contains(it) }
}

fun mergeStrings(
    inputText: String,
    mask: String,
    representation: Char,
    selectionPosition: Int,
    updatePosition: () -> Unit
): String {
    val maskedText = StringBuilder()
    var maskIndex = 0
    var textIndex = 0

    while (true) {
        when {
            textIndex >= inputText.length && maskIndex >= mask.length -> break
            textIndex < inputText.length && maskIndex >= mask.length -> break
            textIndex >= inputText.length && maskIndex < mask.length -> {
                maskedText.append(mask.subSequence(maskIndex, mask.length))
                break
            }
        }
        when {
            mask[maskIndex] == representation -> {
                maskedText.append(inputText[textIndex])
                textIndex++
                maskIndex++
            }

            mask[maskIndex] == inputText[textIndex] -> {
                maskedText.append(inputText[textIndex])
                textIndex++
                maskIndex++
            }

            else -> {
                val s = mask[maskIndex]
                maskedText.append(s)
                if (maskIndex + 1 == selectionPosition) {
                    // Обновление позиции курсора, если не происходит удаление
                    updatePosition()
                }
                maskIndex++
            }
        }
    }
    return maskedText.toString()
}


class InputMaskVisualTransformation(private val hintTextColor: Color) : VisualTransformation {

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

