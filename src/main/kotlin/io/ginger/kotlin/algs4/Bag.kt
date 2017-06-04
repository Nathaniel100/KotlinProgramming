package io.ginger.kotlin.algs4

/**
 * Created by wufan on 2017/6/4.
 */


class Bag<T> : Iterable<T> {

    private class Node<T>(var data: T, var next: Node<T>?) {
        constructor(item: T) : this(item, null)
    }

    private var first: Node<T>? = null
    private var size: Int = 0

    fun isEmpty(): Boolean = first == null

    fun add(item: T) {
        if (first == null) {
            first = Node(item)
        } else {
            val node = Node(item, first)
            first = node
        }
        size++
    }

    fun getSize() : Int = size

    override fun iterator(): Iterator<T> {
        return BagIterator(first)
    }

    private class BagIterator<T>(var current: Node<T>?) : Iterator<T> {
        override fun hasNext(): Boolean {
            return current != null
        }

        override fun next(): T {
            if (!hasNext()) throw NoSuchElementException()
            val item = current!!.data
            current = current!!.next
            return item
        }
    }
}

fun main(args: Array<String>) {
    val bag = Bag<String>()
    println(bag.getSize())
    println(bag.isEmpty())

    println("After some items")
    bag.add("hello")
    bag.add("world")
    bag.add("kotlin")

    println(bag.isEmpty())
    println(bag.getSize())
    bag.forEach({ println(it) })

    bag.add("java")
    println("After add java")
    println(bag.getSize())
    bag.forEach({ println(it) })
}