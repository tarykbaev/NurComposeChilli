package com.design.composechili.utils

import android.util.Log

fun String.safeTake(n:Int): String {
    Log.e("TAG", "$n & ${this.length}", )
    return when{
        isNotBlank() && length > n -> take(n).plus("...")
        isNotBlank() -> take(n)
        else -> this
    }
}