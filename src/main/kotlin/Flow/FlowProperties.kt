package Flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val numbers = sendNumber()
        println("Flow hasn't started yet")
        println("Flow will start now")
        withTimeoutOrNull(1000) {
            numbers.collect {
                println(it)
            }
        }
    }
}

fun sendNumber() = flow {
    listOf(1, 2, 3).forEach {
        delay(400L)
        emit(it)
    }
}