package cz.training.kotlin

import java.math.BigDecimal
import java.time.LocalDate

fun main(args: Array<String>) {
    val array1 = arrayOf("hello","world")
    println(array1)

    for (item in array1) {
        println("item: $item")
    }

    val array2 = intArrayOf(1,2,4,8)
    val array4 = arrayOf(1,2,4,8)

    /*
        V Kotlinu definuji jestli je list vylozene mutable nebo immutable
     */
    val list2 = getSomeList().toMutableList()
    list2.add("hello")

    val set1 = setOf("hello", "world")
    val set2 = mutableSetOf("hello", "world")

    if ("hello" in set1) {
        println("hello in set1")
    }

    val map1 = mapOf(
            "hello" to "world",
            "hello2" to "world2"
    )
    println(map1)

    println(list2[0])
    println(map1["hello"])

    val map2 = mutableMapOf("hello" to "world")
    map2["hello2"] = "test2"
    // map2["hello"] = 1 //expects string
    println(map2)

    if ("hello2" in map2) {
        println("hello2 is in map2")
    }

    val list4 = listOf("hello5", "hello6") + list2
    println(list4)

    val map4 = mapOf("hello4" to "world4") + map2
    println(map4)

    if (map2 == mapOf("hello" to "world", "hello2" to "test2")) {
        println("collections are equal")
    }

    if (LocalDate.of(2022, 1, 1) <
            LocalDate.of(2022, 5, 1)) {
        println("< is true")
    }

    val num1 = BigDecimal(4523)
    println(num1 + 54.2.toBigDecimal())
    println(num1 + 54.toBigDecimal() * 2.toBigDecimal())
}

fun getSomeList() = listOf("Hello", "World")