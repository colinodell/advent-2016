package com.colinodell.advent2016

class Day10(private val input: List<String>) {
    fun solvePart1() = Factory(input).runUntilBotHas(listOf(61, 17))
    fun solvePart2(): Int {
        val f = Factory(input)
        f.runAll()

        return f.containers
            .filterKeys { listOf("output 0", "output 1", "output 2").contains(it) }
            .values
            .map { it.chips.first() }
            .reduce(Int::times)
    }

    private class Container(private val name: String) {
        val chips = mutableListOf<Int>()
        fun take(chip: Int) {
            chips.add(chip)
        }
        fun giveLow(container: Container) {
            container.take(chips.minOrNull()!!)
        }
        fun giveHigh(container: Container) {
            container.take(chips.maxOrNull()!!)
        }
        fun canProceed() = name.contains("output") || chips.size == 2
    }

    private class Factory(input: List<String>) {
        val containers = mutableMapOf<String, Container>()
        fun getContainer(name: String) = containers.getOrPut(name) { Container(name) }

        val instructions: MutableList<Instruction>

        init {
            instructions = input.map { line ->
                if (line.contains("goes to")) {
                    val (value, destination) = Regex("value (\\d+) goes to (.+)").find(line)!!.groupValues.drop(1)
                    ValueAssignmentInstruction(destination, value.toInt())
                } else {
                    val (giver, lowDest, highDest) = Regex("(bot \\d+) gives low to (.+) and high to (.+)").find(line)!!.groupValues.drop(1)
                    OutputInstruction(giver, lowDest, highDest)
                }
            }.toMutableList()
        }

        fun step(): Boolean {
            if (instructions.isEmpty()) {
                return false
            }

            val i = instructions.indexOfFirst { it.execute(this) }
            instructions.removeAt(i)

            return true
        }

        fun runAll() {
            while (step()) {}
        }

        fun runUntilBotHas(values: List<Int>): String {
            while (true) {
                step()
                val bot = containers.toList().firstOrNull { it.second.chips.containsAll(values) }
                if (bot !== null) {
                    return bot.first
                }
            }
        }
    }

    private interface Instruction {
        fun execute(factory: Factory): Boolean
    }

    private class ValueAssignmentInstruction(val bot: String, val value: Int) : Instruction {
        override fun execute(factory: Factory): Boolean {
            factory.getContainer(bot).take(value)
            return true
        }
    }

    private class OutputInstruction(val bot: String, val lowTarget: String, val highTarget: String) : Instruction {
        override fun execute(factory: Factory): Boolean {
            val container = factory.getContainer(bot)

            if (!container.canProceed()) {
                return false
            }

            container.giveLow(factory.getContainer(lowTarget))
            container.giveHigh(factory.getContainer(highTarget))

            return true
        }
    }
}
