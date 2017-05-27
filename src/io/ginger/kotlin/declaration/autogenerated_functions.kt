package io.ginger.kotlin.declaration

/**
 * Created by wufan on 2017/5/27.
 */

fun main(args : Array<String>) {
    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser : ${user == secondUser}")
    println("user == thirdUser : ${user == thirdUser}")

    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 2))
    println(user.copy("Max", 2))
}

