package org.example.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    val firstJob = launch {
//        println("First Job starts")
//        delay(5000L)
//        println("First Job Ends")
//    }
//
////    delay(1000L)
////    firstJob.cancel()
//
//    firstJob.join()

    // Child Coroutine
    launch {
        launch {
            println("First Network Call running")
            delay(1000L)
//            println("First Network Call completed")
            try {
                throw Exception("Network Error")
            } catch (e: Exception) {
              println("Network Error: $e")
            }

        }


        launch {
            println("Second Network Call running")
            delay(1000L)
            println("Second Network Call completed")
        }
    }
    println("Program continues")

}