package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 14")
class Day14Test {
    private val sampleSalt = "abc"
    private val actualSalt = "qzyelonm"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day14(sampleSalt).solvePart1()
            assertThat(answer).isEqualTo(22728)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day14(actualSalt).solvePart1()
            assertThat(answer).isEqualTo(15168)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day14(sampleSalt).solvePart2()
            assertThat(answer).isEqualTo(22551)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day14(actualSalt).solvePart2()
            assertThat(answer).isEqualTo(20864)
        }
    }
}