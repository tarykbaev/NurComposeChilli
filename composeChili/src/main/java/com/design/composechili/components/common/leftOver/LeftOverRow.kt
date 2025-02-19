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
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.design.composechili.R
import com.design.composechili.theme.ChiliTheme
import com.design.composechili.utils.toThreeDigitsFormat
import kotlin.math.ln
import kotlin.math.pow

@Composable
fun LeftOverRow(
    modifier: Modifier = Modifier,
    title: String,
    limit: Long = 50000000000L,
    remain: Long = 20000000000L,
    isSuspended: Boolean = false,
    packageType: AnimatedLeftOverParams,
    showUnlim: Boolean = false,
    pieChartIcons: List<String>? = listOf("https://minio.o.kg/lkab/services/circle_icon/light/tetering_on.png"),
    endIcon: Int = when (packageType) {
        AnimatedLeftOverParams.Internet -> R.drawable.ic_more_internet
        AnimatedLeftOverParams.Call -> R.drawable.ic_more_calls
        else -> R.drawable.ic_more_internet
    }
) {
    val descriptionText = getDescriptionText(isSuspended, limit, remain, packageType)

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

@Composable
private fun getDescriptionText(
    isSuspended: Boolean,
    limit: Long,
    remain: Long,
    type: AnimatedLeftOverParams
): String {

    val GIGABYTE = 3
    val TERRABYTE = 4

    val locale = Locale.current
    val internetUnits = when (locale.language) {
        "en" -> arrayOf("B", "KB", "MB", "GB", "TB")
        else -> arrayOf("Б", "КБ", "MБ", "ГБ", "ТБ")
    }
    val callsUnit = when (locale.language) {
        "en" -> "min"
        else -> "мин"
    }

    val suffix = when (locale.language) {
        "ru" -> ""
        "kg" -> if (type == AnimatedLeftOverParams.Call) "тон" else "тан"
        else -> ""
    }

    val prefix = when (locale.language) {
        "ru" -> "из"
        "en" -> "from"
        else -> ""
    }

    val unitMultiplier = 1024.0
    val limitIndex = (ln(limit.toDouble()) / ln(unitMultiplier)).toInt()
    val limitUnitsFromSize = limit / unitMultiplier.pow(limitIndex.toDouble())
    val remainIndex = (ln(remain.toDouble()) / ln(unitMultiplier)).toInt()
    val remainUnitsFromSize = remain / unitMultiplier.pow(remainIndex.toDouble())

    val limitUnitName =
        if (type == AnimatedLeftOverParams.Call) callsUnit else internetUnits[limitIndex]
    val remainUnitName =
        if (type == AnimatedLeftOverParams.Call) callsUnit else internetUnits[limitIndex]

    val limitText = when {
        isSuspended -> "Inactive"
        type == AnimatedLeftOverParams.Call -> "${limit / 60} $limitUnitName$suffix"
        limitIndex == GIGABYTE || limitIndex == TERRABYTE -> {
            "${limitUnitsFromSize.toThreeDigitsFormat} $limitUnitName$suffix"
        }
        else -> "${limitUnitsFromSize.toInt()} $limitUnitName$suffix"
    }

    val remainText = when {
        isSuspended -> ""
        type == AnimatedLeftOverParams.Call -> "$prefix ${remain / 60} $remainUnitName"
        remainIndex == GIGABYTE || remainIndex == TERRABYTE -> {
            "$prefix ${remainUnitsFromSize.toThreeDigitsFormat} $remainUnitName"
        }
        else -> "$prefix ${remainUnitsFromSize.toInt()} $remainUnitName"
    }

    return "$limitText $remainText"
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
