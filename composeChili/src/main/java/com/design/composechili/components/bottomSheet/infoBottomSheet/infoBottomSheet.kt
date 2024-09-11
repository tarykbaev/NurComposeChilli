package com.design.composechili.components.bottomSheet.infoBottomSheet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.bottomSheet.baseBottomSheet.BaseBottomSheet
import com.design.composechili.components.buttons.baseButton.BaseButton
import com.design.composechili.components.buttons.baseButton.ChiliButtonStyle
import com.design.composechili.extensions.getBottomSheetState
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoBottomSheet(
    modifier: Modifier = Modifier,
    sheetState: BottomSheetScaffoldState,
    title: String,
    description: String,
    @DrawableRes icon: Int,
    buttons: List<InfoBottomSheetButton>,
    peekHeight: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    ChiliTheme {
        BaseBottomSheet(
            sheetState = sheetState,
            peekHeight = peekHeight,
            hasCloseIcon = true,
            bottomSheetContent = {
                Column(modifier = modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(painter = painterResource(id = icon), contentDescription = null)
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = title.take(InfoBottomSheetsParams.Default.maxChars),
                                style = InfoBottomSheetsParams.Default.titleStyle
                            )
                            Text(
                                text = description,
                                style = InfoBottomSheetsParams.Default.descriptionStyle
                            )
                        }
                    }
                }
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(buttons.size) {
                        BaseButton(
                            onClick = buttons[it].onClick,
                            title = buttons[it].title,
                            buttonStyle = buttons[it].buttonStyle
                        )
                    }
                }
            }) { content() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun InfoBottomSheet_Preview() {
    ChiliTheme {
        val scope = rememberCoroutineScope()
        val sheetState = getBottomSheetState()

        val buttons = listOf(
            InfoBottomSheetButton(
                title = "First",
                onClick = {},
                buttonStyle = ChiliButtonStyle.Primary
            ),
            InfoBottomSheetButton(
                title = "Cancel",
                onClick = {
                    scope.launch { sheetState.bottomSheetState.hide() }
                },
                buttonStyle = ChiliButtonStyle.Additional
            ),
        )

        InfoBottomSheet(
            sheetState = sheetState,
            title = "Заголовок окна",
            description = "LALALLA Текстовый блок, который содержит 120 символов, и этого количества должно хватить для информации ...",
            buttons = buttons,
            peekHeight = 430.dp,
            icon = R.drawable.ic_cat
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_bonus_new),
                contentDescription = null
            )
        }
    }
}

@Stable
data class InfoBottomSheetButton(
    val onClick: () -> Unit,
    val title: String,
    val buttonStyle: ChiliButtonStyle
)

@Stable
data class InfoBottomSheetsParams(
    val titleStyle: TextStyle,
    val descriptionStyle: TextStyle,
    val maxChars: Int
) {
    companion object {
        private const val MAX_CHARS = 120
        val Default
            @Composable get() = InfoBottomSheetsParams(
                titleStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor
                ),
                descriptionStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH4,
                    color = ChiliTheme.Colors.chiliErrorTextColor
                ),
                maxChars = MAX_CHARS
            )
    }
}