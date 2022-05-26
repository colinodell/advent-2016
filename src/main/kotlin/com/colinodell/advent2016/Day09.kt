package com.colinodell.advent2016

import java.math.BigInteger

class Day09 (private val input: String) {
    fun solvePart1() = calculateDecompressedLengthV1(input)
    fun solvePart2() = calculateDecompressedLengthV2(input)

    private fun calculateDecompressedLengthV1(input: String): Int {
        var totalLength = 0
        var i = 0
        while (i < input.length) {
            val c = input[i]
            if (c == '(') {
                val end = input.indexOf(')', i)
                val (length, repeat) = input.substring(i + 1, end).split('x').map { it.toInt() }
                i = end + length + 1
                totalLength += length * repeat
            } else {
                totalLength += 1
                i++
            }
        }

        return totalLength
    }

    private fun calculateDecompressedLengthV2(input: String): BigInteger {
        // Like v1, but recursive
        var totalLength = BigInteger.ZERO
        var i = 0
        while (i < input.length) {
            val c = input[i]
            if (c == '(') {
                val end = input.indexOf(')', i)
                val (length, repeat) = input.substring(i + 1, end).split('x').map { it.toInt() }
                i = end + length + 1
                totalLength += calculateDecompressedLengthV2(input.substring(end + 1, i)) * repeat.toBigInteger()
            } else {
                totalLength += BigInteger.ONE
                i++
            }
        }

        return totalLength
    }
}