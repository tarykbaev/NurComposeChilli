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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.components.common.leftOver.model.LeftOverUiModel
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.theme.textStyle.ChiliTextStyleBuilder

/**
 * A composable card that displays information about the current tariff leftovers
 * such as internet and call package balances.
 *
 * It shows a title, a description (e.g., next charge date), and a list of usage packages.
 *
 * @param title The title of the card (e.g., tariff name).
 * @param description The description below the title (e.g., "250с будет списано 01.03.2025").
 * @param lisOfLeftOvers A list of [LeftOverUiModel] representing the remaining and total amounts.
 * @param params UI customization parameters from [TariffLeftOverCardParams].
 */

@Composable
fun TariffLeftOverCard(
    title: String = "",
    description: String = "",
    lisOfLeftOvers: List<LeftOverUiModel> = listOf(),
    onClick: () -> Unit = {},
    onAddClick: () -> Unit = {},
    params: TariffLeftOverCardParams = TariffLeftOverCardParams.Default,
) {

    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors()
            .copy(containerColor = ChiliTheme.Colors.ChiliCardViewBackground)
    ) {
        Column(modifier = Modifier.padding(bottom = params.cardBottomPadding)) {
            Row(
                modifier = Modifier
                    .padding(horizontal = params.rowHorizontalPadding)
                    .padding(vertical = params.rowVerticalPadding)
            ) {
                Column {
                    Text(
                        modifier = Modifier.padding(bottom = params.titleBottomPadding),
                        text = title, style = ChiliTextStyleBuilder.H8.Primary.Regular
                    )
                    Text(description, style = ChiliTextStyleBuilder.H8.Primary.Regular)
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
                            .padding(horizontal = params.leftOverRowHorizontalPadding),
                        packageType = item.packageType,
                        isSuspended = false,
                        limit = item.limit,
                        remain = item.remain,
                        pieChartIcons = item.pieChartIcons,
                        title = when (item.packageType) {
                            AnimatedLeftOverParams.Internet -> context.getString(R.string.package_name_internet)
                            AnimatedLeftOverParams.Call -> context.getString(R.string.package_name_call)
                            else -> ""
                        },
                        onClick = onClick,
                        onAddClick = onAddClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun TariffLeftOverCard_Preview() {
    ChiliTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            TariffLeftOverCard(
                title = "Служебный 250+ (на месяц)",
                description = "250с будет списано 01.03.2025",
                lisOfLeftOvers = listOf(
                    LeftOverUiModel(
                        packageType = AnimatedLeftOverParams.Internet,
                        limit = 5000000000L,
                        remain = 2400000000L,
                        expiryDate = null,
                        showUnlim = false,
                        isSuspended = true,
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
            )
        }
    }
}