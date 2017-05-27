package io.ginger.kotlin.delegated_properties

/**
 * Created by wufan on 2017/5/27.
 */

class LazySample {
    val lazy : String by lazy { println("computed"); "my lazy" }
}

fun main(args : Array<String>) {
    val sample = LazySample()
    println("lazy = ${sample.lazy}")
    println("lazy = ${sample.lazy}")
}
