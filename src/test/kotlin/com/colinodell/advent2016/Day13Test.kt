package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {
    private val sampleInput = 10
    private val sampleTarget = Vector2(7, 4)

    private val actualInput = 1350
    private val actualTarget = Vector2(31, 39)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day13(sampleInput).solvePart1(sampleTarget)
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day13(actualInput).solvePart1(actualTarget)
            assertThat(answer).isEqualTo(92)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day13(actualInput).solvePart2()
            assertThat(answer).isEqualTo(124)
        }
    }
}
