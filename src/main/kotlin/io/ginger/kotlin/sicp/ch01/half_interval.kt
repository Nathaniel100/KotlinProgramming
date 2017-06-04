package io.ginger.kotlin.sicp.ch01

import java.lang.Math.abs

/**
 * Created by wufan on 2017/6/4.
 */

val tolerance = 0.00001
fun closeEnough(a: Double, b: Double): Boolean {
    return abs(a - b) < tolerance
}

fun search(f: (Double) -> Double, negPoint: Double, posPoint: Double): Double {
    val midPoint = average(negPoint, posPoint)
    if (closeEnough(negPoint, posPoint)) return midPoint
    else {
        val testValue = f(midPoint)
        if (testValue > 0) return search(f, negPoint, midPoint)
        else if (testValue < 0) return search(f, midPoint, posPoint)
        else return midPoint
    }
}

fun halfIntervalMethod(f: (Double) -> Double, a: Double, b: Double): Double {
    val valA = f(a)
    val valB = f(b)
    if (valA < 0 && valB > 0) {
        return search(f, a, b)
    } else if (valA > 0 && valB < 0) {
        return search(f, b, a)
    } else {
        throw IllegalArgumentException("Values are not of oppsite sign $a $b")
    }
}

fun main(args: Array<String>) {
    println(halfIntervalMethod(Math::sin, 2.0, 4.0))
    println(halfIntervalMethod({ it * it * it - 2 * it - 3 }, 1.0, 2.0))
}