package com.design.composechili.utils

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle

fun String.safeTake(n: Int): String {
    Log.e("TAG", "$n & ${this.length}")
    return when {
        isNotBlank() && length > n -> take(n).plus("...")
        isNotBlank() -> take(n)
        else -> this
    }
}

fun Float.addCurrency(): AnnotatedString {
    return buildAnnotatedString {
        append("${this@addCurrency} ")
        withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("с")
        }
    }
}

fun Double.addCurrency(): AnnotatedString {
    return buildAnnotatedString {
        append("${this@addCurrency} ")
        withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
            append("с")
        }
    }
}