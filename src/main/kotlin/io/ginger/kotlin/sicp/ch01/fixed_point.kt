package io.ginger.kotlin.sicp.ch01

import java.lang.Math.cos
import java.lang.Math.sin

/**
 * Created by wufan on 2017/6/4.
 */

fun fixedPoint(f: (Double)->Double, firstGuess: Double): Double {
    tailrec fun tryGuess(guess: Double): Double {
        val next = f(guess)
        if(closeEnough(guess, next)) return next
        else return tryGuess(next)
    }
    return tryGuess(firstGuess)
}

fun sqrtByFixedPoint(x: Double): Double = fixedPoint({average(x / it, it)}, 1.0)

fun sqrtByFixedPoint2(x: Double): Double = fixedPoint(averageDamp { x / it }, 1.0)

fun square(x: Double): Double  = x * x

fun cubeRoot(x: Double): Double = fixedPoint(averageDamp { x / square(it) }, 1.0)



fun main(args: Array<String>) {
    println(fixedPoint(Math::cos, 1.0))
    println(fixedPoint({sin(it) + cos(it)}, 1.0))
    println(sqrtByFixedPoint(2.0))
    println(sqrtByFixedPoint2(2.0))
    println(fixedPoint({1 + 1/it}, 1.0))
    println(cubeRoot(5.0))
}