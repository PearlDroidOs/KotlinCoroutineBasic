package bFlow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main () {
    runBlocking {
        wayThree().collect{
            println("Received : $it")
        }
    }

}

fun wayOne() = flow {
    for (i in 1..10)
        emit(i)
}

fun wayTwo() = listOf(1,2,3,4,5,6,7,8,9,10).asFlow()

fun wayThree() = flowOf("one", "two", "three")