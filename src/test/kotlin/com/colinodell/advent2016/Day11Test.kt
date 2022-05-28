package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 11")
class Day11Test {
    private val sample = """
        The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.
        The second floor contains a hydrogen generator.
        The third floor contains a lithium generator.
        The fourth floor contains nothing relevant.
    """.trimIndent().trim().split("\n")

    private val actualPart1 = """
        The first floor contains a promethium generator and a promethium-compatible microchip.
        The second floor contains a cobalt generator, a curium generator, a ruthenium generator, and a plutonium generator.
        The third floor contains a cobalt-compatible microchip, a curium-compatible microchip, a ruthenium-compatible microchip, and a plutonium-compatible microchip.
        The fourth floor contains nothing relevant.
    """.trimIndent().trim().split("\n")

    private val actualPart2 = """
        The first floor contains a promethium generator, a promethium-compatible microchip, an elerium generator, an elerium-compatible microchip, a dilithium generator, and a  dilithium-compatible microchip.
        The second floor contains a cobalt generator, a curium generator, a ruthenium generator, and a plutonium generator.
        The third floor contains a cobalt-compatible microchip, a curium-compatible microchip, a ruthenium-compatible microchip, and a plutonium-compatible microchip.
        The fourth floor contains nothing relevant.
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day11(sample).solve()
            assertThat(answer).isEqualTo(11)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day11(actualPart1).solve()
            assertThat(answer).isEqualTo(33)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day11(actualPart2).solve()
            assertThat(answer).isEqualTo(57)
        }
    }
}