package cz.training.kotlin

fun main() {
    println("Hello world".toMyPrefixedString())
}

private fun String.toMyPrefixedString(): String? =
    "prefix: $this"
