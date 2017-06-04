package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/6/4.
 */

fun <T, R> sum(term: (T) -> R, a: T, next: (T) -> T, b: T, initial: R,
               compare: (T, T) -> Int, plus: (R, R) -> R): R {
    if (compare(a, b) > 0) return initial
    else return plus(term(a), sum(term, next(a), next, b, initial, compare, plus))
}

fun <T, R> sumI(term: (T) -> R, a: T, next: (T) -> T, b: T, initial: R,
               compare: (T, T) -> Int, plus: (R, R) -> R): R {
    tailrec fun sumIter(counter: T, result: R): R {
        if (compare(counter, b) > 0) return result
        else return sumIter(next(counter), plus(result, term(counter)))

    }
    return sumIter(a, initial)
}


fun sumCubes(a: Int, b: Int): Int = sum(
        { it -> it * it * it }, a, { it -> it + 1 }, b,
        0, Int::compareTo, { x, y -> x + y }
)

fun sumIntegers(a: Int, b: Int): Int = sum(
        { it -> it }, a, { it -> it + 1 }, b,
        0, Int::compareTo, { x, y -> x + y }
)

fun piSum(a: Int, b: Int): Double = sum(
        { it -> 1.0 / (it * (it + 2)) }, a, { it -> it + 4 }, b,
        0.0, Int::compareTo, { x, y -> x + y }
)

fun integral(f: (Double) -> Double, a: Int, b: Int, dx: Double): Double =
        dx * sum(f, (a + dx / 2), { it -> it + dx }, b.toDouble(),
                0.0, Double::compareTo, { x, y -> x + y })

fun sumCubesI(a: Int, b: Int): Int = sumI(
        { it -> it * it * it }, a, { it -> it + 1 }, b,
        0, Int::compareTo, { x, y -> x + y }
)

fun sumIntegersI(a: Int, b: Int): Int = sumI(
        { it -> it }, a, { it -> it + 1 }, b,
        0, Int::compareTo, { x, y -> x + y }
)

fun piSumI(a: Int, b: Int): Double = sumI(
        { it -> 1.0 / (it * (it + 2)) }, a, { it -> it + 4 }, b,
        0.0, Int::compareTo, { x, y -> x + y }
)

fun integralI(f: (Double) -> Double, a: Int, b: Int, dx: Double): Double =
        dx * sumI(f, (a + dx / 2), { it -> it + dx }, b.toDouble(),
                0.0, Double::compareTo, { x, y -> x + y })

fun main(args: Array<String>) {
    println(sumCubes(1, 10))
    println(sumIntegers(1, 10))
    println(8 * piSum(1, 10000))
    println(integral({it -> it * it * it}, 0, 1, 0.001))

    println(sumCubesI(1, 10))
    println(sumIntegersI(1, 10))
    println(8 * piSumI(1, 10000))
    println(integralI({it -> it * it * it}, 0, 1, 0.001))
}

