package com.colinodell.advent2016

class Day11(private val input: List<String>) {
    fun solve(): Int {
        // Parse the input
        val rgx = Regex("(\\w+(?: generator|-compatible microchip))")
        val floors = input.map { rgx.findAll(it).map { it.groupValues[1] }.toList() }

        val start = State(0, floors.mapIndexed { i, f -> i to f.toSet() }.toMap())

        val end = State(
            3,
            mapOf(
                0 to setOf(),
                1 to setOf(),
                2 to setOf(),
                3 to floors.flatten().toSet(),
            )
        )

        val generator = fun(state: State) = state.generateNextStates()
        val h = fun(state: State) = (state.items[2]!!.size * 4) + (state.items[1]!!.size * 6) + (state.items[0]!!.size * 8)

        return AStar(start, end, generator, h).distance
    }

    private data class State(val currentFloor: Int, val items: Map<Int, Set<String>>) {
        fun generateNextStates() = generateAllPossibleNextStates()

        private fun generateAllPossibleNextStates() = sequence {
            val itemsExistOnLowerFloors = items.filterKeys { it < currentFloor }.values.any { it.isNotEmpty() }
            val nextPossibleFloors = (0..3).filter { it == currentFloor + 1 || (it == currentFloor - 1 && itemsExistOnLowerFloors) }

            for (nextFloor in nextPossibleFloors) {
                // Optimization: If we're going up, bring two items if we can, instead of one
                if (nextFloor > currentFloor) {
                    val twoItemMoves = generateTwoItemMoves(nextFloor)
                    if (twoItemMoves.isNotEmpty()) {
                        yieldAll(twoItemMoves)
                    } else {
                        yieldAll(generateSingleItemMoves(nextFloor))
                    }
                }

                // Optimization: If we're going down, bring one item if we can, instead of two
                else {
                    val singleItemMoves = generateSingleItemMoves(nextFloor)
                    if (singleItemMoves.isNotEmpty()) {
                        yieldAll(singleItemMoves)
                    } else {
                        yieldAll(generateTwoItemMoves(nextFloor))
                    }
                }
            }
        }

        private fun generateSingleItemMoves(nextFloor: Int): Collection<State> =
            items[currentFloor]!!.toList().map { item ->
                val newItems = items.toMutableMap().mapValues { it.value.toMutableSet() }
                newItems[currentFloor]!!.remove(item)
                newItems[nextFloor]!!.add(item)
                State(nextFloor, newItems)
            }.filter { it.isValid() }

        private fun generateTwoItemMoves(nextFloor: Int): Collection<State> = items[currentFloor]!!.permutationPairs().map { pair ->
            val newItems = items.toMutableMap().mapValues { it.value.toMutableSet() }
            newItems[currentFloor]!!.remove(pair.first)
            newItems[currentFloor]!!.remove(pair.second)
            newItems[nextFloor]!!.add(pair.first)
            newItems[nextFloor]!!.add(pair.second)
            State(nextFloor, newItems)
        }.filter { it.isValid() }.toList()

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

        val hashString: String by lazy {
            var hash = currentFloor.toString()

            for ((floor, items) in items) {
                // Find pairs of generators and compatible microchips
                val generators = items.filter { it.endsWith("generator") }.map { it.replace(" generator", "") }.toSet()
                val microchips = items.filter { it.endsWith("microchip") }.map { it.replace("-compatible microchip", "") }.toSet()
                val pairs = generators.intersect(microchips)

                val remainingItems = items.toSortedSet()

                // Remove any items that start with any pair prefix
                for (prefix in pairs) {
                    remainingItems.removeIf { it.startsWith(prefix) }
                }

                // Add the remaining items to the hash
                hash += "|floor-$floor-pairs-${pairs.size}-${remainingItems.joinToString(",")}"
            }

            hash
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as State

            if (currentFloor != other.currentFloor) return false

            return hashString == other.hashString
        }

        override fun hashCode(): Int {
            return hashString.hashCode()
        }
    }
}
