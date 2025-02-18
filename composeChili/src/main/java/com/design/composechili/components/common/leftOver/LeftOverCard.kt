package com.design.composechili.components.common.leftOver

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme

@Composable
fun LeftOverRow(
    modifier: Modifier = Modifier,
    title: String = "Internet",
    limit: Long = 50000L,
    remain: Long = 20000L,
    isSuspended: Boolean = false,
    description: String = "$limit from $remain",
    descriptionSuspended: String = "Inactive",
    packageType: AnimatedLeftOverParams,
    showUnlim: Boolean = false,
    pieChartIcons: List<String>? = listOf("https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png"),
    endIcon: Int = when (packageType) {
        AnimatedLeftOverParams.Internet -> R.drawable.ic_more_internet
        AnimatedLeftOverParams.Call -> R.drawable.ic_more_internet
        else -> R.drawable.ic_more_internet
    }
) {
    val descriptionText = if (isSuspended) descriptionSuspended else description
    Column(modifier, verticalArrangement = Arrangement.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
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
                    Text(title)
                    Image(painter = painterResource(R.drawable.chili_ic_chevron), null)
                }
                Text(descriptionText)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(endIcon), null)
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
                isSuspended = true
            )
            LeftOverRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                title = "Calls",
                packageType = AnimatedLeftOverParams.Call
            )

        }
    }
}
