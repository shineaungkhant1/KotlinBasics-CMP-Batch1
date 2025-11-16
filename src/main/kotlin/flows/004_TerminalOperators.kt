package org.example.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {
    val numbersFLow = flow {
        (1..10).forEach {
            delay(500L)
            emit(it)
        }
    }

    // First
    println("First Value =======> ${numbersFLow.first()}")

    // toList()
    println("Second Value =======> ${numbersFLow.toList()}")

}


