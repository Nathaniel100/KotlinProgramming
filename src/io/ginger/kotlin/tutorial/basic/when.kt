package io.ginger.kotlin.tutorial.basic

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args : Array<String>) {
    cases(1)
    cases("Hello")
    cases(2L)
    cases(1.0f)
    cases("K")
}

fun cases(obj : Any) {
    when(obj) {
        1 -> println("one")
        "Hello" -> println("Greeting")
        is Long -> println("Long")
        !is String -> println("Not a string")
        else -> println("unknown")
    }
}
