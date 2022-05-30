package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 20")
class Day20Test {
    private val sample = """
        5-8
        0-2
        4-7
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day20(sample).solvePart1()).isEqualTo(3)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart1()
            assertThat(answer).isEqualTo(17348574)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day20(resourceAsListOfString("day20.txt")).solvePart2()
            assertThat(answer).isEqualTo(104)
        }
    }
}