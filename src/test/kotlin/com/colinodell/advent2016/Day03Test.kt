package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 3")
class Day03Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart1()
            assertThat(answer).isEqualTo(1032)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day03(resourceAsText("day03.txt")).solvePart2()
            assertThat(answer).isEqualTo(1838)
        }
    }
}