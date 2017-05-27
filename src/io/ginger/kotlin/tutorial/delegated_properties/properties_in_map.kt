package io.ginger.kotlin.tutorial.delegated_properties

/**
 * Created by wufan on 2017/5/27.
 */

class User3(val map : Map<String, Any?>) {
    val name : String by map
    val age : Int by map
}

fun main(args : Array<String>) {
    val user = User3(mapOf(
            "name" to "John Doe",
            "age" to 25
    ))

    println("name = ${user.name}, age = ${user.age}")
}
