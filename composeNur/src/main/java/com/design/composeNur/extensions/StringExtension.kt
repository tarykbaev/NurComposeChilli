package com.design.composeNur.extensions

fun String.removeSpaces(): String {
    return this.replace(" ", "")
}