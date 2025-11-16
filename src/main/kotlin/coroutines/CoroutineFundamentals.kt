package org.example.coroutines

import kotlinx.coroutines.*


fun main() = runBlocking {
    launch {
        makeNetworkCall()
        val movies = getMoviesFromNetwork()

    }
    val getMoviesDeferred : Deferred<List<String>> = async {
        getMoviesFromNetwork()
    }
    val movies = getMoviesDeferred.await()
    println(movies)

    println("Progress continues to run")
}

suspend fun makeNetworkCall() {
    println("Network call starts")
    delay(2000)
    println("Network call completes")
}

suspend fun getMoviesFromNetwork(): List<String> {
    delay(3000)
    return listOf("Movie 1", "Movie 2", "Movie 3")
}