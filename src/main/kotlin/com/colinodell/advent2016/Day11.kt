package com.colinodell.advent2016

class Day11 (private val input: List<String>) {
    fun solve(): Int {
        // Parse the input
        val rgx = Regex("(\\w+(?: generator|-compatible microchip))")
        val floors = input.map { rgx.findAll(it).map { it.groupValues[1] }.toList() }

        val start = State(0, floors.mapIndexed { i, f -> i to f.toMutableSet() }.toMap())

        val end = State(3, mapOf(
            0 to mutableSetOf(),
            1 to mutableSetOf(),
            2 to mutableSetOf(),
            3 to floors.flatten().toMutableSet(),
        ))

        val generator = fun(state: State) = state.generateNextStates()
        val h = fun(state: State) = (state.items[2]!!.size * 4) + (state.items[1]!!.size * 6) + (state.items[0]!!.size * 8)

        return AStar(start, end, generator, h).size - 1
    }

    private data class State(val currentFloor: Int, val items: Map<Int, MutableSet<String>>) {
        fun generateNextStates() = generateAllPossibleNextStates().filter { it.isValid() }.toList()

        private fun generateAllPossibleNextStates() = sequence {
            val nextPossibleFloors = (0..3).filter { it == currentFloor + 1 || it == currentFloor - 1 }

            // For each possible floor
            for (nextFloor in nextPossibleFloors) {
                // Taking 1 item:
                for (item in items[currentFloor]!!.toList()) {
                    val newItems = items.toMutableMap().mapValues { it.value.toMutableSet() }
                    newItems[currentFloor]!!.remove(item)
                    newItems[nextFloor]!!.add(item)
                    yield(State(nextFloor, newItems))
                }

                // Taking 2 items:
                for (pair in items[currentFloor]!!.permutationPairs()) {
                    val newItems = items.toMutableMap().mapValues { it.value.toMutableSet() }
                    newItems[currentFloor]!!.remove(pair.first)
                    newItems[currentFloor]!!.remove(pair.second)
                    newItems[nextFloor]!!.add(pair.first)
                    newItems[nextFloor]!!.add(pair.second)
                    yield(State(nextFloor, newItems))
                }
            }
        }

        fun isValid(): Boolean {
            for (itemsOnFloor in items.values) {
                val generators = itemsOnFloor.filter { it.endsWith("generator") }.map { it.replace(" generator", "") }
                val microchips = itemsOnFloor.filter { it.endsWith("microchip") }.map { it.replace("-compatible microchip", "") }

                // Floors may contain only generators, only microchips, or be empty
                if (generators.isEmpty() || microchips.isEmpty()) {
                    continue
                }

                // If a chip exists on the same floor as another RTG, and it's not connected to its own RTG, the state is invalid
                if (!generators.containsAll(microchips)) {
                    return false
                }
            }

            return true
        }
    }
}