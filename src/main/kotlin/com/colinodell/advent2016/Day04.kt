package com.colinodell.advent2016

class Day04(val input: List<String>) {
    fun solvePart1(): Int {
        return input.map { Room.fromString(it) }
            .filter { it.isReal }
            .sumOf { it.sectorId }
    }

    fun solvePart2(): Int {
        return input.map { Room.fromString(it) }
            .filter { it.isReal }
            .first { it.realName.contains("north") }
            .sectorId
    }

    class Room(val name: String, val sectorId: Int, val checksum: String) {
        // Static constructor
        companion object {
            fun fromString(input: String): Room {
                val regex = Regex("""([a-z\-]+)-(\d+)\[(\w+)\]""")
                val matchResult = regex.matchEntire(input) ?: throw IllegalArgumentException("Invalid input: $input")

                val name = matchResult.groupValues[1]
                val sectorId = matchResult.groupValues[2].toInt()
                val checksum = matchResult.groupValues[3]

                return Room(name, sectorId, checksum)
            }
        }

        val realChecksum: String
            get() {
                return name.replace("-", "")
                    .groupingBy { it }
                    .eachCount()
                    .toList()
                    .sortedWith(compareByDescending<Pair<Char, Int>> { it.second }.thenBy { it.first })
                    .take(5)
                    .map { it.first }
                    .joinToString("")
            }

        val realName: String
            get() {
                // Shift cipher
                val shiftedName = name.map { c ->
                    if (c == '-') {
                        ' '
                    } else {
                        ('a' + (c - 'a' + sectorId) % 26)
                    }
                }

                return shiftedName.joinToString("")
            }

        val isReal: Boolean
            get() {
                return realChecksum == checksum
            }
    }
}
