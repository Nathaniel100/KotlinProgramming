package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/5/31.
 */

tailrec fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    else if (a < b) return gcd(b, a)
    else return gcd(b, a % b)
}

fun main(args: Array<String>) {
    println(gcd(100, 40))
    println(gcd(30, 40))
    println(gcd(24, 40))
    println(gcd(80, 40))
}
