package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 21")
class Day21Test {
    private val sampleInstructions = """
        swap position 4 with position 0
        swap letter d with letter b
        reverse positions 0 through 4
        rotate left 1 step
        move position 1 to position 4
        move position 3 to position 0
        rotate based on position of letter b
        rotate based on position of letter d
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day21(sampleInstructions).solvePart1("abcde")).isEqualTo("decab")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart1("abcdefgh")
            assertThat(answer).isEqualTo("dgfaehcb")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day21(sampleInstructions).solvePart2("decab")).isEqualTo("abcde")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day21(resourceAsListOfString("day21.txt")).solvePart2("fbgdceah")
            assertThat(answer).isEqualTo("fdhgacbe")
        }
    }
}
