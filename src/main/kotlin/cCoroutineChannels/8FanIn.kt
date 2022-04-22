package cCoroutineChannels

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.SendChannel

fun main () {
    runBlocking {
        val channel = Channel<String>()
        launch { sendString(channel, 200L, "message1") }
        launch { sendString(channel, 500L, "message2") }
        repeat(6) {
            println(channel.receive())
        }
        coroutineContext.cancelChildren()
    }
}

suspend fun CoroutineScope.sendString(channel: SendChannel<String>, time: Long, message: String) {
    while (true){
        delay(time)
        channel.send(message)
    }
}
