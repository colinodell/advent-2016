package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 24")
class Day24Test {
    private val sampleInput = """
        ###########
        #0.1.....2#
        #.#######.#
        #4.......3#
        ###########
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day24(sampleInput).solvePart1()
            assertThat(answer).isEqualTo(14)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart1()
            assertThat(answer).isEqualTo(498)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day24(sampleInput).solvePart2()
            assertThat(answer).isEqualTo(20)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day24(resourceAsListOfString("day24.txt")).solvePart2()
            assertThat(answer).isEqualTo(804)
        }
    }
}
