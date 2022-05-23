package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 1")
class Day01Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day01(listOf("R5", "L5", "R5", "R3")).solvePart1()
            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day01(resourceAsListOfString("day01.txt", ", ")).solvePart1()
            assertThat(answer).isEqualTo(253)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day01(listOf("R8", "R4", "R4", "R8")).solvePart2()
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day01(resourceAsListOfString("day01.txt", ", ")).solvePart2()
            assertThat(answer).isEqualTo(126)
        }
    }
}