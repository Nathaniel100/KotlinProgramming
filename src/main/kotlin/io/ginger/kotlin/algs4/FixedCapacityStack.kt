package io.ginger.kotlin.algs4

/**
 * Created by wufan on 2017/6/8.
 */
class FixedCapacityStack<T>(cap: Int) {
    @Suppress("UNCHECKED_CAST")
    private val a: Array<T> = Array(cap, {Any()}) as Array<T>
    var size: Int = 0
        get() = field

    fun push(item: T) {
        if(size == a.size) {
            throw IndexOutOfBoundsException()
        }
        a[size++] = item
    }

    fun pop(): T {
        if(size == 0) {
            throw IndexOutOfBoundsException()
        }
        return a[--size]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }
}

fun main(args: Array<String>) {
    val stack = FixedCapacityStack<String>(100)
    val stdin = StdIn()
    while(!stdin.isEmpty()) {
        val s = stdin.readString()
        if(s != "-") stack.push(s)
        else if(!s.isEmpty()) print("${stack.pop()} ")
    }
    println("(${stack.size} left on stack)")
}