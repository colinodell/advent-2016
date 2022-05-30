package com.colinodell.advent2016

class Day13 (private val input: Int) {
    fun solvePart1(target: Vector2) = AStar(Vector2(1, 1), target, ::calculateOpenSpaces, { it.manhattanDistance(target) }).distance

    fun solvePart2() = AStar(Vector2(1, 1), Vector2(-1, -1), ::calculateOpenSpaces, {0}, 50).seen.size

    private fun calculateOpenSpaces(current: Vector2): Sequence<Vector2> {
        return current.neighbors().filter {
            if (it.x < 0 || it.y < 0) return@filter false

            val number = (it.x * it.x) + (3 * it.x) + (2 * it.x * it.y) + (it.y) + (it.y * it.y) + input
            Integer.toBinaryString(number).count { it == '1' } % 2 == 0
        }.asSequence()
    }
}