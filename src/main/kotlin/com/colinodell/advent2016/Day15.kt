package com.colinodell.advent2016

class Day15(input: List<String>) {
    private val discs = input.map { Disc.fromString(it) }

    fun solvePart1() = solve(false)
    fun solvePart2() = solve(true)

    private fun solve(withExtraDisc: Boolean): Int {
        val discs = if (withExtraDisc) this.discs.plus(Disc(this.discs.size + 1, 11, 0)) else this.discs
        return (0..Int.MAX_VALUE).first { time ->
            discs.all { it.isOpen(time) }
        }
    }

    private data class Disc(val offset: Int, val positions: Int, val initialPosition: Int) {
        fun isOpen(time: Int) = (time + offset + initialPosition) % positions == 0

        companion object {
            fun fromString(s: String): Disc {
                Regex("Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).").matchEntire(s)!!.let {
                    val (offset, positions, initialPosition) = it.groupValues.drop(1).map { it.toInt() }
                    return Disc(offset, positions, initialPosition)
                }
            }
        }
    }
}