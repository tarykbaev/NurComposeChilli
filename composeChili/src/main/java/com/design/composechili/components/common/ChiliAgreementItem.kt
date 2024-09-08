package com.design.composechili.components.common

import android.text.Html
import android.text.style.URLSpan
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.text.getSpans
import com.design.composechili.R
import com.design.composechili.components.checkbox.ChiliCheckbox
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

private const val URL_TAG = "URL"

enum class DisplayMode {
    CHECKBOX,
    ICON,
    TEXT_ONLY
}

/**
 * @param [startIcon] accepts a drawable resource ID for the icon displayed when the item is not editable.
 * @param [startIconSize] sets the size of the start icon when the item is not editable.
 * @param [agreementHtmlText] accepts a [String] with HTML content and displays it as styled text.
 * @param [agreementTextStyle] sets the style of the agreement text.
 * @param [linkColor] sets the color of hyperlinks within the agreement text.
 * @param [isChecked] indicates whether the checkbox is checked when the item is editable.
 * @param [onCheckedChange] sets the handler for checkbox state changes when the item is editable.
 * @param [displayMode] sets the display mode of the item.
 * @param [onLinkClick] sets the handler for clicks on hyperlinks within the agreement text.
 */
@Composable
fun ChiliAgreementItem(
    modifier: Modifier = Modifier,
    @DrawableRes startIcon: Int = R.drawable.chili_ic_checkmark,
    startIconSize: Dp = dimensionResource(R.dimen.view_24dp),
    agreementHtmlText: String,
    agreementTextStyle: TextStyle = ChiliTextStyle.get(
        ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
        ChiliTheme.Colors.ChiliPrimaryTextColor
    ),
    linkColor: Color = colorResource(R.color.magenta_1),
    isChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    displayMode: DisplayMode = DisplayMode.CHECKBOX,
    onLinkClick: (String) -> Unit
) {

    val annotatedHtmlAgreementText = remember(agreementHtmlText, linkColor) {
        parseHtmlToAnnotatedString(agreementHtmlText, linkColor)
    }

    ChiliTheme {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (displayMode) {
                DisplayMode.CHECKBOX -> {
                    ChiliCheckbox(
                        modifier = Modifier,
                        isChecked = isChecked,
                        onCheckedChange = onCheckedChange
                    )
                }

                DisplayMode.ICON -> {
                    Image(
                        modifier = Modifier.size(startIconSize),
                        painter = painterResource(startIcon),
                        contentDescription = "agreement_item_icon"
                    )
                }

                DisplayMode.TEXT_ONLY -> {}
            }

            Spacer(
                modifier = Modifier
                    .width(
                        if (displayMode == DisplayMode.CHECKBOX) dimensionResource(R.dimen.padding_4dp)
                        else dimensionResource(R.dimen.padding_16dp)
                    )
            )

            ClickableText(
                modifier = Modifier,
                style = agreementTextStyle,
                text = annotatedHtmlAgreementText
            ) { offset ->
                annotatedHtmlAgreementText.getStringAnnotations(
                    tag = URL_TAG, start = offset, end = offset
                ).firstOrNull()?.let { annotation ->
                    onLinkClick(annotation.item)
                }
            }
        }
    }
}

fun parseHtmlToAnnotatedString(htmlText: String, linkColor: Color): AnnotatedString {
    val spanned = Html.fromHtml(htmlText, Html.FROM_HTML_MODE_COMPACT)
    return buildAnnotatedString {
        append(spanned)
        spanned.getSpans<URLSpan>().forEach { span ->
            val start = spanned.getSpanStart(span)
            val end = spanned.getSpanEnd(span)

            addStyle(
                SpanStyle(
                    color = linkColor, textDecoration = TextDecoration.Underline
                ), start, end
            )

            addStringAnnotation(
                tag = URL_TAG, annotation = span.url, start, end
            )
        }
    }
}

@Preview
@Composable
fun ChiliAgreementItemPreview() {
    ChiliTheme {
        var isChecked by remember { mutableStateOf(false) }

        ChiliAgreementItem(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 16.dp
                ),
            agreementHtmlText = "AgreementText",
            isChecked = isChecked,
            displayMode = DisplayMode.CHECKBOX,
            onCheckedChange = {
                isChecked = it
            }
        ) {
            
        }
    }
}