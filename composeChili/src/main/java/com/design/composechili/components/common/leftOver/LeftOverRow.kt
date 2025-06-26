package com.design.composechili.components.common.leftOver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder
import com.design.composechili.utils.LeftOverUtils

/**
 * A composable that displays a row item showing package usage information (internet/calls) with:
 * - An animated circular progress indicator
 * - Title and usage description
 * - Optional end icon
 * - Click handling
 *
 * @param modifier Modifier to be applied to the layout
 * @param title The title text to display (e.g., "Internet" or "Calls")
 * @param limit The total limit/allowance of the package (in bytes for internet, seconds for calls)
 * @param remain The remaining amount of the package (in bytes for internet, seconds for calls)
 * @param isSuspended Whether the package is currently suspended/inactive
 * @param packageType The type of package (Internet/Call) which determines styling and units
 * @param showUnlim Whether to show the package as unlimited (affects progress indicator)
 * @param pieChartIcons Optional list of image URLs to display as rotating icons in the progress indicator
 * @param endIcon Resource ID of the icon to display at the end of the row
 * @param onClick Callback when the row is clicked
 */

@Composable
fun LeftOverRow(
    modifier: Modifier = Modifier,
    title: String,
    limit: Long = AnimatedLeftOverParams.Call.limit,
    remain: Long = AnimatedLeftOverParams.Call.left,
    isSuspended: Boolean = false,
    packageType: AnimatedLeftOverParams,
    showUnlim: Boolean = false,
    pieChartIcons: List<String>? = listOf("https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png"),
    endIcon: Int = when (packageType) {
        AnimatedLeftOverParams.Internet -> R.drawable.ic_more_internet
        AnimatedLeftOverParams.Call -> R.drawable.ic_more_calls
        else -> R.drawable.ic_more_internet
    },
    onClick: () -> Unit = {},
    onAddClick: () -> Unit = {},
) {
    val locale = Locale.current.language
    val descriptionText =
        LeftOverUtils.getDescriptionText(
            isSuspended,
            limit,
            remain,
            packageType.typeName,
            locale,
            LocalContext.current
        )

    Column(modifier, verticalArrangement = Arrangement.Center) {
        Row(
            modifier = Modifier
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(
                        color = ChiliTheme.Colors.СhiliRippleForegroundColor
                    )
                ) { onClick() }
                .background(ChiliTheme.Colors.ChiliCardViewBackground)
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AnimatedLeftOver(
                leftOverParams = packageType,
                isUnlimited = showUnlim,
                limit = limit,
                left = remain,
                bottomUrlImageList = pieChartIcons
            )
            Column(
                modifier = Modifier
                    .weight(6f)
                    .padding(horizontal = 12.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = title, style = ChiliTextStyleBuilder.H8.Primary.Default)
                    Image(painter = painterResource(AnimatedLeftOverParams.Call.chevron), "chevron icon")
                }
                Text(text = descriptionText, style = ChiliTextStyleBuilder.H8.Primary.Bold)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painter = painterResource(endIcon),
                contentDescription = "icon add",
                modifier = Modifier
                    .clip(packageType.iconRippleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(color = ChiliTheme.Colors.СhiliRippleForegroundColor)
                    ) { onAddClick() },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LeftOverCard_Preview() {
    ChiliTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            LeftOverRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                packageType = AnimatedLeftOverParams.Internet,
                isSuspended = true,
                title = "Internet",
            )
            LeftOverRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                title = "Calls",
                packageType = AnimatedLeftOverParams.Call,
                limit = 5000,
                remain = 2400,
            )

        }
    }
}
