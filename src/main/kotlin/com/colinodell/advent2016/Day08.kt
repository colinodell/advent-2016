package com.colinodell.advent2016

class Day08 (input: List<String>, width: Int, height: Int) {
    private val display = Display(width, height)

    init {
        input.forEach { display.process(it) }
    }

    fun solvePart1() = display.pixels.values.count { it }

    fun solvePart2() = display.render()

    private class Display(val width: Int, val height: Int) {
        val pixels = mutableMapOf<Vector2, Boolean>()

        fun process(line: String) {
            val split = line.split(" ")
            when(split[0]) {
                "rect" -> {
                    val (a, b) = split[1].split("x").map { it.toInt() }
                    for (i in 0 until a) {
                        for (j in 0 until b) {
                            pixels[Vector2(i, j)] = true
                        }
                    }
                }
                "rotate" -> {
                    val axis = split[1]
                    val index = split[2].split("=")[1].toInt()
                    val shift = split[4].toInt()

                    val rekey = if (axis == "row") {
                        { v: Vector2 -> if (v.y == index) Vector2((v.x + shift) % width, v.y) else v }
                    } else {
                        { v: Vector2 -> if (v.x == index) Vector2(v.x, (v.y + shift) % height) else v }
                    }

                    val newPixels = pixels.toList().associate { rekey(it.first) to it.second }

                    pixels.clear()
                    pixels.putAll(newPixels)
                }
            }
        }

        fun render(): String {
            val sb = StringBuilder()
            for (i in 0 until height) {
                for (j in 0 until width) {
                    sb.append(if (pixels[Vector2(j, i)] == true) "#" else ".")
                }
                sb.append("\n")
            }

            return sb.toString()
        }
    }
}