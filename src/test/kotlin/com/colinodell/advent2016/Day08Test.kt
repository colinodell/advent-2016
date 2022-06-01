package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 8")
class Day08Test {
    private val sample = """
        rect 3x2
        rotate column x=1 by 1
        rotate row y=0 by 4
        rotate column x=1 by 1
    """.trimIndent().trim().split("\n")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day08(sample, 7, 3).solvePart1()
            assertThat(answer).isEqualTo(6)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day08(resourceAsListOfString("day08.txt"), 50, 6).solvePart1()
            assertThat(answer).isEqualTo(119)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day08(sample, 7, 3).solvePart2()
            assertThat(answer.trim()).isEqualTo(
                """
                .#..#.#
                #.#....
                .#.....
                """.trimIndent()
            )
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day08(resourceAsListOfString("day08.txt"), 50, 6).solvePart2()
            assertThat(answer.trim()).isEqualTo(
                """
                ####.####.#..#.####..###.####..##...##..###...##..
                ...#.#....#..#.#....#....#....#..#.#..#.#..#.#..#.
                ..#..###..####.###..#....###..#..#.#....#..#.#..#.
                .#...#....#..#.#.....##..#....#..#.#.##.###..#..#.
                #....#....#..#.#.......#.#....#..#.#..#.#....#..#.
                ####.#....#..#.#....###..#.....##...###.#.....##..
                """.trimIndent()
            )
        }
    }
}
