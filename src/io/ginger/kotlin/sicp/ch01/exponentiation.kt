package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/5/31.
 */

fun isEven(value: Long): Boolean {
    return value % 2L == 0L
}

fun square(value: Long): Long {
    return value * value
}

// b^n = b*b^n-1  b^0 = 1
// O(n)
fun expt(b: Long, n: Long): Long {
    if (n == 0L) return 1L
    else return b * expt(b, n - 1)
}

fun exptI(b: Long, n: Long): Long {
    tailrec fun exptIter(b: Long, n: Long, result: Long): Long {
        if(n == 0L) return result
        else return exptIter(b, n - 1, result * b)
    }
    return exptIter(b, n, 1L)
}

// b^n = (b^(n/2))^2 = (b^2)^(n/2) if n is even
// b^n = b*b^n-1 if n is odd
// b^0 = 1
fun exptFast(b: Long, n: Long): Long {
    if (n == 0L) return 1L
    else if (isEven(n)) return square(exptFast(b, n / 2))
    else return b * exptFast(b, n - 1)
}

fun exptFastI(b: Long, n: Long): Long {
    tailrec fun exptFastIter(b: Long, n: Long, result: Long): Long {
        if(n == 0L) return result
        else if(isEven(n)) return exptFastIter(b * b, n / 2, result)
        else return exptFastIter(b, n - 1, b * result)
    }
    return exptFastIter(b, n, 1L)
}

fun main(args: Array<String>) {
    println(expt(2, 3))
    println(expt(2, 5))
    println(expt(2, 10))
    println(expt(2, 20))
    println(expt(2, 30))
    println(expt(2, 32))

    println(exptI(2, 3))
    println(exptI(2, 5))
    println(exptI(2, 10))
    println(exptI(2, 20))
    println(exptI(2, 30))
    println(exptI(2, 32))

    println(exptFast(2, 3))
    println(exptFast(2, 5))
    println(exptFast(2, 10))
    println(exptFast(2, 20))
    println(exptFast(2, 30))
    println(exptFast(2, 32))

    println(exptFastI(2, 3))
    println(exptFastI(2, 5))
    println(exptFastI(2, 10))
    println(exptFastI(2, 20))
    println(exptFastI(2, 30))
    println(exptFastI(2, 32))
}
