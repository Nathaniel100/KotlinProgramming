package io.ginger.kotlin.sicp.ch01

import io.ginger.kotlin.tool.StopWatcher

/**
 * Created by wufan on 2017/5/27.
 */

fun factorialR(n: Long): Long = if (n == 0L || n == 1L) 1L else n * factorialR(n - 1)

fun factorialI(n: Long): Long {
    tailrec fun factorialIter(n: Long, product: Long, counter: Long): Long {
        return if (counter > n) product else factorialIter(n, product * counter, counter + 1)
    }
    return factorialIter(n, 1L, 1L)
}

fun main(args: Array<String>) {
    println(factorialR(6L))
    println(factorialR(10L))
    println(factorialR(20L))
    println(factorialR(30L))

    println(factorialI(6L))
    println(factorialI(10L))
    println(factorialI(20L))
    println(factorialI(30L))

    val COUNT : Int = 10000

    val watcher = StopWatcher()
    for(i in 1..COUNT) {
        factorialR(20)
    }
    println("factorialR(20) $COUNT times costs ${watcher.elapsedUs()} us")

    watcher.reset()
    for(i in 1..COUNT) {
        factorialI(20)
    }
    println("factorialI(20) $COUNT times costs ${watcher.elapsedUs()} us")
}
