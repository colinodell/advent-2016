package com.colinodell.advent2016

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Vector2")
class Vector2Test {
    @Test
    fun `Constructor and Properties`() {
        val vector = Vector2(1, 2)
        assertThat(vector.x).isEqualTo(1)
        assertThat(vector.y).isEqualTo(2)
    }

    @Test
    fun `Addition`() {
        val vector = Vector2(1, 2) + Vector2(3, 4)
        assertThat(vector.x).isEqualTo(4)
        assertThat(vector.y).isEqualTo(6)
    }

    @Test
    fun `String Representation`() {
        val vector = Vector2(1, 2)
        assertThat(vector.toString()).isEqualTo("(1, 2)")
    }

    @Test
    fun `Manhattan Distance`() {
        val vector = Vector2(1, -2)
        assertThat(vector.manhattanDistance()).isEqualTo(3)
    }

    @Test
    fun `Manhattan Distance between two points`() {
        val vector1 = Vector2(1, -2)
        val vector2 = Vector2(4, 6)
        assertThat(vector1.manhattanDistance(vector2)).isEqualTo(11)
    }
}
