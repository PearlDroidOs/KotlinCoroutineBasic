package dSharedState

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main () {
    runBlocking {
        //Solution 1: Fine-grained
        val counterContext = newSingleThreadContext("CounterContext")
        var counter = 0
        withContext(Dispatchers.Default) {
            massiveNewRun2 {
                withContext(counterContext) {
                    counter++
                }
            }
        }
        println("Counter = $counter")

        //Solution 2: Coarse-grained
        val counterContext2 = newSingleThreadContext("CounterContext")
        var counter2 = 0
        withContext(counterContext2) {
            massiveRun {
                counter2++
            }
        }
        println("Counter = $counter2")
    }

}

suspend fun massiveNewRun2(action: suspend () -> Unit) {
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
