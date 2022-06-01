package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {
    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            assertThat(Day18(".^^.^.^^^^").solve(10)).isEqualTo(38)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day18(resourceAsText("day18.txt")).solve(40)
            assertThat(answer).isEqualTo(1974)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day18(resourceAsText("day18.txt")).solve(400000)
            assertThat(answer).isEqualTo(19991126)
        }
    }
}
