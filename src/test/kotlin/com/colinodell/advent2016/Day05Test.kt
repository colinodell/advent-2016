package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 5")
class Day05Test {
    private val sample = "abc"
    private val puzzleInput = "ffykfhsq"

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day05(sample).solvePart1()
            assertThat(answer).isEqualTo("18f47a30")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day05(puzzleInput).solvePart1()
            assertThat(answer).isEqualTo("c6697b55")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day05(sample).solvePart2()
            assertThat(answer).isEqualTo("05ace8e3")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day05(puzzleInput).solvePart2()
            assertThat(answer).isEqualTo("8c35d1ab")
        }
    }
}