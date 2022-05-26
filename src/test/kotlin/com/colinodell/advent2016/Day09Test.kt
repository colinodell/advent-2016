package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.math.BigInteger

@DisplayName("Day 9")
class Day09Test {
    private val samplesPart1 = mapOf(
        "ADVENT" to 6,
        "A(1x5)BC" to 7,
        "(3x3)XYZ" to 9,
        "A(2x2)BCD(2x2)EFG" to 11,
        "(6x1)(1x3)A" to 6,
        "X(8x2)(3x3)ABCY" to 18,
    )

    private val samplesPart2 = mapOf(
        "ADVENT" to 6,
        "A(1x5)BC" to 7,
        "(3x3)XYZ" to 9,
        "X(8x2)(3x3)ABCY" to 20,
        "(27x12)(20x12)(13x14)(7x10)(1x12)A" to 241920,
        "(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN" to 445,
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            samplesPart1.forEach { (input, expected) ->
                assertThat(Day09(input).solvePart1()).isEqualTo(expected)
            }
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day09(resourceAsText("day09.txt")).solvePart1()
            assertThat(answer).isEqualTo(102239)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            samplesPart2.forEach { (input, expected) ->
                assertThat(Day09(input).solvePart2()).isEqualTo(expected)
            }
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day09(resourceAsText("day09.txt")).solvePart2()
            assertThat(answer).isEqualTo(BigInteger("10780403063"))
        }
    }
}