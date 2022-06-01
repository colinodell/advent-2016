package com.colinodell.advent2016

class Day22(input: List<String>) {
    private val nodes = input.drop(2).map { Node.parse(it) }

    fun solvePart1() = nodes.permutationPairs().includingReversePairs().filter { it.first.used > 0 && it.first.used < it.second.avail }.count()
    fun solvePart2(): Int {
        val xMax = nodes.maxOf { it.pos.x }
        val hole = nodes.first { it.used == 0 }
        val wallStart = nodes.filter { it.size > 250 }.minByOrNull { it.pos.x }!!

        return listOf(
            hole.pos.manhattanDistance(wallStart.pos), // empty node to wall
            hole.pos.y, // up to the top
            (xMax - wallStart.pos.x), // over to the goal
            (5 * (xMax - 1)) // from the goal back to the start
        ).sum()
    }

    private data class Node(val pos: Vector2, val size: Int, val used: Int, val avail: Int) {
        companion object {
            private val re = Regex("""/dev/grid/node-x(\d+)-y(\d+)\s+(\d+)T\s+(\d+)T\s+(\d+)T""")
            fun parse(line: String): Node {
                val (x, y, size, used, avail) = re.find(line)!!.groupValues.drop(1).map { it.toInt() }
                return Node(Vector2(x, y), size, used, avail)
            }
        }
    }
}
