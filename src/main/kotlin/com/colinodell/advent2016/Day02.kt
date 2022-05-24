package com.colinodell.advent2016

class Day02(private val instructions: List<String>) {
    fun solvePart1(): String = getCode(instructions, partA)
    fun solvePart2(): String = getCode(instructions, partB)

    private val movements = mapOf(
        'U' to Vector2(0, -1),
        'D' to Vector2(0, 1),
        'L' to Vector2(-1, 0),
        'R' to Vector2(1, 0),
    )

    private val partA: Grid<Char> = mapOf(
        Vector2(0, 0) to '1',
        Vector2(1, 0) to '2',
        Vector2(2, 0) to '3',
        Vector2(0, 1) to '4',
        Vector2(1, 1) to '5',
        Vector2(2, 1) to '6',
        Vector2(0, 2) to '7',
        Vector2(1, 2) to '8',
        Vector2(2, 2) to '9',
    )

    private val partB: Grid<Char> = mapOf(
        Vector2(2, 0) to '1',
        Vector2(1, 1) to '2',
        Vector2(2, 1) to '3',
        Vector2(3, 1) to '4',
        Vector2(0, 2) to '5',
        Vector2(1, 2) to '6',
        Vector2(2, 2) to '7',
        Vector2(3, 2) to '8',
        Vector2(4, 2) to '9',
        Vector2(1, 3) to 'A',
        Vector2(2, 3) to 'B',
        Vector2(3, 3) to 'C',
        Vector2(2, 4) to 'D',
    )

    private fun getCode(instructions: List<String>, keypad: Grid<Char>): String {
        var pos = keypad.entries.find { it.value == '5' }!!.key
        var code = ""
        instructions.forEach { line ->
            line.forEach { char ->
                val nextPosition = pos + movements[char]!!
                if (keypad.containsKey(nextPosition)) {
                    pos = nextPosition
                }
            }

            code += keypad[pos]
        }

        return code
    }
}