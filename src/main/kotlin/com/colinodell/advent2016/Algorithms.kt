package com.colinodell.advent2016

import java.math.BigInteger
import java.security.MessageDigest
import java.util.PriorityQueue

class SearchResult<T> (val end: T?, val path: Collection<T>, val seen: Set<T>) {
    val found = end != null
    val distance = path.size - 1
}

fun <T> AStar(start: T, goal: T, generateNextStates: (T) -> Sequence<T>, heuristic: (T) -> Int = { 0 }, maxDistance: Int = Int.MAX_VALUE): SearchResult<T> {
    val reachedGoal: (T) -> Boolean = { it == goal }
    return AStar(start, reachedGoal, generateNextStates, heuristic, maxDistance)
}

fun <T> AStar(start: T, reachedGoal: (T) -> Boolean, generateNextStates: (T) -> Sequence<T>, heuristic: (T) -> Int = { 0 }, maxDistance: Int = Int.MAX_VALUE): SearchResult<T> {
    val gScore = mutableMapOf(start to 0)
    val fScore = mutableMapOf(start to heuristic(start))

    val openSet = PriorityQueue<T>(1, Comparator.comparingInt { fScore[it]!! })
    openSet.add(start)

    val cameFrom = mutableMapOf<T, T>()

    while (openSet.isNotEmpty()) {
        val current = openSet.poll()
        if (reachedGoal(current)) {
            // Reconstruct path
            var previous = current
            val totalPath = mutableListOf(previous)
            while (cameFrom.containsKey(previous)) {
                previous = cameFrom[previous]!!
                totalPath.add(previous)
            }

            totalPath.reverse()

            return SearchResult(current, totalPath, gScore.keys)
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

    return SearchResult(null, emptyList(), gScore.keys)
}

fun <T> DFS_all(start: T, reachedGoal: (T) -> Boolean, generateNextMoves: (T) -> Sequence<T>) = sequence {
    val s = mutableListOf(start)
    while (s.isNotEmpty()) {
        val next = s.first()
        s.removeAt(0)
        if (reachedGoal(next)) {
            yield(next)
        } else {
            s.addAll(generateNextMoves(next))
        }
    }
}

private val md5Digester = MessageDigest.getInstance("MD5")

fun md5(str: String): String {
    val bigInt = BigInteger(1, md5Digester.digest(str.toByteArray(Charsets.US_ASCII)))
    return String.format("%032x", bigInt)
}
