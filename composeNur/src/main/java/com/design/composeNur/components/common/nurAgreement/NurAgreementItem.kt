package com.design.composeNur.components.common.nurAgreement

import android.text.Html
import android.text.style.URLSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.getSpans
import com.design.composeNur.components.checkbox.NurCheckbox
import com.design.composeNur.theme.NurTheme
import com.design.composenur.R

private const val URL_TAG = "URL"

enum class DisplayMode {
    CHECKBOX,
    ICON,
    TEXT_ONLY
}

/**
 * A composable function that creates an agreement item with customizable display modes, including a checkbox, icon,
 * or text-only presentation. The agreement text supports HTML formatting and allows clickable links.
 *
 * @param modifier A [Modifier] to adjust the layout or decoration of the composable. Defaults to [Modifier] with no modifications.
 *
 * @param agreementHtmlText A [String] containing the HTML text of the agreement. Links within the text will be clickable.
 *
 * @param isChecked A [Boolean] that indicates the checked state of the agreement item when in CHECKBOX mode.
 * Defaults to `false`.
 *
 * @param onCheckedChange A lambda function that is invoked when the checked state changes in CHECKBOX mode.
 * The new checked state is passed as a parameter. Defaults to an empty lambda.
 *
 * @param displayMode An instance of [DisplayMode] to determine the presentation style of the agreement item.
 * Options include [DisplayMode.CHECKBOX], [DisplayMode.ICON], and [DisplayMode.TEXT_ONLY]. Defaults to [DisplayMode.CHECKBOX].
 *
 * @param NurAgreementItemParams An instance of [NurAgreementItemParams] to configure additional parameters such
 * as text style, link color, and icon size. Defaults to [com.design.composeNur.components.common.nurAgreement.NurAgreementItemParams.Default].
 *
 * @param onLinkClick A lambda function that is invoked when a link within the agreement text is clicked.
 * The URL of the clicked link is passed as a parameter.
 *
 * @sample [com.design.composeNur.components.common.nurAgreement.NurAgreementItemParams.Default]
 */
@Composable
fun NurAgreementItem(
    modifier: Modifier = Modifier,
    agreementHtmlText: String,
    isChecked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    displayMode: DisplayMode = DisplayMode.CHECKBOX,
    nurAgreementItemParams: NurAgreementItemParams = NurAgreementItemParams.Default,
    onLinkClick: (String) -> Unit
) {

    val annotatedHtmlAgreementText =
        remember(agreementHtmlText, nurAgreementItemParams.linkColor) {
            parseHtmlToAnnotatedString(agreementHtmlText, nurAgreementItemParams.linkColor)
        }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (displayMode) {
            DisplayMode.CHECKBOX -> {
                NurCheckbox(
                    isChecked = isChecked,
                    onCheckedChange = onCheckedChange
                )
            }

            DisplayMode.ICON -> {
                Image(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, start = 12.dp)
                        .size(nurAgreementItemParams.startIconSize),
                    painter = painterResource(nurAgreementItemParams.startIcon),
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
            style = nurAgreementItemParams.agreementHtmlTextStyle,
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

/**
 * Parses HTML text to an [AnnotatedString] with clickable links. The text can include inline styles,
 * and the links are styled with the specified link color.
 *
 * @param htmlText A [String] containing the HTML-formatted text.
 *
 * @param linkColor A [Color] used for styling the clickable links within the text.
 *
 * @return An [AnnotatedString] with the formatted text and clickable link annotations.
 */
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

@Preview(showBackground = true)
@Composable
fun NurAgreementItemPreview() {
    NurTheme {
        var isChecked by remember { mutableStateOf(false) }

        Column {
            NurAgreementItem(
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
            NurAgreementItem(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 16.dp
                    ),
                agreementHtmlText = "AgreementText",
                isChecked = true,
                displayMode = DisplayMode.ICON,
                onCheckedChange = {
                    isChecked = it
                }
            ) {

            }
        }
    }
}