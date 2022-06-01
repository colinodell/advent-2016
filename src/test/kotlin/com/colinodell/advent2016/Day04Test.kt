package com.colinodell.advent2016

import com.colinodell.advent2016.Resources.resourceAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {
    private val sample = listOf(
        "aaaaa-bbb-z-y-x-123[abxyz]",
        "a-b-c-d-e-f-g-h-987[abcde]",
        "not-a-real-room-404[oarel]",
        "totally-real-room-200[decoy]",
    )

    @Nested
    @DisplayName("Room class")
    inner class Room {
        @Test
        fun `can be created from a string`() {
            val room = Day04.Room.fromString("aaaaa-bbb-z-y-x-123[abxyz]")
            assertThat(room.name).isEqualTo("aaaaa-bbb-z-y-x")
            assertThat(room.sectorId).isEqualTo(123)
            assertThat(room.checksum).isEqualTo("abxyz")
        }

        @Test
        fun `calculates the real checksum`() {
            val room = Day04.Room.fromString("aaaaa-bbb-z-y-x-123[abxyz]")
            assertThat(room.realChecksum).isEqualTo("abxyz")
        }

        @Test
        fun `identifies whether a room is real or fake`() {
            val room = Day04.Room.fromString("aaaaa-bbb-z-y-x-123[abxyz]")
            assertThat(room.isReal).isTrue

            val room2 = Day04.Room.fromString("totally-real-room-200[decoy]")
            assertThat(room2.isReal).isFalse
        }

        @Test
        fun `decodes the real name of the room`() {
            val room = Day04.Room.fromString("qzmt-zixmtkozy-ivhz-343[zimth]")
            assertThat(room.realName).isEqualTo("very encrypted name")
        }
    }

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches Sample Data`() {
            val answer = Day04(sample).solvePart1()
            assertThat(answer).isEqualTo(1514)
        }

        @Test
        fun `Matches Actual Data`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart1()
            assertThat(answer).isEqualTo(137896)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches Actual Data`() {
            val answer = Day04(resourceAsListOfString("day04.txt")).solvePart2()
            assertThat(answer).isEqualTo(501)
        }
    }
}
