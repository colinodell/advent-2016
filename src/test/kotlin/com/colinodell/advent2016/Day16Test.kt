package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 16")
class Day16Test {
    @Nested
    @DisplayName("Function Tests")
    inner class FunctionTests {
        @Test
        fun `Generates Data`() {
            val data = Day16.generateData("10000", 20)
            assertThat(data).isEqualTo("10000011110010000111")
        }

        @Test
        fun `Generates checksums`() {
            val checksum = Day16.calculateCheckSum("10000011110010000111")
            assertThat(checksum).isEqualTo("01100")
        }
    }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day16("01110110101001000", 272).solve()
            assertThat(answer).isEqualTo("11100111011101111")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day16("01110110101001000", 35651584).solve()
            assertThat(answer).isEqualTo("10001110010000110")
        }
    }
}