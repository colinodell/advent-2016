package com.colinodell.advent2016

class Day21(private val operations: List<String>) {
    fun solvePart1(password: String) = operations.fold(password) { text, operation -> perform(operation, text)}

    fun solvePart2(password: String) = operations.reversed().fold(password) { text, operation -> perform(operation, text, reverse = true)}

    private fun perform(operation: String, text: String, reverse: Boolean = false): String {
        val match = Regex("""(.+?) (\w)\b(?: .+ (\w))?""").find(operation)!!.groupValues
        val op = match[1]
        val args = match.drop(2)

        return when (op) {
            "swap position" -> swapPosition(text, args[0].toInt(), args[1].toInt())
            "swap letter" -> swapLetter(text, args[0][0], args[1][0])
            "rotate left" -> if (!reverse) {
                rotateLeft(text, args[0].toInt())
            } else {
                rotateRight(text, args[0].toInt())
            }
            "rotate right" -> if (!reverse) {
                rotateRight(text, args[0].toInt())
            } else {
                rotateLeft(text, args[0].toInt())
            }
            "rotate based on position of letter" -> rotateBasedOnPositionOfLetter(text, args[0][0], reverse)
            "reverse positions" -> reversePositions(text, args[0].toInt(), args[1].toInt())
            "move position" -> if (!reverse) {
                movePosition(text, args[0].toInt(), args[1].toInt())
            } else {
                movePosition(text, args[1].toInt(), args[0].toInt())
            }
            else -> throw IllegalArgumentException("Unknown operation: $op")
        }
    }

    private fun swapPosition(s: String, a: Int, b: Int): String {
        val chars = s.toCharArray()
        val tmp = chars[a]
        chars[a] = chars[b]
        chars[b] = tmp
        return chars.joinToString("")
    }

    private fun swapLetter(s: String, a: Char, b: Char): String {
        return s.map { if (it == a) b else if (it == b) a else it }.joinToString("")
    }

    private fun rotateLeft(s: String, n: Int): String {
        val tmp = ArrayDeque(s.toList())
        repeat(n) { tmp.addLast(tmp.removeFirst()) }
        return tmp.joinToString("")
    }

    private fun rotateRight(s: String, n: Int): String {
        val tmp = ArrayDeque(s.toList())
        repeat(n) { tmp.addFirst(tmp.removeLast()) }
        return tmp.joinToString("")
    }

    private fun rotateBasedOnPositionOfLetter(s: String, c: Char, reverse: Boolean): String {
        val index = s.indexOf(c)
        return if (!reverse) {
            rotateRight(s, if (index >= 4) 2 + index else 1 + index)
        } else {
            rotateLeft(s, index / 2 + (if (index % 2 == 1 || index == 0) 1 else 5))
        }
    }

    private fun reversePositions(s: String, a: Int, b: Int): String {
        return s.substring(0, a) + s.substring(a, b + 1).reversed() + s.substring(b + 1)
    }

    private fun movePosition(s: String, a: Int, b: Int): String {
        val chars = ArrayDeque(s.toList())
        chars.add(b, chars.removeAt(a))
        return chars.joinToString("")
    }
}