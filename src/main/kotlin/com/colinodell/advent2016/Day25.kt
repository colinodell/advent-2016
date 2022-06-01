package com.colinodell.advent2016

class Day25(input: List<String>) {
    private val computer = AssembunnyComputer(input)
    fun solve() = (0..Int.MAX_VALUE).first {
        computer.executeYieldingOutputs(mapOf("a" to it)).take(8).toList() == listOf(0, 1, 0, 1, 0, 1, 0, 1)
    }
}
