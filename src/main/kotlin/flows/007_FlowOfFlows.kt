package org.example.flows

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
fun main() : Unit = runBlocking {
    val userIdFlow = flow {
        (1..3).forEach {
            emit(it)
        }
    }.
            flatMapLatest {
                getUserDetails(it)
            }
//    flatMapMerge {
//        getUserDetails(it)
//    }
//    flatMapConcat {
//        getUserDetails(it)
//    }
        .flowOn(Dispatchers.IO)

    userIdFlow.collect{
        println("Collected user ======> $it")
    }
}


suspend fun getUserDetails(userId : Int) : Flow<String> {

    return flow {

        when(userId){
            1-> {
                delay(1500L)
                emit("{name: John, age:30}")
            }
            2-> {
                delay(1000L)
                emit("{name: Mary, age:24}")
            }
            else -> {
                delay(2000L)
                emit("{name: Jack, age:25}")
            }
        }
    }
}