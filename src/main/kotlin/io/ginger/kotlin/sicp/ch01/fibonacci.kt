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

fun fibFast(n: Long): Long {
    tailrec fun fibFastIter(a: Long, b: Long, p: Long, q: Long, count: Long): Long {
        if(count == 0L) return b
        else if(isEven(count)) return fibFastIter(a, b, q*q + p*p, q*q + 2*p*q, count / 2)
        else return fibFastIter(b*q + a*q + a*p, b*p + a*q, p, q, count - 1)
    }
    return fibFastIter(1, 0, 0, 1, n)
}

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

    println(fibFast(6))
    println(fibFast(20))
    println(fibFast(40))
    println(fibFast(50))
    println(fibFast(100))
}

