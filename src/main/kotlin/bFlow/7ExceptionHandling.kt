package bFlow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        onCompletionOperator()
    }
}

suspend fun onCompletionOperator() {
    (1..3).asFlow()
//        .onEach { check(it != 2) }
        .onCompletion { cause ->
            if(cause != null)
                println("Flow completed with $cause")
            else
                println("Flow completed successfully")
        }
        .catch { e -> println("Caught exception $e") }
        .collect { println(it) }

}
suspend fun catchOperator() {
    (1..3).asFlow()
        .onEach { check(it != 2) }
        .catch { e -> println("Exception: $e") }
        .collect { println(it) }
}

suspend fun tryCatch() {
    try {
        (1..3).asFlow()
            .onEach { check(it != 2) }
            .collect { println(it) }
    } catch (ex: Exception) {
        println("Exception: $ex")
    }
}