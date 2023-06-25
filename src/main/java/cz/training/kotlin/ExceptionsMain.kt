package cz.training.kotlin

import java.io.IOException

class MyException : Exception {
    constructor() : super()
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}

fun throwMyException() {
    throw MyException("hello")
}

@Throws(exceptionClasses = [IOException::class]) //pro kompatibilitu s Javou
fun throwIoException() {
    throw IOException()
}

fun main() {
    try {
        throwMyException()
    } catch (e: MyException) {
        println("my exception!")
        e.printStackTrace()
    } finally {

    }
}