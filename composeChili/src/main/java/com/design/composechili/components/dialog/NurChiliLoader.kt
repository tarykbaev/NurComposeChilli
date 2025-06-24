package com.design.composechili.components.dialog

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.design.composechili.theme.ChiliTheme

@Composable
fun NurChiliLoader(
    isVisible: Boolean,
    loaderText: String? = null,
    params: NurChiliLoaderParams = NurChiliLoaderParams.Default,
    onDismissRequest: () -> Unit = { }
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = params.dialogProperties,
        ) {
            Card(
                modifier = Modifier
                    .wrapContentSize(),
                colors = CardDefaults.cardColors(
                    containerColor = params.backgroundColor
                ),
                shape = RoundedCornerShape(params.backgroundCornerRadius)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .wrapContentSize()
                        .background(params.backgroundColor),
                    verticalArrangement = Arrangement.Center
                ) {
                    AnimatedVisibility(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        visible = true,
                        enter = fadeIn()
                    ) {
                        CircularProgressIndicator(
                            color = params.progressColor,
                            strokeWidth = params.progressWidth,
                        )
                    }
                    loaderText?.let {
                        Spacer(modifier = Modifier.size(16.dp))
                        Text(
                            text = it,
                            textAlign = TextAlign.Center,
                            style = params.textStyle,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(horizontal = 48.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun NurChiliLoader_Preview() {
    ChiliTheme {
        NurChiliLoader(isVisible = true)
    }
}