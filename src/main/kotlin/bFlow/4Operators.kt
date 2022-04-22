package bFlow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    runBlocking {
        reduceOperator()
    }
}

suspend fun flowOnOperator() {
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect {
            println(it)
        }
}

suspend fun reduceOperator() {
    val size = 5
    val factorial = (1..size).asFlow()
        .reduce {accumulator: Int, value: Int ->  accumulator*value}
    println("Factorial of $size is $factorial")
}

suspend fun takeOperator() {
    (1..10).asFlow()
        .take(2)
        .collect {
            println(it)
        }
}

suspend fun transformOperator() {
    (1..10).asFlow()
        .transform {
            emit("Emitting value $it")
            emit(it)
        }.collect {
            println(it)
        }
}

suspend fun filterOperator() {
    (1..10).asFlow()
        .filter {
            delay(100L)
            it % 2 == 0
        }
        .collect {
            println(it)
        }
}

suspend fun mapOperator() {
    (1..10).asFlow()
        .map {
            delay(100L)
            "Mapping $it"
        }
        .collect {
            println(it)
        }
}