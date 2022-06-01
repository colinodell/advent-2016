package com.colinodell.advent2016

class Day20(val input: List<String>) {
    private val firewallRules = optimize(
        input
            .map { it.split("-") }
            .map { LongRange(it[0].toLong(), it[1].toLong()) }
            .sortedBy { it.first }
    )

    fun solvePart1() = firewallRules.first().last.inc()
    fun solvePart2() = 4294967296L - firewallRules.sumOf { (it.last - it.first).inc() }

    // Shamelessly borrowed from https://github.com/tginsberg/advent-2016-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2016/Day20.kt
    private fun optimize(ranges: List<LongRange>): List<LongRange> =
        ranges.drop(1).fold(ranges.take(1)) { carry, next ->
            if (carry.last().overlaps(next)) carry.dropLast(1).plusElement(carry.last().plus(next))
            else carry.plusElement(next)
        }

    private fun LongRange.plus(other: LongRange): LongRange =
        LongRange(this.first.coerceAtMost(other.first), this.last.coerceAtLeast(other.last))

    private fun LongRange.overlaps(other: LongRange) =
        other.first in this || this.last + 1 in other
}
