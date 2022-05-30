package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("Day 17")
class Day17Test {
    @DisplayName("Part 1")
    class Part1 {
        @ParameterizedTest(name = "The shortest path for passcode {0}")
        @MethodSource("getData")
        fun `Solves Part 1`(passcode: String, expected: String) {
            val answer = Day17(passcode).solvePart1()
            assertThat(answer).isEqualTo(expected)
        }

        companion object {
            @JvmStatic
            fun getData(): List<Arguments> {
                return listOf(
                        Arguments.of("ihgpwlah", "DDRRRD"),
                        Arguments.of("kglvqrro", "DDUDRLRRUDRD"),
                        Arguments.of("ulqzkmiv", "DRURDRUDDLLDLUURRDULRLDUUDDDRR"),
                        Arguments.of("dmypynyp", "RDRDUDLRDR"),
                )
            }
        }
    }

    @DisplayName("Part 2")
    class Part2 {
        @ParameterizedTest(name = "The longest path for passcode {0}")
        @MethodSource("getData")
        fun `Solves Part 2`(passcode: String, expected: Int) {
            val answer = Day17(passcode).solvePart2()
            assertThat(answer).isEqualTo(expected)
        }

        companion object {
            @JvmStatic
            fun getData(): List<Arguments> {
                return listOf(
                    Arguments.of("ihgpwlah", 370),
                    Arguments.of("kglvqrro", 492),
                    Arguments.of("ulqzkmiv", 830),
                    Arguments.of("dmypynyp", 386),
                )
            }
        }
    }
}