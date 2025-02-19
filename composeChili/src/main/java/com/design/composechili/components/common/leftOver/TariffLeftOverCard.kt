package com.design.composechili.components.common.leftOver

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyle

@Composable
fun TariffLeftOverCard(
    title: String = "Служебный 250+ (на месяц)",
    description: String = "250с будет списано 01.03.2025",
    lisOfLeftOvers: List<LeftOverUiModel> = listOf(
        LeftOverUiModel(
            packageType = AnimatedLeftOverParams.Internet,
            limit = 5000000000L,
            remain = 2400000000L,
            expiryDate = null,
            showUnlim = false,
            isSuspended = false,
            pieChartIcons = listOf(
                "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
                "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png"
            )
        ),
        LeftOverUiModel(
            packageType = AnimatedLeftOverParams.Call,
            limit = 10000L,
            remain = 2400L,
            expiryDate = null,
            showUnlim = false,
            isSuspended = false,
            pieChartIcons = listOf(
                "https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png",
                "https://minio.o.kg/lkab/services/circle_icon/light/tetering_off.png"
            )
        )
    )
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors()
            .copy(containerColor = ChiliTheme.Colors.ChiliCardViewBackground)
    ) {
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 12.dp)
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(bottom = 8.dp),
                        text = title, style = ChiliTextStyle.get(
                            ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                            ChiliTheme.Colors.ChiliPrimaryTextColor,
                            ChiliTheme.Attribute.ChiliBoldTextFont
                        )
                    )
                    Text(
                        description, style = ChiliTextStyle.get(
                            ChiliTheme.Attribute.ChiliTextDimensions.TextSizeH7,
                            ChiliTheme.Colors.ChiliPrimaryTextColor,
                            ChiliTheme.Attribute.ChiliRegularTextFont
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Image(painter = painterResource(R.drawable.chili_ic_chevron), null)
            }
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = ChiliTheme.Colors.ChiliDividerColor,
                thickness = ChiliTheme.Attribute.ChiliDividerHeightSize
            )
            LazyColumn {
                items(lisOfLeftOvers) { item ->
                    LeftOverRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp),
                        packageType = item.packageType,
                        isSuspended = false,
                        limit = item.limit,
                        remain = item.remain,
                        pieChartIcons = item.pieChartIcons
                    )
                }
            }
        }
    }
}

data class LeftOverUiModel(
    val packageType: AnimatedLeftOverParams,
    var limit: Long = 0,
    var remain: Long = 0,
    var expiryDate: String? = null,
    var showUnlim: Boolean = false,
    var isSuspended: Boolean = false,
    var pieChartIcons: List<String>? = null
)

@Preview(showBackground = false)
@Composable
fun TariffLeftOverCard_Preview() {
    ChiliTheme{
        Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
            TariffLeftOverCard()
        }
    }
}