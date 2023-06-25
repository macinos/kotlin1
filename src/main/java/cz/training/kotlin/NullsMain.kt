package cz.training.kotlin

fun main() {
    var str1: String = "Hello"
//    str1 = null
    var str2: String? = "Hello"
    str2 = null
//    println(str2!!.trim()) // Throws nullpointer
    println(str2?.trim())
    println(str2?.trim() ?: "dsda")

   /*val p1 = Person(
            lastName = "Doe"
    )

    println(p1)*/

    // smart cast
    var str4: String?
    str4 = "Hello"
    str4 = null
    println(str4?.trim())

    // Platform types
    // String!
    // public String! getString() {...}
    // val str8: String! = "hello"

}