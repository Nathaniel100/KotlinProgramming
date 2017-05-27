package io.ginger.kotlin.sicp.ch01

/**
 * Created by wufan on 2017/5/27.
 */

fun p() {
    return p()
}

fun testOrder(x: Int, y: Any) : Int {
    return if (x == 0) 0 else testOrder(x, y)
}

fun main(args : Array<String>) {
    // 如果抛出StackOverflowError异常说明是Applciation order，打印出0说明是Normal order
    println(testOrder(0, p()))
}
