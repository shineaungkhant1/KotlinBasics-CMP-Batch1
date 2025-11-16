package org.example.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun  main() : Unit = runBlocking {
    val numberFlow = flow {
        (1..10).forEach {
            delay(500L)
            emit(it)
        }
    }.filter {
        it % 2 == 0
    }
//    map {
//        it * 2
//    }

    numberFlow.collect {
        println("Collected Data =========> $it")
    }
}