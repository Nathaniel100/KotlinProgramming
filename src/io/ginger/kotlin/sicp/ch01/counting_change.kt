package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/5/31.
 */

// Example:
// $1 = 100 cents
// changes: 50 25 10 5 1

fun firstDenomination(kindsOfCoins: Int): Int {
    when (kindsOfCoins) {
        1 -> return 1
        2 -> return 5
        3 -> return 10
        4 -> return 25
        5 -> return 50
    }
    throw IllegalArgumentException()
}

// Recursive
fun countChange(total: Int): Int {
    fun cc(total: Int, kindsOfCoins: Int): Int {
        if (total == 0) return 1
        else if (total < 0 || kindsOfCoins == 0) return 0
        else return cc(total - firstDenomination(kindsOfCoins), kindsOfCoins) +
                cc(total, kindsOfCoins - 1)
    }
    return cc(total, 5)
}

// TODO how to make it iterative
// Iterative
fun countChangeI(total: Int): Int {
    // as a cache
    val dimens: Array<IntArray> = Array(total + 1, { _ -> IntArray(6, { _ -> -1 }) })
    fun cc(total: Int, kindsOfCoins: Int): Int {
        if (total == 0) return 1
        else if (total < 0 || kindsOfCoins == 0) return 0
        else if (dimens[total][kindsOfCoins] != -1) return dimens[total][kindsOfCoins]
        else {
            dimens[total][kindsOfCoins] = cc(total - firstDenomination(kindsOfCoins), kindsOfCoins) +
                    cc(total, kindsOfCoins - 1)
            return dimens[total][kindsOfCoins]
        }
    }
    return cc(total, 5)
}


fun main(args: Array<String>) {
    println(countChange(100))
    println(countChange(500))
    println(countChange(1000)) // slow

    println(countChangeI(100))
    println(countChangeI(500))
    println(countChangeI(1000))
    println(countChangeI(2000))
    println(countChangeI(50000))
}