package com.colinodell.advent2016

class Day19 {
    fun solvePart1(elfCount: Int) = 2 * (elfCount - Integer.highestOneBit(elfCount)) + 1
    fun solvePart2(elfCount: Int): Int {
        val left: ArrayDeque<Int> = ArrayDeque()
        val right: ArrayDeque<Int> = ArrayDeque()
        for (i in 1..elfCount) {
            if (i < (elfCount / 2) + 1) {
                left.add(i)
            } else {
                right.addFirst(i)
            }
        }

        while (left.isNotEmpty() && right.isNotEmpty()) {
            if (left.size > right.size) {
                left.removeLast()
            } else {
                right.removeLast()
            }

            right.addFirst(left.removeFirst())
            left.addLast(right.removeLast())
        }

        return left.firstOrNull() ?: right.firstOrNull() ?: 0
    }
}
