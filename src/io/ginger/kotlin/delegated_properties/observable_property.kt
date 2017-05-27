package io.ginger.kotlin.delegated_properties

import kotlin.properties.Delegates

/**
 * Created by wufan on 2017/5/27.
 */

class User {
    var name : String by Delegates.observable("no name") {
        d, old, new -> println("$old -> $new")
    }
}

fun main(args : Array<String>) {
    val user = User()
    user.name = "Alex"
}
