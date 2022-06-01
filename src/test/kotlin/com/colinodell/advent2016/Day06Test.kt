package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {
    private val sample = """
        eedadn
        drvtee
        eandsr
        raavrd
        atevrs
        tsrnev
        sdttsa
        rasrtv
        nssdts
        ntnada
        svetve
        tesnvt
        vntsnd
        vrdear
        dvrsen
        enarar
    """.trimIndent().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day06(sample).solvePart1()
            assertThat(answer).isEqualTo("easter")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()
            assertThat(answer).isEqualTo("kjxfwkdh")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day06(sample).solvePart2()
            assertThat(answer).isEqualTo("advent")
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()
            assertThat(answer).isEqualTo("xrwcsnps")
        }
    }
}
