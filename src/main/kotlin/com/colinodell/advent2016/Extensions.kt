package com.colinodell.advent2016

fun <T> Iterable<T>.permutationPairs(): Sequence<Pair<T, T>> = sequence {
    for (i in withIndex()) {
        for (j in withIndex()) {
            if (i.index < j.index) {
                yield(Pair(i.value, j.value))
            }
        }
    }
}