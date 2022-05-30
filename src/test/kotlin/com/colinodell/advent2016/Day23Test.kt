package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 23")
class Day23Test {
    private val sampleInput = """
        cpy 2 a
        tgl a
        tgl a
        tgl a
        cpy 1 a
        dec a
        dec a
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day23(sampleInput).solve(0)
            assertThat(answer).isEqualTo(3)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day23(resourceAsListOfString("day23.txt")).solve(7)
            assertThat(answer).isEqualTo(10584)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day23(resourceAsListOfString("day23.txt")).solve(12)
            assertThat(answer).isEqualTo(479007144)
        }
    }
}