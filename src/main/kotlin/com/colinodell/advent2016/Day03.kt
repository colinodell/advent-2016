package com.colinodell.advent2016

class Day03(private val input: String) {
    fun solvePart1() = parsePart1(input).count { it.isValid() }

    fun solvePart2() = parsePart2(input).count { it.isValid() }

    private fun parseRow(row: String): List<Int> = row.trim().split("\\s+".toRegex()).map { it.toInt() }

    private fun parsePart1(input: String): List<Triangle> {
        return input.split("\n").map { parseRow(it) }.map { Triangle(it[0], it[1], it[2]) }
    }

    private fun parsePart2(input: String): List<Triangle> {
        val rows = input.split("\n").map { parseRow(it) }
        val triangles = mutableListOf<Triangle>()

        for (c in 0..2) {
            for (r in rows.indices step 3) {
                triangles.add(Triangle(rows[r][c], rows[r + 1][c], rows[r + 2][c]))
            }
        }

        return triangles
    }

    private class Triangle(val a: Int, val b: Int, val c: Int) {
        fun isValid() = a + b > c && a + c > b && b + c > a
    }
}
