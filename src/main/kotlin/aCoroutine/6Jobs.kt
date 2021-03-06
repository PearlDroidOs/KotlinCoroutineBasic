package aCoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            println("Job 1 launched")

            val job2 = launch {
                println("Job 2 launched")
                delay(3000L)
                println("Job 2 is finishing")
            }

            job2.invokeOnCompletion { println("Job 2 is completed") }

            val job3 = launch {
                println("Job 3 launched")
                delay(3000L)
                println("Job 3 is finishing")
            }

            job3.invokeOnCompletion { println("Job 3 is completed") }

        }

        job1.invokeOnCompletion { println("Job 1 is completed") }

        delay(500L)
        println("Job 1 will be canceled")
        job1.cancel()
    }
}