package com.colinodell.advent2016

import java.util.*

class SearchResult<T> (val found: Boolean, val path: Collection<T>, val seen: Set<T>) {
    val distance = path.size - 1
}

fun <T> AStar(start: T, goal: T, generateNextStates: (T) -> Collection<T>, heuristic: (T) -> Int, maxDistance: Int = Int.MAX_VALUE): SearchResult<T> {
    val gScore = mutableMapOf(start to 0)
    val fScore = mutableMapOf(start to heuristic(start))

    val openSet = PriorityQueue<T>(1, Comparator.comparingInt { fScore[it]!! })
    openSet.add(start)

    val cameFrom = mutableMapOf<T, T>()

    while (openSet.isNotEmpty()) {
        var current = openSet.poll()
        if (current == goal) {
            // Reconstruct path
            val totalPath = mutableListOf(current)
            while (cameFrom.containsKey(current)) {
                current = cameFrom[current]!!
                totalPath.add(current)
            }

            totalPath.reverse()

            return SearchResult(true, totalPath, gScore.keys)
        }

        for (neighbor in generateNextStates(current)) {
            val tentativeGScore = gScore[current]!! + 1
            if (tentativeGScore >= gScore.getOrDefault(neighbor, Int.MAX_VALUE)) {
                continue
            }

            if (tentativeGScore > maxDistance) {
                continue
            }

            cameFrom[neighbor] = current
            gScore[neighbor] = tentativeGScore
            fScore[neighbor] = tentativeGScore + heuristic(neighbor)
            if (!openSet.contains(neighbor)) {
                openSet.add(neighbor)
            }
        }
    }

    return SearchResult(false, emptyList(), gScore.keys)
}