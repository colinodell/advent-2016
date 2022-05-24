package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 2")
class Day02Test {
    private val sample = listOf(
        "ULL",
        "RRDDD",
        "LURDL",
        "UUUUD",
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day02(sample).solvePart1()
            assertThat(answer).isEqualTo("1985")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart1()
            assertThat(answer).isEqualTo("38961")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day02(sample).solvePart2()
            assertThat(answer).isEqualTo("5DB3")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day02(resourceAsListOfString("day02.txt")).solvePart2()
            assertThat(answer).isEqualTo("46C92")
        }
    }
}