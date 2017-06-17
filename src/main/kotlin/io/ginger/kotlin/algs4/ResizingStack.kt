package io.ginger.kotlin.algs4

/**
 * Created by wufan on 2017/6/17.
 */

class ResizingStack<T> : Iterable<T>{
    @Suppress("UNCHECKED_CAST")
    var items: Array<T> = Array(8, { Any() }) as Array<T>
    var size: Int = 0

    fun push(item: T) {
        if(size == items.size) {
            resize(2 * size)
        }
        items[size++] = item
    }

    fun pop(): T {
        if(size == 0) {
            throw IllegalStateException("Current stack is empty")
        }
        return items[--size]
    }

    private fun resize(newSize: Int) {
        val oldItems = items
        @Suppress("UNCHECKED_CAST")
        items = Array(newSize, { Any() }) as Array<T>
        System.arraycopy(oldItems, 0, items, 0, size)

    }

    override fun iterator(): Iterator<T> {
        return ReverseIterator(size)
    }

    inner class ReverseIterator(var current: Int) : Iterator<T> {
        override fun hasNext(): Boolean {
            return current > 0
        }

        override fun next(): T {
            return items[--current]
        }
    }
}

fun main(args: Array<String>) {
    val stack = ResizingStack<String>()
    while (!isEmpty()) {
        val s = readString()
        if (s != "-") stack.push(s)
        else if (!s.isEmpty()) print("${stack.pop()} ")
    }
    println("(${stack.size} left on stack)")

    stack.forEach({println(it)})
}
