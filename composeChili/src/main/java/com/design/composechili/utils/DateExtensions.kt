package com.design.composechili.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.formatByRegex(regex: String): String {
    return SimpleDateFormat(regex, Locale.getDefault()).format(this)
}