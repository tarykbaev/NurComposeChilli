package com.design.composechili.utils

import android.content.Context
import com.design.composechili.R
import com.design.composechili.components.common.leftOver.AnimatedLeftOverParams
import kotlin.math.ln
import kotlin.math.pow

object LeftOverUtils {

    const val GIGABYTE = 3
    const val TERABYTE = 4

    fun getDescriptionText(
        isSuspended: Boolean,
        limit: Long,
        remain: Long,
        type: String,
        language: String,
        context: Context,
    ): String {

        val internetUnits = context.resources.getStringArray(R.array.internet_units)

        val callsUnit = context.getString(R.string.text_minutes)

        val suffix = when (language) {
            context.getString(R.string.locale_kg) ->
                if (type == AnimatedLeftOverParams.CALL_TYPE) context.getString(R.string.from_suffix_min)
                else context.getString(R.string.from_suffix_internet)

            else -> ""
        }

        val prefix = context.getString(R.string.from_prefix)

        val unitMultiplier = 1024.0
        val limitIndex = (ln(limit.toDouble()) / ln(unitMultiplier)).toInt()
        val limitUnitsFromSize = limit / unitMultiplier.pow(limitIndex.toDouble())
        val remainIndex = (ln(remain.toDouble()) / ln(unitMultiplier)).toInt()
        val remainUnitsFromSize = remain / unitMultiplier.pow(remainIndex.toDouble())

        val limitUnitName =
            if (type == AnimatedLeftOverParams.CALL_TYPE) callsUnit else internetUnits[limitIndex]
        val remainUnitName =
            if (type == AnimatedLeftOverParams.CALL_TYPE) callsUnit else internetUnits[remainIndex]

        val limitText = when {
            isSuspended -> context.getString(R.string.text_inactive)
            type == AnimatedLeftOverParams.CALL_TYPE -> "${limit / 60} $limitUnitName$suffix"
            limitIndex == GIGABYTE || limitIndex == TERABYTE -> {
                "${limitUnitsFromSize.toThreeDigitsFormat} $limitUnitName$suffix"
            }

            else -> "${limitUnitsFromSize.toInt()} $limitUnitName$suffix"
        }

        val remainText = when {
            isSuspended -> ""
            type == AnimatedLeftOverParams.CALL_TYPE -> "$prefix ${remain / 60} $remainUnitName"
            remainIndex == GIGABYTE || remainIndex == TERABYTE -> {
                "$prefix ${remainUnitsFromSize.toThreeDigitsFormat} $remainUnitName"
            }

            else -> "$prefix ${remainUnitsFromSize.toInt()} $remainUnitName"
        }

        return "$limitText $remainText"
    }
}
