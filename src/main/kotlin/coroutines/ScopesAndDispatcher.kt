package org.example.coroutines

import kotlinx.coroutines.*

fun main() : Unit = runBlocking {
    GlobalScope.launch {
        println("Coroutine running in Global Scope")
    }

    launch(Dispatchers.IO) {
        println("Network call starts")
        delay(2000L)
        println("Network call completes")

    }

//    launch (Dispatchers.Default){
//        (1..10000).forEach {
//            println(it)
//        }
//    }

//    launch {
//        withContext(Dispatchers.IO){
//            println("Network call starts")
//            delay(2000L)
//            println("Network call completes")
//        }
    val state = HomeState()
    launch {
        val movies = MovieRepository().getMovies()
       state.movies = movies

    }
    println("Program continues to run")
    }

class HomeState(var movies : List<String> = listOf())

class MovieRepository{
    suspend fun getMovies(): List<String>{
       return  withContext(Dispatchers.IO){
           println("Fetching movies...")
           delay(3000L)
           return@withContext listOf("Movie 1", "Movie 2", "Movie 3")
       }
    }
}