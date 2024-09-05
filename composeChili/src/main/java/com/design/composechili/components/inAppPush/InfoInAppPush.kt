package com.design.composechili.components.inAppPush

import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
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
        modifier = Modifier.padding(horizontal = 8.dp),
        onDismissRequest = onDismissRequest
    ) {

        if (banner.isNotBlank()) {
            SubcomposeAsyncImage(
                modifier = Modifier,
                model = banner,
                alignment = Alignment.Center,
                contentDescription = String()
            ) {
                val state = painter.state

                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = title,
            style = titleStyle,

            )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = description,
            style = descriptionStyle
        )
        BaseButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = onClickListener,
            title = buttonText,
            buttonStyle = ChiliButtonStyle.Secondary,
        )
    }


}