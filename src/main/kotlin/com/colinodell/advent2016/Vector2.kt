package com.colinodell.advent2016

import kotlin.math.abs

data class Vector2 (val x: Int, val y: Int) {
    operator fun plus(other: Vector2) = Vector2(x + other.x, y + other.y)

    override fun toString() = "($x, $y)"

    fun manhattanDistance() = abs(x) + abs(y)
    fun manhattanDistance(other: Vector2) = abs(x - other.x) + abs(y - other.y)

    fun neighbors() = listOf(
        Vector2(x - 1, y),
        Vector2(x + 1, y),
        Vector2(x, y - 1),
        Vector2(x, y + 1)
    )
}

typealias Grid<T> = Map<Vector2, T>
