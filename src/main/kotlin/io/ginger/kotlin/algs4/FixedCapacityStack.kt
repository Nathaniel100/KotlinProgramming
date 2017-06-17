package io.ginger.kotlin.algs4

/**
 * Created by wufan on 2017/6/8.
 */
class FixedCapacityStack<T>(cap: Int) : Iterable<T> {
    @Suppress("UNCHECKED_CAST")
    private val a: Array<T> = Array(cap, { Any() }) as Array<T>
    var size: Int = 0
        get() = field

    fun push(item: T) {
        if (size == a.size) {
            throw IndexOutOfBoundsException()
        }
        a[size++] = item
    }

    fun pop(): T {
        if (size == 0) {
            throw IndexOutOfBoundsException()
        }
        return a[--size]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun iterator(): Iterator<T> {
        return FixedCapacityStackIterator(size)
    }

    private inner class FixedCapacityStackIterator(var current: Int): Iterator<T> {

        override fun hasNext(): Boolean {
            return current != 0
        }

        override fun next(): T {
            return a[--current]
        }

    }

}

fun main(args: Array<String>) {
    val stack = FixedCapacityStack<String>(100)
    while (!isEmpty()) {
        val s = readString()
        if (s != "-") stack.push(s)
        else if (!s.isEmpty()) print("${stack.pop()} ")
    }
    println("(${stack.size} left on stack)")

    stack.forEach({println(it)})
}