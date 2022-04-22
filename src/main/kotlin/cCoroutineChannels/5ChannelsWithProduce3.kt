package cCoroutineChannels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        produceSquares2().consumeEach {
            println(it)
        }
    }
}

fun CoroutineScope.produceSquares2() = produce {
    for (x in 1..5)
        send(x*x)
}