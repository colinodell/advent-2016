package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class Day19Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day19().solvePart1(5)).isEqualTo(3)
        }

        @Test
        fun `Matches Actual Data`() {
            assertThat(Day19().solvePart1(3004953)).isEqualTo(1815603)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day19().solvePart2(5)).isEqualTo(2)
        }

        @Test
        fun `Matches Actual Data`() {
            assertThat(Day19().solvePart2(3004953)).isEqualTo(1410630)
        }
    }
}
