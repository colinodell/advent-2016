package com.colinodell.advent2016

class Day14(private val salt: String) {
    fun solvePart1(): Int = solve(0)
    fun solvePart2(): Int = solve(2016)

    private fun solve(stretchFactor: Int) =
        generateHashes(1, stretchFactor)
            .map { PossibleKey(it, findTripleDigit(it.hash)) }
            .filter { it.tripleChar != null }
            .filter { futureHashContainsFiveRepeats(it.tripleChar!!, it.hash.index, stretchFactor) }
            .take(64)
            .last()
            .hash.index

    private var hashCache = mapOf<Int, String>()

    private fun generateHashes(startingAt: Int = 1, stretchFactor: Int) = sequence {
        var i = startingAt
        while (true) {
            if (!hashCache.containsKey(i)) {
                var newHash = md5(salt + i)
                // Apply an additional stretchFactor times
                for (j in 1..stretchFactor) {
                    newHash = md5(newHash)
                }

                // Cache the new hash along with the most-recent 1,000 items
                hashCache = hashCache.filterNot { it.key < i - 1000 }.plus(Pair(i, newHash))
            }
            yield(IndexedHash(i, hashCache[i]!!))
            i++
        }
    }

    private fun futureHashContainsFiveRepeats(match: Char, iteration: Int, stretchFactor: Int) =
        generateHashes(iteration + 1, stretchFactor)
            .take(1000)
            .any { it.hash.contains(match.toString().repeat(5)) }

    private val threeDigits = Regex("([0-9a-f])\\1\\1")

    private fun findTripleDigit(hash: String) = threeDigits.find(hash)?.groupValues?.get(1)?.first()

    private data class IndexedHash(val index: Int, val hash: String)
    private data class PossibleKey(val hash: IndexedHash, val tripleChar: Char?)
}
