package io.ginger.kotlin.algs4

import java.io.BufferedInputStream
import java.util.*
import java.util.regex.Pattern

/**
 * Created by wufan on 2017/6/4.
 */
val EMPTY_STRING = String()
private val CHARSET_NAME = "UTF-8"
private val WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+")
private val EMPTY_PATTERN = Pattern.compile("")
private val EVERYTHING_PATTERN = Pattern.compile("\\A")


private val scanner: Scanner = Scanner(BufferedInputStream(System.`in`), CHARSET_NAME)

fun isEmpty(): Boolean = !scanner.hasNext()

fun hasNextLine(): Boolean = scanner.hasNextLine()

fun hasNextChar(): Boolean {
    scanner.useDelimiter(EMPTY_PATTERN)
    val result = scanner.hasNext()
    scanner.useDelimiter(WHITESPACE_PATTERN)
    return result
}

fun readLine(): String {
    try {
        return scanner.nextLine()
    } catch (e: NoSuchElementException) {
        return EMPTY_STRING
    }
}

fun readChar(): Char {
    scanner.useDelimiter(EMPTY_PATTERN)
    val ch = scanner.next()
    assert(ch.length == 1, { "Internal Error: readChar" })
    scanner.useDelimiter(WHITESPACE_PATTERN)
    return ch[0]
}

fun readAll(): String {
    if (!hasNextLine()) return EMPTY_STRING
    val result = scanner.useDelimiter(EVERYTHING_PATTERN).next()
    scanner.useDelimiter(WHITESPACE_PATTERN)
    return result
}

fun readString(): String = scanner.next()

fun readInt(): Int = scanner.nextInt()

fun readDouble(): Double = scanner.nextDouble()

fun readFloat(): Float = scanner.nextFloat()

fun readLong(): Long = scanner.nextLong()

fun readShort(): Short = scanner.nextShort()

fun readByte(): Byte = scanner.nextByte()

fun readBoolean(): Boolean {
    val s: String = readString()
    if (s.equals("true", true)) return true
    else if (s.equals("false", true)) return false
    else if (s == "1") return true
    else if (s == "0") return false
    throw InputMismatchException()
}

fun readAllStrings(): Array<String> {
    val tokens = WHITESPACE_PATTERN.split(readAll())
    if (tokens.isEmpty() || tokens[0].isNotEmpty()) {
        return tokens
    }

    return tokens.copyOfRange(1, tokens.size - 1)
}

fun readAllLines(): Array<String> {
    val lines = MutableList(0, { "" })
    while (hasNextLine()) {
        lines.add(readLine())
    }
    return lines.toTypedArray()
}

fun readAllInts(): IntArray {
    return readAllStrings().map { it.toInt() }.toIntArray()
}

fun readAllLongs(): LongArray {
    return readAllStrings().map { it.toLong() }.toLongArray()
}

fun readAllDoubles(): DoubleArray {
    return readAllStrings().map { it.toDouble() }.toDoubleArray()
}

fun main(args: Array<String>) {
    val ints: IntArray = readAllInts()
    ints.forEach { print("$it ") }
}

/******************************************************************************
 *  Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 *
 *  This file is part of algs4.jar, which accompanies the textbook
 *
 *      Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne,
 *      Addison-Wesley Professional, 2011, ISBN 0-321-57351-X.
 *      http://algs4.cs.princeton.edu
 *
 *
 *  algs4.jar is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  algs4.jar is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with algs4.jar.  If not, see http://www.gnu.org/licenses.
 ******************************************************************************/