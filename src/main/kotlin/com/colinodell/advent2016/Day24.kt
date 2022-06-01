package com.colinodell.advent2016

class Day24(input: List<String>) {
    private val layout = input.toGrid()
    private val requiredLocations = layout.filter { it.value.isDigit() }.keys
    private val start = layout.filter { it.value == '0' }.keys.first()

    fun solvePart1() = solve { state: State -> state.seen.containsAll(requiredLocations) }
    fun solvePart2() = solve { state: State -> state.seen.containsAll(requiredLocations) && state.pos == start }

    private fun solve(reachedGoal: (State) -> Boolean) =
        AStar(State(start, setOf(start)), reachedGoal, { state: State -> state.generateNextMoves(layout) }).distance

    private data class State(val pos: Vector2, val seen: Set<Vector2> = emptySet()) {
        fun generateNextMoves(layout: Grid<Char>) =
            pos.neighbors().associateWith { layout[it] }.filter { it.value != '#' && it.value != null }.map {
                if (it.value?.isDigit() == true) {
                    State(it.key, seen.plus(it.key))
                } else {
                    State(it.key, seen)
                }
            }.asSequence()
    }
}
