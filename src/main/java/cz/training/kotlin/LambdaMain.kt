package cz.training.kotlin

fun main() {
    val run1: () -> Unit = { //promenna je typu "funkce"
        println("Hello world")
    }
    run1()

    //vnorene funkce povoleny
    fun doSomething(arg1: String, block: () -> Unit) {
        println("hello $arg1")
        block()
    }

    doSomething("hello") {
        println("my function!")
    }

    //StringBuilder.() se rika receiver = meni objekt this na tento SB objekt
    //otaznik na konci = nullable (muze byt null)
    fun doSomething2(sb: StringBuilder, block: (StringBuilder.() -> Unit)? = null) {
        sb.append("hello world sb!")
        if (block != null)
            sb.block()
    }

    val sb = StringBuilder()
    doSomething2(sb) {
        append("hello - lambda!") //append volano na novy this (SB) z definice parametru funkce
    }
    println(sb)
}