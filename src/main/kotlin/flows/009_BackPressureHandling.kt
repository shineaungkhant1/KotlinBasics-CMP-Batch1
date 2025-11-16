package org.example.flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking{
    val fastFlow = flow {
        (1..5).forEach {
            println("Emitting ========> $it")
            emit(it)
            delay(50L)
        }
    }

//    fastFlow.collect {
//        delay(1000L)
//        println("No Backpressure Handling =======> $it")
//    }

//    fastFlow.buffer(capacity = 5).collect {
//        delay(1000L)
//        println("Buffer ======> $it")
//    }

//    fastFlow.conflate().collect {
//        delay(100)
//        println("Buffer ======> $it")
//    }

    fastFlow.collectLatest {
        delay(1000L)
        println("Buffer ======> $it")
    }
}

