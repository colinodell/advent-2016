package com.colinodell.advent2016

import kotlin.math.absoluteValue

class Day01(private val data: List<String>) {
    fun solvePart1(): Int {
        val distances = IntArray(4) { 0 }
        var currentDirection = 0;

        for (instruction in data) {
            val direction = instruction[0]
            val distance = instruction.substring(1).toInt()

            val newDirection = when (direction) {
                'R' -> (currentDirection + 1) % 4
                'L' -> (4 + currentDirection - 1) % 4
                else -> throw IllegalArgumentException("Invalid direction: $direction")
            }

            distances[newDirection] += distance
            currentDirection = newDirection
        }

        return distances[0] - distances[2] + distances[1] - distances[3]
    }
}