package io.ginger.kotlin.delegated_properties

import kotlin.properties.Delegates

/**
 * Created by wufan on 2017/5/27.
 */

class User2 {
    var name : String by Delegates.notNull()

    fun init(name : String) {
        this.name = name
    }
}

fun main(args : Array<String>) {
    val user = User2()
    // user.name -> IllegalStateException
    //println(user.name)
    user.init("Carl")
    println(user.name)
}
