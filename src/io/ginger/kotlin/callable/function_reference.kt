package io.ginger.kotlin.callable

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args : Array<String>) {
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))
}

fun isOdd(x : Int) = x % 2 != 0
