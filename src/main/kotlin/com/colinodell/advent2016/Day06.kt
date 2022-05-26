package com.colinodell.advent2016

class Day06(private val input: List<String>) {
    fun solvePart1(): String = inputAsColumns()
        .map { it.groupBy { it }.maxByOrNull { it.value.size }!!.key }
        .joinToString(separator = "")

    fun solvePart2(): String = inputAsColumns()
        .map { it.groupBy { it }.minByOrNull { it.value.size }!!.key }
        .joinToString(separator = "")

    private fun inputAsColumns() = (0 until input[0].length).map { i -> input.map { it[i] } }
}
