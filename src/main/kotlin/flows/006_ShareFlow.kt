package org.example.flows

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
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


    val shareFlow = coldFLow
        .shareIn(
            scope = this,
            started = SharingStarted.Eagerly,
        )

    val job = launch {
        shareFlow.collect {
            println("Numbers Received =======> $it")
        }
    }

    delay(1500)
    job.cancel()


    val job2 = launch {
        shareFlow.collect {
            println("Numbers Received Again =========> $it")
        }
    }
    delay(1000L)
    job2.cancel()

}