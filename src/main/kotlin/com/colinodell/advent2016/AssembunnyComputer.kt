package com.colinodell.advent2016

class AssembunnyComputer(assembly: List<String>) {
    private data class Instruction(var operation: String, val args: Collection<String>)
    private class InvalidArgumentException(val arg: String) : Exception()

    private val program = assembly.map {
        val parts = it.split(" ")
        Instruction(parts[0], parts.drop(1))
    }

    private var memory = program.toMutableList()
    var registers = mutableMapOf<String, Int>()
    private var pos: Int = 0

    fun execute(initialRegisters: Map<String, Int> = mapOf()) {
        memory = program.toMutableList()
        registers = initialRegisters.toMutableMap()
        pos = 0

        while (pos < memory.size) {
            try {
                val instruction = memory[pos]
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
                    "tgl" -> {
                        val targetPosition = pos + registers[instruction.args.first()]!!
                        val targetInstruction = memory[targetPosition]
                        when (targetInstruction.operation) {
                            "inc" -> targetInstruction.operation = "dec"
                            "dec" -> targetInstruction.operation = "inc"
                            "tgl" -> targetInstruction.operation = "inc"
                            "jnz" -> targetInstruction.operation = "cpy"
                            "cpy" -> targetInstruction.operation = "jnz"
                            else -> throw InvalidArgumentException(targetInstruction.operation)
                        }
                    }
                }
            } catch (e: Exception) {
                // do nothing
            }
            pos++
        }
    }

    private fun getValue(arg: String) = arg.toIntOrNull() ?: registers.getOrElse(arg) { throw InvalidArgumentException(arg) }


}