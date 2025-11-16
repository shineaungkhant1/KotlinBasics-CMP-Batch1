package org.example.flows

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking
import org.example.coroutines.getMoviesFromNetwork
import java.lang.IllegalStateException

fun main() : Unit = runBlocking {
    val flow = flow {
        emit(100)
        throw IllegalStateException("Something went wrong")
        emit(200)
    }.
    catch { exception ->
        println("Flow failed with exception ${exception.stackTraceToString()}")
        emit(-1)
    }.
    onCompletion { throwable ->
       throwable?.let {
           print("Flow completed")
       } ?: run {
         print("Flow completed with exception $throwable")
    }
    }
// View
    flow.collect {
        if (it == -1) {
            println("There was something wrong")
        } else {
            println("collected Value ===> $it")
        }
    }
}