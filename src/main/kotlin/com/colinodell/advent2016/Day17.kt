package com.colinodell.advent2016

class Day17(private val input: String) {
    private val start = State(Vector2(0, 0))
    private val reachedGoal: (State) -> Boolean = { it.pos == Vector2(3, 3) }

    fun solvePart1() = AStar(start, reachedGoal, ::generateNextMoves).end!!.path
    fun solvePart2() = DFS_all(start, reachedGoal, ::generateNextMoves).maxOf { it.path.length }

    private val possibleMoves = linkedMapOf(
        'U' to Vector2(0, -1),
        'D' to Vector2(0, 1),
        'L' to Vector2(-1, 0),
        'R' to Vector2(1, 0)
    )

    private fun generateNextMoves(current: State): Sequence<State> {
        val hash = md5(input + current.path)
        val allowedDirs = possibleMoves.keys.filterIndexed { i, _ -> hash[i] in "bcdef" }
        val nextMoves = allowedDirs.map { State(current.pos + possibleMoves[it]!!, current.path + it) }.filter { it.pos.x in 0..3 && it.pos.y in 0..3 }
        return nextMoves.asSequence()
    }

    private data class State (val pos: Vector2, val path: String = "")
}