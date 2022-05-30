package com.colinodell.advent2016

class Day16(private val input: String, private val length: Int) {
    fun solve() = calculateCheckSum(generateData(input, length))

    companion object {
        fun generateData(input: String, length: Int): String {
            var result = input
            while (result.length < length) {
                val a = result
                val b = result.reversed().map { if (it == '0') '1' else '0' }.joinToString("")
                result = a + "0" + b
            }
            return result.take(length)
        }

        fun calculateCheckSum(input: String): String {
            var checksum = input
            while (checksum.length % 2 == 0) {
                val sb = StringBuilder()
                for (i in checksum.indices step 2) {
                    sb.append(if (checksum[i] == checksum[i + 1]) '1' else '0')
                }
                checksum = sb.toString()
            }
            return checksum
        }
    }
}