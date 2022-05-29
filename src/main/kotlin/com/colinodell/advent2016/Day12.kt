package com.colinodell.advent2016

class Day12 (input: List<String>) {
    private val computer = Computer(input.map {
        val parts = it.split(" ")
        Instruction(parts[0], parts.drop(1))
    })

    fun solvePart1() = computer.run().run { computer.registers["a"]!! }
    fun solvePart2() = computer.also { it.registers["c"] = 1 }.run().run { computer.registers["a"]!! }

    data class Instruction(val operation: String, val args: Collection<String>)

    class Computer(private val program: List<Instruction>) {
        var pos = 0
        var registers = mutableMapOf<String, Int>()

        fun run() {
            while (pos < program.size) {
                val instruction = program[pos]
                when (instruction.operation) {
                    "cpy" -> {
                        val value = getValue(instruction.args.first())
                        val register = instruction.args.last()
                        registers[register] = value
                    }
                    "inc" -> {
                        val register = instruction.args.first()
                        registers[register] = registers.getOrDefault(register, 0) + 1
                    }
                    "dec" -> {
                        val register = instruction.args.first()
                        registers[register] = registers.getOrDefault(register, 0) - 1
                    }
                    "jnz" -> {
                        val value = getValue(instruction.args.first())
                        if (value != 0) {
                            pos += getValue(instruction.args.last())
                            continue
                        }
                    }
                }
                pos++
            }
        }

        private fun getValue(arg: String) = arg.toIntOrNull() ?: registers.getOrDefault(arg, 0)
    }
}