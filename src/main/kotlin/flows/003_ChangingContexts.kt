package org.example.flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() : Unit = runBlocking {
    getMoviesFromPersistence().collect{
        println("Collecting Thread =========> ${Thread.currentThread().name}")
        println("Collected Movies =========> $it")
    }
}


suspend fun getMoviesFromPersistence() : Flow<List<String>>{
    return flow{
        println("Collecting Thread =========> ${Thread.currentThread().name}")
        delay(500L)
        emit(listOf("Weapon", "John Wick", "Predator"))
    }.map {
        it.map {
            "Movie: $it"
        }
    }.flowOn(Dispatchers.IO)
}