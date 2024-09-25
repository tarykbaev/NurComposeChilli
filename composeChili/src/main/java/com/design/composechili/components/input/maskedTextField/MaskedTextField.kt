package com.design.composechili.components.input.maskedTextField

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.input.baseInput.BaseInputParams
import com.design.composechili.theme.ChiliTheme


/**
 *  Text Field for fill filling with mask. U can set own representation char, ignore values
 *  * @sample +996 XXX XXX XXX -> +996 708 708 888
 *  * @sample XXXXXX -> 123456
 *  @author stashmamatov
 *  @param [maskInputParams] Field visual transformation params and mask representation value
 *  @sample MaskedTextFieldParams(
 *                 titleTextStyle = ChiliTextStyle.get(
 *                     ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH6,
 *                     ChiliTheme.Colors.ChiliPrimaryTextColor,
 *                     ChiliTheme.Attribute.ChiliBoldTextFont
 *                 ),
 *                 hintTextColor = colorResource(id = R.color.gray_2),
 *                 representation = 'X',
 *                 maskSymbols = listOf('-', ' ', '/'),
 *                 allowedInputSymbols = "*",
 *                 fieldContainerColor = colorResource(id = R.color.gray_5)
 *             )
 *  @param [initialText] Initial text, can add mask representation
 *  @param [mask] Mask Value @sample +996 XXX XXX XXX -> +996 707 707 707
 *  @param [fieldContainerColor] MaskedTextField root container color
 *  @param [onValueChange] callback which will invoke when mask text will parse (+996 708 XXX XXX)
 *  @param [rootContainerPadding] padding for root container, def value 16dp
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaskedTextField(
    modifier: Modifier = Modifier,
    maskInputParams: MaskedTextFieldParams = MaskedTextFieldParams.Default,
    initialText: String,
    mask: String = initialText,
    fieldContainerColor: Color = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor,
    onValueChange: (String) -> Unit,
    rootContainerPadding: PaddingValues = PaddingValues(horizontal = 16.dp)
) {
    var text by remember { mutableStateOf(initialText) }
    var selectionPosition by remember { mutableIntStateOf(mask.indexOf(maskInputParams.representation)) }
    var isEditing by remember { mutableStateOf(false) }
    var endIconVisibility by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .wrapContentHeight()
            .padding(rootContainerPadding)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(fieldContainerColor)
                .padding(horizontal = 16.dp)
        ) {
            BasicTextField(
                modifier = Modifier
                    .weight(1f)
                    .defaultMinSize(
                        minWidth = TextFieldDefaults.MinWidth,
                        minHeight = 40.dp
                    ),
                value = TextFieldValue(text, TextRange(selectionPosition)),
                visualTransformation = MaskTextFieldVisualTransformation(maskInputParams.hintTextColor),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    capitalization = KeyboardCapitalization.Characters
                ),
                onValueChange = { newText ->
                    if (!isEditing) {
                        isEditing = true
                        val inputText = StringBuilder(newText.text)
                        val clearedText =
                            clearMaskSymbols(
                                inputText.toString(),
                                maskInputParams.maskSymbols,
                                maskInputParams.representation
                            )
                                .clearForbiddenSymbols(maskInputParams.allowedInputSymbols)
                        val maskedText =
                            mergeStrings(clearedText, mask, maskInputParams.representation, selectionPosition) {
                                selectionPosition++
                            }

                        val isMaskAdding = checkIsMaskAdding(text, maskedText, maskInputParams.representation)

                        // Определение позиции для маски
                        val lastMaskSym =
                            maskedText.indexOfFirst { it == maskInputParams.representation }.takeIf { it != -1 }
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
                textStyle = maskInputParams.titleTextStyle.copy(textAlign = TextAlign.Center),
                cursorBrush = SolidColor(colorResource(id = R.color.magenta_1)),
            ){ innerTextField ->
                TextFieldDefaults.DecorationBox(
                    value = text,
                    visualTransformation = MaskTextFieldVisualTransformation(maskInputParams.hintTextColor),
                    innerTextField = innerTextField,
                    shape = CircleShape.copy(CornerSize(12.dp)),
                    singleLine = true,
                    enabled = true,
                    isError = false,
                    interactionSource = remember {MutableInteractionSource()},
                    colors = TextFieldDefaults.colors().copy(
                        focusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor,
                        disabledContainerColor = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor,
                        unfocusedContainerColor = ChiliTheme.Colors.ChiliCodeInputItemBackgroundColor
                    ),
                    contentPadding = BaseInputParams.Default.textFieldPadding,
                )
            }
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

@Preview
@Composable
fun MaskedTextFieldPreview() {
    ChiliTheme {
        MaskedTextField(initialText = "+997 XXX XXX XXX", onValueChange = {})
    }
}