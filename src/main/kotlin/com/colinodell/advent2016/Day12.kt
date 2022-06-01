package com.colinodell.advent2016

class Day12(input: List<String>) {
    private val computer = AssembunnyComputer(input)

    fun solvePart1() = computer.execute().run { computer.registers["a"]!! }
    fun solvePart2() = computer.execute(mapOf("c" to 1)).run { computer.registers["a"]!! }
}
