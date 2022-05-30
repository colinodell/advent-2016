package com.colinodell.advent2016

class Day18 (startingRow: String) {
    fun solve(rowCount: Int) = dungeon.map { it.count { it == '.' } }.take(rowCount).sum()

    private val dungeon = generateSequence(startingRow) { previousRow ->
        previousRow.indices.map { i ->
            val left = previousRow.getOrNull(i - 1) ?: '.'
            val right = previousRow.getOrNull(i + 1) ?: '.'
            if (left == right) '.' else '^'
        }.joinToString("")
    }
}