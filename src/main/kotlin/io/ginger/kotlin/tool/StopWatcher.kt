package io.ginger.kotlin.tool

/**
 * Created by wufan on 2017/5/27.
 */

class StopWatcher {
    var current: Long
    init {
        current = System.nanoTime()
    }

    fun elapsedMs() : Long {
        val pre = current
        current = System.nanoTime()
        return (current - pre) / 1000000
    }

    fun elapsedUs() : Long {
        val pre = current
        current = System.nanoTime()
        return (current - pre) / 1000
    }

    fun elapsedNs() : Long {
        val pre = current
        current = System.nanoTime()
        return (current - pre)
    }

    fun reset() {
        current = System.nanoTime()
    }
}
