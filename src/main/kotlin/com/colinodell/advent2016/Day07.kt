package com.colinodell.advent2016

class Day07(private val input: List<String>) {
    fun solvePart1() = input.map(::IPv7).count { it.supportsTLS() }
    fun solvePart2() = input.map(::IPv7).count { it.supportsSSL() }

    private class IPv7(ip: String) {
        private val supernets = Regex("(?<!\\[)[a-z]+(?=\\[|$)").findAll(ip).map { it.value }
        private val hypernets = Regex("\\[([a-z]+)\\]").findAll(ip).map { it.groups[1]?.value ?: "" }

        fun supportsTLS() = supernets.any { hasABBA(it) } && !hypernets.any { hasABBA(it) }
        fun supportsSSL() = supernets.flatMap { getABAs(it) }.any { hasBAB(it) }

        private fun hasABBA(s: String): Boolean {
            return (0 until s.length - 3).any { s[it] == s[it + 3] && s[it + 1] == s[it + 2] && s[it] != s[it + 1] }
        }

        private fun getABAs(s: String): List<String> {
            return (0 until s.length - 2).map { s.substring(it, it + 3) }.filter { it[0] == it[2] && it[0] != it[1] }
        }

        private fun hasBAB(aba: String) = hypernets.any {
            it.contains(
                listOf(aba[1], aba[0], aba[1]).joinToString("")
            )
        }
    }
}
