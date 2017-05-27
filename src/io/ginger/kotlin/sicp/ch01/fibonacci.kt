package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/5/27.
 */

// 0 1 1 2 3 5 8 13 21

fun fibR(n: Long): Long {
    when (n) {
        0L -> return 0L
        1L -> return 1L
        else -> return fibR(n - 1) + fibR(n - 2)
    }
}

fun fibI(n: Long): Long {
    tailrec fun fibIter(n: Long, counter: Long, a: Long, b: Long): Long {
        if (counter == n) return a
        else return fibIter(n, counter + 1, b, a + b)
    }
    return fibIter(n, 0, 0, 1)
}

// todo faster method

fun main(args: Array<String>) {
    println(fibR(6))
    println(fibR(20))
    println(fibR(40))
    // too slow
    //println(fibR(50))

    println(fibI(6))
    println(fibI(20))
    println(fibI(40))
    println(fibI(50))
    println(fibI(100))
}

