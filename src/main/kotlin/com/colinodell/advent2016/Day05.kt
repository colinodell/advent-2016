package com.colinodell.advent2016

import java.math.BigInteger
import java.security.MessageDigest

class Day05 (private val input: String) {
    fun solvePart1(): String = generateInterestingHashes()
        .take(8)
        .map { it[5] }
        .joinToString("")

    fun solvePart2() = generateInterestingHashes()
        .map { Pair(it[5], it[6]) }
        .filter { it.first in '0'..'7' }
        .distinctBy { it.first }
        .take(8)
        .sortedBy { it.first }
        .map { it.second }
        .joinToString("")

    private fun generateInterestingHashes() = sequence {
        var i = 0
        while (true) {
            val hash = md5(input + i)
            if (hash.startsWith("00000")) {
                yield(hash)
            }
            i++
        }
    }

    private fun md5(str: String): String {
        val md = MessageDigest.getInstance("MD5")
        val bigInt = BigInteger(1, md.digest(str.toByteArray(Charsets.UTF_8)))
        return String.format("%032x", bigInt)
    }
}

