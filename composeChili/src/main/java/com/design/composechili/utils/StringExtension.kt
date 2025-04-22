package com.design.composechili.utils

import android.util.Log
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.safeTake(n:Int): String {
    Log.e("TAG", "$n & ${this.length}", )
    return when{
        isNotBlank() && length > n -> take(n).plus("...")
        isNotBlank() -> take(n)
        else -> this
    }
}

fun String.toLocalDate(): LocalDateTime{
    return LocalDateTime.parse(this, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
}