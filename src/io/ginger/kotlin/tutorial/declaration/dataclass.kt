package io.ginger.kotlin.tutorial.declaration

/**
 * Created by wufan on 2017/5/27.
 */


fun getUser(): User {
    return User("Alex", 1)
}

fun main(args : Array<String>) {
    val user = getUser()
    println("name = ${user.name} id = ${user.id}")

    val (name, id) = getUser()
    println("name = $name id = $id")

    println("name = ${getUser().component1()} id = ${getUser().component2()}")
}