package com.design.composechili.extensions

fun String.removeSpaces(): String {
    return this.replace(" ", "")
}