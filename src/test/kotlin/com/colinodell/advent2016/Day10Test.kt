package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()
            assertThat(answer).isEqualTo("bot 181")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()
            assertThat(answer).isEqualTo(12567)
        }
    }
}