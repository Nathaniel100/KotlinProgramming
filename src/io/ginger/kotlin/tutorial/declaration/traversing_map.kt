package io.ginger.kotlin.tutorial.declaration

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args : Array<String>) {
    val map = hashMapOf<String, Int>()
    map["one"] = 1
    map["two"] = 2
    //or
    map.put("three", 3)
    map.put("four", 4)

    for((k, v) in map) {
        println("key = $k value = $v")
    }
    println(map)
}