package com.design.composechili.components.common.pieChart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.text.parseAsHtml
import com.design.composechili.R
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.abs

@Composable
fun PieChart(
    modifier: Modifier = Modifier,
    size: Dp = 300.dp,
    totalAmount: Float,
    categoriesList: List<SpendingCategory>,
    innerText: String,
) {

    val canvasItems = categoriesList.map {
        PieChartData(it.type?.getColor() ?: colorResource(R.color.gray_6), it.totalCharge ?: 0f)
    }
    val somSymbol = "<b> <u>c</u> </b>".parseAsHtml()

    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Canvas(modifier = modifier.size(size)) {
            var startAngle = 90f
            canvasItems.forEach {
                val sweepAngle = (it.amount * 360) / totalAmount
                drawArc(
                    color = it.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(width = (size / 15).toPx())
                )
                startAngle += sweepAngle
            }
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = innerText)
            Text(text = "${totalAmount.toInt()} $somSymbol")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PieChart_Preview() {
    Column(
        Modifier
            .size(300.dp)
            .padding(32.dp)
    ) {
        PieChart(
            totalAmount = 1000.00f,
            categoriesList = listOf(
                SpendingCategory(
                    "",
                    type = EnumSpendingCategory.SUBSCRIPTION_FEE,
                    totalCharge = 100f
                ),
                SpendingCategory("", type = EnumSpendingCategory.OMONEY, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.SERVICES, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.INTERNET, totalCharge = 100f),
                SpendingCategory(
                    "",
                    type = EnumSpendingCategory.INTERNET_PACKAGE,
                    totalCharge = 100f
                ),
                SpendingCategory("", type = EnumSpendingCategory.ROAMING, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.OUT_VOICE, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.SMS, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.INNER_VOICE, totalCharge = 100f),
                SpendingCategory("", type = EnumSpendingCategory.NONE, totalCharge = 100f),
            ),
            innerText = "Some text"
        )
    }
}

data class PieChartData(
    val color: Color,
    val amount: Float
)

enum class EnumSpendingCategory {
    SUBSCRIPTION_FEE,
    OMONEY,
    SERVICES,
    INTERNET,
    INTERNET_PACKAGE,
    ROAMING,
    OUT_VOICE,
    SMS,
    INNER_VOICE,
    NONE,
}

@Composable
fun EnumSpendingCategory.getColor(): Color {
    return when (this) {
        EnumSpendingCategory.SUBSCRIPTION_FEE -> colorResource(R.color.orange_1)
        EnumSpendingCategory.OMONEY -> colorResource(R.color.magenta_1)
        EnumSpendingCategory.SERVICES -> colorResource(R.color.green_5)
        EnumSpendingCategory.INTERNET -> colorResource(R.color.cyan_1)
        EnumSpendingCategory.INTERNET_PACKAGE -> colorResource(R.color.red_1)
        EnumSpendingCategory.ROAMING -> colorResource(R.color.blue_2)
        EnumSpendingCategory.OUT_VOICE -> colorResource(R.color.green_1)
        EnumSpendingCategory.SMS -> colorResource(R.color.purple_1)
        EnumSpendingCategory.INNER_VOICE -> colorResource(R.color.magenta_2)
        EnumSpendingCategory.NONE -> colorResource(R.color.gray_6)
    }
}


data class SpendingCategory(
    var name: String? = null,
    var type: EnumSpendingCategory? = null,
    var totalCharge: Float? = null,
    var subCategories: List<SpendingSubCategory>? = null
) {

    fun getTotalCharge(): String {
        return totalCharge?.toDouble()?.toThreeDigitsFormat ?: ""
    }

}

data class SpendingSubCategory(
    var name: String? = null,
    var charge: Double? = null,
    var amount: Double? = null,
    var date: Long? = null,
    var subType: EnumSpendingSubCategory? = null,
    var count: Int? = null,
    var desc: String? = null,
    var number: String? = null,
    //no,for now making variable below of enum type would be illogical. i think
    var indDesc: String? = null
) {
    fun getPaymentDate(): String {
        date?.let { return Date(it).formatByRegex("dd.MM.yyyy - HH:mm:ss").toLowerCase() }
        return ""
    }

    fun getCharge(): String {
        return charge?.toThreeDigitsFormat ?: ""
    }
}

val Double.toThreeDigitsFormat: String
    get() {
        return when {
            (abs(this) < 10.0) -> this.round("0.00")
            (abs(this) in 10.0..100.0) -> this.round("#.0")
            else -> this.round("#")
        }.replace(".", ",")
    }

private fun Double.round(format: String = "#.##", roundingMode: RoundingMode? = null): String {
    val df = DecimalFormat(format)
    roundingMode?.let { df.roundingMode = roundingMode }
    return df.format(this).replace(".", ",")
}

fun Date.formatByRegex(regex: String): String {
    return SimpleDateFormat(regex, Locale.getDefault()).format(this)
}

enum class EnumSpendingSubCategory {
    INTERNET,
    OUT_SMS,
    OUT_CALL,
    INCOMING_CALL,
    INCOMING_SMS,
    PREPAYMENT_BACK,
    INTERNATIONAL_OUT_CALL,
    SUBSCRIPTION_FEE,
    SERVICES,
    OMONEY,
    INTERNET_PACKAGE,
    ROAMING,
    OTHER;
}