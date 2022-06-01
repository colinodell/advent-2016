package com.colinodell.advent2016

class Day01(private val data: List<String>) {
    fun solvePart1() = followInstructions().last().manhattanDistance()

    fun solvePart2(): Int {
        // Iterate through followInstructions() until the first repeated value is found
        val seen = mutableSetOf<Vector2>()
        for (v in followInstructions()) {
            if (seen.contains(v)) {
                return v.manhattanDistance()
            }
            seen.add(v)
        }

        throw IllegalStateException("No repeated value found")
    }

    private fun followInstructions() = sequence {
        var currentPosition = Vector2(0, 0)
        var currentDirection = 0

        for (instruction in data) {
            val direction = instruction[0]
            val distance = instruction.substring(1).toInt()

            currentDirection = when (direction) {
                'R' -> (currentDirection + 1) % 4
                'L' -> (4 + currentDirection - 1) % 4
                else -> throw IllegalArgumentException("Invalid direction: $direction")
            }

            // Iterate "distance" times
            for (i in 1..distance) {
                currentPosition += when (currentDirection) {
                    0 -> Vector2(0, 1)
                    1 -> Vector2(1, 0)
                    2 -> Vector2(0, -1)
                    3 -> Vector2(-1, 0)
                    else -> throw IllegalArgumentException("Invalid direction: $currentDirection")
                }
                yield(currentPosition)
            }
        }
    }
}
