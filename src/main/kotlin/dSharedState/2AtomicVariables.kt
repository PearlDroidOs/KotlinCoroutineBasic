package dSharedState

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis


fun main () {
    runBlocking {
        var counter = AtomicInteger()
        withContext(Dispatchers.Default) {
            massiveNewRun { counter.incrementAndGet() }
        }
        println("Counter = $counter")
    }

}

suspend fun massiveNewRun(action: suspend () -> Unit) {
    val n = 100
    val k = 1000
    val time = measureTimeMillis {
        coroutineScope {
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}
