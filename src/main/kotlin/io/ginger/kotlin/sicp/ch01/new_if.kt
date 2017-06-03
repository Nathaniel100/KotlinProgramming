package io.ginger.kotlin.sicp.ch01

import java.lang.Math.abs

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args: Array<String>) {
    // it will throw StackOverflowError
    fun squareRootByGuess(value: Double, guess: Double): Double {
        fun newIf(predicate: Boolean, thenClause: Double, elseClause: Double): Double {
            when (predicate) {
                true -> return thenClause
                else -> return elseClause
            }
        }

        fun average(value: Double) = value * 0.5

        fun square(value: Double) = value * value

        fun guessIsGood(value: Double, guess: Double) = abs(square(guess) - value) < 1e-6

        fun improveGuess(value: Double, guess: Double) = average(value / guess + guess)

        // squareRootByGuess function as a parameter of newIf, it will be expanded, resulting in an infinite loop
        return newIf((guessIsGood(value, guess)), guess, squareRootByGuess(value, improveGuess(value, guess)))
    }

    fun squareRoot(value: Double) = squareRootByGuess(value, 1.0)

    println(squareRoot(0.0))
    println(squareRoot(2.0))
    println(squareRoot(4.0))
    println(squareRoot(100.0))
    println(squareRoot(10000000000.0))
    println(squareRoot(1e-12))
}
