package com.colinodell.advent2016

import kotlin.math.abs

data class Vector2 (val x: Int, val y: Int) {
    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)

    override fun toString() = "($x, $y)"

    fun manhattanDistance() = abs(x) + abs(y)
}

typealias Grid<T> = Map<Vector2, T>
