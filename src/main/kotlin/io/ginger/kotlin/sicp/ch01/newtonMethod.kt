package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/6/4.
 */

val dx = 0.000_001

fun derivative(f: (Double) -> Double): (Double) -> Double = {(f(it + dx) - f(it)) / dx}

fun newtonTransform(f: (Double) -> Double): (Double) -> Double = {it - f(it) / derivative(f)(it)}

fun newtonMethod(f: (Double) -> Double, guess: Double): Double = fixedPoint(newtonTransform(f), guess)

fun sqrtByNewtonMethod(x: Double): Double = newtonMethod({ square(it) - x}, 1.0)

fun fixedPointTransform(f: (Double) -> Double, transform: ((Double)->Double) -> ((Double) -> Double),
                        guess: Double): Double = fixedPoint(transform(f), guess)

fun sqrtByAverageDamp(x: Double): Double = fixedPointTransform({x/it}, ::averageDamp, 1.0)
fun sqrtByNewtonTransform(x: Double): Double = fixedPointTransform({x - square(it)}, ::newtonTransform, 1.0)

fun main(args: Array<String>) {
    println(sqrtByNewtonMethod(2.0))
    println(sqrtByAverageDamp(2.0))
    println(sqrtByNewtonTransform(2.0))
}
