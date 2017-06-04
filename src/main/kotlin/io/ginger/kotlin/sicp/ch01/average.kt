package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/6/4.
 */

fun average(value: Double) = value * 0.5

fun average(a: Double, b: Double): Double = (a + b) * 0.5

fun average(a: Int, b: Int): Double = (a + b) * 0.5

fun averageDamp(f: (Double) -> Double): (Double) -> Double =  { average(it, f(it)) }
