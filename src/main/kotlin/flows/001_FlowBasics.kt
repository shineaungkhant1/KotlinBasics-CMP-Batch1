package org.example.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {
    val newFlow = flow {
        emit(1)
        delay(1000)
        emit(2)
    }

    newFlow.collect {
        println("First collector =========> $it")
    }

    newFlow.collect {
        println("Second collector =========> $it")
    }
}