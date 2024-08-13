package com.design.composechili.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTextStyle
import com.design.composechili.theme.ChiliTheme


@Composable
fun BaseSnackBar(
    text: String,
    modifier: Modifier = Modifier,
    actionText: String = String(),
    isLoading: Boolean = false,
    @DrawableRes startIcon: Int? = null,
    actionListener: (() -> Unit)? = null,
    dismissAction: (() -> Unit)? = null,
    baseSnackBarParams: BaseSnackBarParams = BaseSnackBarParams.Default
) {
    ChiliTheme {
        Snackbar(
            modifier = modifier.padding(
                horizontal = ChiliTheme.Attribute.ChiliSnackbarContentPaddingHorizontal,
                vertical = ChiliTheme.Attribute.ChiliSnackbarContentPaddingVertical
            ),
            shape = RoundedCornerShape(baseSnackBarParams.cornersSize),
            containerColor = baseSnackBarParams.containerColor,
            action = {
                Text(actionText, color = baseSnackBarParams.actionTextColor, modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.padding_16dp), vertical =  ChiliTheme.Attribute.ChiliSnackbarContentPaddingVertical)
                    .clickable { actionListener?.invoke() })
            },
            dismissAction = { dismissAction?.invoke() },
            content = {
                Row(
                    modifier = Modifier.wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .width(dimensionResource(id = R.dimen.view_32dp))
                            ,
                            color = baseSnackBarParams.containerColor,
                            strokeCap = StrokeCap.Round,
                            trackColor = baseSnackBarParams.textColor
                        )
                    }
                    if (startIcon != null) {
                        Image(
                            modifier = Modifier
                                .size(
                                    width = ChiliTheme.Attribute.ChiliSnackbarIconWidth,
                                    height = ChiliTheme.Attribute.ChiliSnackbarIconHeight
                                )
                                .padding(end = 12.dp),

                            painter = painterResource(id = startIcon),
                            contentDescription = "Base SnackBar start icon"
                        )
                    }

                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                            .padding(start = 12.dp),
                        text = text,
                        color = baseSnackBarParams.textColor
                    )
                }
            },
        )
    }
}

data class BaseSnackBarParams(
    val containerColor: Color,
    val cornersSize: Dp,
    val textColor: Color,
    val actionTextColor: Color,
    val textStyle: TextStyle,
) {
    companion object {
        val Default
            @Composable
            get() = BaseSnackBarParams(
                containerColor = ChiliTheme.Colors.ChiliSnackbarBackground,
                cornersSize = ChiliTheme.Attribute.ChiliSnackbarBackgroundCornerRadius,
                textColor = ChiliTheme.Colors.ChiliSnackbarTextColor,
                actionTextColor = ChiliTheme.Colors.ChiliComponentButtonTextColorActive,
                textStyle = ChiliTextStyle.get(
                    textSize = ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH8,
                    color = ChiliTheme.Colors.ChiliPrimaryTextColor,
                )
            )
    }

}