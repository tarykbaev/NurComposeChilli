package com.design.composechili.components.inAppPush

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import com.design.composechili.R
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme

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
        ) {
            if (banner.isNotBlank()) {
                SubcomposeAsyncImage(
                    modifier = Modifier.align(Alignment.Center),
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
            text = title,
            style = titleStyle,
            )

        Text(
            modifier = Modifier.padding(top = 16.dp), text = description, style = descriptionStyle
        )
        BaseButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = onClickListener,
            title = buttonText,
            buttonStyle = ChiliButtonStyle.Secondary,
        )
    }


}