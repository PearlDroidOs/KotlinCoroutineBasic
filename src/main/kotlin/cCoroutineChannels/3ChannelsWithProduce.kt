package cCoroutineChannels

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        val channel = produce {
            for (x in 1..5)
                send(x*x)
        }

        for (k in channel)
            println(k)
    }
}