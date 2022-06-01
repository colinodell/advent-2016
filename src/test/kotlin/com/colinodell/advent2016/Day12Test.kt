package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {
    private val sample = """
        cpy 41 a
        inc a
        inc a
        dec a
        jnz a 2
        dec a
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day12(sample).solvePart1()
            assertThat(answer).isEqualTo(42)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart1()
            assertThat(answer).isEqualTo(318009)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day12(resourceAsListOfString("day12.txt")).solvePart2()
            assertThat(answer).isEqualTo(9227663)
        }
    }
}
