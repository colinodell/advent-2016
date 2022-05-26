package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 7")
class Day07Test {
    private val sample1 = """
        abba[mnop]qrst
        abcd[bddb]xyyx
        aaaa[qwer]tyui
        ioxxoj[asdfgh]zxcvbn
    """.trimIndent().split("\n")

    private val sample2 = """
        aba[bab]xyz
        xyx[xyx]xyx
        aaa[kek]eke
        zazbz[bzb]cdb
    """.trimIndent().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day07(sample1).solvePart1()
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()
            assertThat(answer).isEqualTo(118)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day07(sample2).solvePart2()
            assertThat(answer).isEqualTo(3)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()
            assertThat(answer).isEqualTo(260)
        }
    }
}