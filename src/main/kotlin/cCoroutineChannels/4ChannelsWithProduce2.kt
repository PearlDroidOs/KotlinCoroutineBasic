package cCoroutineChannels

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        for (k in produceSquares())
            println(k)
    }
}

fun CoroutineScope.produceSquares() = produce {
    for (x in 1..5)
        send(x*x)
}