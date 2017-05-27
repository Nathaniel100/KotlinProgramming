package io.ginger.kotlin.sicp.ch01

import java.lang.Math.abs

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args: Array<String>) {
    // This is a tai recursion function
    tailrec fun squareRootByGuess(value: Double, guess: Double): Double {
        fun average(value: Double) = value * 0.5

        fun square(value: Double) = value * value

        fun improveGuess(value: Double, guess: Double) = average(value / guess + guess)

        //
        //This is not good for small and large numbers
        //fun guessIsGood(value: Double, guess: Double) = abs(square(guess) - value) < 1e-6
        //

        fun guessIsGood(value: Double, guess: Double) = abs(guess - improveGuess(value, guess)) < 1e-6

        return if (guessIsGood(value, guess)) guess else squareRootByGuess(value, improveGuess(value, guess))
    }

    fun squareRoot(value: Double) = squareRootByGuess(value, 1.0)

    println(squareRoot(0.0))
    println(squareRoot(2.0))
    println(squareRoot(4.0))
    println(squareRoot(100.0))
    println(squareRoot(10000000000.0))
    println(squareRoot(1e36))
    println(squareRoot(1e-36))
}
