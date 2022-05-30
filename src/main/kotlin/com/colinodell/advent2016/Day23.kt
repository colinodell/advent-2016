package com.colinodell.advent2016

class Day23(input: List<String>) {
    private val computer = AssembunnyComputer(input)

    fun solve(initialARegisterValue: Int) = computer.execute(mapOf("a" to initialARegisterValue)).run { computer.registers["a"]!! }
}
