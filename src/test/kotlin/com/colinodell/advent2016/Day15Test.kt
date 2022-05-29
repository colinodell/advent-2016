package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 15")
class Day15Test {
    private val sample = """
        Disc #1 has 5 positions; at time=0, it is at position 4.
        Disc #2 has 2 positions; at time=0, it is at position 1.
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day15(sample).solvePart1()
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day15(resourceAsListOfString("day15.txt")).solvePart1()
            assertThat(answer).isEqualTo(122318)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day15(resourceAsListOfString("day15.txt")).solvePart2()
            assertThat(answer).isEqualTo(3208583)
        }
    }
}