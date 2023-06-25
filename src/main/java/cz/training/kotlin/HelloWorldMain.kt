package cz.training.kotlin

import java.time.LocalDate
import java.util.*

/*
 Kotlin source -> Kotlin compiler -> Java Bytecode
*/

fun main(args: Array<String>) {
    println(LocalDate.now())
    println("Hello World, Kotlin is here!")
    println(add1(1, 5))

    /*
     val - readonly: preferovat, pokud chci zabranit nechtenym modifikacim
     var - prepisovatelna (r/w) promenna
     */
    val val1 = add1(1, 5)
    println(val1)

    var var1 = add1(1, 5)
    var1++
    println(var1)

    var var2: Int
    var2 = 121123
    var2 = 5123

    val val2: Int
    println("hello world!")
    val2 = 6312
    println(val2)

    val date1 = Date()
    val date2 = Date(0)
    println(date1.toInstant())

    val val4 = if (var1 > 5)
        100
    else
        200

    var1 = 200
    when (var1) { //switch, bez breaku
        100 -> println("var is 100")
        5 -> println("var is 5")
        10 -> println("var is 10")
        20,40 -> println("var is 20,40")
        in listOf(100,200,400,600) -> println("is in list")
        !in listOf(100,200,400,600) -> println("is in list")
        in 900 .. 950 -> println("between 900 .. 950") // je to lazy nealokuje se pole pro x hodnot, ale on demand
        else -> println("it's something else")
    }

    var varAny: Any = 500
    when (varAny) {
        is Int -> println("is Int")
        is Long -> println("is Long")
        is String -> println("is String")
    }

    when {
        var1 == 500 -> println("var is 500")
        varAny is Long -> println("varAny is Long")
        date1.toInstant().epochSecond > 5 -> println("epoch sec more than 5")
    }

    when (val instant = date1.toInstant()) {
        null -> println("is null")
        else -> println("hello " + instant.epochSecond)
    }

    val val8 = when (var1) {
        5 -> 0
        10 -> 1
        else -> 2
    }

    //CYKLY
    var1 = 5
    while (var1-- > 0) {
        println("var1 is " + var1)
    }

    val list1 = listOf("Test 1", "Test 2", "Test 4", "Test 8")
    for (item in list1) {
        println(item)
    }

    for (x in 1..5) {
        println("x = " + x)
    }

    for (x in 1 until 5) {
        println("x = " + x)
    }

    for (x in 10 downTo 1 step 2) { //od desiti k jedne po dvou
        println("x = " + x)
    }

    val str1 = "Hello"
    if (str1 == "Hello") { // == je volani equals, === jsou == v Jave
        println("str1 is Hello")
    }

    if (str1.equals("hello", ignoreCase = true)) {
        println("str1 is Hello")
    }
    println("Hello world: $str1")
    println("Hello world: ${str1}world")

    println("Hello: ${str1.lowercase()}")
    println("Hello: ${(val1 + 5) * 5}")
    println("Hello: ${
        (val1 + 5) * 5
    } - test")

    println("""
        Hello world!
        
        This is a kotlin program.
        It's running on JVM.
        ${'$'}{(val1 + 5)
    """.trimIndent())
}

fun add1(a: Int, b: Int): Int {
    return a + b
}



