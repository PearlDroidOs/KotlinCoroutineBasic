package bFlow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        combine()
    }
}

suspend fun zip() {
    val english = flowOf("One", "Two", "Three")
    val french = flowOf("Un", "Deux", "Troix")
    english.zip(french) {a,b -> "'$a' in French is '$b'"}
        .collect {
            println(it)
        }
}

suspend fun combine() {
    val numbers = (1..5).asFlow().onEach { delay(300) }
    val values = flowOf("One", "Two", "Three", "Four", "Five").onEach { delay(400)}

    numbers.combine(values) {a, b -> "$a -> $b"}.collect { println(it) }
}