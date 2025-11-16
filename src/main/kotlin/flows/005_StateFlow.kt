package org.example.flows

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking{
    val coldFLow = flow {
        (1..10).forEach {
            delay(100L)
            emit(it)
        }
    }


    val stateFlow = coldFLow
        .stateIn(
            scope = this,
            started = SharingStarted.Eagerly,
            initialValue = 0
        )

    val job = launch {
        stateFlow.collect {
            println("Numbers Received =======> $it")
        }
    }

    delay(1000L)
    job.cancel()


    val job2 = launch {
        stateFlow.collect {
            println("Numbers Received Again =========> $it")
        }
    }
    delay(1000L)
    job2.cancel()

}