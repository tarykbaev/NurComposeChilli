package com.design.composechili.components.inAppPush

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle
import com.design.composechili.utils.safeTake

/**
 * A customizable in-app push notification component for displaying informational messages with a title, description, button, and optional banner.
 *
 * @param title A string representing the main title of the in-app push notification.
 * This is typically the most prominent text in the notification.
 *
 * @param description A string providing additional information or context, typically displayed below the title.
 * This helps give the user more details about the notification.
 *
 * @param buttonText A string representing the text that appears on the action button.
 * This is typically used to prompt the user to take action, such as "Learn more" or "Dismiss."
 *
 * @param banner An optional string URL or resource reference for the image banner displayed in the notification.
 * This can be used to add a visual element to the notification. Default is an empty string (no banner).
 *
 * @param bannerCorner A `CornerBasedShape` object that defines the corner shape of the banner.
 * You can set custom rounded corners or other shapes for the banner. Default is `RoundedCornerShape(24.dp)`.
 *
 * @param titleStyle A `TextStyle` object used to customize the appearance of the title, including text size, color, and font.
 * Default style uses `ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7`, `ChiliTheme.Colors.ChiliPrimaryTextColor`, and the `Roboto` medium font.
 *
 * @param descriptionStyle A `TextStyle` object used to customize the appearance of the description text, including text size and color.
 * Default style uses `ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8` and `ChiliTheme.Colors.ChiliSecondaryTextColor`.
 *
 * @param onClickListener A lambda function that is invoked when the action button is clicked.
 * This typically handles the action triggered by the user interaction, such as navigation or data submission.
 *
 * @param onDismissRequest A lambda function that is invoked when the in-app push is dismissed.
 * This allows for custom dismissal logic, such as closing the notification or updating the UI.
 *
 * Example Usage:
 * ```
 * InfoInAppPush(
 *     title = "New Feature Available!",
 *     description = "Check out our latest update with new exciting features.",
 *     buttonText = "Learn More",
 *     banner = "https://example.com/banner.png",
 *     onClickListener = { /* Handle button click */ },
 *     onDismissRequest = { /* Handle dismissal */ }
 * )
 * ```
 */

@Composable
fun InfoInAppPush(
    title: String,
    description: String,
    buttonText: String,
    banner: String = String(),
    bannerCorner: CornerBasedShape = RoundedCornerShape(24.dp),
    titleStyle: TextStyle = ChiliTextStyle.get(
        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
        color = ChiliTheme.Colors.ChiliPrimaryTextColor,
        font = Font(R.font.roboto_medium),
    ),
    descriptionStyle: TextStyle = ChiliTextStyle.get(
        textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
        color = ChiliTheme.Colors.ChiliSecondaryTextColor,
    ),
    onClickListener: () -> Unit,
    onDismissRequest: () -> Unit,
) {

    BaseInAppPush(
        modifier = Modifier.padding(horizontal = 8.dp), onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 12.dp)
        ) {

            if (banner.isNotBlank()) {
                SubcomposeAsyncImage(
                    modifier = Modifier.align(Alignment.Center).fillMaxWidth(),
                    model = banner,
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    contentDescription = String()
                ) {
                    val state = painter.state

                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator()
                    } else {
                        SubcomposeAsyncImageContent(
                            Modifier.clip(bannerCorner),
                            clipToBounds = false
                        )
                    }
                }
            }
        }

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title.safeTake(60),
            style = titleStyle,

            )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = description.safeTake(190),
            style = descriptionStyle
        )
        BaseButton(
            buttonPadding = PaddingValues(top = 16.dp),
            onClick = onClickListener,
            title = buttonText,
            buttonStyle = ChiliButtonStyle.Secondary,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InfoInAppPushPreview() {
    ChiliTheme {
        Column(Modifier.fillMaxSize()) {
            InfoInAppPush(
                title = "Максимальная длина заголовка равна 60 символов, а если не по",
                description = "Описание описания, которое описывает описанное описание описанного описания, максимум из 190 символов," +
                        "но если ничего \n не помещается, не проблема, потому что у нас всегда...",
                buttonText = "ПОДРОБНЕЕ",
                onClickListener = { /*TODO*/ }) {
            }
        }
    }
}